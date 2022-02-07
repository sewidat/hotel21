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
    String room_information;
    int number_of_bed;


    public int compareToL2H(Room o) {
        if (price == o.price) {
            return 0;
        } else {
            if (price > o.price) {
                return 1;
            } else {
                return -1;
            }
        }

    }

    public int compareToH2L(Room o) {
        if (price == o.price) {
            return 0;
        } else {
            if (price > o.price) {
                return -1;
            } else {
                return 1;
            }
        }

    }


}
