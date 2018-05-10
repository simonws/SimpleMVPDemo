package com.example.administrator.mvpdemo.constant.datamanager.network.retrofit;

import com.example.administrator.mvpdemo.constant.Constants;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class DefaultRetrofitHelper {


    public DefaultRetrofitHelper() {
        url = Constants.DOU_BAN_URL;
    }


    protected OkHttpClient client = new OkHttpClient();
    protected GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
    protected Retrofit mRetrofit = null;
    protected String url = Constants.DOU_BAN_URL;
    ;

    public DefaultRetrofitHelper(String url) {
        this.url = url;
        init();
    }

    public <T> T getServer(Class<T> interfaceClass) {
        return (T) mRetrofit.create(interfaceClass);
    }


    private void init() {
        resetApp();
    }

    private void resetApp() {
        mRetrofit = new Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(factory)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();
    }

}
