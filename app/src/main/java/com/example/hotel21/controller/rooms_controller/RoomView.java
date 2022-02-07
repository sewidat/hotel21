package com.example.hotel21.controller.rooms_controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.hotel21.R;
import com.example.hotel21.model.room.RoomDetail;

import java.util.ArrayList;

public class RoomView extends AppCompatActivity {
    ImageView imageView;
    GridView gridView;
    int roomID;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_view);
        gridView = findViewById(R.id.room_details_grid);
        imageView = findViewById(R.id.room_detail_image);
        Intent intent = getIntent();
        roomID = Integer.parseInt(intent.getStringExtra("roomID"));
        position = intent.getIntExtra("position", 0);
        int imageID = intent.getIntExtra("image", R.drawable.hotel);
        Log.d("roomId", roomID + "");
        imageView.setImageResource(imageID);
        ArrayList<RoomDetail> roomDetails = new ArrayList<>();
        roomDetails.add(new RoomDetail("detail1", R.drawable.ic_baseline_info_24));
        roomDetails.add(new RoomDetail("detail1", R.drawable.ic_baseline_info_24));
        roomDetails.add(new RoomDetail("detail1", R.drawable.ic_baseline_info_24));
        roomDetails.add(new RoomDetail("detail1", R.drawable.ic_baseline_info_24));
        roomDetails.add(new RoomDetail("detail1", R.drawable.ic_baseline_info_24));
        RoomDetailGVAdapter roomDetailGVAdapter = new RoomDetailGVAdapter(this, roomDetails);
        gridView.setAdapter(roomDetailGVAdapter);
    }

    public void reserve(View view) {
        Intent intent = new Intent(this, ReservePage.class);
        intent.putExtra("roomID", roomID);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}