package com.example.administrator.mvpdemo.service.manager.network;

import java.util.Map;

/**
 * Created by ws on 18-5-7.
 */

public interface IHttpProcessor {
    void get(String url, Map<String, Object> params, IHttpCallBack httpCallBack);

    void post(String url, Map<String, Object> params, IHttpCallBack httpCallBack);
}
