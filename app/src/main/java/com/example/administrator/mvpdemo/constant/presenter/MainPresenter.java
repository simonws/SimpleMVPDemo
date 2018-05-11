package com.example.administrator.mvpdemo.constant.presenter;


import com.example.administrator.mvpdemo.constant.Constants;
import com.example.administrator.mvpdemo.constant.datamanager.network.HttpCallBack;
import com.example.administrator.mvpdemo.constant.datamanager.network.HttpHelper;
import com.example.administrator.mvpdemo.constant.datamanager.network.retrofit.GitLoginData;
import com.example.administrator.mvpdemo.ui.activity.MainActivity;

import java.util.HashMap;
import java.util.Map;


public class MainPresenter extends BasePresenter<MainActivity> {

    public void fetchBookInfo(String name, String tag, int start, int count) {
        Map<String, String> param = new HashMap<>();
        param.put(Constants.param_name_key, name);
        param.put(Constants.param_tag_key, tag);
        param.put(Constants.param_start_key, start + "");
        param.put(Constants.param_count_key, count + "");
        HttpHelper.getsInstance().get(Constants.GIT_HUB_URL, param, new HttpCallBack<GitLoginData>() {
            @Override
            public void onSuccess(GitLoginData objResult) {
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

    public void fetchLoginInfo(String name) {
        Map<String, String> param = new HashMap<>();
        param.put(Constants.param_user_key, name);
        HttpHelper.getsInstance().get(Constants.GIT_HUB_URL, param, new HttpCallBack<GitLoginData>() {
            @Override
            public void onSuccess(GitLoginData objResult) {
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
        HttpHelper.getsInstance().get(Constants.DOU_BAN_URL, param, new HttpCallBack<GitLoginData>() {
            @Override
            public void onSuccess(GitLoginData objResult) {
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
