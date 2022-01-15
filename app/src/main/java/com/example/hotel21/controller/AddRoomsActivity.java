package com.example.hotel21.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hotel21.R;

import java.util.HashMap;
import java.util.Map;


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
    public void btnaddRoomOnClik(View view) {
        String Number_of_floor = edtFloorNumber.getText().toString();
        String Price_of_Rooms = edtPriceOfRooms.getText().toString();
        String Room_in_info = edtRoomInformation.getText().toString();
        String Number_of_beds = edtNumberOfBedds.getText().toString();
        String Room_type = spinner_for_roomtype.getSelectedItem().toString();

        addRoom(Number_of_floor,Room_type,Price_of_Rooms,Room_in_info,Number_of_beds);
    }







    private void addRoom(String Number_of_floor, String Room_type, String Price_of_Rooms,String Room_in_info
    ,String Number_of_beds) {
        if (Number_of_floor.isEmpty() || Price_of_Rooms.isEmpty() || Room_in_info.isEmpty() || Number_of_beds.isEmpty() ||
                Room_type.isEmpty()) {
            Toast.makeText(this, "Please fill all data Requierd", Toast.LENGTH_SHORT).show();
        } else {
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            System.out.println("data i  nedd  " +Number_of_floor + "-" + Price_of_Rooms + "-" +
                    "-" +Room_type + "-" + Room_in_info + "-" + Number_of_beds);
            String url = "http://10.0.2.2:80/mobileproject/AddRoom.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    System.out.println(response);
                    if (response.contains("success")) {
                        Toast.makeText(AddRoomsActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AddRoomsActivity.this, LonginActivity.class);
                        startActivity(intent);
                        finish();


                    } else if (response.contains("failure")) {
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
            requestQueue.add(stringRequest);
        }

    }



}