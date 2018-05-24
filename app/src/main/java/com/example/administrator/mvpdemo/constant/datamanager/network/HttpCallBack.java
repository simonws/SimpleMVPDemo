package com.example.administrator.mvpdemo.constant.datamanager.network;

import com.example.administrator.app.MvpApplication;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by ws on 18-5-7.
 */

public abstract class HttpCallBack<Result> implements IHttpCallBack {
    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        Class<?> clz = analyseClass(this);
        final Result objResult = (Result) gson.fromJson(result, clz);
        MvpApplication.getsHandler().post(new Runnable() {
            @Override
            public void run() {
                onSuccess(objResult);
            }
        });

    }

    private Class<?> analyseClass(Object object) {
        Type genType = object.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        return (Class<?>) params[0];
    }

    public abstract void onSuccess(Result objResult);
}
