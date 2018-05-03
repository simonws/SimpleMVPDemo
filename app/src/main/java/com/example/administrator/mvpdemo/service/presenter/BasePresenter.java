package com.example.administrator.mvpdemo.service.presenter;

import com.example.administrator.mvpdemo.service.entity.BaseData;
import com.example.administrator.mvpdemo.service.view.IView;

import java.lang.ref.WeakReference;

/**
 * Created by ws on 18-5-2.
 */

public abstract class BasePresenter<D extends BaseData, V extends IView> {
    protected D mData;
    protected WeakReference<V> mViewReference;


    public void detachView() {
        if (mViewReference != null) {
            mViewReference.clear();
        }
    }

    public void attachView(V view) {
        mViewReference = new WeakReference<>(view);
    }
}
