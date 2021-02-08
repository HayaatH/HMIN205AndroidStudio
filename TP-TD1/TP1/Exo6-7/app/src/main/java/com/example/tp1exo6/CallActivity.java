package com.example.tp1exo6;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class CallActivity extends AppCompatActivity {

    protected TextView number;
    protected ImageView phone;


    public void addListenerOnButton(){
        Button bcall = findViewById(R.id.bcall);
        bcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = number.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+n));
                startActivity(callIntent);
            }});

        Button button = findViewById(R.id.retCall);
        button.setOnClickListener(v -> {
            Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
            startActivityForResult(myIntent,0);
        });

    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        Intent myIntent = getIntent();

        this.number = findViewById(R.id.number);
        final Bundle bundle = getIntent().getExtras();
        number.setText(bundle.getString("number"));

        addListenerOnButton();
    }

}
