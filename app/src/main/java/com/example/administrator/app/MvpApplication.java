package com.example.administrator.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.example.administrator.mvpdemo.constant.datamanager.network.HttpHelper;
import com.example.administrator.mvpdemo.constant.datamanager.network.retrofit.OkhttpProcessor;

import java.util.logging.LogRecord;

/**
 * Created by ws on 18-5-11.
 */

public class MvpApplication extends Application {
    public static Context sContext;
    private static Handler sHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        HttpHelper.getsInstance().init(new OkhttpProcessor());
        sContext = this;

        sHandler = new Handler();
    }

    public static Handler getsHandler() {
        return sHandler;
    }


}
