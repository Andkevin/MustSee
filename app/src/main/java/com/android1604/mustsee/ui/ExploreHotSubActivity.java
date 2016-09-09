package com.android1604.mustsee.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android1604.mustsee.BaseActivity;
import com.android1604.mustsee.R;
import com.android1604.mustsee.adapter.ExploreListAdapter;
import com.android1604.mustsee.adapter.HotSubListAdapter;
import com.android1604.mustsee.bean.ExploreInfoBean;
import com.android1604.mustsee.bean.ExploreSubscribeBean;
import com.android1604.mustsee.presenter.ExplorePresenterImpl;
import com.android1604.mustsee.view.IExploreView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

/**
 * Created by my on 2016/9/8.
 */
public class ExploreHotSubActivity extends BaseActivity implements IExploreView, View.OnClickListener{
    private ExplorePresenterImpl mExplorePresenter;
    private TextView mSubscribeTxt;
    private PullToRefreshListView mRefreshLv;
    private String mKeyword;
    private ImageView mBackImgView;
    private TextView mKeywordTxt;
    private HotSubListAdapter mHotSubListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore_hotsubscribe_titlelist_activity_view);
        mExplorePresenter = new ExplorePresenterImpl(this);
        mKeyword = getIntent().getExtras().getString("keyword");
        if(mKeyword == null){
            return;
        }
        initView();
        mExplorePresenter.queryHotSubList(mKeyword);
    }

    private void initView() {
        mSubscribeTxt = (TextView)findViewById(R.id.hotsub_toolbar_subornot_tv);
        mBackImgView = (ImageView) findViewById(R.id.hotsub_toolbar_back_iv);
        mKeywordTxt = (TextView) findViewById(R.id.hotsub_toolbar_keyword_tv);
        mKeywordTxt.setText(mKeyword);
        mSubscribeTxt.setOnClickListener(this);
        mBackImgView.setOnClickListener(this);
        mRefreshLv = (PullToRefreshListView) findViewById(R.id.hotsub_list_view_lv);
        mRefreshLv.setOnItemClickListener(itemClickListener);
    }

    @Override
    public void applyHotSubList(ExploreSubscribeBean exploreSubscribeBean) {
        if(mHotSubListAdapter == null){
            mHotSubListAdapter = new HotSubListAdapter(this,exploreSubscribeBean);
            mRefreshLv.setAdapter(mHotSubListAdapter);
        }
        mHotSubListAdapter.notifyDataSetChanged();
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //TO-DO
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hotsub_toolbar_subornot_tv:
                String subCurText = mSubscribeTxt.getText().toString();
                if(subCurText.equals("订阅")){
                    mSubscribeTxt.setText("退订");
                }else {
                    mSubscribeTxt.setText("订阅");
                }
                break;
            case R.id.hotsub_toolbar_back_iv:
                this.finish();
                break;
        }
    }

    //无需使用
    @Override
    public void applyExploreInfo(ExploreInfoBean exploreInfoBean) {}

}
