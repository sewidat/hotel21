package com.example.hotel21.controller.AdminController;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hotel21.R;
import com.example.hotel21.model.user.IUserDa;
import com.example.hotel21.model.user.User;
import com.example.hotel21.model.user.UserFactory;


import java.util.ArrayList;

 public class EmployeesListviewAdapter extends ArrayAdapter<User>   {
    private static final  String  TAG  = "EmployeesListviewAdapter" ;
    private Context context;
    int Resource;


    public EmployeesListviewAdapter(Context context, int resource, ArrayList<User> objects) {
        super(context, resource, objects);
        this.context = context;
        this.Resource = resource;
    }

//    Class employeeMainPage = EmployeeMainPage.class;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent ) {
        int user_id  = getItem(position).getUser_id();
        String first_name  = getItem(position).getFirst_name();
        String last_name = getItem(position).getLast_name();
        LayoutInflater inflater  = LayoutInflater.from(context);


        convertView = inflater.inflate(Resource,parent,false);
        TextView tv1 = (TextView)   convertView.findViewById(R.id.Delete_useridID);
        TextView tv2 = (TextView)   convertView.findViewById(R.id.Delete_first_nameID);
        TextView tv3 = (TextView)   convertView.findViewById(R.id.Delete_last_nameID);
        Button tv4 = (Button)   convertView.findViewById(R.id.Delete_btnEmplyoee);


        tv1.setText(user_id+"");
        tv2.setText(first_name+"");
        tv3.setText(last_name+"");
        tv4.setText("Remove" + " " + user_id);

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String [] ids = tv4.getText().toString().split(" ");
                int user_id = Integer.parseInt(ids[1]);
                UserFactory userFactory = new UserFactory();
                IUserDa iUserDa = userFactory.getModel();
                iUserDa.adminRemoveEmployee(String.valueOf(user_id));
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
