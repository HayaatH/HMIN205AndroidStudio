package com.code.tp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModel;

public class Planning_4  extends AppCompatActivity {

    TextView AM1;
    TextView AM2;
    TextView PM1;
    TextView PM2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning_view);

        AM1 = findViewById(R.id.am1);
        AM2 = findViewById(R.id.am2);;
        PM1 = findViewById(R.id.pm1);;
        PM2 = findViewById(R.id.pm2);;
        PlanningModel pModel = new ViewModelProvider(this).get(PlanningModel.class);

        AM1.setText(pModel.AM1);
        AM2.setText(pModel.AM2);
        PM1.setText(pModel.PM1);
        PM2.setText(pModel.PM2);

    }
}
