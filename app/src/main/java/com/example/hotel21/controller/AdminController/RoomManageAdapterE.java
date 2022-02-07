package com.example.hotel21.controller.AdminController;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
import com.example.hotel21.controller.SignUpActivity;
import com.example.hotel21.model.database.Database;
import com.example.hotel21.model.reserve.IReserveDa;
import com.example.hotel21.model.reserve.ReserveFactory;
import com.example.hotel21.model.room.Room;
import com.example.hotel21.model.service.Service;

import java.util.ArrayList;

public class RoomManageAdapterE extends ArrayAdapter<Room>  {
    private static final  String  TAG  = "RoomManageAdapter" ;
    private Context context_service;
    int Resource;
    public static int  helppos  ;
     RoomsListViewForEmployee roomsListViewForEmployee;
     SignUpActivity signUpActivity;

    public RoomManageAdapterE(Context context, int resource, ArrayList<Room> objects) {
        super(context, resource, objects);
        this.context_service = context;
        this.Resource = resource;
    }

    public RoomManageAdapterE(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public RoomManageAdapterE(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int room_id = getItem(position).getRoom_id();
        int floor_number = getItem(position).getFloor_number();
        String type  = getItem(position).getType();
        String info = getItem(position).getRoom_information();
        int price = getItem(position).getPrice();
        int number_of_bed = getItem(position).getNumber_of_bed();



        LayoutInflater inflater  = LayoutInflater.from(context_service);


        convertView = inflater.inflate(Resource,parent,false);
        TextView tv1 = (TextView)   convertView.findViewById(R.id.room_idtextview_E);
        TextView tv2 = (TextView)   convertView.findViewById(R.id.room_floorNumbertextview_E);
        TextView tv3 = (TextView)   convertView.findViewById(R.id.room_typetextview_E);
        TextView tv4 = (TextView)   convertView.findViewById(R.id.room_daypricetextview_E);
        TextView tv5 = (TextView)   convertView.findViewById(R.id.room_roomInformationtextview_E);
        TextView tv6 = (TextView)   convertView.findViewById(R.id.room_number_of_bed_textview_E);
        Button update_btn = (Button) convertView.findViewById(R.id.room_btnforUpdate_E);
        tv1.setText(String.valueOf(room_id));
        tv2.setText(String.valueOf(floor_number));
        tv3.setText(type);
        tv4.setText(String.valueOf(price));
        tv5.setText(info);
        tv6.setText(String.valueOf(number_of_bed));
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences =  PreferenceManager.getDefaultSharedPreferences(context_service);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("room_id" , room_id);
                editor.putInt("floor_number",floor_number);
                editor.putString("type",type);
                editor.putString("info",info);
                editor.putInt("price", price);
                editor.putInt("number_of_bed",number_of_bed);
                editor.commit();
                Intent intent = new Intent(context_service,SignUpActivity.class);
                intent.putExtra("postion",position);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context_service.startActivity(intent);


            }
        });





        return  convertView;
    }
    @Override
    public void notifyDataSetChanged() // Create this function in your adapter class
    {
        super.notifyDataSetChanged();
    }
}
