package com.example.administrator.mvpdemo.constant.datamanager;

import com.example.administrator.mvpdemo.constant.datamanager.network.retrofit.RetrofitHelperFactory;
import com.example.administrator.mvpdemo.constant.datamanager.network.retrofit.RetrofitInterface;
import com.example.administrator.mvpdemo.constant.bean.Book;
import com.example.administrator.mvpdemo.constant.bean.PhoneData;

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

    private RetrofitInterface.MainInterface mBookService;

    private DataManager() {
        mCompositeSubscription = new CompositeSubscription();
    }

    private RetrofitInterface.MainInterface getBookService() {
        if (mBookService == null) {
            mBookService = RetrofitHelperFactory.getDoubanHelper().getServer(RetrofitInterface.MainInterface.class);
        }
        return mBookService;
    }

    public void getBookInfo(String name, String tag, int start, int count, Observer<Book> observer) {
        Subscription subscription = getBookService().getBookInfo(name, tag, start, count).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer);
        clearSubcriber(subscription);
    }

    public void getPhoneInfo(String name, String tag, int start, int count, Observer<PhoneData> observer) {
        Subscription subscription = getBookService().getPhoneInfo(name, tag, start, count).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer);
        clearSubcriber(subscription);
    }
}
