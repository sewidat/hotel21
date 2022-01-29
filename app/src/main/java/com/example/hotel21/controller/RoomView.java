package com.example.hotel21.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.hotel21.R;
import com.example.hotel21.model.room.RoomDetail;

import java.util.ArrayList;

import lombok.var;

public class RoomView extends AppCompatActivity {
    ImageView imageView;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_view);
        gridView = findViewById(R.id.room_details_grid);
        imageView = findViewById(R.id.room_detail_image);
        Intent intent = getIntent();
        int imageID = intent.getIntExtra("image", R.drawable.hotel);
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
        Intent intent = new Intent(this,ReservePage.class);
        startActivity(intent);
    }
}