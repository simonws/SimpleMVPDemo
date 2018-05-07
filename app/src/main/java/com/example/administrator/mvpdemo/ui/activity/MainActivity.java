package com.example.administrator.mvpdemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mvpdemo.R;
import com.example.administrator.mvpdemo.service.entity.Book;
import com.example.administrator.mvpdemo.service.presenter.BookPresenter;
import com.example.administrator.mvpdemo.service.presenter.PresenterFactory;
import com.example.administrator.mvpdemo.service.view.IBookView;

public class MainActivity extends BaseActivity<BookPresenter, Book> implements IBookView<Book> {

    private TextView text;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.fetchData("金瓶梅", null, 0, 1);
            }
        });
    }

    @Override
    protected BookPresenter createPresenter() {
        return PresenterFactory.getBookPresenter();
    }


    @Override
    public void onSuccess(Book mBook) {
        text.setText(mBook.toString());
    }


    @Override
    public void onError(String result) {
        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onBookData(Book data) {

    }
}
