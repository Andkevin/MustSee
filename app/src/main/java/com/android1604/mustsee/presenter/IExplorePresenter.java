package com.android1604.mustsee.presenter;

import com.android1604.mustsee.bean.ExploreInfoBean;

/**
 * Created by my on 2016/9/6.
 */
public interface IExplorePresenter {

    /**
     * 查询探索界面列表信息
     */
    void queryExploreList();

    /**
     * 获取到探索界面列表信息后的接口回调行为
     */
    interface ExploreInfoCallback{
        void exploreInfoOK(ExploreInfoBean exploreInfoBean);
    }
}
