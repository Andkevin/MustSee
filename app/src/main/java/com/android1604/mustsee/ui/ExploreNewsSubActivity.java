package com.android1604.mustsee.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android1604.mustsee.BaseActivity;
import com.android1604.mustsee.R;
import com.android1604.mustsee.adapter.ExploreNewsSubscribeAdapter;
import com.android1604.mustsee.adapter.NewsListAdapter;
import com.android1604.mustsee.bean.AddBean;
import com.android1604.mustsee.bean.DeleteBean;
import com.android1604.mustsee.bean.ExploreInfoBean;
import com.android1604.mustsee.bean.NewsBean;
import com.android1604.mustsee.bean.NewsBean1;
import com.android1604.mustsee.bean.SearchAutoTipBean;
import com.android1604.mustsee.bean.SearchHotBean;
import com.android1604.mustsee.presenter.impl.AllSubPresenterImpl;
import com.android1604.mustsee.presenter.impl.ExplorePresenterImpl;
import com.android1604.mustsee.view.IExploreView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/9/8.
 */
public class ExploreNewsSubActivity extends BaseActivity implements IExploreView, View.OnClickListener {
    private Context mContext;
    private ExplorePresenterImpl mExplorePresenter;
    private TextView mSubscribeTxt;
    private PullToRefreshListView mRefreshLv;
    private String mKeyword;
    private ImageView mBackImgView;
    private TextView mKeywordTxt;
    private ExploreNewsSubscribeAdapter mNewsListAdapter;
    private List<NewsBean1.BodyBean.NewsListBean> newsBeanList = new ArrayList<>();
    public static final int LV_REQ_ADDMORE = 0;
    private String lastId = "0";
    private int mSubStatus = -1;
    private String mSrpId = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore_hotsubscribe_titlelist_activity_view);
        mContext = this;
        mExplorePresenter = new ExplorePresenterImpl(this);
        mKeyword = getIntent().getExtras().getString("keyword");
        if (mKeyword == null) {
            Toast.makeText(this, "关键字为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        initView();
        mExplorePresenter.queryNewsSubList(mKeyword,"0");
    }

    private void initView() {
        mSubscribeTxt = (TextView) findViewById(R.id.hotsub_toolbar_subornot_tv);
        mBackImgView = (ImageView) findViewById(R.id.hotsub_toolbar_back_iv);
        mKeywordTxt = (TextView) findViewById(R.id.hotsub_toolbar_keyword_tv);
        mKeywordTxt.setText(mKeyword);
        mSubscribeTxt.setOnClickListener(this);
        mBackImgView.setOnClickListener(this);
        mRefreshLv = (PullToRefreshListView) findViewById(R.id.hotsub_list_view_lv);
        mRefreshLv.setOnItemClickListener(itemClickListener);
    }

    //设置订阅状态
    private void setSubStatus(int subStatus){
        if(subStatus == 1){
            mSubscribeTxt.setText("退订");
        }else{
            mSubscribeTxt.setText("订阅");
        }
    }

    @Override
    public void applyNewsSubList(NewsBean1 newsBean) {
        if(lastId.equals("0")){
            mSubStatus = newsBean.getBody().getSrpInfo().getSubscribe();
            setSubStatus(mSubStatus);                            //设置订阅状态
            mSrpId = newsBean.getBody().getSrpInfo().getSrpId();
            newsBeanList.clear();
            newsBeanList.addAll(newsBean.getBody().getNewsList());
//            mNewsListAdapter = new NewsListAdapter(this, newsBeanList);
            mNewsListAdapter = new ExploreNewsSubscribeAdapter(this, newsBeanList);
            mRefreshLv.setAdapter(mNewsListAdapter);
            mNewsListAdapter.notifyDataSetChanged();
            listRefreshCtrl();
        }else{
            newsBeanList.addAll(newsBean.getBody().getNewsList());
            Log.d("curNewsBeanList","newsBeanList.size()============================"+newsBeanList.size());
            mNewsListAdapter.notifyDataSetChanged();
            mHandler.sendEmptyMessage(LV_REQ_ADDMORE);
        }
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
                    Log.d("lastIdlastId","============================"+lastId);
                    mExplorePresenter.queryNewsSubList(mKeyword,lastId);
                }else{
                    Toast.makeText(mContext, "lastId无效!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * List的Item点击事件
     * 跳转到相关详情Activity页面
     */
    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String docId = newsBeanList.get(position-1).getDocId();
            String docType = newsBeanList.get(position-1).getDocType();
            Intent intent = new Intent(mContext, ContentDetailsActivity.class);
            intent.putExtra("docId",docId);
            intent.putExtra("docType",docType);
            startActivity(intent);
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hotsub_toolbar_subornot_tv:
                String subCurText = mSubscribeTxt.getText().toString();
                if (subCurText.equals("订阅")) {
                    mSubscribeTxt.setText("退订");
                    mExplorePresenter.addSubscribe(mKeyword,mSrpId);
//                    AllSubPresenterImpl.subDeleteChannel("",mKeyword,mSrpId);
                } else {
                    mSubscribeTxt.setText("订阅");
                    mExplorePresenter.delSubscribe(mKeyword,mSrpId);
//                    AllSubPresenterImpl.subAddChannel("", mKeyword,mSrpId);
                }
                break;
            case R.id.hotsub_toolbar_back_iv:
                this.finish();
                break;
        }
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case LV_REQ_ADDMORE:
                    mRefreshLv.onRefreshComplete();
                    break;
            }
        }
    };

    //无需使用
    @Override
    public void applyExploreInfo(ExploreInfoBean exploreInfoBean) {}
    @Override
    public void applyHotSearchList(SearchHotBean searchHotBean) {}
    @Override
    public void applyAutoSearchList(SearchAutoTipBean searchAutoTipBean) {}
    @Override
    public void applyAddSubscribeInfo(AddBean addBean) {}
    @Override
    public void applyDelSubscribeInfo(DeleteBean deleteBean) {}

}
