package com.example.hotel21.controller.EmployeeController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hotel21.R;
import com.example.hotel21.controller.common.LonginActivity;
import com.example.hotel21.model.database.Database;
import com.example.hotel21.model.reserve.IReserveDa;
import com.example.hotel21.model.reserve.ReserveFactory;
import com.example.hotel21.model.service.IServiceDa;
import com.example.hotel21.model.service.Service;
import com.example.hotel21.model.service.ServiceFactory;

import java.util.ArrayList;

public class EmployeeMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_main_page);
        updateResandServ();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String data = preferences.getString("user_name", "");
        System.out.println("inside employee  " + data);
        run();
    }

    public void run() {
        final Handler handler = new Handler();
        ListView listView = findViewById(R.id.listvieww);

        handler.post(
                () -> {

                    ServiceFactory serviceFactory = new ServiceFactory();
                    IServiceDa iServiceDa = serviceFactory.getModel();
                    iServiceDa.getallservicces(EmployeeMainPage.this,listView);
                }
        );

    }

    public void Logoutforemployee(View view) {
        Intent intent = new Intent(EmployeeMainPage.this, LonginActivity.class);
        startActivity(intent);
    }


    public void OnCLickEmployee(View view) {
        Intent intent = new Intent(EmployeeMainPage.this ,UpdateReservitionEmp_Acitivty.class);
        startActivity(intent);
       /* ReserveFactory reserveFactory = new ReserveFactory();
        IReserveDa iReserveDa = reserveFactory.getModel();
        iReserveDa.setAllDoneReservesDone(EmployeeMainPage.this);*/
    }
    public void updateResandServ(){
        ReserveFactory reserveFactory = new ReserveFactory();
        IReserveDa iReserveDa = reserveFactory.getModel();
//        iReserveDa.setReservesToServiceDone(EmployeeMainPage.this);

    }


    public void OnclickForDoneReserve(View view) {
    }


}