package com.example.hotel21.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel21.R;
import com.example.hotel21.model.room.Room;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomVH> {
    private static final String TAG = "RoomAdapter";
    List<Room> roomList;

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
        holder.numberOfBeds.setText(room.getNumber_of_bed()+"");
        holder.info.setText(room.getRoom_information());

    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }
}
