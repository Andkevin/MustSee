package com.android1604.mustsee.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android1604.mustsee.R;
import com.android1604.mustsee.adapter.ExploreListAdapter;
import com.android1604.mustsee.bean.ExploreInfoBean;
import com.android1604.mustsee.bean.ExploreSubscribeBean;
import com.android1604.mustsee.presenter.impl.ExplorePresenterImpl;
import com.android1604.mustsee.view.IExploreView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

public class ExploreFragment extends Fragment implements IExploreView{
    private Context mContext;
    private PullToRefreshListView mLv;
    private  LinearLayout mIndicView;
    private int mIndicCount;
    private ViewPager mListViewPager;
    private ExploreInfoBean mExploreInfoBean;
    private boolean netReqFinish = false;
    private ExplorePresenterImpl mExplorePresenter;
    private ExploreListAdapter mExploreListAdapter;
    public static final int LV_REQ_REFRESH = 1;
    private ConvenientBanner mBanner;

    public static ExploreFragment newInstance() {
        ExploreFragment fragment = new ExploreFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        mExplorePresenter = new ExplorePresenterImpl(this);
        mExplorePresenter.queryExploreList();
    }

    @Override
    public void onStart() {
        super.onStart();
        if(mBanner != null){
            mBanner.setCanLoop(true);
            mBanner.setScrollDuration(3000);
            mBanner.startTurning(4000);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mBanner != null){
            mBanner.stopTurning();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        initContentView(view);
        return view;
    }

    private void initContentView(View view) {
        mLv = (PullToRefreshListView) view.findViewById(R.id.fragment_explore_list_view_lv);
        mLv.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        listRefreshCtrl();          //ListView下拉刷新的监听事件
    }

    /**
     * 初始化ListView的头部
     */
    private void initListHeader() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_list_header_view,null);
        mLv.getRefreshableView().addHeaderView(view);
        mBanner = (ConvenientBanner) view.findViewById(R.id.explore_list_header_banner);
        mBanner.setPages(
                new CBViewHolderCreator<NetImageHolderView>() {
                    @Override
                    public NetImageHolderView createHolder() {
                        return new NetImageHolderView();
                    }
                },mExploreInfoBean.getBody().getRollingImagesList()
        ).setPageIndicator(new int[]{R.drawable.banner_indication_focus, R.drawable.banner_indication_unfocus});

        mBanner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(mContext, "这是Banner的item点击事件", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class NetImageHolderView implements Holder<ExploreInfoBean.BodyBean.RollingImagesListBean>{
        private TextView titleTxt;
        private ImageView imgView;
        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_list_header_item_view,null);
            titleTxt = (TextView) view.findViewById(R.id.explore_list_header_item_title_tv);
            imgView = (ImageView) view.findViewById(R.id.explore_list_header_item_img_iv);
            return view;
        }

        @Override
        public void UpdateUI(Context context, int position, ExploreInfoBean.BodyBean.RollingImagesListBean data) {
//            ExploreInfoBean.BodyBean.RollingImagesListBean rollingObj = data.get(position);
            titleTxt.setText(data.getTitle());
            Picasso.with(context).load(data.getImageUrl()).into(imgView);
        }
    }


    /**
     * 探索页面数据请求完成后的方法调用
     * 功能:刷新相关视图的适配器数据
     */
    @Override
    public void applyExploreInfo(ExploreInfoBean exploreInfoBean) {
        mExploreInfoBean = exploreInfoBean;
        if(mExploreListAdapter == null){
            mExploreListAdapter = new ExploreListAdapter(mContext, mExploreInfoBean.getBody());
            initListHeader();               //初始化ExpandListView的头部
            mLv.setAdapter(mExploreListAdapter);
        }
        mExploreListAdapter.notifyDataSetChanged();
    }

    /**
     * 功能:控制ViewPager的Indicator显示变换
     */
    private void indicatorCtl(int index) {
        ImageView view = (ImageView) mIndicView.getChildAt(index);
        for (int i = 0; i < mIndicCount; i++) {
            mIndicView.getChildAt(i).setEnabled(false);
        }
        view.setEnabled(true);
    }

    /**
     * ListView刷新的监听事件
     */
    private void listRefreshCtrl() {
        mLv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                refreshView.getLoadingLayoutProxy().setRefreshingLabel("加载中...");
                refreshView.getLoadingLayoutProxy().setPullLabel("下拉刷新");
                refreshView.getLoadingLayoutProxy().setReleaseLabel("松手刷新");
                mHandler.sendEmptyMessage(LV_REQ_REFRESH);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case LV_REQ_REFRESH:
                    mLv.onRefreshComplete();
                    //更新适配器
                    break;
            }
        }
    };

    //无需使用
    @Override
    public void applyHotSubList(ExploreSubscribeBean exploreSubscribeBean) {}
}
