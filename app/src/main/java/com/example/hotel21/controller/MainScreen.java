package com.example.hotel21.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.hotel21.R;
import com.example.hotel21.model.room.Room;

import java.util.ArrayList;
import java.util.List;

public class MainScreen extends AppCompatActivity {
    RecyclerView roomsRecyclerView;
    List<Room> roomList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        roomsRecyclerView = findViewById(R.id.rooms_recycler_view);
        initData();
        initRecyclerView();

    }

    private void initRecyclerView() {
        RoomAdapter roomAdapter = new RoomAdapter(this, roomList);
        roomsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        roomsRecyclerView.setAdapter(roomAdapter);
    }

    private void initData() {
        roomList = new ArrayList<>();
        roomList.add(new Room(1, 3, "typeR", 55, true, "qwerty", 4));
        roomList.add(new Room(2, 3, "typeR", 55, true, "qwerty", 4));
        roomList.add(new Room(3, 3, "typeR", 55, true, "qwerty", 4));
        roomList.add(new Room(7, 3, "typeR", 55, true, "qwerty", 4));
        roomList.add(new Room(5, 3, "typeR", 55, true, "qwerty", 4));
        roomList.add(new Room(1, 3, "typeR", 55, true, "qwerty", 4));
        roomList.add(new Room(1, 3, "typeR", 55, true, "qwerty", 4));
        roomList.add(new Room(1, 3, "typeR", 55, true, "qwerty", 4));
        roomList.add(new Room(1, 3, "typeR", 55, true, "qwerty", 4));
        roomList.add(new Room(1, 3, "typeR", 55, true, "qwerty", 4));
        roomList.add(new Room(1, 3, "typeR", 55, true, "qwerty", 4));
        roomList.add(new Room(1, 3, "typeR", 55, true, "qwerty", 4));
        roomList.add(new Room(1, 3, "typeR", 55, true, "qwerty", 4));
        roomList.add(new Room(1, 3, "typeR", 55, true, "qwerty", 4));
        roomList.add(new Room(1, 3, "typeR", 55, true, "qwerty", 4));
        roomList.add(new Room(1, 3, "typeR", 55, true, "qwerty", 4));
        roomList.add(new Room(1, 3, "typeR", 55, true, "qwerty", 4));
    }

}