package com.example.administrator.mvpdemo.service.presenter;

import android.content.Context;
import android.content.Intent;


import com.example.administrator.mvpdemo.service.entity.Book;
import com.example.administrator.mvpdemo.service.manager.DataManager;
import com.example.administrator.mvpdemo.service.view.BookView;
import com.example.administrator.mvpdemo.service.view.IView;

import java.lang.ref.WeakReference;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by win764-1 on 2016/12/12.
 */

public class BookPresenter implements Presenter {
    private DataManager manager;
    private CompositeSubscription mCompositeSubscription;
    private WeakReference<IView> mBookView;
    private Book mBook;

    public BookPresenter() {
        manager = new DataManager();
        mCompositeSubscription = new CompositeSubscription();
    }


    @Override
    public void detachView() {
        if (mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }

        if (mBookView != null) {
            mBookView.clear();
        }
    }


    @Override
    public void attachView(IView view) {
        mBookView = new WeakReference<>(view);
    }

    @Override
    public void fetchData(String name, String tag, int start, int count) {

        mCompositeSubscription.add(manager.getSearchBooks(name, tag, start, count)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<Book>() {
                @Override
                public void onCompleted() {
                    if (mBook != null && mBookView.get() != null) {
                        mBookView.get().onSuccess(mBook);
                    }
                }

                @Override
                public void onError(Throwable e) {
                    if (mBookView.get() != null) {
                        mBookView.get().onError("请求失败！！");
                    }
                }

                @Override
                public void onNext(Book book) {
                    mBook = book;
                }
            })
        );

    }


//    public void getSearchBooks(String name, String tag, int start, int count) {
//        mCompositeSubscription.add(manager.getSearchBooks(name, tag, start, count)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(new Observer<Book>() {
//                @Override
//                public void onCompleted() {
//                    if (mBook != null && mBookView.get() != null) {
//                        mBookView.get().onSuccess(mBook);
//                    }
//                }
//
//                @Override
//                public void onError(Throwable e) {
//                    if (mBook != null && mBookView.get() != null) {
//                        mBookView.get().onError("请求失败！！");
//                    }
//                }
//
//                @Override
//                public void onNext(Book book) {
//                    mBook = book;
//                }
//            })
//        );
//    }
}
