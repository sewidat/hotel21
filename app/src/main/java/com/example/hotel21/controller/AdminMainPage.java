package com.example.hotel21.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hotel21.R;


public class AdminMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mainpage);
    }

    public void addroomOnClik(View view) {
        Intent intent = new Intent(AdminMainPage.this, AddRoomsActivity.class);
        startActivity(intent);
    }

    public void deleteroomOnClik(View view) {
        Intent intent = new Intent(AdminMainPage.this,SignUpActivity.class);
        startActivity(intent);
    }

    public void getroomOnClick(View view) {
        Intent intent = new Intent(AdminMainPage.this,SignUpActivity.class);
        startActivity(intent);
    }

   
}