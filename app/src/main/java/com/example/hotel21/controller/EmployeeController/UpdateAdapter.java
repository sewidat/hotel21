package com.example.hotel21.controller.EmployeeController;


import androidx.appcompat.app.AppCompatActivity;


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
import com.example.hotel21.model.reserve.Reserve;
import com.example.hotel21.model.reserve.ReserveFactory;


import java.util.ArrayList;
import java.util.Date;

public class UpdateAdapter extends ArrayAdapter<Reserve>   {
    private static final  String  TAG  = "EmployeeAdapter" ;
    private Context contextfood;
    int Resource;
    ArrayList<Reserve> list;


    public UpdateAdapter(Context context, int resource, ArrayList<Reserve> objects) {
        super(context, resource, objects);
        this.contextfood = context;
        this.Resource = resource;
        this.list = objects;
    }

//    Class employeeMainPage = EmployeeMainPage.class;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent ) {
        int reserveID  = getItem(position).getReserve_id();
        int roomID  = getItem(position).getRoom_id();
        String startDate = getItem(position).getStart_time();
        String endTime = getItem(position).getEnd_time();
        LayoutInflater inflater  = LayoutInflater.from(contextfood);


        convertView = inflater.inflate(Resource,parent,false);
        TextView tv1 = (TextView)   convertView.findViewById(R.id.Up_reserve_text_view);
        TextView tv2 = (TextView)   convertView.findViewById(R.id.Up_roomID_text_view);
        TextView tv3 = (TextView)   convertView.findViewById(R.id.Up_StartDate_text_view);
        TextView tv4 = (TextView)   convertView.findViewById(R.id.Up_EndDate_text_view);

        tv1.setText(reserveID+"");
        tv2.setText(roomID+"");
        tv3.setText(startDate+"");
        tv4.setText(endTime+"");





        return  convertView;
    }

    @Override
    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
    }
}
