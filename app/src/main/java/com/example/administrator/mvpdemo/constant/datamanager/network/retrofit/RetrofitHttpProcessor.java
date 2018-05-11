package com.example.administrator.mvpdemo.constant.datamanager.network.retrofit;

import android.util.Log;

import com.example.administrator.mvpdemo.constant.Constants;
import com.example.administrator.mvpdemo.constant.datamanager.network.HttpCallBack;
import com.example.administrator.mvpdemo.constant.datamanager.network.IHttpCallBack;
import com.example.administrator.mvpdemo.constant.datamanager.network.IHttpProcessor;
import com.google.gson.GsonBuilder;

import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ws on 18-5-10.
 */

public class RetrofitHttpProcessor implements IHttpProcessor {
    private static final String TAG = "RetrofitHttpProcessor";
    private Retrofit.Builder builder;
    private OkHttpClient client = new OkHttpClient();
    private GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
    private Retrofit mRetrofit = null;
    private RetrofitInterface.MainInterface mMainInterface;

    public RetrofitHttpProcessor() {
        builder = new Retrofit.Builder()
            .client(client)
            .addConverterFactory(factory)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
    }


    @Override
    public void get(String url, Map<String, String> params, final HttpCallBack httpCallBack) {
        Observer observer = new Observer<GitLoginData>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                httpCallBack.onFailed(e);
            }

            @Override
            public void onNext(GitLoginData book) {
//
//                Log.d(TAG, "ok");
                httpCallBack.onSuccess(book);
            }
        };
        mRetrofit = builder.baseUrl(url).build();
        mMainInterface = mRetrofit.create(RetrofitInterface.MainInterface.class);
        mMainInterface.getLoginName(params.get(Constants.param_user_key))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer);
    }

    @Override
    public void post(String url, Map<String, String> params, HttpCallBack httpCallBack) {

    }
}
