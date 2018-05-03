package com.example.administrator.mvpdemo.service.presenter;


import com.example.administrator.mvpdemo.service.entity.Book;
import com.example.administrator.mvpdemo.service.manager.DataManager;
import com.example.administrator.mvpdemo.ui.activity.MainActivity;

import rx.Observer;
import rx.Subscription;


public class BookPresenter extends BasePresenter<Book, MainActivity> {

    public void fetchData(String name, String tag, int start, int count) {
        Subscription subscribe = DataManager.getInstance().getSearchBooksA(name, tag, start, count, new Observer<Book>() {
            @Override
            public void onCompleted() {
                if (mData != null && mViewReference.get() != null) {
                    mViewReference.get().onBookData(mData);
                }
            }

            @Override
            public void onError(Throwable e) {
                if (mViewReference.get() != null) {
                    mViewReference.get().onError("请求失败！！");
                }
            }

            @Override
            public void onNext(Book book) {
                mData = book;
            }
        });

        DataManager.getInstance().clearSubcriber(subscribe);
    }
}
