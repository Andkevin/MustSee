package com.android1604.mustsee;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.android1604.mustsee.presenter.IStartPresenter;
import com.android1604.mustsee.presenter.impl.StartPresenterImpl;
import com.android1604.mustsee.ui.MainActivity;
import com.android1604.mustsee.view.IStartView;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.squareup.picasso.Picasso;

/**
 * 欢迎页面，获取定位信息
 */
public class StartActivity extends BaseActivity implements IStartView{

    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();
    private IStartPresenter startPresenter;
    private ImageView mImageView;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = new Intent(StartActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.activity_start);
        startPresenter = new StartPresenterImpl(this);
        mImageView = (ImageView) findViewById(R.id.start_image_iv);
        mLocationClient = new LocationClient(getApplicationContext());     //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);    //注册监听函数
        initLocation();
        //开启定位功能，会自动开始定位
        mLocationClient.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mLocationClient.stop();
    }

    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 0;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    @Override
    public void refreshView(String url) {
        Picasso.with(this).load(url).into(mImageView);
        mImageView.setVisibility(View.VISIBLE);
    }

    @Override
    public void refreshView() {
        mImageView.setVisibility(View.VISIBLE);
    }


    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            String lat = String.valueOf(bdLocation.getLatitude());
            SharedPreferences preferences = getSharedPreferences("location", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("lat",lat);
            editor.commit();
            startPresenter.getImageUrl();
            handler.sendEmptyMessageDelayed(1,3000);
        }
    }
}
