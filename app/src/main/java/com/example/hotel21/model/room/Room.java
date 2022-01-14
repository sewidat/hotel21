package com.example.hotel21.model.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    int room_id ;
    int floor_number ;
    String type ;
    double price ;
    boolean is_available;
    String room_information ;
    int  number_of_bed ;
}
