package com.example.administrator.mvpdemo.constant.datamanager.network;

/**
 * Created by ws on 18-5-7.
 */

public interface IHttpCallBack {
    void onSuccess(String result);

    void onFailed(Throwable error);
}
