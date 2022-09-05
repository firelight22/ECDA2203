package com.quentinrouet.bddarticle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArticleDao dao = new ArticleDao(new DbHelper(this));
        dao.insert(
                new Article(0,"Pomme de tere","Pomme de terre","https",1.0f,4.0f,false)
        );
    }
}