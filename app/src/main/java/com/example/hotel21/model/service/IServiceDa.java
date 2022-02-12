package com.example.hotel21.model.service;

import android.widget.ListView;

import com.example.hotel21.controller.EmployeeController.EmployeeMainPage;
import com.example.hotel21.controller.AdminController.ServicePageForAdmin;

public interface IServiceDa {
    void getallservicces(EmployeeMainPage employeeMainPage, ListView listView);
    void getservicesforadmin(ServicePageForAdmin  servicePageForAdmin , ListView listView);
    void addservicesfromadmin(ServicePageForAdmin servicePageForAdmin,String service_description ,String service_price);

}
