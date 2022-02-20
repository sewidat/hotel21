package com.example.hotel21.controller.AdminController;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.hotel21.R;
import com.example.hotel21.model.user.UserDa;
import com.example.hotel21.model.user.UserFactory;

public class AdminAddEmployee extends AppCompatActivity {
    EditText userNameEditText, passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminadd_employees);
        userNameEditText = findViewById(R.id.Username_Emp);
        passwordEditText = findViewById(R.id.Password_Emp);
    }



    public void newEmployeeClick(View view) {
        String username = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        UserFactory userFactory = new UserFactory() ;
        UserDa userDa = userFactory.getModel();
        userDa.adminaddEmplyoee(this,username,password);
    }
}