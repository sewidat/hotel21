package com.example.hotel21.model.reserve;

import android.widget.ListView;

import com.example.hotel21.controller.EmployeeController.EmployeeMainPage;
import com.example.hotel21.controller.EmployeeController.UpdateReservitionEmp_Acitivty;
import com.example.hotel21.model.database.Database;

class ReserveDa implements IReserveDa {


    @Override
    public void setReservesToServiceDone(String reserve, String service) {
        Database database = Database.getInstance();
        database.setServicesToReserveDonebyemployee(reserve,service);

    }

    @Override
    public void getReservtionTable(UpdateReservitionEmp_Acitivty updateReservitionEmp_acitivty, ListView listView) {
        Database database = Database.getInstance();
        database.getReservitionForEmployee(updateReservitionEmp_acitivty,listView);
    }


    @Override
    public void setAllDoneReservesDone(UpdateReservitionEmp_Acitivty updateReservitionEmp_acitivty) {
        Database database = Database.getInstance();
        database.getCurrentDate(updateReservitionEmp_acitivty);
    }
}
