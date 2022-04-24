package com.lounes.convertisseurmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pageresultat extends AppCompatActivity {

    private TextView valeurC;
    private TextView valeurB;
    private Button btRetour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageresultat);

        valeurB = (TextView) findViewById(R.id.valeurB);
        valeurC = (TextView) findViewById(R.id.valeurC);
        btRetour = (Button) findViewById(R.id.btRetour);

        Intent afficher = getIntent();
        String valeurDeBase = afficher.getStringExtra("valeur")+" "+afficher.getStringExtra("unitebase");
        valeurB.setText(valeurDeBase);

        Intent afficherValeur = getIntent();
        String valeurConverti = afficherValeur.getStringExtra("valeurconverti")+" "+afficherValeur.getStringExtra("uniteconverti");
        valeurC.setText(valeurConverti);

        btRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toBack();
            }
        });
    }

    private void toBack(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}