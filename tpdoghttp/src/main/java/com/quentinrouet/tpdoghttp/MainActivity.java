package com.quentinrouet.tpdoghttp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.quentinrouet.tpdoghttp.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding amb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        amb = DataBindingUtil.setContentView(this, R.layout.activity_main);
        OkHttpClient client = new OkHttpClient();
        Request requestDogFact = new Request.Builder()
                .url("https://dog-api.kinduff.com/api/facts")
                .build();
        amb.buttonRequest.setOnClickListener(v -> {
            client.newCall(requestDogFact).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.e(TAG, "onFailure: " + e.getMessage());
                    runOnUiThread(() -> {
                        amb.textViewResult.setText("Erreur, vérifiez votre connexion");
                    });
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    String bodyRes = response.body().string();
                    if(response.code() == 200){
                        try {
                            //On récupère la chaine de caractères de retour et
                            // on la transforme on objet JSON
                            JSONObject resJson = new JSONObject(bodyRes);
                            //On réucpère le JSON array "facts" dans l'objet JSON de résultat
                            JSONArray arrayFacts = resJson.getJSONArray("facts");

                            ArrayList<String> alFacts = new ArrayList<>();
                            //On parcoure le tableau pour récupérer créer liste de facts
                            for(int i =0; i<arrayFacts.length();i++){
                                alFacts.add(arrayFacts.getString(i));
                            }
                            //on utilise l'arraylist pour créer un objet DogFact
                            DogFact df = new DogFact(alFacts);
                            runOnUiThread(() -> {
                                amb.textViewResult.setText(df.getFacts().toString());
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        });

    }
}