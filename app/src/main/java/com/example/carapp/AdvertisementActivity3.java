package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import Models.Addimage;
import Models.Advresult;
import Models.Newadv;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdvertisementActivity3 extends AppCompatActivity {

    Button choseimagebutton,addimagebutton,publishadvbutton,backbutton;
    ImageView imageView;
    String advidv;
    static String memberidv="";

    Bitmap bitmap;

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

        choseimagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showimage();
            }
        });

        addimagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadimage();

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

    public void loadimage(){

        String image=imageToString();


        Call<Addimage> request=ManagerAll.getInstance().addimage(memberidv,advidv,image);
        request.enqueue(new Callback<Addimage>() {
            @Override
            public void onResponse(Call<Addimage> call, Response<Addimage> response) {
                if(response.body().getTf()){
                    Toast.makeText(getApplicationContext(),response.body().getResultmessage(),Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),response.body().getResultmessage(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Addimage> call, Throwable t) {

            }
        });
    }


    //opening the galery
    public void showimage(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,777);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==777 && resultCode==RESULT_OK && data!=null){
            Uri path=data.getData();
            try {
                bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                imageView.setImageBitmap(bitmap);
                imageView.setVisibility(View.VISIBLE);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    public String imageToString(){
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] byt=byteArrayOutputStream.toByteArray();
        String imageToString= Base64.encodeToString(byt,Base64.DEFAULT);
        return imageToString;
    }




    public void publishadv(String memberid,String title,String description,String province,String city,String year,String make,String model,String colour,String fueltype,String kilometer,String price){

        Call<Advresult> request= ManagerAll.getInstance().addadv(memberid,title,description,province,city,year,make,model,colour,fueltype,kilometer,price);
        request.enqueue(new Callback<Advresult>() {
            @Override
            public void onResponse(Call<Advresult> call, Response<Advresult> response) {
                if (response.body().getResult()){
                    Toast.makeText(getApplicationContext(),"Advertisement  published successfully",Toast.LENGTH_LONG).show();
                    //ilan numarasi alindi
                    advidv=response.body().getAdvid();
                    String memberid=response.body().getMemberid();
                    sendmemberid(memberid);
                }

            }

            @Override
            public void onFailure(Call<Advresult> call, Throwable t) {

            }
        });
    }

    public String sendmemberid(String memberid){
        memberidv=memberid;
        return memberidv;
    }

}