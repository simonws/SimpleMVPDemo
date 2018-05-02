package com.example.administrator.mvpdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.mvpdemo.service.entity.Book;
import com.example.administrator.mvpdemo.service.presenter.Presenter;
import com.example.administrator.mvpdemo.service.view.BookView;

/**
 * Created by ws on 18-5-2.
 */

public abstract class BaseActivity extends AppCompatActivity implements BookView {
    protected Presenter presenter;

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

    protected abstract Presenter createPresenter();
}
