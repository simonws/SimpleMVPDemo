package com.example.administrator.mvpdemo.service.view;

import com.example.administrator.mvpdemo.service.entity.BaseData;

/**
 * Created by win764-1 on 2016/12/12.
 */

public interface IView<T extends BaseData> {

    void onSuccess(T book);

    void onError(String result);
}
