package com.example.hotel21.controller.AdminController;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hotel21.R;
import com.example.hotel21.controller.common.LonginActivity;
import com.example.hotel21.model.service.IServiceDa;
import com.example.hotel21.model.service.ServiceFactory;

public class ServicePageForAdmin extends AppCompatActivity {

    EditText service_description , service_price ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_page_for_admin);
        service_description = findViewById(R.id.service_descriptionID);
        service_price = findViewById(R.id.service_priceID);

        run();
    }
    public void run() {
        final Handler handler = new Handler();
        ListView listView = findViewById(R.id.listview3);

        handler.post(
                () -> {

                    ServiceFactory serviceFactory = new ServiceFactory();
                    IServiceDa iServiceDa = serviceFactory.getModel();
                    iServiceDa.getservicesforadmin(ServicePageForAdmin.this,listView);
                }
        );

    }

    public void addservicesonbtn(View view) {
        String servicedescription = service_description.getText().toString();
        String serviceprice = service_price.getText().toString();
        ServiceFactory serviceFactory = new ServiceFactory();
        IServiceDa iServiceDa = serviceFactory.getModel();
        iServiceDa.addservicesfromadmin(ServicePageForAdmin.this,servicedescription,serviceprice);

    }


    public void RefreshListviewforadminbtn(View view) {
        Intent intent = new Intent(ServicePageForAdmin.this, ServicePageForAdmin.class);
        startActivity(intent);

    }
}