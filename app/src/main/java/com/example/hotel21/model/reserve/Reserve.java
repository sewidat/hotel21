package com.example.hotel21.model.reserve;

import com.example.hotel21.model.room.Room;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class Reserve {

    private int reserve_id ;
    private int room_id;
    private int customer_id ;
    private String start_time;
    private String end_time ;
    private boolean is_done;
    private double total_price;

    public Reserve(int reserve_id, int room_id, int customer_id, String start_time, String end_time, boolean is_done, double total_price) {
        this.reserve_id = reserve_id;
        this.room_id = room_id;
        this.customer_id = customer_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.is_done = is_done;
        this.total_price = total_price;
    }
    public Reserve(int reserve_id, int room_id, String start_time, String end_time) {
        this.reserve_id = reserve_id;
        this.room_id = room_id;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public int getReserve_id() {
        return reserve_id;
    }

    public void setReserve_id(int reserve_id) {
        this.reserve_id = reserve_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public boolean isIs_done() {
        return is_done;
    }

    public void setIs_done(boolean is_done) {
        this.is_done = is_done;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
}
