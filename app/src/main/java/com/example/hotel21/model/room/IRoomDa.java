package com.example.hotel21.model.room;

import android.widget.ListView;

import com.example.hotel21.controller.AdminController.RoomsListViewForEmployee;
import com.example.hotel21.controller.AdminController.UpdateRoomInformations;

public interface IRoomDa {
    void getRoomsforEmployee(RoomsListViewForEmployee roomsListViewForEmployee , ListView listView);
    void updateRooms(Room room , UpdateRoomInformations updateRoomInformations);
}
