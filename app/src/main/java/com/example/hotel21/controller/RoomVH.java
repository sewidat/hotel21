package com.example.hotel21.controller;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel21.R;

public class RoomVH extends RecyclerView.ViewHolder {
    private static final String TAG = "RoomVH";
    CardView cardView;
    TextView type, price, numberOfBeds, info;

    public RoomVH(@NonNull View itemView) {
        super(itemView);
        type = itemView.findViewById(R.id.type_of_room);
        price = itemView.findViewById(R.id.price);
        numberOfBeds = itemView.findViewById(R.id.number_of_beds);
        info = itemView.findViewById(R.id.info);
        cardView = itemView.findViewById(R.id.room_card);
        cardView.setOnClickListener(v -> {
//            Intent intent = new Intent(MainScreen.context, RoomActivity.class);
            Log.d("data", "works");
        });
    }


}
