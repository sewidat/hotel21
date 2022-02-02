package com.example.hotel21.model.database;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.hotel21.R;
import com.example.hotel21.controller.AddRoomsActivity;
import com.example.hotel21.controller.AdminController.AdminRemoveEmployee;
import com.example.hotel21.controller.AdminController.AdminaddEmployees;
import com.example.hotel21.controller.AdminController.EmployeesListviewAdpater;
import com.example.hotel21.controller.AdminController.AdminMainPage;
import com.example.hotel21.controller.EmployeeController.EmployeeAdapter;
import com.example.hotel21.controller.EmployeeController.EmployeeMainPage;
import com.example.hotel21.controller.EmployeeController.UpdateAdapter;
import com.example.hotel21.controller.EmployeeController.UpdateReservitionEmp_Acitivty;
import com.example.hotel21.controller.LonginActivity;
import com.example.hotel21.controller.AdminController.ServicePageForAdmin;
import com.example.hotel21.controller.AdminController.ServicesAdapter;
import com.example.hotel21.controller.SignUpActivity;
import com.example.hotel21.controller.EmployeeController.EmployeeListViewItem;
import com.example.hotel21.model.reserve.Reserve;
import com.example.hotel21.model.service.Service;
import com.example.hotel21.model.user.User;

import org.json.JSONException;
import org.json.JSONObject;

public class Database extends AppCompatActivity {
    EmployeeAdapter adapter;
    ServicesAdapter servicesAdapter;
    UpdateAdapter updateAdapter;
      EmployeesListviewAdpater employeesListviewAdater;


    private static Database single_instance = null;
    ArrayList<User> users = new ArrayList<>();

    public static Database getInstance() {
        if (single_instance == null)
            single_instance = new Database();

        return single_instance;
    }

    private Database() {

    }


