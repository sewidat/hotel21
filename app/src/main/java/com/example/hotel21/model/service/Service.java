package com.example.hotel21.model.service;

public class Service {


        int service_id ;
        String service_description;
        int service_price ;

        public Service(int service_id, String service_description, int service_price) {
            this.service_id = service_id;
            this.service_description = service_description;
            this.service_price = service_price;
        }

        public int getService_id() {
            return service_id;
        }

        public void setService_id(int service_id) {
            this.service_id = service_id;
        }

        public String getService_description() {
            return service_description;
        }

        public void setService_description(String service_description) {
            this.service_description = service_description;
        }

        public int getService_price() {
            return service_price;
        }

        public void setService_price(int service_price) {
            this.service_price = service_price;
        }
    }


