package com.app.elchackathon;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;


import com.app.elchackathon.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void goToAnActivity(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    public void goToAnActivity2(View view){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

}