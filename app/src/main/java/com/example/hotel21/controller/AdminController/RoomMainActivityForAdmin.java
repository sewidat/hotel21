package com.example.hotel21.controller.AdminController;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import com.example.hotel21.R;

public class RoomMainActivityForAdmin extends AppCompatActivity {
    TextView userNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_main_acivity_for_admin);
        userNameTextView = findViewById(R.id.NameofadminInRoomMain);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String data = preferences.getString("user_name", "");
        userNameTextView.setText(data);
    }

    public void btnAddRoomOnClick(View view) {
        Intent intent = new Intent(RoomMainActivityForAdmin.this , AddRoomsActivity.class);
        startActivity(intent);
    }

    public void updateRoomsBtnOnClick(View view) {
        Intent intent = new Intent(RoomMainActivityForAdmin.this , RoomsListViewForEmployee.class);
        startActivity(intent);
    }
}