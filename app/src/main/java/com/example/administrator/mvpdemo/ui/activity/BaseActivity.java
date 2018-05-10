package com.example.administrator.mvpdemo.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.administrator.mvpdemo.constant.presenter.BasePresenter;
import com.example.administrator.mvpdemo.constant.iview.IView;

/**
 * Created by ws on 18-5-2.
 */

public abstract class BaseActivity<T extends BasePresenter> extends Activity implements IView {
    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    protected abstract T createPresenter();
}
