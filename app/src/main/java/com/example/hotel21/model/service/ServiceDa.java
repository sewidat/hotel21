package com.example.hotel21.model.service;

import android.widget.ListView;

import com.example.hotel21.controller.EmployeeController.EmployeeMainPage;
import com.example.hotel21.controller.AdminController.ServicePageForAdmin;
import com.example.hotel21.model.database.Database;

public class ServiceDa implements  IServiceDa {
    @Override
    public void getallservicces(EmployeeMainPage employeeMainPage, ListView listView) {
        Database database = Database.getInstance();
        database.getListViewForEmployee(employeeMainPage,listView);



    }

    @Override
    public void getservicesforadmin(ServicePageForAdmin servicePageForAdmin, ListView listView) {
        Database database = Database.getInstance();
        database.getServicesForAdmin(servicePageForAdmin,listView);
    }

    @Override
    public void addservicesfromadmin(ServicePageForAdmin servicePageForAdmin, String service_description, String service_price) {
        Database database = Database.getInstance();
        database.setServicesfromadmin(servicePageForAdmin,service_description,service_price);
    }
    }


