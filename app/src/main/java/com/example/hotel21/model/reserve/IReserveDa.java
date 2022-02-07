package com.example.hotel21.model.reserve;

import android.widget.ListView;


import com.example.hotel21.controller.EmployeeController.EmployeeMainPage;
import com.example.hotel21.controller.EmployeeController.UpdateReservitionEmp_Acitivty;

public interface IReserveDa {
    void setReservesToServiceDone(String reserve, String service);
    void getReservtionTable(UpdateReservitionEmp_Acitivty updateReservitionEmp_acitivty , ListView listView);
    void setAllDoneReservesDone(UpdateReservitionEmp_Acitivty employeeMainPage);



}
