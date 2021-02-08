package com.example.tp1exo6;



import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;


public class SecondActivity  extends AppCompatActivity {
    protected TextView name;
    protected TextView surname;
    protected TextView age;
    protected TextView domain;
    protected TextView number;

    public void addListenerOnButton(){

        Button call = findViewById(R.id.bcall);
        call.setOnClickListener(v -> {
            Intent intentCalling = new Intent(getApplicationContext(), CallActivity.class);
            intentCalling.putExtra("number", number.getText().toString());
            startActivity(intentCalling);
        });


        Button button = findViewById(R.id.ret);
        button.setOnClickListener(v -> {
            Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
            startActivityForResult(myIntent,0);
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        this.name = findViewById(R.id.nameS);
        this.surname = findViewById(R.id.surnameS);
        this.age = findViewById(R.id.ageS);
        this.domain = findViewById(R.id.domainS);
        this.number = findViewById(R.id.numberS);

        final Bundle bundle = getIntent().getExtras();
        name.setText(bundle.getString("name"));
        surname.setText(bundle.getString("surname"));
        age.setText(bundle.getString("age"));
        domain.setText(bundle.getString("domain"));
        number.setText(bundle.getString("number"));

        if(name.getText().equals("")){
            name.setTextColor(Color.RED);
            name.setText("Empty");

        }
        if(surname.getText().equals("")){
            surname.setTextColor(Color.RED);
            surname.setText("Empty");
        }
        if(age.getText().equals("")){
            age.setTextColor(Color.RED);
            age.setText("Empty");
        }
        if(domain.getText().equals("")){
            domain.setTextColor(Color.RED);
            domain.setText("Empty");
        }

        if(number.getText().equals("")){
            number.setTextColor(Color.RED);
            number.setText("0");
        }

        addListenerOnButton();


    }
}
