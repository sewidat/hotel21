package com.example.hotel21.model.user;

import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.hotel21.controller.AdminController.AdminRemoveEmployee;
import com.example.hotel21.controller.AdminController.AdminaddEmployees;
import com.example.hotel21.controller.EmployeeController.UpdateReservitionEmp_Acitivty;
import com.example.hotel21.controller.common.LonginActivity;
import com.example.hotel21.controller.common.SignUpActivity;
import com.example.hotel21.controller.user_controller.UserDetailsUpdate;

import java.util.List;

public interface IUserDa {
    List<User> getUsers();
    public void  updateUser(User user , Activity userDetailsUpdate) ;
    public void getUser(LonginActivity longinActivity, SharedPreferences.Editor editor , CheckBox chx , String name ,String password);
    public  void addUser(SignUpActivity signUpActivity ,String userName, String Password, String firstname
            ,String lastname , String visacard , String emaill, String phoneN,String usergender,String user_age);
    public void Updatedatafromemployee(UpdateReservitionEmp_Acitivty updateReservitionEmp_acitivty ,String username, String Password,
                                       String visacard , String emaill, String phoneN,String user_age);
    public void adminaddEmplyoee(AdminaddEmployees adminaddEmployees , String username , String userpassword);
    public  void getEmployeesforAdmin(AdminRemoveEmployee adminRemoveEmployee, ListView listView);
     public  void adminRemoveEmployee(String user_id);
}