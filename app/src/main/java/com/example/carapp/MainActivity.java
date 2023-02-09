package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView useremailtextview,logouttextview;
    String useremailv,useremailbv;
    SharedPreferences.Editor editor;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        definition();
        getvaluefromintent();

        logouttextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logout();


            }
        });

    }

    public void definition(){
        useremailtextview=findViewById(R.id.museremailtextview);
        logouttextview=findViewById(R.id.mlogouttextview);
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
    public void logout(){
        SharedPreferences shared=getSharedPreferences("loginshared",0);
        editor = shared.edit();
        editor.clear();
        editor.commit();
        Intent intent=new Intent(MainActivity.this,LoginActivity.class);

        startActivity(intent);


    }
}