package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import Adapter.AdsAdapter;
import Models.Ads;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdsActivity extends AppCompatActivity {

    ListView listView;
    List<Ads> list;
    AdsAdapter adsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);
        listView=findViewById(R.id.listviewads);
        listads();

    }

    public void listads(){

        Call<List<Ads>> request= ManagerAll.getInstance().getAds();
        request.enqueue(new Callback<List<Ads>>() {
            @Override
            public void onResponse(Call<List<Ads>> call, Response<List<Ads>> response) {

                if(response.isSuccessful()){

                    if(response.body().get(0).getTf()){

                        list=response.body();
                        adsAdapter=new AdsAdapter(list,getApplicationContext());
                        listView.setAdapter(adsAdapter);
                        Toast.makeText(getApplicationContext(),response.body().get(0).getSayi()+" ads  were listed",Toast.LENGTH_LONG).show();

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Ads>> call, Throwable t) {

            }
        });

    }
}