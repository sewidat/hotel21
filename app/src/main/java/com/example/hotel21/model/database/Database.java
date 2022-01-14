package com.example.hotel21.model.database;

import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import com.example.hotel21.controller.SignUpActivity;
import  com.example.hotel21.model.user.User;

public class Database {
    private static Database single_instance = null;

    public static Database getInstance() {
        if (single_instance == null)
            single_instance = new Database();

        return single_instance;
    }

    private Database() {

    }

    public User getUserById(int id) {
        User user = new User();
        String url = "http://10.0.2.2:81/mobileproject/getUserById.php?&i d=" + id;


        return user;
    }

    public void updateUser(User user , SignUpActivity signUpActivity) {

        String url = "http://localhost:81/mobileproject/updateUser.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("success")) {
                    Toast.makeText(signUpActivity, "Update Done successfully.", Toast.LENGTH_SHORT).show();
                } else if (response.equals("failure")) {
                    Toast.makeText(signUpActivity, "Invalid Update !!!", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(signUpActivity, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("user_name", user.getUser_name());
                data.put("user_password", user.getUser_password());
                data.put("first_name", user.getFirst_name());
                data.put("last_name", user.getLast_name());
                data.put("visa_number", user.getVisa_number());
                data.put("user_email", user.getUser_email());
                data.put("user_phone", user.getUser_phone());
                data.put("user_gender", user.getUser_gender());
                data.put("user_age", user.getUser_age()+"");

                return data;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(signUpActivity.getApplicationContext());
        requestQueue.add(stringRequest);
    }
}
