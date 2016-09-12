package com.android1604.mustsee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android1604.mustsee.BaseActivity;
import com.android1604.mustsee.R;
import com.android1604.mustsee.bean.PushChannelBean;
import com.android1604.mustsee.bean.TabTitlesBean;
import com.android1604.mustsee.fragment.InformationFragment;
import com.android1604.mustsee.presenter.impl.ChannelPresenterImpl;
import com.android1604.mustsee.presenter.impl.InformationPresenterImpl;
import com.android1604.mustsee.view.IChannelView;

import java.util.ArrayList;
import java.util.List;

public class ChannelActivity extends BaseActivity implements IChannelView{

    private int currentItem;
    private EasyTipDragView mDragView;
    private ImageView backImage;
    private ChannelPresenterImpl channelPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);
        initView();
        Intent intent = getIntent();
        currentItem = intent.getIntExtra("currentItem", 0);
        channelPresenter = new ChannelPresenterImpl(this);
        channelPresenter.getPushChannel();
    }

    private void initView() {
        mDragView = (EasyTipDragView) findViewById(R.id.channel_easy_tip_drag_view);
        backImage = (ImageView) findViewById(R.id.channel_back_iv);
        initListener();
    }

    private void initListener() {
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mDragView.setSelectedListener(new MyChannelItemView.OnSelectedListener() {
            @Override
            public void onTileSelected(TabTitlesBean.BodyBean.DataListBean entity, int position, View view) {
                mDragView.setCurrent(position);
                Intent intent = new Intent(ChannelActivity.this, InformationFragment.class);
                intent.putExtra("current",position);
                ChannelActivity.this.setResult(2,intent);
                ChannelActivity.this.finish();
            }
        });
        //设置每次数据改变后的回调（例如每次拖拽排序了标签或者增删了标签都会回调）
        mDragView.setDataResultCallback(new EasyTipDragView.OnDataChangeResultCallback() {
            @Override
            public void onDataChangeResult(ArrayList<TabTitlesBean.BodyBean.DataListBean> tips) {

            }
        });
        //设置点击“确定”按钮后最终数据的回调
        mDragView.setOnCompleteCallback(new EasyTipDragView.OnCompleteCallback() {
            @Override
            public void onComplete(ArrayList<TabTitlesBean.BodyBean.DataListBean> tips) {
                ChannelPresenterImpl.sortChannel(tips);

            }
        });

    }

    @Override
    public void refreshDragView(List<PushChannelBean.BodyBean.DataListBean> pushChannelList) {
        mDragView.setDragData(InformationPresenterImpl.getData());
        mDragView.setPushDatas(pushChannelList);
        mDragView.setCurrent(currentItem);
        mDragView.open();
    }
}

