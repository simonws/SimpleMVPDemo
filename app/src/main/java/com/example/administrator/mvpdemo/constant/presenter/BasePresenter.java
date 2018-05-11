package com.example.administrator.mvpdemo.constant.presenter;

import com.example.administrator.mvpdemo.constant.iview.IView;

import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by ws on 18-5-2.
 */

public abstract class BasePresenter<V extends IView> {
    protected WeakReference<V> mViewReference;

    public static final String UTF_8 = "UTF-8";

    protected String appendUrl(String douBanUrl, Map<String, String> parameters) {
        StringBuilder sb = new StringBuilder();
        sb.append(douBanUrl);
        boolean first = true;

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (first) {
                first = false;
                sb.append("?");
            } else {
                sb.append("&");
            }
            try {
                sb.append(URLEncoder.encode(key, UTF_8) + "="
                    + URLEncoder.encode(value, UTF_8));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public void detachView() {
        if (mViewReference != null) {
            mViewReference.clear();
        }
    }

    protected void processErrorInfo(Throwable e) {
        if (mViewReference.get() != null) {
            mViewReference.get().onError("请求失败！！");
        }
        e.printStackTrace();
    }

    public void attachView(V view) {
        mViewReference = new WeakReference<>(view);
    }
}
