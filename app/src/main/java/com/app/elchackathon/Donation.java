package com.app.elchackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Donation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
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
