package com.android1604.mustsee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android1604.mustsee.BaseActivity;
import com.android1604.mustsee.R;
import com.android1604.mustsee.bean.PushChannelBean;
import com.android1604.mustsee.presenter.IChannelPresenter;
import com.android1604.mustsee.presenter.impl.ChannelPresenterImpl;
import com.android1604.mustsee.view.IChannelView;

import java.util.ArrayList;
import java.util.List;

public class ChannelActivity extends BaseActivity implements IChannelView {

    private ImageView backImage;
    private CustomPushChannelGridView mPushGridView;
    private List<PushChannelBean.BodyBean.DataListBean> pushChannels = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private PushChannelAdapter mPushChannelAdapter;
    private CustomMyChannelGridView mMyGridView;
    private int currentItem;
    private MyChannelAdapter mMyChannelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
        Intent intent = getIntent();
        ArrayList<String> titleList = intent.getStringArrayListExtra("titleList");
        currentItem = intent.getIntExtra("currentItem", 0);
        titles.addAll(titleList);
        IChannelPresenter channelPresenter = new ChannelPresenterImpl(this);
        channelPresenter.getPushChannel();
        initView();
    }

    private void initView() {
        backImage = (ImageView) findViewById(R.id.channel_back_iv);
        mPushGridView = (CustomPushChannelGridView) findViewById(R.id.channel_push_gv);
        mPushChannelAdapter = new PushChannelAdapter();
        mPushGridView.setAdapter(mPushChannelAdapter);
        mMyGridView = (CustomMyChannelGridView) findViewById(R.id.channel_my_gv);
        mMyChannelAdapter = new MyChannelAdapter();
        mMyGridView.setAdapter(mMyChannelAdapter);
        initListener();
    }

    private void initListener() {
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    @Override
    public void refreshPushChannel(List<PushChannelBean.BodyBean.DataListBean> pushChannelList) {
        pushChannels.addAll(pushChannelList);
        mPushChannelAdapter.notifyDataSetChanged();
    }




    class MyChannelAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return titles == null ? 0 : titles.size();
        }

        @Override
        public Object getItem(int position) {
            return titles.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView;
            convertView = LayoutInflater.from(ChannelActivity.this).inflate(R.layout.channel_list_item,parent,false);
            textView = (TextView) convertView.findViewById(R.id.channel_list_txt);
            textView.setText(titles.get(position));
            if(position == currentItem){
                textView.setTextColor(getResources().getColor(R.color.selectedTextColor));
            }
            return convertView;
        }
    }


    class PushChannelAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return pushChannels == null ? 0 : pushChannels.size();
        }

        @Override
        public Object getItem(int position) {
            return pushChannels.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView;
            if(position != pushChannels.size()-1){
                convertView = LayoutInflater.from(ChannelActivity.this).inflate(R.layout.channel_list_item,parent,false);
                textView = (TextView) convertView.findViewById(R.id.channel_list_txt);

            }else{
                convertView = LayoutInflater.from(ChannelActivity.this).inflate(R.layout.channel_list_more_item,parent,false);
                textView = (TextView) convertView.findViewById(R.id.channel_list_more_txt);
            }
            String keyword = pushChannels.get(position).getKeyword();
            textView.setText(keyword);
            return convertView;
        }
    }


}
