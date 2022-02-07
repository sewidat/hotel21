package com.example.hotel21.controller.EmployeeController;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hotel21.R;

public class EmployeeListViewItem   {
    private int reserveID ;
    private int  serviceID ;
    private  int room_id ;
    private  String service_description;

    public EmployeeListViewItem(int reserveID, int serviceID, int room_id, String service_description) {
        this.reserveID = reserveID;
        this.serviceID = serviceID;
        this.room_id = room_id;
        this.service_description = service_description;
    }

    public int getReserveID() {
        return reserveID;
    }

    public void setReserveID(int reserveID) {
        this.reserveID = reserveID;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getservice_description() {
        return service_description;
    }

    public void setservice_description(String room_description) {
        this.service_description = room_description;
    }

}
