package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Models.Member;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText emailedit,passwordedit;
    Button loginbutton;
    String emailv,passwordv;

    TextView signuptextview;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        definition();
        sharedPreferences=getApplicationContext().getSharedPreferences("loginshared",0);
        if(sharedPreferences.getString("userid",null)!=null && sharedPreferences.getString("email",null)!=null){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getvalueedittext();
                login(emailv,passwordv);
            }
        });
        signuptextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });


    }



    public void definition (){

        emailedit=findViewById(R.id.emailedittext);
        passwordedit=findViewById(R.id.passwordedittext);
        loginbutton=findViewById(R.id.loginbutton);
        signuptextview=findViewById(R.id.signuptextview);
    }

    public void getvalueedittext(){

        emailv=emailedit.getText().toString();
        passwordv=passwordedit.getText().toString();

    }

    public void login(String emailv,String passwordv){
        Call<Member> request= ManagerAll.getInstance().getmember(emailv,passwordv);
        request.enqueue(new Callback<Member>() {
            @Override
            public void onResponse(Call<Member> call, Response<Member> response) {
                if(response.isSuccessful()){
                    if(response.body().getEmail()!=null && response.body().getPassword()!=null){
                        String userid=String.valueOf(response.body().getId());
                        String email=response.body().getEmail();
                        sharedPreferences=getApplicationContext().getSharedPreferences("loginshared",0);
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.putString("userid",userid);
                        editor.putString("email",email);
                        editor.commit();
                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"invalid useror password",Toast.LENGTH_LONG).show();


                        Intent intent=new Intent(LoginActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                }

            }

            @Override
            public void onFailure(Call<Member> call, Throwable t) {




            }
        });
    }

    public void signup(){
        Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);

    }
}