package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView useremailtextview,logouttextview;
    String useremailv,useremailbv,useridv;
    SharedPreferences.Editor editor;
    SharedPreferences preferences;

    Button addnewadvbutton,adsbutton,favoritesbutton,userinfobutton;



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

        addnewadvbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AdvertisementActivity.class);
                intent.putExtra("userid",useridv);
                startActivity(intent);
                finish();
            }
        });


        adsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AdsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        favoritesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, FavoritesssActivity.class);

                intent.putExtra("memberid",useridv);
                startActivity(intent);
            }
        });


        userinfobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, UserActivity.class);

                intent.putExtra("memberid",useridv);
                startActivity(intent);
            }
        });

    }




    public void definition(){
        useremailtextview=findViewById(R.id.museremailtextview);
        logouttextview=findViewById(R.id.mlogouttextview);
        addnewadvbutton=findViewById(R.id.newadsbutton);
        adsbutton=findViewById(R.id.adsbutton);
        favoritesbutton=findViewById(R.id.favoritebutton);
        userinfobutton=findViewById(R.id.usertinfobutton);
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
        useridv=(shared.getString("userid",""));

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