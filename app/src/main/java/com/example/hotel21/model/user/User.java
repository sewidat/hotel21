package com.example.hotel21.model.user;

import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;


public class User {
    private int user_id;
    private String user_name;
    private String user_password;
    private String first_name;
    private String last_name;
    private String visa_number;
    private String user_email;
    private String user_phone;
    private String user_gender;
    private String user_age;
    private char user_type;

    public User(int user_id, String user_name, String user_password, String first_name, String last_name, String visa_number, String user_email, String user_phone, String user_gender, String user_age, char user_type) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.visa_number = visa_number;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.user_gender = user_gender;
        this.user_age = user_age;
        this.user_type = user_type;
    }

    public User() {

    }

    public User(String userName, String password, String firstname, String lastname, String visacard, String emaill, String phoneN, String usergender, String user_age) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.visa_number = visa_number;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.user_gender = user_gender;
        this.user_age = user_age;
        this.user_type = user_type;
    }
    public User( int user_id,String first_name, String last_name) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getVisa_number() {
        return visa_number;
    }

    public void setVisa_number(String visa_number) {
        this.visa_number = visa_number;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }

    public char getUser_type() {
        return user_type;
    }

    public void setUser_type(char user_type) {
        this.user_type = user_type;
    }
}
