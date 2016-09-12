package com.android1604.mustsee.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android1604.mustsee.BaseActivity;
import com.android1604.mustsee.R;
import com.android1604.mustsee.adapter.NewsListAdapter;
import com.android1604.mustsee.adapter.SearchHistoryListAdapter;
import com.android1604.mustsee.adapter.SearchHotGridAdapter;
import com.android1604.mustsee.bean.ExploreInfoBean;
import com.android1604.mustsee.bean.NewsBean;
import com.android1604.mustsee.bean.SearchAutoTipBean;
import com.android1604.mustsee.bean.SearchHotBean;
import com.android1604.mustsee.presenter.impl.ExplorePresenterImpl;
import com.android1604.mustsee.view.IExploreView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Kevin on 2016/9/10.
 */
public class SearchActivity  extends BaseActivity implements IExploreView,View.OnClickListener{
    private Context mContext;
    private ExplorePresenterImpl mExplorePresenter;
    private String mKeyword;
    private AutoCompleteTextView mAutoCompTxt;
    private ImageView mBarDeleIv;
    private GridView mHotGridView;
    private List<SearchHotBean.BodyBean.DataListBean> mGridAdapterDataList = new ArrayList<>();
    private List<SearchHotBean.BodyBean.DataListBean> mCurGridAdapterDataList = new ArrayList<>();
    private SearchHotGridAdapter mSearchHotGridAdapter;
    private TextView mChangeBatTxt;
    private int mGridDataGroup = 0;
    private int mCurGridDataGroup = 0;
    private PullToRefreshListView mRefreshLv;
    private LinearLayout mPageLoadingView;
    private ImageView mLoadAnimImg;
    private AnimationDrawable mAnimation;
    private String lastId = "0";
    private NewsListAdapter mNewsListAdapter;
    private List<NewsBean.BodyBean.NewsListBean> newsBeanList = new ArrayList<>();
    public static final int LV_REQ_ADDMORE = 0;
    private LinearLayout mSearchDefPageView;
    private ListView mAutoTipLv;
    private SharedPreferences mSharedPref;
    private RelativeLayout mHistoryListView;
    private TextView mClearHistoryTxt;
    private Set<String> mHistorySet = new HashSet<>();
    private List<String> mHistoryList = new ArrayList<>();
    private ListView mHistoryLv;
    private SearchHistoryListAdapter mSearHistoryListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page_layout);
        mContext = this;
        mSharedPref = getSharedPreferences("historylist", Context.MODE_PRIVATE);
        mExplorePresenter = new ExplorePresenterImpl(this);
        mKeyword = getIntent().getExtras().getString("keyword");
        if (mKeyword == null) {
            Toast.makeText(this, "关键字为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        initView();
        mExplorePresenter.queryHotSearchList();
    }

    private void initView() {
        mSearchDefPageView = (LinearLayout) findViewById(R.id.activity_search_page_default_subview);
        mAutoTipLv = (ListView) findViewById(R.id.activity_search_page_autolist_subview);
        mRefreshLv = (PullToRefreshListView) findViewById(R.id.activity_search_page_news_list_subview);
        mPageLoadingView = (LinearLayout)findViewById(R.id.activity_search_page_load_subview);
        mHistoryListView = (RelativeLayout) findViewById(R.id.activity_search_def_historylist_subview);
        subViewShowCtl(mSearchDefPageView);             //此时控制显示默认页面
        mClearHistoryTxt = (TextView) findViewById(R.id.activity_search_def_delhistory_tv);
        mClearHistoryTxt.setOnClickListener(this);
        mLoadAnimImg = (ImageView)findViewById(R.id.activity_search_page_load_img_iv);
        mAutoCompTxt = (AutoCompleteTextView) findViewById(R.id.activity_search_toolbar_searchbox_actv);
        if(mAutoCompTxt != null){
            mAutoCompTxt.setHint("大家都在搜:"+mKeyword);
        }
        mBarDeleIv = (ImageView) findViewById(R.id.activity_search_toolbar_delete_iv);
        mHotGridView = (GridView) findViewById(R.id.activity_search_default_hotgrid_gd);
        mChangeBatTxt = (TextView) findViewById(R.id.activity_search_default_batchange_tv);
        if(mChangeBatTxt != null){
            mChangeBatTxt.setOnClickListener(this);
        }
        mSharedPref.getStringSet("history",mHistorySet);
        mHistoryList.addAll(mHistoryList);
        mHistoryLv = (ListView) findViewById(R.id.activity_search_def_historylist_lv);
        mSearHistoryListAdapter= new SearchHistoryListAdapter(this,mHistoryList);
        mHistoryLv.setAdapter(mSearHistoryListAdapter);
        historyShowCtrl(mHistoryList.size());
    }

    private void historyShowCtrl(int size){
        if(mHistoryList.size() > 0){
            mHistoryListView.setVisibility(View.VISIBLE);
        }else{
            mHistoryListView.setVisibility(View.GONE);
        }
    }

    //相关View的点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_search_default_batchange_tv:
                mCurGridDataGroup++;
                mCurGridDataGroup %= mGridDataGroup;
                mCurGridAdapterDataList.clear();
                for (int i = 0; i < 6; i++) {
                    mCurGridAdapterDataList.add(mGridAdapterDataList.get(i+mCurGridDataGroup*6));
                }
                mSearchHotGridAdapter.notifyDataSetChanged();
                break;
            case R.id.activity_search_toolbar_delete_iv:

                break;
            case R.id.activity_search_def_delhistory_tv:

                break;
        }
    }

    //查询到热搜榜数据后的相关操作
    @Override
    public void applyHotSearchList(SearchHotBean searchHotBean) {
        mGridAdapterDataList.addAll(searchHotBean.getBody().getDataList());
        mGridDataGroup = mGridAdapterDataList.size()/6;
        mCurGridAdapterDataList.clear();
        for (int i = 0; i < 6; i++) {
            mCurGridAdapterDataList.add(mGridAdapterDataList.get(i));
        }
        if(mSearchHotGridAdapter == null){
            mSearchHotGridAdapter = new SearchHotGridAdapter(mContext,mCurGridAdapterDataList);
            mHotGridView.setAdapter(mSearchHotGridAdapter);
            mHotGridView.setOnItemClickListener(mItemListener);
        }
        mSearchHotGridAdapter.notifyDataSetChanged();
    }

    //适配器视图item的点击事件处理
    AdapterView.OnItemClickListener mItemListener = new AdapterView.OnItemClickListener() {
        private SharedPreferences.Editor mSpEditor;

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int parentId = parent.getId();
            switch (parentId){
                //实时热搜榜的Grid适配器item点击事件
                case R.id.activity_search_default_hotgrid_gd:
                    mKeyword = mCurGridAdapterDataList.get(position).getKeyword();
                    mAutoCompTxt.setText(mKeyword);
                    mHistorySet.add(mKeyword);
                    mSpEditor = mSharedPref.edit();
                    mSpEditor.putStringSet("history",mHistorySet);
                    mSpEditor.commit();
                    mExplorePresenter.queryNewsSubList(mKeyword,"0");
                    //加载页面的等待动画
                    subViewShowCtl(mPageLoadingView);
                    mLoadAnimImg.setBackgroundResource(R.drawable.loading_animation);
                    mAnimation = (AnimationDrawable) mLoadAnimImg.getBackground();
                    mLoadAnimImg.post(new Runnable() {
                        @Override
                        public void run() {
                            if(mAnimation != null && !mAnimation.isRunning()){
                                mAnimation.start();            //开始等待动画
                            }
                        }
                    });
                    break;
            }
        }
    };

    @Override
    public void applyAutoSearchList(SearchAutoTipBean searchAutoTipBean) {

    }

    //查询到NewsBean数据后的相关操作
    @Override
    public void applyNewsSubList(NewsBean newsBean) {
        subViewShowCtl(mRefreshLv);
        if(lastId.equals("0")){
            newsBeanList.clear();
            newsBeanList.addAll(newsBean.getBody().getNewsList());
            mNewsListAdapter = new NewsListAdapter(this, newsBeanList);
            mRefreshLv.setAdapter(mNewsListAdapter);
            mNewsListAdapter.notifyDataSetChanged();
            listRefreshCtrl();
        }else{
            newsBeanList.addAll(newsBean.getBody().getNewsList());
            mNewsListAdapter.notifyDataSetChanged();
            mRefreshLv.onRefreshComplete();
        }
        mAnimation.stop();           //结束等待动画
    }

    /**
     * ListView刷新的监听事件
     */
    private void listRefreshCtrl() {
        mRefreshLv.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        mRefreshLv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {}

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                refreshView.getLoadingLayoutProxy().setRefreshingLabel("推荐中...");
                refreshView.getLoadingLayoutProxy().setPullLabel("下拉刷新");
                refreshView.getLoadingLayoutProxy().setReleaseLabel("松手刷新");
                lastId = newsBeanList.get(newsBeanList.size() - 1).getId();
                if(!lastId.equals("0")){
                    mExplorePresenter.queryNewsSubList(mKeyword,lastId);
                }else{
                    Toast.makeText(mContext, "lastId无效!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //控制Activity中子页面的显示和隐藏
    private void subViewShowCtl(View view){
        switch (view.getId()){
            case R.id.activity_search_page_default_subview:
                mSearchDefPageView.setVisibility(View.VISIBLE);
                mAutoTipLv.setVisibility(View.GONE);
                mRefreshLv.setVisibility(View.GONE);
                mPageLoadingView.setVisibility(View.GONE);
                break;
            case R.id.activity_search_page_autolist_subview:
                mSearchDefPageView.setVisibility(View.GONE);
                mAutoTipLv.setVisibility(View.VISIBLE);
                mRefreshLv.setVisibility(View.GONE);
                mPageLoadingView.setVisibility(View.GONE);
                break;
            case R.id.activity_search_page_news_list_subview:
                mSearchDefPageView.setVisibility(View.GONE);
                mAutoTipLv.setVisibility(View.GONE);
                mRefreshLv.setVisibility(View.VISIBLE);
                mPageLoadingView.setVisibility(View.GONE);
                break;
            case R.id.activity_search_page_load_subview:
                mSearchDefPageView.setVisibility(View.GONE);
                mAutoTipLv.setVisibility(View.GONE);
                mRefreshLv.setVisibility(View.GONE);
                mPageLoadingView.setVisibility(View.VISIBLE);
                break;
        }
    }

//    private Handler mHandler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what){
//                case LV_REQ_ADDMORE:
//                    mRefreshLv.onRefreshComplete();
//                    break;
//            }
//        }
//    };

    //监听系统返回键响应事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
            if(mRefreshLv.getVisibility() == View.VISIBLE){
                subViewShowCtl(mSearchDefPageView);
                return true;
            }else{
                this.finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    //不使用
    @Override
    public void applyExploreInfo(ExploreInfoBean exploreInfoBean) {}
}
