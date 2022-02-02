package com.example.hotel21.model.service;

public class Service {


        int service_id ;
        String room_descrption;
        int service_price ;

        public Service(int service_id, String room_descrption, int service_price) {
            this.service_id = service_id;
            this.room_descrption = room_descrption;
            this.service_price = service_price;
        }

        public int getService_id() {
            return service_id;
        }

        public void setService_id(int service_id) {
            this.service_id = service_id;
        }

        public String getRoom_descrption() {
            return room_descrption;
        }

        public void setRoom_descrption(String room_descrption) {
            this.room_descrption = room_descrption;
        }

        public int getService_price() {
            return service_price;
        }

        public void setService_price(int service_price) {
            this.service_price = service_price;
        }
    }


