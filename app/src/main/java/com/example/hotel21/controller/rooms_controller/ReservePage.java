package com.example.hotel21.controller.rooms_controller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hotel21.R;
import com.example.hotel21.controller.common.LonginActivity;
import com.example.hotel21.controller.common.MainActivity;
import com.example.hotel21.controller.ui.home.HomeFragment;
import com.example.hotel21.controller.ui.reserved_rooms.GalleryFragment;
import com.example.hotel21.model.database.Database;
import com.example.hotel21.model.reserve.Reserve;
import com.example.hotel21.model.room.Room;
import com.example.hotel21.model.service.Service;
import com.example.hotel21.model.user.User;

import java.security.Provider;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ReservePage extends AppCompatActivity {
    Spinner additionalServices, howManyNights;
    ArrayList<String> servicesList;
    ArrayList<Integer> numOfNights;
    private ArrayList<Service> services;
    ArrayAdapter<String> servicesAdapter;
    ArrayAdapter<Integer> nightsAdapter;
    int roomID;
    int position;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_page);
        additionalServices = findViewById(R.id.spinner);
        howManyNights = findViewById(R.id.spinner2);
        Intent intent = getIntent();
        roomID = intent.getIntExtra("roomID", 0);
        position = intent.getIntExtra("position", 0);
        servicesList = new ArrayList();
        Thread thread = new Thread(new ServicesTask(this));
        thread.start();
        servicesAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, servicesList);
        numOfNights = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            numOfNights.add(i);
        }
        nightsAdapter = new ArrayAdapter<Integer>(this, R.layout.support_simple_spinner_dropdown_item, numOfNights);
        servicesAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        nightsAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        additionalServices.setAdapter(servicesAdapter);
        howManyNights.setAdapter(nightsAdapter);
        Log.d("roomID", String.valueOf(roomID));

        additionalServices.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "This is " +
                        adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        servicesAdapter.notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void proceed(View view) {
/*
i need to show the reservies that user have i the current time
 */
        GalleryFragment.addRoom(RoomAdapter.roomList.get(position));

        DateTimeFormatter dtf = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        }
        LocalDateTime now = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            now = LocalDateTime.now();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            System.out.println(dtf.format(now));
        }
        String startDate = now.toString().substring(0, 10);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //create instance of the Calendar class and set the date to the given date
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(startDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Room room = RoomAdapter.roomList.get(position);
        int numberOfNights = 0;
        double totalPrice = room.getPrice() * numberOfNights;


        // use add() method to add the days to the given date
        cal.add(Calendar.DAY_OF_MONTH, 3);
        String endDate = sdf.format(cal.getTime());

        User user = LonginActivity.user;
        String additional_Services = additionalServices.getSelectedItem().toString();
        String howMany_Nights = howManyNights.getSelectedItem().toString();

        Reserve reserve = new Reserve(room.getRoom_id(), user.getUser_id()
                , startDate, endDate, false, totalPrice);
        Database.getInstance().addReservebyuser(reserve, ReservePage.this);

    }


    class ServicesTask implements Runnable {
        AppCompatActivity activity;

        public ServicesTask(AppCompatActivity activity) {
            this.activity = activity;
        }

        @Override
        public void run() {
            Database.getServices(activity);
            while (Database.services == null) {

            }
            services = Database.services;
            for (Service service : services)
                servicesList.add(service.getService_description());
        }
    }
}