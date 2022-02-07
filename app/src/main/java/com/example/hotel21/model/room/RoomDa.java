package com.example.hotel21.model.room;


import android.widget.ListView;

import com.example.hotel21.controller.AdminController.RoomsListViewForEmployee;
import com.example.hotel21.controller.AdminController.UpdateRoomInformations;
import com.example.hotel21.model.database.Database;

 public class RoomDa implements IRoomDa{


    @Override
    public void getRoomsforEmployee(RoomsListViewForEmployee roomsListViewForEmployee, ListView listView) {
        Database database = Database.getInstance();
        database.getRoomsForAdmin(roomsListViewForEmployee,listView);
    }

     @Override
     public void updateRooms(Room room, UpdateRoomInformations updateRoomInformations) {
         Database database = Database.getInstance();
         database.updateRooms(room,updateRoomInformations);
     }
 }
