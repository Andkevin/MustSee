package com.android1604.mustsee.http;

import android.content.Context;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by my on 2016/9/6.
 *
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

    /**
     * 判断网络是否连接1
     */
    public static boolean isNetworkAvailable1() {
        try {
            URL url = new URL("http://www.baidu.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(2000);
            conn.connect();
            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                return true;
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断网络是否连接2
     */
    public static boolean isNetworkAvailable(final Context context) {
        Runtime runtime = Runtime.getRuntime();
        Process pingProcess = null;
        try {
            pingProcess = runtime.exec("/system/bin/ping -c 1 www.baidu.com");
            int exitCode = pingProcess.waitFor();
            return (exitCode == 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
