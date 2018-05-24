package com.example.administrator.mvpdemo.constant.bean;

/**
 * Created by ws on 18-4-9.
 */

public class GitLoginData {


    private String login;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return login + " == " + id;
    }
}