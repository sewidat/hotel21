package com.example.hotel21.controller.EmployeeController;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hotel21.R;
import com.example.hotel21.controller.AdminController.ServicePageForAdmin;
import com.example.hotel21.controller.EmployeeController.EmployeeListViewItem;
import com.example.hotel21.controller.EmployeeController.EmployeeMainPage;
import com.example.hotel21.controller.common.LonginActivity;
import com.example.hotel21.controller.common.MainScreen;
import com.example.hotel21.model.database.Database;
import com.example.hotel21.model.reserve.IReserveDa;
import com.example.hotel21.model.reserve.ReserveFactory;


import java.util.ArrayList;

public class EmployeeAdapter  extends ArrayAdapter<EmployeeListViewItem>   {
    private static final  String  TAG  = "EmployeeAdapter" ;
    private Context contextfood;
    int Resource;


    public EmployeeAdapter(Context context, int resource, ArrayList<EmployeeListViewItem> objects) {
        super(context, resource, objects);
        this.contextfood = context;
        this.Resource = resource;
    }

//    Class employeeMainPage = EmployeeMainPage.class;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent ) {
        int reserveID  = getItem(position).getReserveID();
        int serviceID  = getItem(position).getServiceID();
        int room_id = getItem(position).getRoom_id();
        String service_description = getItem(position).getservice_description();
        LayoutInflater inflater  = LayoutInflater.from(contextfood);


        convertView = inflater.inflate(Resource,parent,false);
        TextView tv1 = (TextView)   convertView.findViewById(R.id.textview1);
        TextView tv2 = (TextView)   convertView.findViewById(R.id.textview2);
        Button tv3 = (Button)   convertView.findViewById(R.id.btnmalek);
        TextView tv4 = (TextView)   convertView.findViewById(R.id.room_idtextview);
        TextView tv5 = (TextView)   convertView.findViewById(R.id.service_destextview);

        tv1.setText(reserveID+"");
        tv2.setText(serviceID+"");
        tv3.setText(reserveID+" "+serviceID);
        tv4.setText(room_id+"");
        tv5.setText(service_description+"");
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String [] ids = tv3.getText().toString().split(" ");
                int reserveId = Integer.parseInt(ids[0]);
                int serviceId = Integer.parseInt(ids[1]);
                System.out.println(reserveId + "---" + serviceId);
                ReserveFactory reserveFactory = new ReserveFactory();
                IReserveDa iReserveDa = reserveFactory.getModel();
                iReserveDa.setReservesToServiceDone(String.valueOf(serviceId),String.valueOf(reserveId));
            }
        });




        return  convertView;
    }

    @Override
    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
    }
}
