package com.example.hotel21.model.user;

import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.hotel21.controller.AdminController.AdminRemoveEmployee;
import com.example.hotel21.controller.AdminController.AdminAddEmployee;
import com.example.hotel21.controller.EmployeeController.EmployeeUpdateHisInformation;
import com.example.hotel21.controller.common.LonginActivity;
import com.example.hotel21.controller.common.SignUpActivity;

import java.util.List;

public interface IUserDa {
    List<User> getUsers();
    public void  updateUser(User user , Activity userDetailsUpdate) ;
    public void getUser(LonginActivity longinActivity, SharedPreferences.Editor editor , CheckBox chx , String name ,String password);
    public  void addUser(SignUpActivity signUpActivity ,String userName, String Password, String firstname
            ,String lastname , String visacard , String emaill, String phoneN,String usergender,String user_age);
    public void Updatedatafromemployee(EmployeeUpdateHisInformation updateReservitionEmp_acitivty, String user_name, String password_ue, String firstname, String lastname,
                                       String visacard, String emaill, String phoneN, String gender ,String age) ;
    public void adminaddEmplyoee(AdminAddEmployee adminaddEmployees , String username , String userpassword);
    public  void getEmployeesforAdmin(AdminRemoveEmployee adminRemoveEmployee, ListView listView);
     public  void adminRemoveEmployee(String user_id);
}