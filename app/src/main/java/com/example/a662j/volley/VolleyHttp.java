package com.example.a662j.volley;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.a662j.MyApplication;
import com.example.a662j.models.Employee;
import com.example.a662j.utils.Logger;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyHttp {

    static String TAG = VolleyHttp.class.getSimpleName();
    public static boolean IS_TESTER = true;
    static String SERVER_DEVELOPMENT = "https://dummy.restapiexample.com/api/v1/";
    static String SERVER_PRODUCTION = "https://dummy.restapiexample.com/api/v1/";


    static String server(String url) {
        if (IS_TESTER) {
            return SERVER_DEVELOPMENT + url;
        }
        return SERVER_PRODUCTION + url;
    }

    static HashMap<String, String> headers() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-type", "application/json; charset UTF-8");
        return headers;
    }

    public static void get(String api, HashMap<String, String> params, VolleyHandler volleyHandler) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, server(api),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Logger.d(TAG, response);
                        volleyHandler.onSucces(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Logger.d(TAG, error.toString());
                        volleyHandler.onError(error.toString());
                    }
                }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };

        MyApplication.instance.addToRequestQueue(stringRequest);
    }

    public static void getSingle(String api, HashMap<String, String> params, VolleyHandler volleyHandler) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, server(api),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Logger.d(TAG, response);
                        volleyHandler.onSucces(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Logger.d(TAG, error.toString());
                        volleyHandler.onError(error.toString());
                    }
                }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };

        MyApplication.instance.addToRequestQueue(stringRequest);
    }

    public static void post(String api, HashMap<String, Object> body, VolleyHandler volleyHandler) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, server(api),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Logger.d(TAG, response);
                        volleyHandler.onSucces(response);
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Logger.d(TAG, error.toString());
                        volleyHandler.onError(error.toString());
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers();
            }
        };
        MyApplication.instance.addToRequestQueue(stringRequest);
    }

    public static void put(String api, HashMap<String, Object> body, VolleyHandler volleyHandler) {

        StringRequest stringRequest = new StringRequest(Request.Method.PUT, server(api),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Logger.d(TAG, response);
                        volleyHandler.onSucces(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Logger.d(TAG, error.toString());
                        volleyHandler.onError(error.toString());
                    }
                }
        ) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers();
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                return new JSONObject(body).toString().getBytes();
            }
        };
        MyApplication.instance.addToRequestQueue(stringRequest);
    }

    public static void delete(String api, VolleyHandler volleyHandler) {
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, server(api),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Logger.d(TAG, response);
                        volleyHandler.onSucces(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Logger.d(TAG, error.toString());
                        volleyHandler.onError(error.toString());
                    }
                }
        );
        MyApplication.instance.addToRequestQueue(stringRequest);
    }

    public static String API_LIST_POST = "employees";
    public static String API_SINGLE_POST = "employee/1";
    public static String API_CREATE_POST = "create";
    public static String API_UPDATE_POST = "update/21";
    public static String API_DELETE_POST = "delete/2";

    public static HashMap<String, String> paramsEmpty() {
        return new HashMap<String, String>();
    }

    public static HashMap<String, Object> paramsCreate(Employee employee) {

        HashMap<String, Object> params = new HashMap<>();
        params.put("employee_name", employee.getEmployee_name());
        params.put("employee_salary", employee.getEmployee_salary());
        params.put("employee_age", employee.getEmployee_age());
        params.put("profile_image", employee.getProfile_image());
        return params;

    }


    public static HashMap<String, Object> paramsUpdate(Employee employee) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", employee.getId());
        params.put("employee_name", employee.getEmployee_name());
        params.put("employee_salary", employee.getEmployee_salary());
        params.put("employee_age", employee.getEmployee_age());
        params.put("profile_image", employee.getProfile_image());
        return params;
    }


}
