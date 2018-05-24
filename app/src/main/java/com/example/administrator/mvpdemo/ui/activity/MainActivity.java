package com.example.administrator.mvpdemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.constant.bean.GitLoginData;
import com.example.administrator.mvpdemo.constant.iview.IMainView;
import com.example.administrator.mvpdemo.constant.presenter.MainPresenter;
import com.example.administrator.mvpdemo.constant.presenter.PresenterFactory;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {

    private TextView mLoginInfo;
    private Button mLoginRequestButton;


    private TextView mBookInfo;
    private Button mBookRequestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoginInfo = (TextView) findViewById(R.id.login_text_id);
        mLoginRequestButton = (Button) findViewById(R.id.login_info_request);
        mLoginRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.fetchLoginInfo("simonws");
            }
        });


        mBookInfo = (TextView) findViewById(R.id.book_text_id);
        mBookRequestBtn = (Button) findViewById(R.id.book_info_request);
        mBookRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.fetchPhoneInfo("金瓶梅", null, 0, 1);
            }
        });
    }

    @Override
    protected MainPresenter createPresenter() {
        return PresenterFactory.getBookPresenter();
    }

    @Override
    public void onError(String result) {
        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onBookDataSuccess(GitLoginData data) {
        mLoginInfo.setText(data.toString());
    }

    @Override
    public void onPhoneDataSuccess(GitLoginData data) {
        mBookInfo.setText(data.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

}
