package com.android1604.mustsee.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by my on 2016/9/6.
 */
public class HttpUtils {
    private static HttpService mHttpService;
    public static final String BASE_URL = "http://api2.souyue.mobi";
    public static HttpService getHttpService(){
        if(mHttpService == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            mHttpService = retrofit.create(HttpService.class);
        }
        return mHttpService;
    }
}
