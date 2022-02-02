package com.example.hotel21.controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel21.R;
import com.example.hotel21.model.room.Room;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomVH> {
    private static final String TAG = "RoomAdapter";
    public static List<Room> roomList;
    Context context;

    public RoomAdapter(Context context, List<Room> roomList) {
        this.roomList = roomList;
        this.context = context;
    }

    public RoomAdapter(List<Room> roomList) {
        this.roomList = roomList;
    }

    @NonNull
    @Override
    public RoomVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_card, parent, false);
        return new RoomVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomVH holder, int position) {
        Room room = roomList.get(position);
        holder.type.setText(room.getType());
        holder.price.setText(room.getPrice() + "");
        holder.numberOfBeds.setText(room.getNumber_of_bed() + "");
        holder.info.setText(room.getRoom_information());
        holder.roomImage.setImageResource(R.drawable.map);
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(context, RoomView.class);
            intent.putExtra("image", R.drawable.map);
            intent.putExtra("roomID", roomList.get(position).getRoom_id() + "");
            intent.putExtra("position", position);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }
}
