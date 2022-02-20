package com.example.hotel21.controller.EmployeeController;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

import com.example.hotel21.R;
import com.example.hotel21.controller.common.LonginActivity;
import com.example.hotel21.model.user.IUserDa;
import com.example.hotel21.model.user.User;
import com.example.hotel21.model.user.UserFactory;

public class EmployeeUpdateHisInformation extends AppCompatActivity {
    private EditText user_name , pass ,fisrt_name , last_name ,visa_card,
            user_age , phone ,email ,age ,gender;
    User user ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_update_his_information);

        user_name = findViewById(R.id.Username_UE);
        pass = findViewById(R.id.Password_UE);
        fisrt_name = findViewById(R.id.firstName_UE);
        last_name = findViewById(R.id.LastName_UE);
        visa_card = findViewById(R.id.visanumber_UE);
        phone = findViewById(R.id.phone_UE);
        email = findViewById(R.id.Email_UE);
        age = findViewById(R.id.Age_UE);
        gender = findViewById(R.id.Gender_UE);
        user = LonginActivity.user;
        user_name.setText(user.getUser_name());


    }

    public void updatePersonalInformation(View view) {
        String password_ue = pass.getText().toString();
        String first_name_ue = fisrt_name.getText().toString();
        String last_name_ue =  last_name.getText().toString();
        String visa_card_ue = visa_card.getText().toString();
        String phone_ue = phone.getText().toString();
        String email_ue = email.getText().toString();
        String age_ue  =  age.getText().toString();
        String gender_ue = gender.getText().toString();

        UserFactory userFactory = new UserFactory() ;
        IUserDa iUserDa = userFactory.getModel();
        iUserDa.Updatedatafromemployee(this,user.getUser_name(),
                password_ue,first_name_ue,last_name_ue,visa_card_ue,email_ue,phone_ue,gender_ue,age_ue);

    }
}