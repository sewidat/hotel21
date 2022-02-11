package com.example.hotel21.controller.AdminController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hotel21.R;
import com.example.hotel21.controller.common.SignUpActivity;
import com.example.hotel21.model.room.IRoomDa;
import com.example.hotel21.model.room.Room;
import com.example.hotel21.model.room.RoomDa;
import com.example.hotel21.model.room.RoomFactory;
import com.example.hotel21.model.user.IUserDa;
import com.example.hotel21.model.user.UserFactory;

public class RoomsListViewForEmployee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms_list_view_for_employee);
        run();

    }



    public void run() {
        final Handler handler = new Handler();
        ListView listView = findViewById(R.id.GetRoomsListView_E);

        handler.post(
                () -> {
                    RoomFactory roomFactory = new RoomFactory();
                    IRoomDa iRoomDa = roomFactory.getModel();
                    iRoomDa.getRoomsforEmployee(this,listView);



                });
                }

    public void updateRoomsbtnOnClick(View view) {

    }
}