package com.android1604.mustsee.presenter;

import com.android1604.mustsee.bean.SearchContentBean;
import com.android1604.mustsee.bean.TabTitlesBean;

/**
 * Created by Administrator on 2016/9/6.
 * 关联资讯数据和视图
 */
public interface IInformationPresenter {
    /**
     * 获取请求到的资讯Tab列表
     */
    void getTabTiles();

    /**
     * 获取搜索框的内容
     */
    void getSearchContent();


    interface TabTitlesCallBack {
        void success(TabTitlesBean tabTitlesBean);

        void contentSuccess(SearchContentBean searchContentBean);
    }
}
