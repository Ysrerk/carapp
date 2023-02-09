package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView useremailtextview;
    String useremailv,useremailbv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        definition();
        getvaluefromintent();

    }

    public void definition(){
        useremailtextview=findViewById(R.id.museremailtextview);
    }

    public void getvaluefromintent(){
       Bundle bundle=getIntent().getExtras();
       //useremailbv=bundle.getString("email");
        LoadPreferences();
        useremailtextview.setText(useremailv);
    }
    //with this method i can read email value from shared preferences
    private void LoadPreferences(){

        SharedPreferences shared=getSharedPreferences("loginshared",0);
        useremailv=(shared.getString("email",""));

    }
}