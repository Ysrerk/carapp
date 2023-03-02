package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import Models.Advresult;
import Models.Newadv;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        publishadvbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                publishadv(Newadv.getMemberid(),Newadv.getTitle(),Newadv.getDescription(),Newadv.getProvince(),Newadv.getCity(),Newadv.getYear(),Newadv.getMake(),Newadv.getModel(),Newadv.getColour(),Newadv.getFueltype(),Newadv.getKilometer(),Newadv.getPrice());
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

    public void publishadv(String memberid,String title,String description,String province,String city,String year,String make,String model,String colour,String fueltype,String kilometer,String price){

        Call<Advresult> request= ManagerAll.getInstance().addadv(memberid,title,description,province,city,year,make,model,colour,fueltype,kilometer,price);
        request.enqueue(new Callback<Advresult>() {
            @Override
            public void onResponse(Call<Advresult> call, Response<Advresult> response) {
                if (response.body().getResult()){
                    Toast.makeText(getApplicationContext(),"Advertisement  published successfully",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Advresult> call, Throwable t) {

            }
        });
    }
}