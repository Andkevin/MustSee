package com.android1604.mustsee.presenter;

import com.android1604.mustsee.bean.ExploreInfoBean;
import com.android1604.mustsee.bean.ExploreSubscribeBean;
import com.android1604.mustsee.bean.NewsBean;

/**
 * Created by my on 2016/9/6.
 */
public interface IExplorePresenter {

    //查询探索界面列表信息
    void queryExploreList();

    //查询资讯订阅列表信息
    void queryNewsSubList(String keyword);

    //获取到探索界面列表信息后的接口回调行为
    interface ExploreInfoCallback{
        void exploreInfoOK(ExploreInfoBean exploreInfoBean);
    }

    //获取到资讯订阅列表信息后的接口回调行为
    interface NewsSubListCallback{
        void newsSubListOK(NewsBean newsBean);
    }
}
