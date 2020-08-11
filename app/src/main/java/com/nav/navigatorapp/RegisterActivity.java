package com.nav.navigatorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nav.navigatorapp.pojo.request.LoginData;
import com.nav.navigatorapp.pojo.request.ReqRegister;
import com.nav.navigatorapp.service.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText fname_et,mname_et,lname_et,email_et,password_et;
    AppCompatButton reg_signup_btn,reg_signin_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }
    void init()
     {
         fname_et=findViewById(R.id.fname_et);
         mname_et=findViewById(R.id.mname_et);
         lname_et=findViewById(R.id.lname_et);
         email_et=findViewById(R.id.email_et);
         password_et=findViewById(R.id.password_et);
         reg_signup_btn=findViewById(R.id.reg_signup_btn);
         reg_signin_btn=findViewById(R.id.reg_signin_btn);
         setListeners();
     }
     void setListeners()
     {
         reg_signup_btn.setOnClickListener(this);
         reg_signin_btn.setOnClickListener(this);
     }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.reg_signin_btn:
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.reg_signup_btn:
                String fname=fname_et.getText().toString();
                String mname=mname_et.getText().toString();
                String lname=lname_et.getText().toString();
                String email=email_et.getText().toString();
                String password=password_et.getText().toString();

                if (!fname.equals("") && !mname.equals("") && !lname.equals("") && !email.equals("") && !password.equals(""))
                {
                    register(fname,mname,lname,email,password);
                }
                else
                {
                    Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
                }

        }
    }

    public void register(String fname,String mname, String lname, String email, String password)
    {
        Toast.makeText(RegisterActivity.this, "hi", Toast.LENGTH_SHORT).show();
        ReqRegister reqRegister=new ReqRegister();
        reqRegister.setFname(fname);
        reqRegister.setMname(mname);
        reqRegister.setLname(lname);
        reqRegister.setEmail(email);
        reqRegister.setPassword(password);
        Call<String> register = ApiClient.getInstance().register(reqRegister);
        register.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful())
                {
                    Toast.makeText(RegisterActivity.this, "You are registered successfully", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
