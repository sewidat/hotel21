package com.example.hotel21.model.user;

import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
    private int user_age;
    private char user_type;


}
