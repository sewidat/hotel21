package com.example.hotel21.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hotel21.R;
import com.example.hotel21.model.room.RoomDetail;

import java.util.ArrayList;

public class RoomDetailGVAdapter extends ArrayAdapter<RoomDetail> {
    public RoomDetailGVAdapter(@NonNull Context context, ArrayList<RoomDetail> arrayList) {
        super(context, 0, arrayList);
    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.room_detail, parent, false);

        }
        RoomDetail roomDetail = getItem(position);
        ImageView imageView = listItemView.findViewById(R.id.room_detail_icon);
        TextView textView = listItemView.findViewById(R.id.room_detail_detail);
        imageView.setImageResource(roomDetail.getIconID());
        textView.setText(roomDetail.getDetail());
        return listItemView;
    }
}
