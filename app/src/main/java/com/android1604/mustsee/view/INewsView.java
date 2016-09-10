package com.android1604.mustsee.view;

import com.android1604.mustsee.bean.NewsBean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/7.
 *
 */
public interface INewsView {
    /**
     * 新闻列表数据
     */
    void refreshView(List<NewsBean.BodyBean.NewsListBean> newsList);

}
