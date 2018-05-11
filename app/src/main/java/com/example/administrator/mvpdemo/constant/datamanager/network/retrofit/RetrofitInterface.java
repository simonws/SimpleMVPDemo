package com.example.administrator.mvpdemo.constant.datamanager.network.retrofit;


import com.example.administrator.mvpdemo.constant.bean.Book;
import com.example.administrator.mvpdemo.constant.bean.PhoneData;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;


public interface RetrofitInterface {

    public interface MainInterface {
        @GET("")
        Observable<Book> getInfo();

        @POST("")
        Observable<PhoneData> postInfo();
    }

}
