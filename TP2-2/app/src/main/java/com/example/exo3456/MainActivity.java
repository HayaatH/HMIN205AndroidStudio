package com.example.exo3456;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button3 = findViewById(R.id.EXO3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i3 = new Intent(getApplicationContext(),EXO3.class);
                startActivity(i3);
            }
        });
/*
        final Button button4 = findViewById(R.id.EXO4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i4 = new Intent(getApplicationContext(),EXO4.class);
                startActivity(i4);
            }
        });

        final Button button5 = findViewById(R.id.EXO5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i5 = new Intent(getApplicationContext(),EXO5.class);
                startActivity(i5);
            }
        });
*/
        final Button button6 = findViewById(R.id.EXO6);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i6 = new Intent(getApplicationContext(),EXO6.class);
                startActivity(i6);
            }
        });
    }
}