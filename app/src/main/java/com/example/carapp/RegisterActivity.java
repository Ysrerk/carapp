package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Models.Register;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText emailedittext,passwordedittext,usernameedittext,phoneedittext,countryedittext;
    String emailv,passwordv,usernamev,phonev,countryv;

    Button registerbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        definition();

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               getvalues();
                register(emailv,passwordv,usernamev,phonev,countryv);
            }
        });


    }

    public  void definition(){
        emailedittext=findViewById(R.id.remailedittetx);
        passwordedittext=findViewById(R.id.rpassword);
        usernameedittext=findViewById(R.id.rusernameedittext);
        phoneedittext=findViewById(R.id.rphonededittext);
        countryedittext=findViewById(R.id.rcountryedittext);
        registerbutton=findViewById(R.id.registerbutton);



    }

    public void getvalues(){
        emailv=emailedittext.getText().toString();
        passwordv=passwordedittext.getText().toString();
        usernamev=usernameedittext.getText().toString();
        phonev=phoneedittext.getText().toString();
        countryv=countryedittext.getText().toString();
    }



    public void register(String emailv ,String passwordv,String usernamev,String phonev,String countryv){

        Call<Register>registerCall= ManagerAll.getInstance().registerm(emailv,passwordv,usernamev,phonev,countryv);
        registerCall.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                Toast.makeText(getApplicationContext(),response.body().getExplanation(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {

            }
        });



    }
}