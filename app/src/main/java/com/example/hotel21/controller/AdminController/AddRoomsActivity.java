package com.example.hotel21.controller.AdminController;

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
import com.example.hotel21.controller.common.LonginActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AddRoomsActivity extends AppCompatActivity {
    EditText edtFloorNumber  , edtPriceOfRooms , edtRoomInformation, edtNumberOfBedds ;
    Spinner spinnerForRoomType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rooms);
        edtFloorNumber = findViewById(R.id.IDnumberOfFloor);
        edtPriceOfRooms = findViewById(R.id.IDpriceofRoom);
        edtRoomInformation = findViewById(R.id.IdRoomInformations);
        edtNumberOfBedds = findViewById(R.id.IdNumberOfBeds);
        spinnerForRoomType = findViewById(R.id.IDtypeofRooms);

    }
    public void btnAddRoomOnClick(View view) {
        int numberOfFloor = Integer.parseInt(edtFloorNumber.getText().toString());
        Double nightPrice = Double.parseDouble(edtPriceOfRooms.getText().toString());
        String roomInfo = edtRoomInformation.getText().toString();
        int bedsNumber = Integer.parseInt(edtNumberOfBedds.getText().toString());
        String roomType = spinnerForRoomType.getSelectedItem().toString();

        ArrayList<String> images = new ArrayList<>();
        images.add("http://10.0.2.2:80/hotel21/photos/1.jpeg");
        images.add("http://10.0.2.2:80/hotel21/photos/2.jpg");
        images.add("http://10.0.2.2:80/hotel21/photos/3.jpg");
        images.add("http://10.0.2.2:80/hotel21/photos/4.jpg");

        int random_int = (int)Math.floor(Math.random()*(4-1+1)+1);
        String image_url = images.get(random_int);
        addRoom(numberOfFloor,roomType,nightPrice,roomInfo,bedsNumber , image_url);
    }







    private void addRoom(int Number_of_floor, String Room_type, Double Price_of_Rooms,String Room_in_info
    ,int Number_of_beds  ,String image_url) {
        if (Number_of_floor == 0 || Price_of_Rooms == 0 || Room_in_info.isEmpty() || Number_of_beds == 0 ||
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
                    data.put("floor_number", String.valueOf(Number_of_floor));
                    data.put("type", Room_type);
                    data.put("day_price", String.valueOf(Price_of_Rooms));
                    data.put("room_information", Room_in_info);
                    data.put("number_of_bed", String.valueOf(Number_of_beds));
                    data.put("image_url", String.valueOf(image_url));

                    return data;
                }

            };
            requestQueue.add(stringRequest);
            //Room room = new Room(Number_of_floor,Room_type,Price_of_Rooms,Room_in_info,Number_of_beds);
        }

    }



}