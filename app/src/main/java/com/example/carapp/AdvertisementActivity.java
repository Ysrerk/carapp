package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Models.Newadv;

public class AdvertisementActivity extends AppCompatActivity {

    EditText titleedittext,descriptionedittext,cityedittext;
    Spinner provincespinner;
    Button nextbutton,backbutton;
    String useridv;
    SharedPreferences.Editor editor;
    SharedPreferences preferences;

    List<String>provincelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisement);
        loadlist();
        definition();
        getvaluefromintent();
        titleedittext.setText(Newadv.getTitle());
        descriptionedittext.setText(Newadv.getDescription());

        //burayi list olusturulunca duzeltmeyi unutma
        provincespinner.setSelection(provincelist.indexOf(Newadv.getProvince()));

        cityedittext.setText(Newadv.getCity());

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!titleedittext.getText().toString().equals("")&& !descriptionedittext.getText().toString().equals("") &&  !cityedittext.getText().toString().equals("")){
                    Newadv.setTitle(titleedittext.getText().toString());
                    Newadv.setDescription(descriptionedittext.getText().toString());
                    //burayi list olusturulunca duzeltmeyi unutma
                    Newadv.setProvince(provincespinner.getSelectedItem().toString());
                    Newadv.setCity(cityedittext.getText().toString());
                    Intent intent=new Intent(AdvertisementActivity.this,AdvertismentActivity2.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),"please enter all  values  properly",Toast.LENGTH_LONG).show();
                }

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
        ArrayAdapter<String> provincelistAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,provincelist);
        provincelistAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provincespinner.setAdapter(provincelistAdapter);

    }

    public void loadlist(){
        provincelist=new ArrayList<>();
        provincelist.add("Ontario");
        provincelist.add("British Colombia");
        provincelist.add("Quebec");
    }

    public void getvaluefromintent(){
        Bundle bundle=getIntent().getExtras();
        //useremailbv=bundle.getString("email");
        LoadPreferences();
        Newadv.setMemberid(useridv);
    }
    private void LoadPreferences(){

        SharedPreferences shared=getSharedPreferences("loginshared",0);

        useridv=(shared.getString("userid",""));

    }
}