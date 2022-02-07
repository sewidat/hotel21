package com.example.hotel21.model.room;


public class Room {
    int room_id ;
    int floor_number ;
    String type ;
    int price ;
    boolean is_available;
    String room_information ;
    int  number_of_bed ;



    public Room(int room_id, int floor_number, String type, int price , boolean is_available, String room_information, int number_of_bed) {
        this.room_id = room_id;
        this.floor_number = floor_number;
        this.type = type ;
        this.price = price;
        this.is_available = is_available;
        this.room_information = room_information;
        this.number_of_bed = number_of_bed ;
    }

    public Room(int room_id, int floor_number, String type, int price ,  String room_information, int number_of_bed) {
        this.room_id = room_id;
        this.floor_number = floor_number;
        this.type = type ;
        this.price = price;
        this.room_information = room_information;
        this.number_of_bed = number_of_bed ;
    }
    public Room( int floor_number, String type, int price ,  String room_information, int number_of_bed) {
        this.room_id = room_id;
        this.floor_number = floor_number;
        this.type = type ;
        this.price = price;
        this.room_information = room_information;
        this.number_of_bed = number_of_bed ;
    }




    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getFloor_number() {
        return floor_number;
    }

    public void setFloor_number(int floor_number) {
        this.floor_number = floor_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    public String getRoom_information() {
        return room_information;
    }

    public void setRoom_information(String room_information) {
        this.room_information = room_information;
    }

    public int getNumber_of_bed() {
        return number_of_bed;
    }

    public void setNumber_of_bed(int number_of_bed) {
        this.number_of_bed = number_of_bed;
    }
}


