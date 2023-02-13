package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AdvertisementActivity extends AppCompatActivity {

    EditText titleedittext,descriptionedittext,cityedittext;
    Spinner provincespinner;
    Button nextbutton,backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisement);
        definition();

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdvertisementActivity.this,AdvertismentActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdvertisementActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }


    public void definition(){

        titleedittext=findViewById(R.id.atitleedittext);
        descriptionedittext=findViewById(R.id.adescriptionedittext);
        cityedittext=findViewById(R.id.acityedittext);
        provincespinner=findViewById(R.id.aprovincespinner);
        nextbutton=findViewById(R.id.anextbutton);
        backbutton=findViewById(R.id.abackbutton);
    }
}