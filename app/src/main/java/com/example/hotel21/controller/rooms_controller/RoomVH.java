package com.example.hotel21.controller.rooms_controller;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel21.R;

public class RoomVH extends RecyclerView.ViewHolder {
    private static final String TAG = "RoomVH";
    CardView cardView;
    ImageView roomImage;
    TextView type, price, numberOfBeds, info;
    LinearLayout parentLayout;
    Intent intent;

    public RoomVH(@NonNull View itemView) {
        super(itemView);
        type = itemView.findViewById(R.id.type_of_room);
        price = itemView.findViewById(R.id.price);
        numberOfBeds = itemView.findViewById(R.id.number_of_beds);
        info = itemView.findViewById(R.id.info);
        cardView = itemView.findViewById(R.id.room_card);
        parentLayout = itemView.findViewById(R.id.parent_rooms);
        roomImage = itemView.findViewById(R.id.room_card_image);
//        cardView.setOnClickListener(v -> {
//
//            Intent intent = new Intent(cardView.getContext(), RoomActivity.class);
//            this.intent = intent;
////            Log.d("data", "works");
//
//        });
    }


}
