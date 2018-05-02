package com.example.administrator.mvpdemo.service.presenter;

/**
 * Created by ws on 18-5-2.
 */

public class PresenterFactory {
    public static BookPresenter getBookPresenter() {
        return new BookPresenter();
    }
}
