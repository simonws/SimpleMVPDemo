package com.example.administrator.mvpdemo.constant.datamanager.network.retrofit;

import com.example.administrator.mvpdemo.constant.datamanager.network.IHttpCallBack;
import com.example.administrator.mvpdemo.constant.datamanager.network.IHttpProcessor;

import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ws on 18-5-10.
 */

public class retrofitHttpProcessor implements IHttpProcessor {

    private RetrofitInterface.MainInterface mBookService;

    @Override
    public void get(String url, Map<String, String> params, final IHttpCallBack httpCallBack) {

        Observer observer = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                httpCallBack.onFailed(e);
            }

            @Override
            public void onNext(String book) {
                httpCallBack.onSuccess(book);
            }
        };

        //name, tag, start, count
        getBookService().getBookInfo(params.get("name"), params.get("tag"), Integer.parseInt(params.get("start")), Integer.parseInt(params.get("count"))).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer);
    }

    private RetrofitInterface.MainInterface getBookService() {
        if (mBookService == null) {
            mBookService = RetrofitHelperFactory.getDoubanHelper().getServer(RetrofitInterface.MainInterface.class);
        }
        return mBookService;
    }

    @Override
    public void post(String url, Map<String, String> params, IHttpCallBack httpCallBack) {

    }
}
