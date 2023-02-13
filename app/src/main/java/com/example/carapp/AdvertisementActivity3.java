package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdvertisementActivity3 extends AppCompatActivity {

    Button choseimagebutton,addimagebutton,publishadvbutton,backbutton;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisement3);
        definition();
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdvertisementActivity3.this,AdvertismentActivity2.class);
                startActivity(intent);
                finish();
            }
        });
    }


    public void definition(){
        choseimagebutton=findViewById(R.id.a3chooseimagebutton);
        addimagebutton=findViewById(R.id.a3addimagebutton);
        publishadvbutton=findViewById(R.id.a3publishadvbutton);
        imageView=findViewById(R.id.a3imageview);
        backbutton=findViewById(R.id.a3backbutton);
    }
}