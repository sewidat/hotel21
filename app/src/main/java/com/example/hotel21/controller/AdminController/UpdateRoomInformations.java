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
    private EditText room_id, floor_number, type, price, room_info,
            numberofbeds;



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
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int room_idd = preferences.getInt("room_id", 0);
         int floor_numberr = preferences.getInt("floor_number", 0);
        String typee = preferences.getString("type", "");
          String info = preferences.getString("info", "");
          int pricee = preferences.getInt("price", 0);
          int numberofbed = preferences.getInt("number_of_bed", 0);
        System.out.println("-----------" + floor_numberr + "---------");
        room_id.setText(String.valueOf(room_idd));
        floor_number.setText(String.valueOf(floor_numberr));
        type.setText(typee);
        price.setText(String.valueOf(pricee));
        room_info.setText(info);
        numberofbeds.setText(String.valueOf(numberofbed));


    }

    public void NewAccountonClik(View view) {
        int room_idd =  Integer.parseInt(room_id.getText().toString());
        int floor_numberr =  Integer.parseInt(floor_number.getText().toString());
        String typee = type.getText().toString();
        int pricee   = Integer.parseInt(price.getText().toString());
        String info =  room_info.getText().toString();
        int number_of_bed = Integer.parseInt(numberofbeds.getText().toString());


        Room room = new Room(room_idd,floor_numberr,typee, pricee,info,number_of_bed);
        RoomFactory roomFactory = new RoomFactory();
        IRoomDa iRoomDa = roomFactory.getModel();
        iRoomDa.updateRooms(room, UpdateRoomInformations.this);
    }
}