package com.example.administrator.mvpdemo.service.presenter;

import com.example.administrator.mvpdemo.service.entity.BaseData;
import com.example.administrator.mvpdemo.service.view.IView;

import java.lang.ref.WeakReference;

/**
 * Created by ws on 18-5-2.
 */

public abstract class BasePresenter<D extends BaseData> implements IPresenter {
    protected D mData;
    protected WeakReference<IView> mViewReference;
}
