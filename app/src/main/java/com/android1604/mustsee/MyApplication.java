package com.android1604.mustsee;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2016/9/5.
 *
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //JPush
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
