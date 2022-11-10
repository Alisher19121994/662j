package com.example.a662j;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a662j.models.Employee;
import com.example.a662j.volley.VolleyHandler;
import com.example.a662j.volley.VolleyHttp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    void initViews() {
        Employee employee = new Employee(1, "Alisher", 5000, 45, "");
        Employee employeePOST = new Employee(1, "Alisherbek", 788000, 45, "");
        Employee employeePUT = new Employee(1, "Alisher Daminov", 922000, 45, "");

        apiVolleyList();
       // apiVolleyPost(employeePOST);
        // apiVolleyPut(employeePUT);
        //apiVolleyDelete(employee);
    }

    void apiVolleyList() {
        VolleyHttp.get(VolleyHttp.API_LIST_POST, VolleyHttp.paramsEmpty(), new VolleyHandler() {
            @Override
            public void onSucces(String response) {

            }

            @Override
            public void onError(String error) {

            }
        });
    }

    void apiVolleySingle(Employee employee) {
        VolleyHttp.getSingle(VolleyHttp.API_SINGLE_POST + employee.getId(), VolleyHttp.paramsEmpty(), new VolleyHandler() {
            @Override
            public void onSucces(String response) {

            }

            @Override
            public void onError(String error) {

            }
        });
    }


    void apiVolleyPost(Employee employee) {
        VolleyHttp.post(VolleyHttp.API_CREATE_POST, VolleyHttp.paramsCreate(employee), new VolleyHandler() {
            @Override
            public void onSucces(String response) {

            }

            @Override
            public void onError(String error) {

            }
        });
    }


    void apiVolleyPut(Employee employee) {
        VolleyHttp.put(VolleyHttp.API_UPDATE_POST + employee.getId(), VolleyHttp.paramsUpdate(employee), new VolleyHandler() {
            @Override
            public void onSucces(String response) {

            }

            @Override
            public void onError(String error) {

            }
        });
    }

    void apiVolleyDelete(Employee employee) {
        VolleyHttp.delete(VolleyHttp.API_DELETE_POST + employee.getId(), new VolleyHandler() {
            @Override
            public void onSucces(String response) {

            }

            @Override
            public void onError(String error) {

            }
        });
    }
}