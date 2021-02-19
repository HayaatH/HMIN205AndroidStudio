package com.example.exo3456;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class EXO3 extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private static final float SHAKE_THRESHOLD = 3.25f;
    private static final int MIN_TIME_BETWEEN_SHAKES_MILLISECS = 1000;
    private long mLastShakeTime;
    private Sensor mAccelerometer;
    private CameraManager cameraManager;
    String cameraId;
    float [] history = new float[2];
    String [] direction = {"NONE","NONE"};
    protected ConstraintLayout base;


    public void Acc() {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (mAccelerometer != null) {
            mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cameraManager = (CameraManager)
                    getSystemService(Context.CAMERA_SERVICE);
        }
        try {
            cameraId = cameraManager.getCameraIdList()[0];
        } catch (@SuppressLint("NewApi") CameraAccessException e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exo_3);

        TextView tv = findViewById(R.id.tv);

        this.base = findViewById(R.id.base);

    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener((SensorEventListener) this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener((SensorEventListener) this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            long curTime = System.currentTimeMillis();
            if ((curTime - mLastShakeTime) > MIN_TIME_BETWEEN_SHAKES_MILLISECS) {

                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];

                double acceleration = Math.sqrt(Math.pow(x, 2) +
                        Math.pow(y, 2) +
                        Math.pow(z, 2)) - SensorManager.GRAVITY_EARTH;

                if (acceleration > SHAKE_THRESHOLD) {
                    mLastShakeTime = curTime;
                    Boolean light = true;
                    if (light) {
                        try {

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                cameraManager.setTorchMode(cameraId, true);
                            }
                            System.out.println("CAMERA ON CAMERA ON CAMERA ON");
                        } catch (@SuppressLint("NewApi") CameraAccessException e) {
                            e.printStackTrace();
                        }

                        light = false;
                    } else {

                        try {

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                cameraManager.setTorchMode(cameraId, false);
                            }
                            System.out.println("CAMERA OFF CAMERA OFF CAMERA OFF");
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }

                        light = true;
                    }
                }
            }
        }

        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        TextView tv = findViewById(R.id.tv);
        if ( x <= 0.15 ){
            base.setBackgroundColor(Color.parseColor("#47b550"));
            tv.setTextColor(Color.parseColor("#000000"));

        }
        if(x > 0.15 && x <= 1 ){
            base.setBackgroundColor(Color.parseColor("#000000"));
            tv.setTextColor(Color.parseColor("#ffffff"));
        }
        if ( x > 1 ){
            base.setBackgroundColor(Color.parseColor("#b53333"));
            tv.setTextColor(Color.parseColor("#000000"));

        }

        float xChange = history[0] - event.values[0];
        float yChange = history[1] - event.values[1];

        history[0] = event.values[0];
        history[1] = event.values[1];

        if (xChange > 2){
            direction[0] = "GAUCHE";
        }
        else if (xChange < -2){
            direction[0] = "DROITE";
        }

        if (yChange > 2){
            direction[1] = "BAS";
        }
        else if (yChange < -2){
            direction[1] = "HAUT";
        }

        String res = "DIRECTION : " + direction[0] + ",  " +  direction[1];
        tv.setText(res);
    }

    @Override
    //obliger d'ajouter mais pas utilisé
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
