package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Models.User;
import Models.UserUpdate;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    TextView memberidtextview,usernametextview;
    EditText phoneedittext, emailedittext;
    Button updatebutton;

    String memberid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        definition();

        Bundle bundle=getIntent().getExtras();

        memberid=bundle.getString("memberid");

        getuserinfo();

        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateuserinfo();
            }
        });
    }

    public void definition(){

        memberidtextview=findViewById(R.id.umemverid);
        emailedittext =findViewById(R.id.uemail);
        phoneedittext =findViewById(R.id.uphone);
        usernametextview=findViewById(R.id.uusername);
        updatebutton=findViewById(R.id.uupdatebutton);

    }

    public void getuserinfo(){
        Call<User> request= ManagerAll.getInstance().getuserinfo(memberid);
        request.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                memberidtextview.setText(response.body().getMemberid());
                emailedittext.setText(response.body().getEmail());
                phoneedittext.setText(response.body().getPhone());
                usernametextview.setText(response.body().getUsername());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    public void updateuserinfo(){

        String emailv,phonev;
        emailv=emailedittext.getText().toString();
        phonev=phoneedittext.getText().toString();

        Call<UserUpdate> request=ManagerAll.getInstance().userupdateinfo(memberid,emailv,phonev);
        request.enqueue(new Callback<UserUpdate>() {
            @Override
            public void onResponse(Call<UserUpdate> call, Response<UserUpdate> response) {
                if(response.body().getResult()){
                    Toast.makeText(getApplicationContext(),"User info was updated  successfully",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"User info was not  updated  successfully",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserUpdate> call, Throwable t) {

            }
        });
    }
}