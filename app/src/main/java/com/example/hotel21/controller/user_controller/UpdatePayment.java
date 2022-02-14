package com.example.hotel21.controller.user_controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.hotel21.R;
import com.example.hotel21.controller.common.LonginActivity;
import com.example.hotel21.model.user.IUserDa;
import com.example.hotel21.model.user.User;
import com.example.hotel21.model.user.UserFactory;

public class UpdatePayment extends AppCompatActivity {
    EditText update_visaNumbertxt  , oldvisanumbertxt;
    User user = LonginActivity.user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_payment);
        update_visaNumbertxt = findViewById(R.id.editTextTextPersonName2);
        oldvisanumbertxt = findViewById(R.id.Oldvisanumber);
        oldvisanumbertxt.setText(user.getVisa_number());

    }

    public void updatevisabtnOnClick(View view) {
        String visa_number = update_visaNumbertxt.getText().toString();
        user.setVisa_number(visa_number);
        UserFactory userFactory = new UserFactory();
        IUserDa iUserDa = userFactory.getModel();
        iUserDa.updateUser(user,UpdatePayment.this);



    }
}