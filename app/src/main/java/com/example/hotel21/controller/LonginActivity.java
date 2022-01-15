package com.example.hotel21.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import com.example.hotel21.R;

public class LonginActivity extends AppCompatActivity {
    EditText username, password;
    private RequestQueue queue;
    private  SharedPreferences preferences ;
    private  SharedPreferences.Editor editor;
    public static final String NAME = "NAME";
    public static final String FLAG = "FLAG";
    public static final String PASS = "PASS";
    CheckBox chx;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ogin);
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        queue = Volley.newRequestQueue(this);
        chx = findViewById(R.id.checkbox);
        remember();

    }



    public void AccountonClik(View view) {
        Intent intent = new Intent(this, AdminMainPage.class);
        startActivity(intent);
    }

    static boolean isAllowed = false;

    public void loginonClick(View view) {
        String user_name = username.getText().toString();
        String user_password = password.getText().toString();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());


        if (user_name.isEmpty() || user_password.isEmpty()) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        } else {

            String url = "http://10.0.2.2:81/hotel21/login.php";
            StringRequest stringRequest  = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    System.out.println(response  + "----mes");

                    if(response.contains("successC")){

                        Toast.makeText(LonginActivity.this,"malik" + password,Toast.LENGTH_SHORT);
                        Intent intent = new Intent(LonginActivity.this, SignUpActivity.class);
                        startActivity(intent);

                    }else if(response.contains("successA")){
                        Toast.makeText(LonginActivity.this,"hello Admin" ,Toast.LENGTH_SHORT);
                        System.out.println("hello admin");
                        Intent intent = new Intent(LonginActivity.this, AddRoomsActivity.class);
                        startActivity(intent);


                    }else if(response.contains("successE")){
                        Toast.makeText(LonginActivity.this,"hello employee" ,Toast.LENGTH_SHORT);
                        Intent intent = new Intent(LonginActivity.this, AdminMainPage.class);
                        startActivity(intent);

                    }else if(response.contains("failure")){

                        Toast.makeText(LonginActivity.this,"Invalid Log in " ,Toast.LENGTH_SHORT);

                    }




                    if(chx.isChecked()){
                        editor.putString(NAME,user_name);
                        editor.putString(PASS,user_password);
                        editor.putBoolean(FLAG,true);
                        editor.commit();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(LonginActivity.this,"Error MESO" + error.getMessage(),Toast.LENGTH_SHORT);



                }
            })
            {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> map = new HashMap<>();
                    map.put("user_name",user_name);
                    map.put("user_password",user_password);
                    return map;

                }
            };

            requestQueue.add(stringRequest);


        }
    }

    public void remember() {
        preferences =PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();
        boolean flag = preferences.getBoolean(FLAG,false );
        if(flag){
            String name = preferences.getString(NAME,"");
            String passwordd = preferences.getString(PASS,"");
            username.setText(name);
            password.setText(passwordd);
            chx.setChecked(true);




        }



    }



}
