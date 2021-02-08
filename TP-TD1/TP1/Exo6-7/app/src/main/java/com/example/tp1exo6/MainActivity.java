package com.example.tp1exo6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    final Context context = this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();


    }

    public void addListenerOnButton() {
        EditText name = findViewById(R.id.name);
        EditText surname = findViewById(R.id.surname);
        EditText age = findViewById(R.id.age);
        EditText domain = findViewById(R.id.domain);
        EditText number = findViewById(R.id.number);
        Button button = findViewById(R.id.bsubmit);
        button.setOnClickListener(v -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Alert");

            alertDialogBuilder.setMessage("Validez-vous?")
                    .setCancelable(false)
                    .setPositiveButton("Oui", (dialog, which) -> {
                        name.setHint("Vous avez validé");
                        surname.setHint("Vous avez validé");
                        age.setBackgroundColor(0XFFBB86FC);
                        Intent myIntent = new Intent(getApplicationContext(), SecondActivity.class);
                        myIntent.putExtra("name", name.getText().toString());
                        myIntent.putExtra("surname", surname.getText().toString());
                        myIntent.putExtra("age", age.getText().toString());
                        myIntent.putExtra("domain", domain.getText().toString());
                        myIntent.putExtra("number", number.getText().toString());
                        startActivity(myIntent);
                    })
                    .setNegativeButton("Non", (dialog, which) -> dialog.cancel());
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        });
    }

    //public class annonce extends DIal
}