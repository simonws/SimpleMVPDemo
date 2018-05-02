package com.example.administrator.mvpdemo.service.presenter;


import com.example.administrator.mvpdemo.service.entity.Book;
import com.example.administrator.mvpdemo.service.manager.DataManager;
import com.example.administrator.mvpdemo.service.view.IView;

import java.lang.ref.WeakReference;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class BookPresenter extends BasePresenter<Book> {

    @Override
    public void detachView() {
        if (mViewReference != null) {
            mViewReference.clear();
        }
    }

    @Override
    public void attachView(IView view) {
        mViewReference = new WeakReference<>(view);
    }

    public void fetchData(String name, String tag, int start, int count) {
        Subscription subscribe = DataManager.getInstance().getSearchBooks(name, tag, start, count)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<Book>() {
                           @Override
                           public void onCompleted() {
                               if (mData != null && mViewReference.get() != null) {
                                   mViewReference.get().onSuccess(mData);
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
                       }
            );

        DataManager.getInstance().clearSubcriber(subscribe);
    }
}
