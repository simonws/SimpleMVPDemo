package com.example.administrator.mvpdemo.constant.datamanager.network;

import java.util.Map;

/**
 * Created by ws on 18-5-7.
 */

public interface IHttpProcessor {
    void get(String url, Map<String, String> params, IHttpCallBack httpCallBack);

    void post(String url, Map<String, String> params, IHttpCallBack httpCallBack);
}
