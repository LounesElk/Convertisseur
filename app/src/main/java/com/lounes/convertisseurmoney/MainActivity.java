package com.lounes.convertisseurmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etValeur;
    private String test;
    private Spinner spValeurB;
    private Spinner spValeurC;
    private Button btConvertisseur;
    private String base;
    private String base_;
    private int positonInt_base;
    private String convertir;
    private String convertir_;
    private int positonInt_convert;

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
                base_= String.valueOf(i);
                positonInt_base = Integer.valueOf(base_);
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
                convertir_= String.valueOf(i);
                positonInt_convert = Integer.valueOf(convertir_);
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
        test = etValeur.getText().toString();
        if(!TextUtils.isEmpty(test)) { //verif si il y a des données dans la zonne à convertir
            if (positonInt_base != positonInt_convert) { //verif si les unités sont diff
                Intent intent = new Intent(this, Pageresultat.class);
                intent.putExtra("valeur", etValeur.getText().toString());
                intent.putExtra("unitebase", base);
                intent.putExtra("uniteconverti", convertir);

                double nb;
                DecimalFormat df = new DecimalFormat("0.00"); // sert a garder uniquement les 2 chiffres après la virgule
                /* Pour passer de string à int et vice versa (jsp comment j ai fais)
                test = etValeur.getText().toString();
                nb = Integer.parseInt(test);
                nb = nb/0.92;
                test = String.valueOf(nb);
                */
                if (positonInt_base == 0) {
                    //euro
                    if (positonInt_convert == 1) { //dollar(1/1.08)
                        test = etValeur.getText().toString();
                        nb = Integer.parseInt(test);
                        nb = nb / (1 / 1.08);
                        test = String.valueOf(df.format(nb));
                    }
                    if (positonInt_convert == 2) { //livre(1.19/1)
                        test = etValeur.getText().toString();
                        nb = Integer.parseInt(test);
                        nb = nb / (1.19 / 1);
                        test = String.valueOf(df.format(nb));
                    }
                }

                if (positonInt_base == 1) {
                    //dollar
                    if (positonInt_convert == 0) { //euro(1/1.08)
                        test = etValeur.getText().toString();
                        nb = Integer.parseInt(test);
                        nb = nb * (1 / 1.08);
                        test = String.valueOf(df.format(nb));
                    }
                    if (positonInt_convert == 2) { //livre(1.29/1)
                        test = etValeur.getText().toString();
                        nb = Integer.parseInt(test);
                        nb = nb / (1.29 / 1);
                        test = String.valueOf(df.format(nb));
                    }
                }

                if (positonInt_base == 2) {
                    //livre
                    if (positonInt_convert == 0) { //euro(1.19/1)
                        test = etValeur.getText().toString();
                        nb = Integer.parseInt(test);
                        nb = nb * (1.19 / 1);
                        test = String.valueOf(df.format(nb));
                    }
                    if (positonInt_convert == 1) { //dollar(1.29/1)
                        test = etValeur.getText().toString();
                        nb = Integer.parseInt(test);
                        nb = nb * (1.29 / 1);
                        test = String.valueOf(df.format(nb));
                    }
                }
                intent.putExtra("valeurconverti", test);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Veuillez choisir une autre unité, la convertion avec la même unité est impossible.", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this, "Veuillez entrer une valeur à convertir.", Toast.LENGTH_LONG).show();
        }
    }

}