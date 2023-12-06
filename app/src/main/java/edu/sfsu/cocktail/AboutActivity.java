package edu.sfsu.cocktail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.widget.Toolbar;

import android.support.v4.app.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolBar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolBar);
    }
}