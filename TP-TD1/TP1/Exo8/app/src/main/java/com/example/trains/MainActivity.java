package com.example.trains;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;


import java.util.ArrayList;
import java.util.List;

import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    Spinner allerS;
    Spinner retourS;
    Spinner horraireS;
    private Object View;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        allerS = (Spinner) findViewById(R.id.aller);
        List aller = new ArrayList();
        aller.add("Paris");
        aller.add("Toulouse");
        aller.add("Montpellier");

        retourS = (Spinner) findViewById(R.id.retour);
        List retour = new ArrayList();
        retour.add("Paris");
        retour.add("Toulouse");
        retour.add("Montpellier");


        ArrayAdapter a = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                aller
        );

        ArrayAdapter r = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                retour
        );

        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        r.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        allerS.setAdapter(a);
        retourS.setAdapter(r);
        addListenerOnButton();
    }


    public void addListenerOnButton(){
        Button go = findViewById(R.id.button);
        View table = (TableLayout) findViewById(R.id.tableau);
        go.setOnClickListener(v->{
            table.setVisibility(table.VISIBLE);
        });

    }
}