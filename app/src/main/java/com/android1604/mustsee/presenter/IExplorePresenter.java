package com.android1604.mustsee.presenter;

import com.android1604.mustsee.bean.AddBean;
import com.android1604.mustsee.bean.DeleteBean;
import com.android1604.mustsee.bean.ExploreInfoBean;
import com.android1604.mustsee.bean.ExploreSubscribeBean;
import com.android1604.mustsee.bean.NewsBean;
import com.android1604.mustsee.bean.NewsBean1;
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

    //探索添加订阅
    void addSubscribe(String keyword, String srpId);

    //探索取消订阅
    void delSubscribe(String keyword, String srpId);


    //获取到探索界面列表信息后的接口回调行为
    interface ExploreInfoCallback{
        void exploreInfoOK(ExploreInfoBean exploreInfoBean);
    }

    //获取到资讯订阅列表信息后的接口回调行为
    interface NewsSubListCallback{
        void newsSubListOK(NewsBean1 newsBean);
    }

    //获取到搜索中的热搜信息后的接口回调行为
    interface HotSearchListCallback{
        void hotSearchListOK(SearchHotBean searchHotBean);
    }

    //获取到搜索中的关键字自动补全信息后的接口回调行为
    interface AutoSearchListCallback{
        void autoSearchListOK(SearchAutoTipBean searchAutoTipBean);
    }

    //获取到添加、取消订阅操作后反馈信息的操作
    interface SubScribeCallback{
        void addSubscribeOK(AddBean addBean);
        void delSubscribeOK(DeleteBean deleteBean);
    }
}
