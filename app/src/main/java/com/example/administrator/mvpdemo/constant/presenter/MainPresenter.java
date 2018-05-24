package com.example.administrator.mvpdemo.constant.presenter;


import com.example.administrator.mvpdemo.constant.Constants;
import com.example.administrator.mvpdemo.constant.datamanager.network.HttpCallBack;
import com.example.administrator.mvpdemo.constant.datamanager.network.HttpHelper;
import com.example.administrator.mvpdemo.constant.bean.GitLoginData;
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
        HttpHelper.getsInstance().get(Constants.GIT_HUB_URL, new HttpCallBack<GitLoginData>() {
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
        StringBuilder stringBuilder = new StringBuilder(Constants.GIT_HUB_URL);
        stringBuilder.append(Constants.param_user_key).append("/").append(name);
        String fullUrl = stringBuilder.toString();
        HttpHelper.getsInstance().get(fullUrl, new HttpCallBack<GitLoginData>() {
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

    private String createUrl(String baseUrl, Map<String, String> param) {
        StringBuilder sb = new StringBuilder(baseUrl);
        int index = 0;
        for (Map.Entry<String, String> entry : param.entrySet()) {
            if (index == 0) {
                sb.append("?");
            } else {
                sb.append("&");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return sb.toString();
    }

    public void fetchPhoneInfo(String name, String tag, int start, int count) {
        Map<String, String> param = new HashMap<>();
        param.put("name", name);
        param.put("tag", tag);
        param.put("start", start + "");
        param.put("count", count + "");
        HttpHelper.getsInstance().get(Constants.DOU_BAN_URL, new HttpCallBack<GitLoginData>() {
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
