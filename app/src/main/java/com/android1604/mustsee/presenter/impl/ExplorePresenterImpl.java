package com.android1604.mustsee.presenter.impl;

import com.android1604.mustsee.bean.ExploreInfoBean;
import com.android1604.mustsee.bean.NewsBean;
import com.android1604.mustsee.bean.SearchAutoTipBean;
import com.android1604.mustsee.bean.SearchHotBean;
import com.android1604.mustsee.model.impl.ExploreModelImpl;
import com.android1604.mustsee.model.IExploreModel;
import com.android1604.mustsee.presenter.IExplorePresenter;
import com.android1604.mustsee.view.IExploreView;

/**
 * Created by Kevin on 2016/9/6.
 */
public class ExplorePresenterImpl implements IExplorePresenter, IExplorePresenter.ExploreInfoCallback,IExplorePresenter.NewsSubListCallback,IExplorePresenter.HotSearchListCallback,IExplorePresenter.AutoSearchListCallback{

    IExploreModel mExploreModel;
    IExploreView mExploreView;

    public ExplorePresenterImpl(IExploreView mExploreView){
        this.mExploreModel = new ExploreModelImpl();
        this.mExploreView = mExploreView;
    }

    //查询探索界面列表信息
    @Override
    public void queryExploreList() {
        mExploreModel.queryExploreList(this);
    }

    //查询资讯订阅列表信息
    @Override
    public void queryNewsSubList(String keyword, String lastId) {
        mExploreModel.queryNewsSubList(keyword,lastId,this);
    }

    //查询搜索中的热搜数据
    @Override
    public void queryHotSearchList() {
        mExploreModel.queryHotSearchList(this);
    }

    //查询搜索中的关键字自动补全数据
    @Override
    public void queryAutoSearchList(String keyword) {
        mExploreModel.queryAutoSearchList(keyword,this);
    }

    //获取到探索界面列表信息后的接口回调行为
    @Override
    public void exploreInfoOK(ExploreInfoBean exploreInfoBean) {
        mExploreView.applyExploreInfo(exploreInfoBean);
    }

    //获取到资讯订阅列表信息后的接口回调行为
    @Override
    public void newsSubListOK(NewsBean newsBean) {
        mExploreView.applyNewsSubList(newsBean);
    }

    //获取到搜索中的关键字自动补全信息后的接口回调行为
    @Override
    public void autoSearchListOK(SearchAutoTipBean searchAutoTipBean) {
        mExploreView.applyAutoSearchList(searchAutoTipBean);
    }

    //获取到搜索中的热搜信息后的接口回调行为
    @Override
    public void hotSearchListOK(SearchHotBean searchHotBean) {
         mExploreView.applyHotSearchList(searchHotBean);
    }
}
