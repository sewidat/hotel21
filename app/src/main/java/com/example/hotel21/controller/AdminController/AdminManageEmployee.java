package com.example.hotel21.controller.AdminController;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import com.example.hotel21.R;

public class AdminManageEmployee extends AppCompatActivity {
    TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_manage_employee);
        textView = findViewById(R.id.NameofadminID);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String data = preferences.getString("user_name", "");
        textView.setText(data);
    }

    public void removeEmployeeOnClik(View view) {
        Intent intent = new Intent(this,AdminRemoveEmployee.class);
        startActivity(intent);
    }

    public void addEmployeeOnClik(View view) {
        Intent intent = new Intent(this,AdminaddEmployees.class);
        startActivity(intent);
    }
}