package com.example.administrator.mvpdemo.constant.presenter;


import com.example.administrator.mvpdemo.constant.Constants;
import com.example.administrator.mvpdemo.constant.bean.Book;
import com.example.administrator.mvpdemo.constant.bean.PhoneData;
import com.example.administrator.mvpdemo.constant.datamanager.network.HttpCallBack;
import com.example.administrator.mvpdemo.constant.datamanager.network.HttpHelper;
import com.example.administrator.mvpdemo.ui.activity.MainActivity;

import java.util.HashMap;
import java.util.Map;


public class MainPresenter extends BasePresenter<MainActivity> {

    public void fetchBookInfo(String name, String tag, int start, int count) {
        Map<String, String> param = new HashMap<>();
        param.put("name", name);
        param.put("tag", tag);
        param.put("start", start + "");
        param.put("count", count + "");

        String finalUrl = appendUrl(Constants.DOU_BAN_URL, param);
        HttpHelper.getsInstance().get(finalUrl, param, new HttpCallBack<Book>() {
            @Override
            public void onSuccess(Book objResult) {
                if (mViewReference.get() != null) {
                    mViewReference.get().onBookDataSuccess(objResult);
                }
            }

            @Override
            public void onFailed(Throwable errorInfo) {
                processErrorInfo(errorInfo);
            }
        });
    }


    public void fetchPhoneInfo(String name, String tag, int start, int count) {
        Map<String, String> param = new HashMap<>();
        param.put("name", name);
        param.put("tag", tag);
        param.put("start", start + "");
        param.put("count", count + "");
        HttpHelper.getsInstance().get(Constants.DOU_BAN_URL, param, new HttpCallBack<PhoneData>() {
            @Override
            public void onSuccess(PhoneData objResult) {
                if (mViewReference.get() != null) {
                    mViewReference.get().onPhoneDataSuccess(objResult);
                }
            }

            @Override
            public void onFailed(Throwable errorInfo) {
                processErrorInfo(errorInfo);
            }
        });
    }


}
