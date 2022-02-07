package com.example.hotel21.model.user;


import java.util.List;

public class UserDa implements IUserDa {

    @Override
    public List<User> getUsers() {

        return null;
    }
    @Override
    public void  updateUser(User user , SignUpActivity signUpActivity) {
        Database database = Database.getInstance();
        database.updateUser(user,signUpActivity);
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
    public void Updatedatafromemployee(UpdateReservitionEmp_Acitivty updateReservitionEmp_acitivty,String username, String Password, String visacard, String emaill, String phoneN, String user_age) {
        Database database = Database.getInstance();
        database.Updatedatafromemployee(updateReservitionEmp_acitivty,username,Password,visacard,emaill, phoneN,user_age);
    }

    @Override
    public void adminaddEmplyoee(AdminaddEmployees adminaddEmployees, String username, String userpassword) {
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
