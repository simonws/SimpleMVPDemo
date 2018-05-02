package com.example.administrator.mvpdemo.service.manager;

import com.example.administrator.mvpdemo.service.RetrofitHelper;
import com.example.administrator.mvpdemo.service.RetrofitService;
import com.example.administrator.mvpdemo.service.entity.Book;

import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


public class DataManager {
    private CompositeSubscription mCompositeSubscription;

    public void clearSubcriber(Subscription subscribe) {
        mCompositeSubscription.add(subscribe);
    }

    private static class DataManagerHolder {
        public static final DataManager sInstance = new DataManager();
    }

    public static DataManager getInstance() {
        return DataManagerHolder.sInstance;
    }

    private RetrofitService mRetrofitService;

    private DataManager() {
        mRetrofitService = RetrofitHelper.getInstance().getServer();
        mCompositeSubscription = new CompositeSubscription();
    }

    public Observable<Book> getSearchBooks(String name, String tag, int start, int count) {
        return mRetrofitService.getSearchBooks(name, tag, start, count);
    }
}
