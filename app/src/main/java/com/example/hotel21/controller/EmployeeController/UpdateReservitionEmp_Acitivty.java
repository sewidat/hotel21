package com.example.hotel21.controller.EmployeeController;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ListView;

import com.example.hotel21.R;
import com.example.hotel21.model.reserve.IReserveDa;
import com.example.hotel21.model.reserve.ReserveFactory;
import com.example.hotel21.model.service.IServiceDa;
import com.example.hotel21.model.service.ServiceFactory;
import com.example.hotel21.model.user.IUserDa;
import com.example.hotel21.model.user.UserFactory;

public class UpdateReservitionEmp_Acitivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_reservition_emp_acitivty);
        run();
    }

    public void run() {
        final Handler handler = new Handler();
        ListView listView = findViewById(R.id.Up_listview);

        handler.post(
                () -> {

                    ReserveFactory reserveFactory = new ReserveFactory();
                    IReserveDa iReserveDa = reserveFactory.getModel();
                    iReserveDa.getReservtionTable(UpdateReservitionEmp_Acitivty.this,listView);
                }
        );

    }

    public void Upbackbtn(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String data = preferences.getString("user_name", "");
        UserFactory userFactory = new UserFactory() ;
        IUserDa iUserDa = userFactory.getModel();
        iUserDa.Updatedatafromemployee(this, data,"mohammad12345","1231","malikissa@gmail.com","0597615538","210");
    }

    public void Upreservebtn(View view) {
        ReserveFactory reserveFactory = new ReserveFactory();
        IReserveDa  iReserveDa =  reserveFactory.getModel();
        iReserveDa.setAllDoneReservesDone(UpdateReservitionEmp_Acitivty.this);
    }
}