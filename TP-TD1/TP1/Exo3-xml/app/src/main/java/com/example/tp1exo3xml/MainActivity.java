package com.example.tp1exo3xml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();

    }

    public void addListenerOnButton() {
        EditText name = (EditText) findViewById(R.id.name);
        EditText surname = (EditText) findViewById(R.id.surname);
        EditText age = (EditText) findViewById(R.id.age);
        EditText domain = (EditText) findViewById(R.id.domain);
        EditText number = (EditText) findViewById(R.id.number);
        button = (Button) findViewById(R.id.bsubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("1: ").append(name.getText().toString());
                result.append("\n2: ").append(surname.getText().toString());
                result.append("\n3: ").append(age.getText().toString());
                result.append("\n4: ").append(domain.getText().toString());
                result.append("\n5: ").append(number.getText().toString());
                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}