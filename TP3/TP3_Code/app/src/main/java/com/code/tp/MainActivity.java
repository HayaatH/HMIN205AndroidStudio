package com.code.tp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


class MainActivityObserver implements LifecycleObserver {
    private static int counter = 0;
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public static void NombreUtilisation() {
        counter+=1;
    }
    public static int getNombreUtilisation() {
       return counter;
    }
}

class MyViewModel extends ViewModel{
    private MutableLiveData<Integer> counter= new MutableLiveData<Integer>();

    MyViewModel(){
        this.counter.setValue(0);
    }
    int getCounter(){
        return this.counter.getValue();
    }

    void addCounter(){
        int plus = this.counter.getValue()+1;
        this.counter.setValue(plus);
    }
}


public class MainActivity extends AppCompatActivity {

    TextView title;
    //MyViewModel counter = new MyViewModel();
    MainActivityObserver counter = new MainActivityObserver() ;

    @Override
    public void onResume() {
        super.onResume();
        counter.NombreUtilisation();
        title = findViewById(R.id.Title);
        title.setText("Cette page à étais vu " + counter.getNombreUtilisation() + " fois !");

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLifecycle().addObserver(new MainActivityObserver());

        final Button addAccount = findViewById(R.id.AddAccount);
        addAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent add = new Intent(getApplicationContext(), AddAccount.class);
                startActivity(add);
            }
        });

        final Button viewAccounts = findViewById(R.id.ViewAccounts);
        viewAccounts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent view = new Intent(getApplicationContext(), Planning.class);
                startActivity(view);
            }
        });

    }
}
