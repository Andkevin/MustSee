package com.android1604.mustsee.model;

import com.android1604.mustsee.presenter.IExplorePresenter;

/**
 * Created by my on 2016/9/6.
 */
public interface IExploreModel {

    //查询探索界面列表信息
    void queryExploreList(IExplorePresenter.ExploreInfoCallback exploreInfoCallback);

    //查询资讯订阅列表信息
    void queryNewsSubList(String keyword,String lastId,IExplorePresenter.NewsSubListCallback newsSubListCallback);

    //查询搜索中的热搜数据
    void queryHotSearchList(IExplorePresenter.HotSearchListCallback hotSearchListCallback);

    //查询搜索中的关键字自动补全数据
    void queryAutoSearchList(String keyword, IExplorePresenter.AutoSearchListCallback autoSearchListCallback);
}
