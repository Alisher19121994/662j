package com.example.a662j.utils;

import android.util.Log;

import com.example.a662j.volley.VolleyHttp;

public class Logger {

    public static void d(String tag, String msg){
        if (VolleyHttp.IS_TESTER){
            Log.d(tag, msg);
        }
    }
}
