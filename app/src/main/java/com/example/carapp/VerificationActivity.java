package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Models.Verification;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerificationActivity extends AppCompatActivity {
    EditText verifycodeedittext;
    Button verifybutton;
    String verifyvaluev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        definition();
        verifybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getvalue();
                verify(verifyvaluev);
            }
        });

    }

    public void definition(){

        verifybutton=findViewById(R.id.vverifybutton);
        verifycodeedittext=findViewById(R.id.vverificationcodeedittext);
    }

    public void getvalue(){
        verifyvaluev=verifycodeedittext.getText().toString();

    }

    public void  verify(String verificationcode){
        Call<Verification>verificationCall= ManagerAll.getInstance().verifymember(verificationcode);
        verificationCall.enqueue(new Callback<Verification>() {
            @Override
            public void onResponse(Call<Verification> call, Response<Verification> response) {
                //Toast.makeText(getApplicationContext(),String.valueOf(response.body().isResult()),Toast.LENGTH_LONG).show();

                if(response.body().isResult()){
                    Intent intent=new Intent(VerificationActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),String.valueOf(response.body().isResult())+"Your account couldnt verified",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Verification> call, Throwable t) {

            }
        });
    }
}