package com.lounes.convertisseurmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Pageresultat extends AppCompatActivity {

    private TextView valeurC;
    private  TextView valeurB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageresultat);

        valeurB = (TextView) findViewById(R.id.valeurB);
        valeurC = (TextView) findViewById(R.id.valeurC);

        Intent afficher = getIntent();
        String valeurDeBase = afficher.getStringExtra("valeur")+" "+afficher.getStringExtra("valeurbase");
        valeurB.setText(valeurDeBase);

        class Converti{
            Intent intent = getIntent();
            if (intent.)

        }

        Intent afficher2 = getIntent();
        String valeurConverti = Converti +" "+afficher.getStringExtra("valeurbase");
        valeurC.setText(valeurConverti);

    }
}