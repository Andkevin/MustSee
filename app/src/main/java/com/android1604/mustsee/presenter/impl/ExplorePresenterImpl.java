package com.android1604.mustsee.presenter.impl;

import com.android1604.mustsee.bean.ExploreInfoBean;
import com.android1604.mustsee.bean.ExploreSubscribeBean;
import com.android1604.mustsee.model.impl.ExploreModelImpl;
import com.android1604.mustsee.model.IExploreModel;
import com.android1604.mustsee.presenter.IExplorePresenter;
import com.android1604.mustsee.view.IExploreView;

/**
 * Created by my on 2016/9/6.
 */
public class ExplorePresenterImpl implements IExplorePresenter, IExplorePresenter.ExploreInfoCallback,IExplorePresenter.HotSubListCallback{

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
     * 查询探索界面热门订阅列表信息
     */
    @Override
    public void queryHotSubList(String keyword) {
        mExploreModel.queryHotSubList(keyword,this);
    }

    /**
     * 获取到探索界面列表信息后的接口回调行为
     */
    @Override
    public void exploreInfoOK(ExploreInfoBean exploreInfoBean) {
        mExploreView.applyExploreInfo(exploreInfoBean);
    }

    /**
     * 获取到探索界面热门订阅列表信息后的接口回调行为
     */
    @Override
    public void hotSubListOK(ExploreSubscribeBean exploreSubscribeBean) {
        mExploreView.applyHotSubList(exploreSubscribeBean);
    }
}
