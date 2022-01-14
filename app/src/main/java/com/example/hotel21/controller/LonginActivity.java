package com.example.hotel21.controller;

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
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
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

    //
    public void NewAccountonClik(View view) {
        Intent intent = new Intent(this, AdminMainPage.class);
        startActivity(intent);
    }


    static boolean isAllowed = false;

    public void loginonClick(View view) {
        String user_name = username.getText().toString();
        String user_password = password.getText().toString();

        if (user_name.isEmpty() || user_password.isEmpty()) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        } else {

            String url = "http://10.0.2.2/mobileproject/login.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String success = jsonObject.getString("success");
                        JSONArray jsonArray = jsonObject.getJSONArray("login");
                        if (success.equals("1")) {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                String name = object.getString("user_name");
                                String password = object.getString("user_password");


                            }

                        }
                        Intent intent = new Intent(LonginActivity.this, SignUpActivity.class);
                        startActivity(intent);
                        if (chx.isChecked()) {
                            editor.putString(NAME, user_name);
                            editor.putString(PASS, user_password);
                            editor.putBoolean(FLAG, true);
                            editor.commit();
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(LonginActivity.this, "Error" + e.getMessage(), Toast.LENGTH_SHORT);

                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(LonginActivity.this, "Error MESO" + error.getMessage(), Toast.LENGTH_SHORT);


                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> map = new HashMap<>();
                    map.put("user_name", user_name);
                    map.put("user_password", user_password);
                    return map;

                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);


        }
    }

    public void remember() {
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();
        boolean flag = preferences.getBoolean(FLAG, false);
        if (flag) {
            String name = preferences.getString(NAME, "");
            String passwordd = preferences.getString(PASS, "");
            username.setText(name);
            password.setText(passwordd);
            chx.setChecked(true);

        }


    }

    public void NewAccountOnClik(View view) {
    }
}


