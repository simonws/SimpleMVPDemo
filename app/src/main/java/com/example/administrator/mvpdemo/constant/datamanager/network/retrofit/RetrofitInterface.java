package com.example.administrator.mvpdemo.constant.datamanager.network.retrofit;


import com.example.administrator.mvpdemo.constant.bean.Book;
import com.example.administrator.mvpdemo.constant.bean.PhoneData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


public interface RetrofitInterface {

    public interface MainInterface {
        @GET("book/search")
        Observable<String> getInfo();

        @POST("")
        Observable<String> postInfo();

        @GET("book/search")
        Observable<Object> getInfo(@Query("q") String name,
                                   @Query("tag") String tag, @Query("start") String start,
                                   @Query("count") String count);

        @GET("/users/{user}")
        Observable<GitLoginData> getLoginName(@Path("user") String user);
//        @GET("book/search")
//        Observable<PhoneData> getPhoneInfo(@Query("q") String name,
//                                           @Query("tag") String tag, @Query("start") int start,
//                                           @Query("count") int count);
    }

}
