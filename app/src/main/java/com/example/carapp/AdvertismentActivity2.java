package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Models.Newadv;

public class AdvertismentActivity2 extends AppCompatActivity {

    EditText yearedittext,makeedittext,modeledittext,colouredittext,kilometeredittext,priceedittext;
    Button nextbutton,backbutton;
    Spinner fuelspinner;
    List<String> fuellist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisment2);
        loadfuellist();
        definition();

        yearedittext.setText(Newadv.getYear());
        makeedittext.setText(Newadv.getMake());
        modeledittext.setText(Newadv.getModel());
        colouredittext.setText(Newadv.getColour());

        //burayi list olusturulunca duzeltmeyi unutma
        fuelspinner.setSelection(fuellist.indexOf(Newadv.getFueltype()));


        kilometeredittext.setText(Newadv.getKilometer());
        priceedittext.setText(Newadv.getPrice());

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!yearedittext.getText().toString().equals("")&& !makeedittext.getText().toString().equals("")&& !modeledittext.getText().toString().equals("") && !colouredittext.getText().toString().equals("")&& !kilometeredittext.getText().toString().equals("")&&!priceedittext.getText().toString().equals("")) {
                    Newadv.setYear(yearedittext.getText().toString());
                    Newadv.setMake(makeedittext.getText().toString());
                    Newadv.setModel(modeledittext.getText().toString());
                    Newadv.setColour(colouredittext.getText().toString());
                    Newadv.setFueltype(fuelspinner.getSelectedItem().toString());

                    Newadv.setKilometer(kilometeredittext.getText().toString());
                    Newadv.setPrice(priceedittext.getText().toString());
                    Intent intent=new Intent(AdvertismentActivity2.this,AdvertisementActivity3.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"please enter all  values  properly",Toast.LENGTH_LONG).show();
                }

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

        ArrayAdapter<String> fuellistAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,fuellist);
        fuellistAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuelspinner.setAdapter(fuellistAdapter);
    }

    public  void loadfuellist(){
        fuellist=new ArrayList<>();
        fuellist.add("Gas");
        fuellist.add("Electric");
        fuellist.add("Hybrid");
    }
}