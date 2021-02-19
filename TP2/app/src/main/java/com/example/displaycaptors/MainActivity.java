package com.example.displaycaptors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager mySensorManager;
    ListView listCaptor;
    ListView listAllCaptors;
    HashMap<String,String> allSensorsList = new HashMap<String, String>();


    private void listSensor(){
        mySensorManager = (SensorManager)  getSystemService(Context.SENSOR_SERVICE) ;
        List<Sensor> sensorList =  mySensorManager.getSensorList(Sensor.TYPE_ALL);
        //StringBuffer sensorDesc = new StringBuffer();
        listCaptor = findViewById(R.id.listCaptors);
        //listAllCaptors = findViewById(R.id.listAllCaptors);
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();

        allSensorsList.put("ACCELEROMETER","NO");
        allSensorsList.put("AMBIENT_TEMPERATURE","NO");
        allSensorsList.put("GYROSCOPE","NO");
        allSensorsList.put("LIGHT","NO");
        allSensorsList.put("LINEAR_ACCELERATION","NO");
        allSensorsList.put("MAGNETIC_FIELD","NO");
        allSensorsList.put("ORIENTATION","NO");
        allSensorsList.put("PRESSURE","NO");
        allSensorsList.put("PROXIMITY","NO");
        allSensorsList.put("RELATIVE_HUMIDITY","NO");
        allSensorsList.put("ROTATION_VECTOR","NO");
        allSensorsList.put("TEMPERATURE","NO");




        for(Sensor sensor : sensorList){
            arrayList.add("New sensor detected : \r\n");
            arrayList.add("\tName: " + sensor.getName() + "\r\n");
            arrayList.add("\tType: " + sensor.getType() + "\r\n");
            arrayList.add("Version: " + sensor.getVersion() + "\r\n");
            arrayList.add("Resolution (in the sensor unit): " + sensor.getResolution() + "\r\n");
            arrayList.add("Power in mA used by this sensor while in use" +  sensor.getPower() +"\r\n");
            arrayList.add("Vendor: " + sensor.getVendor() + "\r\n");
            arrayList.add("Maximum range of the sensor in the sensor's unit." +  sensor.getMaximumRange() + "\r\n");
            arrayList.add("Minimum delay allowed between two events in  microsecond " +
                    " or zero if this sensor only returns a  value when the data it's measuring changes " +
            sensor.getMinDelay() + "\r\n");

            if(allSensorsList.get(sensor.getName())!=null){
                allSensorsList.put(sensor.getName(), "YES");
            }
        }

        for(String key : allSensorsList.keySet()){
            if(allSensorsList.get(key)=="NO"){
                arrayList.add(key + " Is Missing");
            }
        }

        //Log.d("Array List: ", Arrays.toString(array));
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, arrayList);
        listCaptor.setAdapter(adapter);
        //Toast.makeText(this, sensorDesc.toString(), Toast.LENGTH_LONG).show();
        //ArrayAdapter adapter2 = new ArrayAdapter<String>(this,
          //      android.R.layout.simple_list_item_1, arrayList);
        //listAllCaptors.setAdapter(adapter2);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listSensor();
    }
}