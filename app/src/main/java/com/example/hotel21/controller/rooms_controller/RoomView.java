package com.example.hotel21.controller.rooms_controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.hotel21.R;
import com.example.hotel21.model.room.Room;
import com.example.hotel21.model.room.RoomDetail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RoomView extends AppCompatActivity {
    ImageView imageView;
    GridView gridView;
    int roomID;
    int position;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_view);
        gridView = findViewById(R.id.room_details_grid);
        imageView = findViewById(R.id.room_detail_image);
        button = findViewById(R.id.button5);
        Intent intent = getIntent();
        boolean reserve = intent.getBooleanExtra("reserve", false);
        if (reserve) {
            button.setVisibility(View.GONE);
        }
        roomID = Integer.parseInt(intent.getStringExtra("roomID"));
        position = intent.getIntExtra("position", 0);
        String imageID = intent.getStringExtra("image");
        Log.d("roomId", roomID + "");
//        imageView.setImageResource(imageID);
        Picasso.get().load(imageID).into(imageView);
        ArrayList<RoomDetail> roomDetails = new ArrayList<>();
        Room room = RoomAdapter.roomList.get(position);
        roomDetails.add(new RoomDetail("price: " + room.getPrice(), android.R.drawable.ic_menu_info_details));
        roomDetails.add(new RoomDetail("floor number: " + room.getFloor_number(), android.R.drawable.ic_menu_info_details));
        roomDetails.add(new RoomDetail("number of beds: " + room.getNumber_of_bed(), android.R.drawable.ic_menu_info_details));
        roomDetails.add(new RoomDetail("type: " + room.getType(), android.R.drawable.ic_menu_info_details));
        roomDetails.add(new RoomDetail("more: " + room.getRoom_information(),android.R.drawable.ic_menu_info_details));


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