package com.example.hotel21.model.user;

import java.util.List;

public interface IUserDa {
    List<User> getUsers();
    public String  updateUser(User user) ;
}