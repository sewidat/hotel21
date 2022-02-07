package com.example.hotel21.controller.AdminController;

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
import com.example.hotel21.controller.LonginActivity;
import com.example.hotel21.model.service.Service;

import java.util.ArrayList;

 public class ServicesAdapter extends ArrayAdapter<Service>  {
    private static final  String  TAG  = "ServicesAdapter" ;
    private Context context_service;
    int Resource;

    public ServicesAdapter(Context context, int resource, ArrayList<Service> objects) {
        super(context, resource, objects);
        this.context_service = context;
        this.Resource = resource;
    }

     public ServicesAdapter(@NonNull Context context, int resource) {
         super(context, resource);
     }

     public ServicesAdapter(@NonNull Context context, int resource, int textViewResourceId) {
         super(context, resource, textViewResourceId);
     }

     @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int service_id = getItem(position).getService_id();
        String service_descrption = getItem(position).getRoom_descrption();
        int  service_price = getItem(position).getService_price();

        LayoutInflater inflater  = LayoutInflater.from(context_service);


        convertView = inflater.inflate(Resource,parent,false);
        TextView tv4 = (TextView)   convertView.findViewById(R.id.ServiceIDView);
        TextView tv5 = (TextView)   convertView.findViewById(R.id.service_description_view);
        TextView tv6 = (TextView)   convertView.findViewById(R.id.service_price_view);
        tv4.setText(service_id+"");
        tv5.setText(service_descrption+"");
        tv6.setText(service_price+"");


        return  convertView;
    }
    @Override
    public void notifyDataSetChanged() // Create this function in your adapter class
    {
        super.notifyDataSetChanged();
    }
}
