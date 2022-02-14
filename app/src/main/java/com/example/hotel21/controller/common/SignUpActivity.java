package com.example.hotel21.controller.common;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import com.example.hotel21.R;
import com.example.hotel21.model.user.IUserDa;
import com.example.hotel21.model.user.UserFactory;

public class SignUpActivity extends AppCompatActivity {
    private EditText user_name , passowd ,fisrt_name , last_name ,visa_card,
            user_age , phone ,email ,age ,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        user_name = findViewById(R.id.Username);
        passowd = findViewById(R.id.Password);
        fisrt_name = findViewById(R.id.firstName);
        last_name = findViewById(R.id.LastName);
        visa_card = findViewById(R.id.visanumber);
        user_age = findViewById(R.id.Age);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.Email);
        age = findViewById(R.id.Age);
        gender = findViewById(R.id.Gender);

    }

    public void NewAccountonClik(View view) {
        String userName = user_name.getText().toString();
        String Password = passowd.getText().toString();
        String firstname = fisrt_name.getText().toString();
        String lastname = last_name.getText().toString();
        String visacard = visa_card.getText().toString();
        String userage =  user_age.getText().toString();
        String phoneN = phone.getText().toString();
        String Age = age.getText().toString();
        String emaill = email.getText().toString();
        String usergender = gender.getText().toString();
        UserFactory userFactory = new UserFactory();
        IUserDa iUserDa = userFactory.getModel();
        iUserDa.addUser(SignUpActivity.this,userName,Password,firstname,lastname,visacard,emaill,phoneN,usergender,Age);

    }

    }





