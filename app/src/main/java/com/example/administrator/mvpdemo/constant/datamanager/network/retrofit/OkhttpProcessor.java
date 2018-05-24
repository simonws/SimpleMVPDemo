package com.example.administrator.mvpdemo.constant.datamanager.network.retrofit;

import android.util.Log;

import com.example.administrator.mvpdemo.constant.Constants;
import com.example.administrator.mvpdemo.constant.datamanager.network.HttpCallBack;
import com.example.administrator.mvpdemo.constant.datamanager.network.IHttpCallBack;
import com.example.administrator.mvpdemo.constant.datamanager.network.IHttpProcessor;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ws on 18-5-10.
 */

public class OkhttpProcessor implements IHttpProcessor {
    private static final String TAG = "OkhttpProcessor";
    private OkHttpClient client;

    public OkhttpProcessor() {
        client = new OkHttpClient();
    }


    @Override
    public void get(String url, final HttpCallBack httpCallBack) {


        Request request = new Request.Builder()
            .url(url)
            .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                httpCallBack.onFailed(e);
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                if (!response.isSuccessful()) {
                    httpCallBack.onFailed(new Exception("error in okhttp"));
                }

                httpCallBack.onSuccess(response.body().string());
            }
        });

    }


    @Override
    public void post(String url, Map<String, String> params, HttpCallBack httpCallBack) {

    }
}
