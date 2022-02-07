package com.example.hotel21.controller.rooms_controller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.hotel21.R;
import com.example.hotel21.controller.common.MainActivity;
import com.example.hotel21.controller.ui.reserved_rooms.GalleryFragment;

import java.util.ArrayList;

public class ReservePage extends AppCompatActivity {
    Spinner additionalServices, howManyNights;
    ArrayList servicesList, numOfNights;
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
        servicesList.add("music");
        numOfNights = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            numOfNights.add(i);
        }
        servicesAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, servicesList);
        nightsAdapter = new ArrayAdapter<Integer>(this, R.layout.support_simple_spinner_dropdown_item, numOfNights);
        servicesAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        nightsAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        additionalServices.setAdapter(servicesAdapter);
        howManyNights.setAdapter(nightsAdapter);
        Log.d("roomID", String.valueOf(roomID));
        System.out.println(RoomAdapter.roomList.get(position));


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void proceed(View view) {
        GalleryFragment.addRoom(RoomAdapter.roomList.get(position));
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}