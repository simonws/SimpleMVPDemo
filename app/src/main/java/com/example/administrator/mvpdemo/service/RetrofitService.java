package com.example.administrator.mvpdemo.service;


import com.example.administrator.mvpdemo.service.entity.Book;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface RetrofitService {

    public interface RetrofitBookService {
        @GET("book/search")
        Observable<Book> getSearchBooksA(@Query("q") String name,
                                         @Query("tag") String tag, @Query("start") int start,
                                         @Query("count") int count);

        @GET("book/search")
        Observable<Book> getSearchBooksB(@Query("q") String name,
                                         @Query("tag") String tag, @Query("start") int start,
                                         @Query("count") int count);
    }


}
