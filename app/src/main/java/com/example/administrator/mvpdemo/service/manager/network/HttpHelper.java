package com.example.administrator.mvpdemo.service.manager.network;

import java.util.Map;

/**
 * Created by ws on 18-5-7.
 */

public class HttpHelper implements IHttpProcessor {
    private IHttpProcessor httpProcessor = null;
    public static final HttpHelper sInstance = new HttpHelper();

    public void init(IHttpProcessor httpProcessor) {
        this.httpProcessor = httpProcessor;
    }

    public static HttpHelper getsInstance() {
        return sInstance;
    }


    @Override
    public void get(String url, Map<String, Object> params, IHttpCallBack httpCallBack) {
        httpProcessor.get(url, params, httpCallBack);
    }

    @Override
    public void post(String url, Map<String, Object> params, IHttpCallBack httpCallBack) {
        httpProcessor.post(url, params, httpCallBack);
    }
}