package com.code.tp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ViewAccounts extends AppCompatActivity {

    ListView listAccount;
    TextView tv;
    ArrayList<String> contacts = new ArrayList<String>();
    String ret = "";

    private void readFromFile(Context context) {

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String fichier  =(String) bundle.get("filename");
        //String surname  =(String) bundle.get("surname");

        try {
            InputStream inputStream = context.openFileInput(fichier);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    this.contacts.add(receiveString);
                }
                inputStream.close();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_accounts);
        listAccount = findViewById(R.id.listAccount);
        tv = findViewById(R.id.tv);

        readFromFile( getApplicationContext());

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_view_accounts, contacts);

       // listAccount.setAdapter(adapter);
        tv.setText( contacts.toString());
        //tv.setText(ret);
    }

}
