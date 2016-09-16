package com.android1604.mustsee.view;

import com.android1604.mustsee.bean.AddBean;
import com.android1604.mustsee.bean.DeleteBean;
import com.android1604.mustsee.bean.ExploreInfoBean;
import com.android1604.mustsee.bean.ExploreSubscribeBean;
import com.android1604.mustsee.bean.NewsBean;
import com.android1604.mustsee.bean.NewsBean1;
import com.android1604.mustsee.bean.SearchAutoTipBean;
import com.android1604.mustsee.bean.SearchHotBean;

/**
 * Created by my on 2016/9/6.
 */
public interface IExploreView {

    //将获取的探索界面的数据应用到相关适配器中
    void applyExploreInfo(ExploreInfoBean exploreInfoBean);

    //将获取的资讯订阅列表信息数据应用到相关适配器中
    void applyNewsSubList(NewsBean1 newsBean);

    //将查询到的热搜数据应用到相关适配器中
    void applyHotSearchList(SearchHotBean searchHotBean);

    //将查询到的关键字自动补全数据应用到相关适配器中
    void applyAutoSearchList(SearchAutoTipBean searchAutoTipBean);

    //应用探索添加订阅操作后反馈的数据
    void applyAddSubscribeInfo(AddBean addBean);

    //应用探索取消订阅操作后反馈的数据
    void applyDelSubscribeInfo(DeleteBean deleteBean);
}
