package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AdvertismentActivity2 extends AppCompatActivity {

    EditText yearedittext,makeedittext,modeledittext,colouredittext,kilometeredittext,priceedittext;
    Button nextbutton,backbutton;
    Spinner fuelspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisment2);
        definition();
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdvertismentActivity2.this,AdvertisementActivity3.class);
                startActivity(intent);
                finish();
            }
        });
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdvertismentActivity2.this,AdvertisementActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }



    public void definition(){

        yearedittext=findViewById(R.id.a2yearedittext);
        makeedittext= findViewById(R.id.a2makeedittext);
        modeledittext=findViewById(R.id.a2modeledittext);
        colouredittext=findViewById(R.id.a2colouredittext);
        kilometeredittext=findViewById(R.id.a2kilometeredittext);
        priceedittext=findViewById(R.id.a2priceedittext);
        nextbutton=findViewById(R.id.a2nextbutton);
        fuelspinner=findViewById(R.id.a2fuelspinner);
        backbutton=findViewById(R.id.a2backbutton);
    }
}