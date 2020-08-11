package com.nav.navigatorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nav.navigatorapp.pojo.request.LoginData;
import com.nav.navigatorapp.pojo.request.ReqLogin;
import com.nav.navigatorapp.service.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText email_et,password_et;
    AppCompatButton signin_btn,signup_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        email_et=findViewById(R.id.email_et);
        password_et=findViewById(R.id.password_et);
        signin_btn=findViewById(R.id.signin_btn);
        signup_btn=findViewById(R.id.signup_btn);
        signin_btn.setOnClickListener(this);
        if (signup_btn!=null)
        signup_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.signin_btn:
//                String email=email_et.getText().toString();
//                String password=password_et.getText().toString();
//                if (email.equals("") && password.equals(""))
//                    Toast.makeText(this, "enter details", Toast.LENGTH_SHORT).show();
//                else
//                    getLoginData(email,password);
                Intent centerintent=new Intent(this,DropInCenterActivity.class);
                startActivity(centerintent);
                finish();
                break;
            case R.id.signup_btn:
                Intent intent=new Intent(this,RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    public void getLoginData(String email, String password) {
        final ReqLogin reqLogin = new ReqLogin();
        reqLogin.setEmail(email);
        reqLogin.setPassword(password);


        Call<LoginData> getLogin = ApiClient.getInstance().getLogin(reqLogin);
        getLogin.enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {
                if (response != null && !response.isSuccessful() && response.errorBody() != null) {
                    Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                } else {
                    LoginData loginData = response.body();
//                    Log.d("login",loginData.getData().getFirst_name());
                    if (loginData.getData()==null)
                    {
                        Log.d("login","null");
                        Toast.makeText(MainActivity.this, "Not the registered User. Please sign up", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {

            }
        });





    }
}
