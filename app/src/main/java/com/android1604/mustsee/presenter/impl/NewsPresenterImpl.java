package com.android1604.mustsee.presenter.impl;

import android.util.Log;

import com.android1604.mustsee.bean.NewsBean;
import com.android1604.mustsee.model.INewsModel;
import com.android1604.mustsee.model.impl.NewsModelImpl;
import com.android1604.mustsee.presenter.INewsPresenter;
import com.android1604.mustsee.view.INewsView;

import java.util.List;

/**
 * Created by Administrator on 2016/9/7.
 *
 */
public class NewsPresenterImpl implements INewsPresenter,INewsPresenter.NewsCallBack {
    private INewsView newsView;
    private INewsModel newsModel;

    public NewsPresenterImpl(INewsView newsView) {
        this.newsView = newsView;
        this.newsModel = new NewsModelImpl();
    }

    @Override
    public void getNewsList(String category, String keyword, String srpId, String indexId, String lastId) {
        newsModel.getNewsList(category,keyword,srpId,indexId,lastId,this);
    }

    @Override
    public void success(NewsBean newsBean) {
        List<NewsBean.BodyBean.NewsListBean> newsList = null;
        if(newsBean != null){
            newsList = newsBean.getBody().getNewsList();
        }
        if(newsList != null){
            newsView.refreshView(newsList);
        }
    }
}
