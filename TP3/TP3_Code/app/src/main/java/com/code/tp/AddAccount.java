package com.code.tp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.io.File;


public class AddAccount extends AppCompatActivity {

    private static final int MAX_LENGTH = 8 ;
    private final static String Key_firstname = "firstname";
    private final static String Key_surname = "surname";
    private final static String Key_number = "number" ;
    private final static String Key_id = "id";
    EditText firstname;
    EditText surname;
    EditText number;
    TextView ident;
    Button submit;
    String id;
    EditText onChange;
    TextView onChangeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) &&(savedInstanceState.containsKey(Key_firstname)))
        {
            String val = savedInstanceState.getString(Key_firstname);
        Toast.makeText(this, "onCreate() firstname : " + val,Toast.LENGTH_SHORT).show();
        }
        if ((savedInstanceState != null) &&(savedInstanceState.containsKey(Key_surname)))
        {
            String val = savedInstanceState.getString(Key_surname);
            Toast.makeText(this, "onCreate() surname : " + val,Toast.LENGTH_SHORT).show();
        }
        if ((savedInstanceState != null) &&(savedInstanceState.containsKey(Key_number)))
        {
            String val = savedInstanceState.getString(Key_number);
            Toast.makeText(this, "onCreate() number : " + val,Toast.LENGTH_SHORT).show();
        }
        if ((savedInstanceState != null) &&(savedInstanceState.containsKey(Key_id)))
        {
            String val = savedInstanceState.getString(Key_id);
            Toast.makeText(this, "onCreate() id : " + val,Toast.LENGTH_SHORT).show();

        }

        setContentView(R.layout.activity_add_account);
        addListenerOnButton();
        id = "id"+random();
        ident =   findViewById(R.id.identifiant);
        ident.setText(id);
    }

    public static String random() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(MAX_LENGTH)+2;
        char tempChar;
        for (int i = 0; i < randomLength; i++){
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        onChange = findViewById(R.id.edName);
        String firstnameS = onChange.getText().toString();
        savedInstanceState.putString(Key_firstname ,firstnameS );

        onChange = findViewById(R.id.edSurname);
        String surnameS = onChange.getText().toString();
        savedInstanceState.putString(Key_surname,surnameS );


        onChange = findViewById(R.id.edNumber);
        String numberS = onChange.getText().toString();
        savedInstanceState.putString(Key_number,numberS);

        onChangeText = findViewById(R.id.identifiant);
        String idS = onChangeText.getText().toString();
        savedInstanceState.putString(Key_id,idS);

        Toast.makeText(this, "Etat de l'activité sauvegardé",Toast.LENGTH_SHORT).show();
    }

    public void addListenerOnButton() {
        firstname = (EditText) findViewById(R.id.edName);
        surname = (EditText) findViewById(R.id.edSurname);
        number = (EditText) findViewById(R.id.edNumber);
        submit = (Button) findViewById(R.id.btnSubmit);
        String fichier = surname.getText().toString()+id+".sav";

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeToFile(fichier,firstname.getText().toString()+" "+surname.getText().toString()+" "+number.getText().toString()
                        +" "+id+"\n", AddAccount.this);
                Intent myIntent = new Intent(getApplicationContext(), ViewAccounts.class);
                //myIntent.putExtra("firstname", firstname.getText().toString());
                //myIntent.putExtra("surname", surname.getText().toString());
                //myIntent.putExtra("number", number.getText().toString());
                //myIntent.putExtra("id", id);
                myIntent.putExtra("filename",fichier);
                startActivity(myIntent);
            }
        });
    }

    private void writeToFile(String filename ,String data, Context context) {
        try {
            //final File file = new File(filename);
            //file.createNewFile();
            //gère en plus du ascii : hanzi + kanji
            FileOutputStream fOS = openFileOutput(filename, Context.MODE_PRIVATE);
            fOS.write(data.getBytes());
            fOS.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
