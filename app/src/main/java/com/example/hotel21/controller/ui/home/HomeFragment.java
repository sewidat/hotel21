package com.example.hotel21.controller.ui.home;

import android.content.Context;
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

    private RecyclerView recyclerView;
    public static List<Room> roomList;
    public static boolean order = false;
    static RoomAdapter roomAdapter;

    Context context;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    ) {

        // false from lowest to highest
        RoomAdapter.reserve = false;
        context = container.getContext();
        Task task = new Task();
        View view = inflater.inflate(R.layout.activity_main_screen, container, false);
        roomAdapter = new RoomAdapter(container.getContext(), roomList);
        recyclerView = view.findViewById(R.id.rooms_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(roomAdapter);
        return view;

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initData() {
        try {
            roomList = (ArrayList<Room>) Database.getInstance().listRoomsforuser(context);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                roomAdapter.notifyDataSetChanged();
            }
        });

    }

    class Task implements Runnable {

        @Override
        public void run() {
            initData();
        }

    }

    public static void updateAdapter() {
        roomAdapter.notifyDataSetChanged();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}