    public void updateUser(User user, SignUpActivity signUpActivity) {

        String url = "http://10.0.2.2/hotel21/updateUser.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("success")) {
                    Toast.makeText(signUpActivity, "Update Done successfully.", Toast.LENGTH_SHORT).show();
                } else if (response.equals("failure")) {
                    Toast.makeText(signUpActivity, "Invalid Update !!!", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(signUpActivity, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("user_name", user.getUser_name());
                data.put("user_password", user.getUser_password());
                data.put("first_name", user.getFirst_name());
                data.put("last_name", user.getLast_name());
                data.put("visa_number", user.getVisa_number());
                data.put("user_email", user.getUser_email());
                data.put("user_phone", user.getUser_phone());
                data.put("user_gender", user.getUser_gender());
                data.put("user_age", user.getUser_age() + "");

                return data;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(signUpActivity.getApplicationContext());
        requestQueue.add(stringRequest);
    }

    EmployeeMainPage EMP ;

    public void getListViewForEmployee(EmployeeMainPage employeeMainPage, ListView listview) {

        EMP = employeeMainPage;
        RequestQueue queue;
        queue = Volley.newRequestQueue(employeeMainPage.getApplicationContext());
        String url = "http://10.0.2.2/hotel21/employee/getServicesToResarveNotDone.php";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,
                null, response -> {
            ArrayList<EmployeeListViewItem> items = new ArrayList<>();
            System.out.println(response + " this is the response ");
            for (int i = 0; i < response.length(); i++) {
                try {

                    JSONObject obj = response.getJSONObject(i);
                    items.add(new EmployeeListViewItem(obj.getInt("reserve_id"), obj.getInt("service_id") , obj.getInt("room_id"),obj.getString("service_description")));
                    System.out.println(items.size());
                } catch (JSONException exception) {
                    Log.d("Error", exception.toString());
                }

            }
            adapter = new EmployeeAdapter(employeeMainPage.getApplicationContext(), R.layout.activity_employee_adapter, items);
            listview.setAdapter(adapter);


        }, error -> System.out.println(error.getMessage()));

        queue.add(request);
    }

    public void getUser(LonginActivity longinActivity, SharedPreferences.Editor editor, CheckBox chx, String username, String password) {

        String user_name = username;
        String user_password = password;

        RequestQueue requestQueue = Volley.newRequestQueue(longinActivity.getApplicationContext());


        if (user_name.isEmpty() || user_password.isEmpty()) {
            Toast.makeText(longinActivity, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        } else {

            String url = "http://10.0.2.2:80/hotel21/login.php";

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    System.out.println(response + "----mes");

                    if (response.contains("successC")) {

                        Intent intent = new Intent(longinActivity, SignUpActivity.class);
                        startActivity(intent);

                    } else if (response.contains("successA")) {
                        Toast.makeText(longinActivity, "hello Admin", Toast.LENGTH_SHORT);
                        System.out.println("hello admin");
                        Intent intent = new Intent(longinActivity, AddRoomsActivity.class);
                        startActivity(intent);


                    } else if (response.contains("successE")) {
                        Toast.makeText(longinActivity, "hello employee", Toast.LENGTH_SHORT);
                        Intent intent = new Intent(longinActivity, AdminMainPage.class);
                        startActivity(intent);

                    } else if (response.contains("failure")) {

                        Toast.makeText(longinActivity, "Invalid Log in ", Toast.LENGTH_SHORT);

                    }
                    if (chx.isChecked()) {
                        editor.putString("NAME", user_name);
                        editor.putString("PASS", user_password);
                        editor.putBoolean("FLAG", true);
                        editor.commit();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(longinActivity, "Error MESO" + error.getMessage(), Toast.LENGTH_SHORT);


                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> map = new HashMap<>();
                    map.put("user_name", user_name);
                    map.put("user_password", user_password);
                    return map;

                }
            };

            requestQueue.add(stringRequest);


        }
    }

    public void getCurrentDate (UpdateReservitionEmp_Acitivty updateReservitionEmp_acitivty)
    {
        String url = "http://worldtimeapi.org/api/timezone/Asia/Hebron";
        RequestQueue queue;
        queue = Volley.newRequestQueue(updateReservitionEmp_acitivty.getApplicationContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url,
                        null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                       try {
                           String datetime = response.getString("datetime").substring(0,10);
                           setAllDoneReservesDone(updateReservitionEmp_acitivty , datetime);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });


        queue.add(jsonObjectRequest);

//        String url = "http://worldtimeapi.org/api/timezone/Asia/Hebron";
//                            String datetime = response.getString("datetime").substring(0,10);

    }

    public void setAllDoneReservesDone(UpdateReservitionEmp_Acitivty updateReservitionEmp_acitivty  , String date ) {

        String url = "http://10.0.2.2/hotel21/employee/updateResarveFromEmployee.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(updateReservitionEmp_acitivty, "The reserves is done and the rooms available.", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(updateReservitionEmp_acitivty, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("current_date", date);
                return data;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(updateReservitionEmp_acitivty.getApplicationContext());
        requestQueue.add(stringRequest);
    }

    public void getServicesForAdmin(ServicePageForAdmin servicePageForAdmin, ListView listView) {
        RequestQueue queue;
        queue = Volley.newRequestQueue(servicePageForAdmin.getApplicationContext());
        String url = "http://10.0.2.2/hotel21/getServicesForAdmin.php";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,
                null, response -> {
            ArrayList<Service> items = new ArrayList<>();
            for (int i = 0; i < response.length(); i++) {
                try {

                    JSONObject obj = response.getJSONObject(i);
                    items.add(new Service(obj.getInt("service_id"), obj.getString("service_description"), obj.getInt("service_price")));

                    System.out.println("we are done");
                } catch (JSONException exception) {
                    Log.d("Error", exception.toString());
                }
            }

            servicesAdapter = new ServicesAdapter(servicePageForAdmin.getApplicationContext(), R.layout.activity_services_adapter, items);
            listView.setAdapter(servicesAdapter);

        }, error -> System.out.println(error.getMessage()));

        queue.add(request);

    }
    public  void setServicesToReserveDonebyemployee( String reserve_id , String service_id ){
        String url = "http://10.0.2.2/hotel21/employee/setServiceToReserveDone.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.contains("successfully")) {
                    Toast.makeText(EMP, "Update Done successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EMP.getApplicationContext(), EmployeeMainPage.class);
                    startActivity(intent);
                } else  {
                    Toast.makeText(EMP, "Invalid Update !!!", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EMP, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("service_id",  service_id);
                data.put("reserve_id", reserve_id);
                return data;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(EMP.getApplicationContext());
        requestQueue.add(stringRequest);
    }



    public void setServicesfromadmin(ServicePageForAdmin servicePageForAdmin , String Des , String price) {
        RequestQueue requestQueue = Volley.newRequestQueue(servicePageForAdmin.getApplicationContext());
        String url = "http://10.0.2.2:80/hotel21/AddservicesFromAdmin.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                if (response.contains("success")) {
                    Toast.makeText(servicePageForAdmin, "Service is added", Toast.LENGTH_SHORT).show();

                } else if (response.contains("failure")) {
                    Toast.makeText(servicePageForAdmin, "Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(servicePageForAdmin, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("service_description", Des);
                data.put("service_price", price);


                return data;
            }

        };
        requestQueue.add(stringRequest);

    }
    public void addUser(SignUpActivity signUpActivity ,String userName, String Password, String firstname
            ,String lastname , String visacard , String emaill, String phoneN,String usergender,String user_age) {
        if(userName.isEmpty()||Password.isEmpty()||firstname.isEmpty()||lastname.isEmpty()||visacard.isEmpty()||
                emaill.isEmpty()||  phoneN.isEmpty()||user_age.isEmpty()||usergender.isEmpty()){
            Toast.makeText(this, "Please fill all data Requierd", Toast.LENGTH_SHORT).show();
        }else {
            RequestQueue requestQueue = Volley.newRequestQueue(signUpActivity.getApplicationContext());

            String url = "http://10.0.2.2:80/hotel21/signup.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    System.out.println(response + "-------------");
                    System.out.println(response.equalsIgnoreCase("success") + "////////////////");

                    if (response.contains("success")) {
                        System.out.println("on if statment");
                        Toast.makeText(signUpActivity, "valid log in", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(signUpActivity, LonginActivity.class);
                        startActivity(intent);
                        finish();


                    } else if (response.contains("failure")) {
                        Toast.makeText(signUpActivity, "Invalid log in", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(signUpActivity, error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("user_name", userName);
                    data.put("user_password", Password);
                    data.put("first_name", firstname);
                    data.put("last_name", lastname);
                    data.put("visa_number", visacard);
                    data.put("user_email",emaill );
                    data.put("user_phone", phoneN);
                    data.put("user_gender", usergender);
                    data.put("user_age", user_age);

                    return data;
                }

            };
            requestQueue.add(stringRequest);

        }
        User user = new User(userName,Password,firstname,lastname,visacard,emaill,phoneN,usergender,Integer.parseInt(user_age));

    }
    public void getReservitionForEmployee(UpdateReservitionEmp_Acitivty updateReservitionEmp_acitivty, ListView listView) {
        RequestQueue queue;
        queue = Volley.newRequestQueue(updateReservitionEmp_acitivty.getApplicationContext());
        String url = "http://10.0.2.2/hotel21/employee/getReservtiondata.php";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,
                null, response -> {
            ArrayList<Reserve> items = new ArrayList<>();
            System.out.println("this is the response ->" + response);
            for (int i = 0; i < response.length(); i++) {
                try {

                    JSONObject obj = response.getJSONObject(i);
                    items.add(new Reserve(obj.getInt("reserve_id"), obj.getInt("room_id"), obj.getString("start_time"),obj.getString("end_time")));
                     for(int a = 0 ; a<items.size();a++){
                         System.out.println(items.get(a).getReserve_id() + "\n"+
                         items.get(a).getRoom_id()  + "\n"+
                         items.get(a).getStart_time() + "\n"+
                          items.get(a).getEnd_time());
                     }
                    System.out.println("we are done");
                } catch (JSONException exception) {
                    Log.d("Error", exception.toString());
                }
            }

            updateAdapter = new UpdateAdapter(updateReservitionEmp_acitivty.getApplicationContext(), R.layout.activity_update_adapter, items);
            listView.setAdapter(updateAdapter);

        }, error -> System.out.println(error.getMessage()));

        queue.add(request);

    }
    public void Updatedatafromemployee(UpdateReservitionEmp_Acitivty updateReservitionEmp_acitivty ,String userName, String Password,
                                             String visacard , String emaill, String phoneN,String user_age) {

        System.out.println(userName + "this is username");

        RequestQueue requestQueue = Volley.newRequestQueue(updateReservitionEmp_acitivty.getApplicationContext());

        String url = "http://10.0.2.2:80/hotel21/employee/EmployeeUpdateData.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println(response + "-------------");
                System.out.println(response.equalsIgnoreCase("success") + "////////////////");

                if (response.contains("success")) {
                    System.out.println("on if statment");
                    Toast.makeText(updateReservitionEmp_acitivty, "valid log in", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(updateReservitionEmp_acitivty, LonginActivity.class);
                    startActivity(intent);
                    finish();


                } else if (response.contains("failure")) {
                    Toast.makeText(updateReservitionEmp_acitivty, "Invalid log in", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(updateReservitionEmp_acitivty, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("user_name", userName);
                data.put("user_password", Password);
                data.put("visa_number", visacard);
                data.put("user_email",emaill );
                data.put("user_phone", phoneN);
                data.put("user_age", user_age);

                return data;
            }

        };
        requestQueue.add(stringRequest);

    }


    public void AdmingAddEmployee(AdminaddEmployees adminaddEmployees , String userName, String Password) {


        RequestQueue requestQueue = Volley.newRequestQueue(adminaddEmployees.getApplicationContext());

        String url = "http://10.0.2.2:80/hotel21/adminaddemployee.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println(response + "-------------");
                System.out.println(response.equalsIgnoreCase("success") + "////////////////");

                if (response.contains("success")) {
                    Toast.makeText(adminaddEmployees, "Emplyoee is added", Toast.LENGTH_SHORT).show();



                } else if (response.contains("failure")) {
                    Toast.makeText(adminaddEmployees, "the username is already taken", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(adminaddEmployees, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("user_name", userName);
                data.put("user_password", Password);


                return data;
            }

        };
        requestQueue.add(stringRequest);

    }

    AdminRemoveEmployee ADE ;
    public void getEmlpoyeesForAdmin(AdminRemoveEmployee adminRemoveEmployee, ListView listview) {
        ADE = adminRemoveEmployee;
        RequestQueue queue;
        queue = Volley.newRequestQueue(adminRemoveEmployee.getApplicationContext());
        String url = "http://10.0.2.2/hotel21/getEmployees.php";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,
                null, response -> {
            ArrayList<User> items = new ArrayList<>();
            System.out.println("----------------------roa " + response.length());
            System.out.println(response);

            for (int i = 0; i < response.length(); i++) {
                try {

                    JSONObject obj = response.getJSONObject(i);
                    items.add(new User(obj.getInt("user_id"),  obj.getString("first_name"),obj.getString("last_name")));
                } catch (JSONException exception) {
                    Log.d("Error", exception.toString());
                }
            }

            employeesListviewAdater = new EmployeesListviewAdpater(adminRemoveEmployee.getApplicationContext(), R.layout.activity_employees_listview_adpater, items);
            listview.setAdapter(employeesListviewAdater);

        }, error -> System.out.println(error.getMessage()));

        queue.add(request);

    }


    public  void RemoveEmplyoeebyID( int user_id) {


        RequestQueue requestQueue = Volley.newRequestQueue(ADE.getApplicationContext());

        String url = "http://10.0.2.2:80/hotel21/AdminRemoveEmployees.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println(response + "-------------");
                System.out.println(response.equalsIgnoreCase("success") + "////////////////");

                if (response.contains("success")) {
                    Toast.makeText(ADE, "Emplyoee is Removed", Toast.LENGTH_SHORT).show();



                } else if (response.contains("failure")) {
                    Toast.makeText(ADE, "there is a problem please contact with reception", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ADE, error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> data = new HashMap<>();
                data.put("user_id", String.valueOf(user_id));


                return data;
            }

        };
        requestQueue.add(stringRequest);

    }

    }




