package com.example.hotel21.controller.AdminController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hotel21.R;
import com.example.hotel21.model.database.Database;
import com.example.hotel21.model.service.IServiceDa;
import com.example.hotel21.model.service.ServiceFactory;
import com.example.hotel21.model.user.IUserDa;
import com.example.hotel21.model.user.UserFactory;

public class AdminRemoveEmployee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_remove_employee);
        run();
        System.out.println("malik");

    }

    public void run() {
        final Handler handler = new Handler();
        ListView listView = findViewById(R.id.Delete_listviewForyEmployees);
        SearchView searchView = findViewById(R.id.searchID);

        handler.post(
                () -> {
                    UserFactory userFactory = new UserFactory();
                    IUserDa iUserDa = userFactory.getModel();
                    iUserDa.getEmployeesforAdmin(this,listView);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> EmployeeListviewAdapter, View view, int i, long l) {
                            Toast.makeText(AdminRemoveEmployee.this,"you click - " + EmployeeListviewAdapter.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT);

                        }
                    });
                    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                        @Override
                        public boolean onQueryTextSubmit(String query) {

                            
                            return false;
                        }

                        @Override
                        public boolean onQueryTextChange(String newText) {
                            return false;
                        }
                    });
                }
        );

    }


    public void OnclickForDoneReserve(View view) {
    }
}