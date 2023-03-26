package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import Adapter.AdsAdapter;
import Adapter.FavoritesAdapter;
import Models.Favorite;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoritesssActivity extends AppCompatActivity {
    ListView listView;
    List<Favorite> list;
    FavoritesAdapter favoritesAdapter;
    String memberid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritesss);
        listView=findViewById(R.id.listviewfavorites);
        Bundle bundle=getIntent().getExtras();

        memberid=bundle.getString("memberid");

        listFavorites();
    }

    public void listFavorites(){
        Call<List<Favorite>> request= ManagerAll.getInstance().getfavorites(memberid);
        request.enqueue(new Callback<List<Favorite>>() {
            @Override
            public void onResponse(Call<List<Favorite>> call, Response<List<Favorite>> response) {

                if(response.isSuccessful()){

                    if(response.body().get(0).getTf()){

                        list=response.body();
                        favoritesAdapter=new FavoritesAdapter(list,getApplicationContext());
                        listView.setAdapter(favoritesAdapter);
                        Toast.makeText(getApplicationContext(),response.body().get(0).getSayi()+" ads  were listed",Toast.LENGTH_LONG).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Favorite>> call, Throwable t) {

            }
        });
    }
}