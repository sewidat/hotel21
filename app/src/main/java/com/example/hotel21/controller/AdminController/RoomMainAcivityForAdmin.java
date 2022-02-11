package com.example.hotel21.controller.AdminController;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import com.example.hotel21.R;

public class RoomMainAcivityForAdmin extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_main_acivity_for_admin);
        textView = findViewById(R.id.NameofadminInRoomMain);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String data = preferences.getString("user_name", "");
        textView.setText(data);
    }

    public void btnaddRoomOnClik(View view) {
        Intent intent = new Intent(RoomMainAcivityForAdmin.this , AddRoomsActivity.class);
        startActivity(intent);
    }

    public void updateRoomsbtnOnClik(View view) {
        Intent intent = new Intent(RoomMainAcivityForAdmin.this , RoomsListViewForEmployee.class);
        startActivity(intent);
    }
}