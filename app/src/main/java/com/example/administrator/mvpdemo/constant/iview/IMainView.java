package com.example.administrator.mvpdemo.constant.iview;

import com.example.administrator.mvpdemo.constant.bean.GitLoginData;

/**
 * Created by ws on 18-5-3.
 */

public interface IMainView {
    void onBookDataSuccess(GitLoginData data);

    void onPhoneDataSuccess(GitLoginData data);
}
