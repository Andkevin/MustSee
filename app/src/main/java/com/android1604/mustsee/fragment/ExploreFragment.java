package com.android1604.mustsee.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android1604.mustsee.R;
import com.android1604.mustsee.bean.ExploreInfoBean;
import com.android1604.mustsee.presenter.ExplorePresenterImpl;
import com.android1604.mustsee.view.IExploreView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment implements IExploreView{
    private Context mContext;
    private PullToRefreshListView mLv;
    private  LinearLayout mIndicView;
    private int mIndicCount;
    private ViewPager mListViewPager;
    private List<ExploreInfoBean> exploreInfoBeanList = new ArrayList<>();
    private boolean netReqFinish = false;
    private ExplorePresenterImpl mExplorePresenter;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        initContentView(view);
        return view;
    }

    private void initContentView(View view) {
        mLv = (PullToRefreshListView) view.findViewById(R.id.fragment_explore_list_view_lv);
        mLv.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        listRefreshCtrl();          //ExpandListView下拉刷新的监听事件
        initListHeader();           //初始化ExpandListView的头部


    }

    /**
     * 初始化ExpandListView的头部
     */
    private void initListHeader() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_list_header_view,null);
        mLv.getRefreshableView().addHeaderView(view);
        mIndicView = (LinearLayout) view.findViewById(R.id.explore_list_header_indic_layout);
        mIndicCount = mIndicView.getChildCount();
        indicatorCtl(0);
        mListViewPager = (ViewPager) view.findViewById(R.id.explore_list_header_vp);


    }

    /**
     * 探索页面数据请求完成后的方法调用
     * 功能:刷新相关视图的适配器数据
     */
    @Override
    public void applyExploreInfo(ExploreInfoBean exploreInfoBean) {

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
     * ExpandListView刷新的监听事件
     */
    private void listRefreshCtrl() {
        mLv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
    }

    /**
     * ListView的适配器
     */


    /**
     * ListView中viewpager的适配器定义
     */
    class ListPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(mContext);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            if(mAdverDatas != null){
//                ImageLoader.init(mContext).loadImage(mAdverDatas.get(position%5), imageView);
//            }
//            container.addView(imageView);
            return imageView;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
