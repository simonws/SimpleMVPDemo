package com.example.administrator.app;

import android.app.Application;

import com.example.administrator.mvpdemo.constant.datamanager.network.HttpHelper;
import com.example.administrator.mvpdemo.constant.datamanager.network.retrofit.RetrofitHttpProcessor;

/**
 * Created by ws on 18-5-11.
 */

public class MvpApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpHelper.getsInstance().init(new RetrofitHttpProcessor());
    }
}
