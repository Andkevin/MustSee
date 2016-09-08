package com.android1604.mustsee.model;

import com.android1604.mustsee.presenter.INewsPresenter;

/**
 * Created by Administrator on 2016/9/7.
 *
 */
public interface INewsModel {
    /**
     * 网络请求新闻列表
     */
    void getNewsList(String category,String keyword,String srpId,int indexId,int lastId,INewsPresenter.NewsCallBack newsCallBack);
}
