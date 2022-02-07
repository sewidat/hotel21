package com.example.hotel21.controller.AdminController;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

import com.example.hotel21.R;
import com.example.hotel21.model.room.IRoomDa;
import com.example.hotel21.model.room.Room;
import com.example.hotel21.model.room.RoomFactory;

public class UpdateRoomInformations extends AppCompatActivity {
    private EditText room_id , floor_number ,type , price  ,room_info,
            numberofbeds ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_room_informations);
        room_id = findViewById(R.id.Up_roomid);
        floor_number = findViewById(R.id.Up_floornumber);
        type = findViewById(R.id.Up_type);
        price = findViewById(R.id.Up_roomprice);
        room_info = findViewById(R.id.Up_roomINFO);
        numberofbeds = findViewById(R.id.Up_numberofbeds);


    }

    public void NewAccountonClik(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int room_idd= preferences.getInt("room_id", 0);
        int floor_numberr= preferences.getInt("floor_number", 0);
        String typee  = preferences.getString("type", "");
        String info = preferences.getString("info","");
        int pricee = preferences.getInt("price",0);
        int numberofbed = preferences.getInt("number_of_bed",0);
        room_id.setText(String.valueOf(room_idd));
        floor_number.setText(String.valueOf(floor_numberr));
        type.setText(typee);
        price.setText(info);
        room_info.setText(String.valueOf(pricee));
        numberofbeds.setText(String.valueOf(numberofbed));
        Room room = new Room(room_idd,floor_numberr,typee, pricee,info,numberofbed);
        RoomFactory roomFactory = new RoomFactory() ;
        IRoomDa iRoomDa = roomFactory.getModel();
        iRoomDa.updateRooms(room, UpdateRoomInformations.this);
    }
}