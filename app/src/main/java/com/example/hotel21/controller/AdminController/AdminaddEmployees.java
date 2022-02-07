package com.example.hotel21.controller.AdminController;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.hotel21.R;
import com.example.hotel21.model.database.Database;
import com.example.hotel21.model.user.UserDa;
import com.example.hotel21.model.user.UserFactory;

public class AdminaddEmployees extends AppCompatActivity {
    EditText edt1 , edt2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminadd_employees);
        edt1 = findViewById(R.id.Username_Emp);
        edt2 = findViewById(R.id.Password_Emp);
    }



    public void NewEmployeeClik(View view) {
        String username = edt1.getText().toString();
        String password = edt2.getText().toString();
        UserFactory userFactory = new UserFactory() ;
        UserDa userDa = userFactory.getModel();
        userDa.adminaddEmplyoee(this,username,password);


    }
}