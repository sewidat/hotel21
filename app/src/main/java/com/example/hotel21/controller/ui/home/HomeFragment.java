package com.example.hotel21.controller.ui.home;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel21.R;
import com.example.hotel21.controller.common.MainActivity;
import com.example.hotel21.controller.rooms_controller.RoomAdapter;
import com.example.hotel21.model.database.Database;
import com.example.hotel21.model.room.Room;

import java.util.ArrayList;
import java.util.List;


@RequiresApi(api = Build.VERSION_CODES.N)
public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    public static List<Room> roomList;
    public static boolean order = false;
    static RoomAdapter roomAdapter;


    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    ) {

        // false from lowest to highest
        initData();
        RoomAdapter.reserve = false;
        roomAdapter = new RoomAdapter(container.getContext(), roomList);
        View view = inflater.inflate(R.layout.activity_main_screen, container, false);
        recyclerView = view.findViewById(R.id.rooms_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(roomAdapter);
        return view;

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initData() {
        roomList = Database.getInstance().roomlistforemployee(HomeFragment.this);

    }

    public static void updateAdapter() {
        roomAdapter.notifyDataSetChanged();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}