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
