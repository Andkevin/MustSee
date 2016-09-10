package com.android1604.mustsee.model;

import com.android1604.mustsee.presenter.IInformationPresenter;

/**
 * Created by Administrator on 2016/9/6.
 * 资讯界面数据接口
 */
public interface IInformationModel {
    /**
     * 请求资讯Tab列表
     */
    void getTabTitles(IInformationPresenter.TabTitlesCallBack callBack);

    /**
     * 请求搜索框中的内容
     */
    void getSearchContent(IInformationPresenter.TabTitlesCallBack callBack);
}
