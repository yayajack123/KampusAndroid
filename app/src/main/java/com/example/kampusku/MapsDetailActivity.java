package com.example.kampusku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MapsDetailActivity extends AppCompatActivity {

    private String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_detail);
        city = getIntent().getStringExtra("City");

        TextView kota = (TextView)findViewById(R.id.city_id);
        kota.setText(city);


        Log.d("logmapsdetail","CITY :"+city);
    }
}
