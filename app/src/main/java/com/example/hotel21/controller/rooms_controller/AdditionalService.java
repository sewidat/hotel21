package com.example.hotel21.controller.rooms_controller;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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
import com.example.hotel21.model.service.Service;


import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdditionalService extends ArrayAdapter<Service> {
    private static final String TAG = "AdditionalService";
    private Context contextfood;
    int Resource;
    Switch aSwitch;

    public AdditionalService(Context context, int resource, ArrayList<Service> objects) {
        super(context, resource, objects);
        this.contextfood = context;
        this.Resource = resource;
    }

//    Class employeeMainPage = EmployeeMainPage.class;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(contextfood);
        String sevice_description = getItem(position).getService_description();


        convertView = inflater.inflate(Resource, parent, false);
        TextView servicesViewtxt = (TextView) convertView.findViewById(R.id.service_descriptionID);
        aSwitch = convertView.findViewById(R.id.service_switch);
        aSwitch.setChecked(true);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b == false) {
                    --ReservePage.globalCounter;
                }
                if (b) {
                    ++ReservePage.globalCounter;
                }
                if (contextfood instanceof ReservePage) {
                    ((ReservePage) contextfood).updatePrice();

                }
//                else {
//                   -- ReservePage.globalCounter;
//                }
                Toast.makeText(contextfood, ReservePage.globalCounter + "", Toast.LENGTH_SHORT).show();
            }

        });
        /*TextView tv1 = (TextView)   convertView.findViewById(R.id.textview1);
        TextView tv2 = (TextView)   convertView.findViewById(R.id.textview2);
        Button tv3 = (Button)   convertView.findViewById(R.id.btnmalek);
        TextView tv4 = (TextView)   convertView.findViewById(R.id.room_idtextview);
        TextView tv5 = (TextView)   convertView.findViewById(R.id.service_destextview);*/
        servicesViewtxt.setText(sevice_description);


        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
