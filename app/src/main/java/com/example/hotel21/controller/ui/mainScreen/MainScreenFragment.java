package com.example.hotel21.controller.ui.mainScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel21.R;
import com.example.hotel21.controller.RoomAdapter;
import com.example.hotel21.model.room.Room;

import java.util.ArrayList;
import java.util.List;

public class MainScreenFragment extends Fragment {
    RecyclerView recyclerView;
    List<Room> roomList;

    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        initData();
        RoomAdapter roomAdapter = new RoomAdapter(roomList);
        View view = inflater.inflate(R.layout.activity_main_screen, container, false);
        recyclerView = view.findViewById(R.id.rooms_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(roomAdapter);
        return view;

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
