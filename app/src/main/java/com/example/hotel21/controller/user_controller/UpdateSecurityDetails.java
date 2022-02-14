package com.example.hotel21.controller.user_controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hotel21.R;
import com.example.hotel21.controller.common.LonginActivity;
import com.example.hotel21.model.user.IUserDa;
import com.example.hotel21.model.user.User;
import com.example.hotel21.model.user.UserFactory;

public class UpdateSecurityDetails extends AppCompatActivity {
  EditText updatePasswordtxt , retypetxt , user_nametxt;
  User user = LonginActivity.user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_security_details);
        updatePasswordtxt = findViewById(R.id.userUpdatePasswordEdittext);
        retypetxt = findViewById(R.id.userRewritePasswordEdittext);
        user_nametxt = findViewById(R.id.username_update_pass_page);
        updatePasswordtxt.setText(user.getUser_password());
        user_nametxt.setText(user.getUser_name());



    }

    public void submitbtnOnClick(View view) {
        String new_username = updatePasswordtxt.getText().toString();
        String retypePass = retypetxt.getText().toString();
        if(new_username.equals(retypePass)) {

            user.setUser_password(new_username);
            UserFactory userFactory = new UserFactory();
            IUserDa iUserDa = userFactory.getModel();
            iUserDa.updateUser(user, UpdateSecurityDetails.this);

        }else {
            Toast.makeText(UpdateSecurityDetails.this,"Please retype password correctly",Toast.LENGTH_SHORT).show();
        }
    }
}