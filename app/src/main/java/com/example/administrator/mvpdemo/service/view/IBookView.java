package com.example.administrator.mvpdemo.service.view;

import com.example.administrator.mvpdemo.service.entity.BaseData;

/**
 * Created by ws on 18-5-3.
 */

public interface IBookView<D extends BaseData> {
    void onBookData(D data);
}
