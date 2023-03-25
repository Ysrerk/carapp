package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import Adapter.SliderAdapter;
import Models.Adsdetail;
import Models.SliderImage;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdsDetailActivity extends AppCompatActivity {

    TextView pricetextview,maketextview,modeltextview,kilometertextview,fueltyepetextview,yeartextview,provincetextview,citytextview;
    Button descriptionbutton,favoritebutton;
    ViewPager adsdetailslider;

    String advid;
    List<SliderImage>imageList;
    SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads_detail);
        Bundle bundle=getIntent().getExtras();
        advid=bundle.getString("advid");
        definition();
        getDetail();
        getImages();
    }


    public void definition(){

        pricetextview=findViewById(R.id.dtextviewprice);
        maketextview=findViewById(R.id.dtextviewmake);
        modeltextview=findViewById(R.id.dtextviewmodel);
        kilometertextview=findViewById(R.id.dtextviewkilometer);
        fueltyepetextview=findViewById(R.id.dtextviewfuel);
        yeartextview=findViewById(R.id.dtextviewyear);
        provincetextview=findViewById(R.id.dtextviewprovince);
        citytextview=findViewById(R.id.dtextviewcity);
        descriptionbutton=findViewById(R.id.ddescriptionbutton);
        favoritebutton=findViewById(R.id.dgetfavoritebutton);
        adsdetailslider=findViewById(R.id.dadsdetailslider);
    }

    public void getDetail(){

        Call<Adsdetail> request= ManagerAll.getInstance().getadsdetail(advid);
        request.enqueue(new Callback<Adsdetail>() {
            @Override
            public void onResponse(Call<Adsdetail> call, Response<Adsdetail> response) {

                pricetextview.setText(response.body().getPrice());
                maketextview.setText(response.body().getMake());
                modeltextview.setText(response.body().getModel());
                kilometertextview.setText(response.body().getKilometer());
                fueltyepetextview.setText(response.body().getFueltype());
                yeartextview.setText(response.body().getYear());
                provincetextview.setText(response.body().getProvince());
                citytextview.setText(response.body().getCity());



            }

            @Override
            public void onFailure(Call<Adsdetail> call, Throwable t) {

            }
        });

    }
    public void getImages(){
        Call<List<SliderImage>> request=ManagerAll.getInstance().getadimage(advid);
        request.enqueue(new Callback<List<SliderImage>>() {
            @Override
            public void onResponse(Call<List<SliderImage>> call, Response<List<SliderImage>> response) {
                imageList=response.body();
                sliderAdapter=new SliderAdapter(imageList,getApplicationContext());
                adsdetailslider.setAdapter(sliderAdapter);

            }

            @Override
            public void onFailure(Call<List<SliderImage>> call, Throwable t) {

            }
        });
    }
}