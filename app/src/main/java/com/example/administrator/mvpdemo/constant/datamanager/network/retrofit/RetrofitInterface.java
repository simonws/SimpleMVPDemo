package com.example.administrator.mvpdemo.constant.datamanager.network.retrofit;


import com.example.administrator.mvpdemo.constant.bean.Book;
import com.example.administrator.mvpdemo.constant.bean.PhoneData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface RetrofitInterface {

    public interface MainInterface {
        @GET("book/search")
        Observable<Book> getBookInfo(@Query("q") String name,
                                     @Query("tag") String tag, @Query("start") int start,
                                     @Query("count") int count);

        @GET("book/search")
        Observable<PhoneData> getPhoneInfo(@Query("q") String name,
                                           @Query("tag") String tag, @Query("start") int start,
                                           @Query("count") int count);
    }


}
