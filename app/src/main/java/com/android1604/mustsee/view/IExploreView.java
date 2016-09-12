package com.android1604.mustsee.view;

import com.android1604.mustsee.bean.ExploreInfoBean;
import com.android1604.mustsee.bean.ExploreSubscribeBean;
import com.android1604.mustsee.bean.NewsBean;

/**
 * Created by my on 2016/9/6.
 */
public interface IExploreView {

    //将获取的探索界面的数据应用到相关适配器中
    void applyExploreInfo(ExploreInfoBean exploreInfoBean);

    //将获取的资讯订阅列表信息数据应用到相关适配器中
    void applyNewsSubList(NewsBean newsBean);
}
