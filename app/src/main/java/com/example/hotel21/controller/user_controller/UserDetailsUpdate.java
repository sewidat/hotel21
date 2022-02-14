package com.example.hotel21.controller.user_controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hotel21.R;
import com.example.hotel21.controller.common.LonginActivity;
import com.example.hotel21.model.user.IUserDa;
import com.example.hotel21.model.user.User;
import com.example.hotel21.model.user.UserFactory;


public class UserDetailsUpdate extends AppCompatActivity {
    EditText emailtext , firstnametext, lastnametext , age ;
    Character gender ;
    public  static String email,first_name,last_name,Age;
    Button savebtn ;
    User user = LonginActivity.user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details_update);
        emailtext = findViewById(R.id.editTextTextPersonName4);
        firstnametext = findViewById(R.id.editTextTextPersonName5);
        lastnametext = findViewById(R.id.editTextTextPersonName6);
        savebtn =  findViewById(R.id.savebtnuser);
        age = findViewById(R.id.editTextTextPersonName7);
        emailtext.setText(user.getUser_email());
        firstnametext.setText(user.getFirst_name());
        lastnametext.setText(user.getLast_name());
        age.setText(String.valueOf(user.getUser_age()));






    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButtonF:
                if (checked)
                    gender = 'F';

                    break;
            case R.id.radioButtonM:
                if (checked)
                    gender = 'M';
                    break;
        }

    }

    public void savebtnclick(View view) {
        email = emailtext.getText().toString();
        first_name = firstnametext.getText().toString();
        last_name = lastnametext.getText().toString();
        Age = age.getText().toString();
        Character g = gender;
        user.setFirst_name(first_name);
        user.setUser_email(email);
        user.setLast_name(last_name);
        user.setUser_age(Integer.parseInt(Age));
        UserFactory userFactory = new UserFactory();
        IUserDa iUserDa = userFactory.getModel();
        iUserDa.updateUser(user,UserDetailsUpdate.this);
    }
}