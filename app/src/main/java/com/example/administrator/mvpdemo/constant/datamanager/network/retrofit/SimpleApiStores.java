package com.example.administrator.mvpdemo.constant.datamanager.network.retrofit;

/**
 * Created by ws on 18-4-9.
 */


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Call<T> get();必须是这种形式,这是2.0之后的新形式
 * 如果不需要转换成Json数据,可以用了ResponseBody;
 * 你也可以使用Call<GsonBean> get();这样的话,需要添加Gson转换器
 */
public interface SimpleApiStores {
    @GET("/users/{user}")
    Call<GitLoginData> getLoginName(@Path("user") String user);
}
