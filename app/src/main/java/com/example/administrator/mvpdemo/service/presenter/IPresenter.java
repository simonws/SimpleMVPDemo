package com.example.administrator.mvpdemo.service.presenter;


import android.content.Intent;

import com.example.administrator.mvpdemo.service.entity.BaseData;
import com.example.administrator.mvpdemo.service.view.IView;


/**
 * Created by win764-1 on 2016/12/12.
 */

public interface IPresenter {
    void detachView();

    void attachView(IView view);
}
