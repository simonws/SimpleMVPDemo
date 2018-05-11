package com.example.administrator.mvpdemo.constant.datamanager.network.volley;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.app.MvpApplication;
import com.example.administrator.mvpdemo.constant.datamanager.network.HttpCallBack;
import com.example.administrator.mvpdemo.constant.datamanager.network.IHttpCallBack;
import com.example.administrator.mvpdemo.constant.datamanager.network.IHttpProcessor;
import com.example.administrator.mvpdemo.ui.activity.MainActivity;

import java.util.Map;

/**
 * Created by ws on 18-5-7.
 */

public class VolleyHttpProcessor implements IHttpProcessor {

    @Override
    public void get(String url, Map<String, String> params, final HttpCallBack httpCallBack) {

        RequestQueue mQueue = Volley.newRequestQueue(MvpApplication.sContext);

        StringRequest stringRequest = new StringRequest(url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    httpCallBack.onSuccess(response);
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
                httpCallBack.onFailed(error);
            }
        });
        //volley第三步
        mQueue.add(stringRequest);


    }

    @Override
    public void post(String url, Map<String, String> params, HttpCallBack httpCallBack) {

    }
}
