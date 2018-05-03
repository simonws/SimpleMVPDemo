package com.example.administrator.mvpdemo.service.manager;

import com.example.administrator.mvpdemo.service.RetrofitHelperFactory;
import com.example.administrator.mvpdemo.service.RetrofitService;
import com.example.administrator.mvpdemo.service.entity.Book;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
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

    private RetrofitService.RetrofitBookService mBookService;

    private DataManager() {
        mCompositeSubscription = new CompositeSubscription();
    }

    private RetrofitService.RetrofitBookService getBookService() {
        if (mBookService == null) {
            mBookService = RetrofitHelperFactory.getDoubanHelper().getServer(RetrofitService.RetrofitBookService.class);
        }
        return mBookService;
    }

    public Subscription getSearchBooksA(String name, String tag, int start, int count, Observer<Book> observer) {
        return getBookService().getSearchBooksA(name, tag, start, count).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer);
    }

    public Observable<Book> getSearchBooksB(String name, String tag, int start, int count, Observer<Book> observer) {
        return getBookService().getSearchBooksB(name, tag, start, count);
    }
}
