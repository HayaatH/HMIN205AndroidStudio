package com.code.tp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Planning  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        final Button exo4 = findViewById(R.id.exo4);
        exo4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent add = new Intent(getApplicationContext(), Planning_4.class);
                startActivity(add);
            }
        });

        final Button exo5 = findViewById(R.id.exo5);
        exo5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent add = new Intent(getApplicationContext(), AddAccount.class);
                startActivity(add);
            }
        });

        final Button exo6 = findViewById(R.id.exo6);
        exo6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent add = new Intent(getApplicationContext(), AddAccount.class);
                startActivity(add);
            }
        });
    }
}
