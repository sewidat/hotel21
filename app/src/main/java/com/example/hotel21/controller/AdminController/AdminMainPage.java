package com.example.hotel21.controller.AdminController;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import com.example.hotel21.R;
import com.example.hotel21.controller.common.LonginActivity;


public class AdminMainPage extends AppCompatActivity {
     TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mainpage);
        textView = findViewById(R.id.NameofadminID_forMainPage);
        String data = getIntent().getStringExtra("user_name");

        textView.setText(data);
         SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
         SharedPreferences.Editor editor ;
        editor = preferences.edit();
        editor.putString("user_name", data);
        editor.commit();

    }

    public void addroomOnClik(View view) {
        Intent intent = new Intent(AdminMainPage.this, AdminManageEmployee.class);
        startActivity(intent);
    }

    public void deleteroomOnClik(View view) {
        Intent intent = new Intent(AdminMainPage.this, ServicePageForAdmin.class);
        startActivity(intent);
    }


    public void getroomOnClick(View view) {
        Intent intent = new Intent(AdminMainPage.this, RoomMainAcivityForAdmin.class);
        startActivity(intent);

    }

    public void LogoutONClik(View view) {

        Intent intent = new Intent(AdminMainPage.this, LonginActivity.class);
        startActivity(intent);
    }
}