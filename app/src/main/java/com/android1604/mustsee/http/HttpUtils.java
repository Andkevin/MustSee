package com.android1604.mustsee.http;

import com.android1604.mustsee.constant.Constant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/9/6.
 * 单例模式创建HttpService
 */
public class HttpUtils {
    private static HttpService httpService;
    public static HttpService create(){
        if(httpService == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            httpService = retrofit.create(HttpService.class);
        }
        return httpService;
    }
}
