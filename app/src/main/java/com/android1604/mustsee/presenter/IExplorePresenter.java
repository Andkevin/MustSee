package com.android1604.mustsee.presenter;

import com.android1604.mustsee.bean.ExploreInfoBean;
import com.android1604.mustsee.bean.ExploreSubscribeBean;
import com.android1604.mustsee.bean.NewsBean;
import com.android1604.mustsee.bean.SearchAutoTipBean;
import com.android1604.mustsee.bean.SearchHotBean;

/**
 * Created by Kevin on 2016/9/6.
 */
public interface IExplorePresenter {

    //查询探索界面列表信息
    void queryExploreList();

    //查询资讯订阅列表信息
    void queryNewsSubList(String keyword, String lastId);

    //查询搜索中的热搜数据
    void queryHotSearchList();

    //查询搜索中的关键字自动补全数据
    void queryAutoSearchList(String keyword);

    //获取到探索界面列表信息后的接口回调行为
    interface ExploreInfoCallback{
        void exploreInfoOK(ExploreInfoBean exploreInfoBean);
    }

    //获取到资讯订阅列表信息后的接口回调行为
    interface NewsSubListCallback{
        void newsSubListOK(NewsBean newsBean);
    }

    //获取到搜索中的热搜信息后的接口回调行为
    interface HotSearchListCallback{
        void hotSearchListOK(SearchHotBean searchHotBean);
    }

    //获取到搜索中的关键字自动补全信息后的接口回调行为
    interface AutoSearchListCallback{
        void autoSearchListOK(SearchAutoTipBean searchAutoTipBean);
    }
}
