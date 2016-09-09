package com.android1604.mustsee.model.impl;

import android.util.Log;

import com.android1604.mustsee.bean.NewsBean;
import com.android1604.mustsee.http.HttpUtils;
import com.android1604.mustsee.model.INewsModel;
import com.android1604.mustsee.presenter.INewsPresenter;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/7.
 *
 */
public class NewsModelImpl implements INewsModel{


    @Override
    public void getNewsList(String category, String keyword, String srpId, String indexId, String lastId, final INewsPresenter.NewsCallBack newsCallBack) {
        HttpUtils.getHttpService().getNewsList(category,keyword,srpId,indexId,lastId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsBean>() {
                    @Override
                    public void call(NewsBean newsBean) {
                        newsCallBack.success(newsBean);
                    }
                });
    }
}
