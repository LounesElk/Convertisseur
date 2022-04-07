package com.lounes.convertisseurmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText etValeur;
    private Spinner spValeurB;
    private Spinner spValeurC;
    private Button btConvertisseur;
    private String base;
    private String convertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValeur = (EditText) findViewById(R.id.etValeur);
        spValeurB = (Spinner) findViewById(R.id.spValeurB);
        spValeurC = (Spinner) findViewById(R.id.spValeurC);
        btConvertisseur = (Button) findViewById(R.id.btConvertisseur);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.convertbase, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spValeurB.setAdapter(adapter);

        spValeurB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                base = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.convertc, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spValeurC.setAdapter(adapter2);

        spValeurC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                convertir= adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btConvertisseur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toConvert();
            }
        });
    }

    private void toConvert(){
        Intent intent = new Intent( this, Pageresultat.class);
        intent.putExtra("valeur",etValeur.getText().toString());
        intent.putExtra("valeurbase", base);
        intent.putExtra("valeurbase", convertir);
        startActivity(intent);
    }
}