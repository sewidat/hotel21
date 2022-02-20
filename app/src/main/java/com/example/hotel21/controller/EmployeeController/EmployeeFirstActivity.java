package com.example.hotel21.controller.EmployeeController;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hotel21.R;
import com.example.hotel21.controller.common.LonginActivity;
import com.example.hotel21.model.user.User;

public class EmployeeFirstActivity extends AppCompatActivity {
    TextView tv  ;
    User user = LonginActivity.user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_first);
        tv = findViewById(R.id.NameofemployeeID_forMainPage);
        tv.setText(user.getUser_name());
    }

    public void ManageServicesOnClik(View view) {
        Intent intent = new Intent(EmployeeFirstActivity.this,EmployeeMainPage.class);
        startActivity(intent);
    }

    public void updaterInformation(View view) {
        Intent intent = new Intent(EmployeeFirstActivity.this , EmployeeUpdateHisInformation.class);
        startActivity(intent);



    }



    public void logoutonClick(View view) {
        Intent intent = new Intent(EmployeeFirstActivity.this, LonginActivity.class);
        startActivity(intent);
    }
}