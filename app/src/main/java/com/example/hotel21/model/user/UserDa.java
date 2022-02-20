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
import com.example.hotel21.model.database.Database;

import java.util.List;

public class UserDa implements IUserDa {

    @Override
    public List<User> getUsers() {

        return null;
    }
    @Override
    public void  updateUser(User user , Activity userDetailsUpdate) {
        Database database = Database.getInstance();
        database.updateUser(user ,userDetailsUpdate);
    }

    @Override
    public void getUser(LonginActivity longinActivity, SharedPreferences.Editor editor, CheckBox chx, String name, String password) {
        Database database = Database.getInstance();
        database.getUser(longinActivity,editor,chx,name,password);
    }

    @Override
    public void addUser(SignUpActivity signUpActivity, String userName, String Password, String firstname, String lastname, String visacard, String emaill, String phoneN, String usergender, String user_age) {
        Database database = Database.getInstance();
        database.addUser(signUpActivity,userName,Password,firstname,lastname,visacard,emaill,phoneN,usergender,user_age);

    }

    @Override
    public void Updatedatafromemployee(EmployeeUpdateHisInformation updateReservitionEmp_acitivty, String user_name, String password_ue, String firstname, String lastname, String visacard, String emaill, String phoneN ,String usergender,String user_age) {
        Database database = Database.getInstance();
        database.Updatedatafromemployee(updateReservitionEmp_acitivty ,user_name,password_ue,firstname ,lastname,visacard,emaill, phoneN,usergender,user_age);

    }



    @Override
    public void adminaddEmplyoee(AdminAddEmployee adminaddEmployees, String username, String userpassword) {
        Database database = Database.getInstance();
        database.AdmingAddEmployee(adminaddEmployees,username,userpassword);

    }

    @Override
    public void getEmployeesforAdmin(AdminRemoveEmployee adminRemoveEmployee, ListView listView) {
        Database database = Database.getInstance();
        database.getEmlpoyeesForAdmin(adminRemoveEmployee,listView);
    }

    @Override
    public void adminRemoveEmployee(String user_id) {
        Database database = Database.getInstance();
        database.RemoveEmplyoeebyID(Integer.parseInt(user_id));

    }
}
