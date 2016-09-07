package com.android1604.mustsee.model;

import com.android1604.mustsee.presenter.IExplorePresenter;

/**
 * Created by my on 2016/9/6.
 */
public interface IExploreModel {

    /**
     * 查询探索界面列表信息
     */
    void queryExploreList(IExplorePresenter.ExploreInfoCallback exploreInfoCallback);
}
