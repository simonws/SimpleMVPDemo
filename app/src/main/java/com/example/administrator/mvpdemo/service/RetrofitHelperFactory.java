package com.example.administrator.mvpdemo.service;

/**
 * Created by ws on 18-5-3.
 */

public class RetrofitHelperFactory {
    private static DefaultRetrofitHelper defaultRetrofitHelper;
    private static DefaultRetrofitHelper doubanRetrofitHelper;

    public static DefaultRetrofitHelper getDefaultHelper() {
        if (defaultRetrofitHelper == null) {
            defaultRetrofitHelper = new DefaultRetrofitHelper();
        }

        return defaultRetrofitHelper;
    }

    public static DefaultRetrofitHelper getDoubanHelper() {
        if (doubanRetrofitHelper == null) {
            doubanRetrofitHelper = new DefaultRetrofitHelper(Constants.DOU_BAN_URL);
        }

        return doubanRetrofitHelper;
    }
}
