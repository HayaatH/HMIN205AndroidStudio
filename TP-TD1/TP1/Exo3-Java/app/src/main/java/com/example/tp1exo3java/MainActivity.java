package com.example.tp1exo3java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);


        TextView tvsurname = new TextView(this);
        tvsurname.setText("1: Nom");
        EditText etsurname = new EditText(this);

        TextView tvname = new TextView(this);
        tvname.setText("2: Prénom");
        EditText etname = new EditText(this);

        TextView tvage = new TextView(this);
        tvage.setText("3: Age");
        EditText etage = new EditText(this);
        etage.setInputType(InputType.TYPE_CLASS_NUMBER);


        TextView tvdomain = new TextView(this);
        tvdomain.setText("4: Domaine de compétence");
        EditText etdomain = new EditText(this);


        TextView tvnumber = new TextView(this);
        tvnumber.setText("5: Numéro");
        EditText etnumber = new EditText(this);
        etnumber.setInputType(InputType.TYPE_CLASS_PHONE);


        Button bsubmit = new Button(this);
        bsubmit.setText("Valider");

        ll.addView(tvsurname);
        ll.addView(etsurname);

        ll.addView(tvname);
        ll.addView(etname);

        ll.addView(tvage);
        ll.addView(etage);

        ll.addView(tvdomain);
        ll.addView(etdomain);

        ll.addView(tvnumber);
        ll.addView(etnumber);


        ll.addView(bsubmit);

        setContentView(ll);


            bsubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    StringBuffer result = new StringBuffer();
                    result.append("1: ").append(etname.getText().toString());
                    result.append("\n2: ").append(etsurname.getText().toString());
                    result.append("\n3: ").append(etage.getText().toString());
                    result.append("\n4: ").append(etdomain.getText().toString());
                    result.append("\n5: ").append(etnumber.getText().toString());
                    Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

