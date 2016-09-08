package com.android1604.mustsee.presenter;

import com.android1604.mustsee.bean.NewsBean;

/**
 * Created by Administrator on 2016/9/7.
 *
 */
public interface INewsPresenter {
    /**
     * 请求新闻列表
     */
    void getNewsList(String category,String keyword,String srpId,int indexId,int lastId);

    interface NewsCallBack{
        void success(NewsBean newsBean);
    }
}
