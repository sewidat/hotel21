package com.example.hotel21.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import com.example.hotel21.R;

public class AddRoomsActivity extends AppCompatActivity {
    EditText edtFloorNumber  , edtPriceOfRooms , edtRoomInformation, edtNumberOfBedds ;
    Spinner spinner_for_roomtype ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rooms);
        edtFloorNumber = findViewById(R.id.IDnumberOfFloor);
        edtPriceOfRooms = findViewById(R.id.IDpriceofRoom);
        edtRoomInformation = findViewById(R.id.IdRoomInformations);
        edtNumberOfBedds = findViewById(R.id.IdNumberOfBeds);
        spinner_for_roomtype = findViewById(R.id.IDtypeofRooms);

    }
    public void NewAccountonClik(View view) {
        String Number_of_floor = edtFloorNumber.getText().toString();
        String Price_of_Rooms = edtPriceOfRooms.getText().toString();
        String Room_in_info = edtRoomInformation.getText().toString();
        String Number_of_beds = edtNumberOfBedds.getText().toString();
        String Room_type = spinner_for_roomtype.getSelectedItem().toString();

        addRoom(Number_of_floor,Price_of_Rooms,Room_in_info,Number_of_beds,Room_type);

    }

    private void addRoom(String Number_of_floor, String Price_of_Rooms, String Room_in_info,String Number_of_beds
    ,String Room_type) {
        if (Number_of_floor.isEmpty() || Price_of_Rooms.isEmpty() || Room_in_info.isEmpty() || Number_of_beds.isEmpty() ||
                Room_type.isEmpty()) {
            Toast.makeText(this, "Please fill all data Requierd", Toast.LENGTH_SHORT).show();
        } else {
            String url = "http://10.0.2.2:80/mobileproject/SignUp.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("success")) {
                        Intent intent = new Intent(AddRoomsActivity.this, LonginActivity.class);
                        startActivity(intent);
                        finish();
                    } else if (response.equals("failure")) {
                        Toast.makeText(AddRoomsActivity.this, "Invalid  Process", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(AddRoomsActivity.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("floor_number", Number_of_floor);
                    data.put("type", Room_type);
                    data.put("day_price", Price_of_Rooms);
                    data.put("room_information", Room_in_info);
                    data.put("number_of_bed", Number_of_beds);


                    return data;
                }

            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }

    }}