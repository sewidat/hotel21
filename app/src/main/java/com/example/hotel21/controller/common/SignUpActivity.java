package com.example.hotel21.controller;

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
    private void addUser(String userName, String Password, String firstname
            ,String lastname , String visacard , String emaill, String phoneN,String usergender,String user_age) {
        if(userName.isEmpty()||Password.isEmpty()||firstname.isEmpty()||lastname.isEmpty()||visacard.isEmpty()||
                emaill.isEmpty()||  phoneN.isEmpty()||user_age.isEmpty()||usergender.isEmpty()){
            Toast.makeText(this, "Please fill all data Requierd", Toast.LENGTH_SHORT).show();
        }else {
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

            String url = "http://10.0.2.2:81/hotel21/signup.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    System.out.println(response + "-------------");
                    System.out.println(response.equalsIgnoreCase("success") + "////////////////");

                    if (response.contains("success")) {
                        System.out.println("on if statment");
                        Toast.makeText(SignUpActivity.this, "valid log in", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpActivity.this, LonginActivity.class);
                        startActivity(intent);
                        finish();


                    } else if (response.contains("failure")) {
                        Toast.makeText(SignUpActivity.this, "Invalid log in", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(SignUpActivity.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("user_name", userName);
                    data.put("user_password", Password);
                    data.put("first_name", firstname);
                    data.put("last_name", lastname);
                    data.put("visa_number", visacard);
                    data.put("user_email",emaill );
                    data.put("user_phone", phoneN);
                    data.put("user_gender", usergender);
                    data.put("user_age", user_age);

                    return data;
                }

            };
            requestQueue.add(stringRequest);
        }

        }
        User user = new User(userName,Password,firstname,lastname,visacard,emaill,phoneN,usergender,Integer.parseInt(user_age));

    }

}



