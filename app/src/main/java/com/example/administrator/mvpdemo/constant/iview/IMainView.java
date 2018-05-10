package com.example.administrator.mvpdemo.constant.iview;

import com.example.administrator.mvpdemo.constant.bean.Book;
import com.example.administrator.mvpdemo.constant.bean.PhoneData;

/**
 * Created by ws on 18-5-3.
 */

public interface IMainView {
    void onBookDataSuccess(Book data);

    void onPhoneDataSuccess(PhoneData data);
}
