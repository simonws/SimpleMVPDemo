package com.example.administrator.mvpdemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.constant.datamanager.network.retrofit.GitLoginData;
import com.example.administrator.mvpdemo.constant.iview.IMainView;
import com.example.administrator.mvpdemo.constant.presenter.MainPresenter;
import com.example.administrator.mvpdemo.constant.presenter.PresenterFactory;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {

    private TextView bookTextView;
    private Button bookRequestButton;


    private TextView phoneTextView;
    private Button phoneRequestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookTextView = (TextView) findViewById(R.id.book_view_id);
        bookRequestButton = (Button) findViewById(R.id.book_info_request);
        bookRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                presenter.fetchBookInfo("金瓶梅", null, 0, 1);
                presenter.fetchLoginInfo("simonws");
            }
        });


        phoneTextView = (TextView) findViewById(R.id.book_view_id);
        phoneRequestButton = (Button) findViewById(R.id.phone_info_request);
        phoneRequestButton.setOnClickListener(new View.OnClickListener() {
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
        bookTextView.setText(data.toString());
    }

    @Override
    public void onPhoneDataSuccess(GitLoginData data) {
        phoneTextView.setText(data.toString());
    }
}
