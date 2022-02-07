package com.example.hotel21.controller.ui.reserved_rooms;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel21.R;
import com.example.hotel21.controller.rooms_controller.RoomAdapter;
import com.example.hotel21.controller.rooms_controller.RoomView;
import com.example.hotel21.model.room.Room;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.N)
public class GalleryFragment extends Fragment {
    RecyclerView recyclerView;
    public static List<Room> roomList;
    public static boolean order = false;
    static RoomAdapter roomAdapter;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.activity_main_screen, container, false);
        roomAdapter = new RoomAdapter(this.getContext(), roomList);
        RoomAdapter.reserve = true;
        recyclerView = view.findViewById(R.id.rooms_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(roomAdapter);
        System.out.println(view.getClass().getSimpleName());

        return view;

    }


    @RequiresApi(api = Build.VERSION_CODES.N)

    public static void addRoom(Room room) {
        if (roomList == null) {
            roomList = new ArrayList<>();
        }
        roomList.add(room);
    }

    public static void updateAdapter() {
        roomAdapter.notifyDataSetChanged();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}