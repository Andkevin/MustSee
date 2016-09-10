package com.android1604.mustsee.presenter;

import com.android1604.mustsee.bean.ExploreInfoBean;
import com.android1604.mustsee.bean.ExploreSubscribeBean;
import com.android1604.mustsee.bean.NewsBean;
import com.android1604.mustsee.model.ExploreModelImpl;
import com.android1604.mustsee.model.IExploreModel;
import com.android1604.mustsee.view.IExploreView;

/**
 * Created by my on 2016/9/6.
 */
public class ExplorePresenterImpl implements IExplorePresenter, IExplorePresenter.ExploreInfoCallback,IExplorePresenter.NewsSubListCallback{

    IExploreModel mExploreModel;
    IExploreView mExploreView;

    public ExplorePresenterImpl(IExploreView mExploreView){
        this.mExploreModel = new ExploreModelImpl();
        this.mExploreView = mExploreView;
    }

    /**
     * 查询探索界面列表信息
     */
    @Override
    public void queryExploreList() {
        mExploreModel.queryExploreList(this);
    }

    /**
     * 查询资讯订阅列表信息
     */
    @Override
    public void queryNewsSubList(String keyword) {
        mExploreModel.queryNewsSubList(keyword,this);
    }

    /**
     * 获取到探索界面列表信息后的接口回调行为
     */
    @Override
    public void exploreInfoOK(ExploreInfoBean exploreInfoBean) {
        mExploreView.applyExploreInfo(exploreInfoBean);
    }

    /**
     * 获取到资讯订阅列表信息后的接口回调行为
     */
    @Override
    public void newsSubListOK(NewsBean newsBean) {
        mExploreView.applyNewsSubList(newsBean);
    }



}
