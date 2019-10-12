package com.app.elchackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapPage extends AppCompatActivity {
    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_page);
    }
    public void goToAnActivity(View view) {
        Intent intent = new Intent(this, StatPage.class);
        startActivity(intent);
    }
    public void goToAnActivity2(View view){
        Intent intent = new Intent(this, Donation.class);
        startActivity(intent);
    }
    public void goToAnActivity3(View view){
        Intent intent = new Intent(this, MapPage.class);
        startActivity(intent);
    }


}
