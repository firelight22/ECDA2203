package com.quentinrouet.bddarticle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArticleDao dao = new ArticleDao(new DbHelper(this));
        dao.insert(
                new Article(0,"Pomme de tere","Pomme de terre","https",1.0f,4.0f,false)
        );

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Faire Qqch
            }
        });
        button.setOnClickListener(v -> {
            //TODO Faire Qqch
        });
    }
}