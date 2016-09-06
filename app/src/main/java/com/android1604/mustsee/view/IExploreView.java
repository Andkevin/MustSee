package com.android1604.mustsee.view;

import com.android1604.mustsee.bean.ExploreInfoBean;

/**
 * Created by my on 2016/9/6.
 */
public interface IExploreView {

    /**
     * 将获取的探索界面的数据应用到相关适配器中
     */
    void applyExploreInfo(ExploreInfoBean exploreInfoBean);
}
