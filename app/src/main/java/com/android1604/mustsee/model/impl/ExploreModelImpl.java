package com.android1604.mustsee.model.impl;

import com.android1604.mustsee.bean.ExploreInfoBean;
import com.android1604.mustsee.bean.NewsBean;
import com.android1604.mustsee.bean.SearchAutoTipBean;
import com.android1604.mustsee.bean.SearchHotBean;
import com.android1604.mustsee.http.HttpUtils;
import com.android1604.mustsee.model.IExploreModel;
import com.android1604.mustsee.presenter.IExplorePresenter;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by my on 2016/9/6.
 */
public class ExploreModelImpl implements IExploreModel {
    //查询探索界面列表信息
    @Override
    public void queryExploreList(final IExplorePresenter.ExploreInfoCallback exploreInfoCallback) {
        HttpUtils.getHttpService().queryExploreInfo().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ExploreInfoBean>() {
                    @Override
                    public void call(ExploreInfoBean exploreInfoBean) {
                        exploreInfoCallback.exploreInfoOK(exploreInfoBean);
                    }
                });
    }
    //查询资讯订阅列表信息
    @Override
    public void queryNewsSubList(String keyword, String lastId, final IExplorePresenter.NewsSubListCallback newsSubListCallback) {
        HttpUtils.getHttpService().queryNewsSubList(keyword, lastId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsBean>() {
                    @Override
                    public void call(NewsBean newsBean) {
                        newsSubListCallback.newsSubListOK(newsBean);
                    }
                });
    }
    //查询搜索中的热搜数据
    @Override
    public void queryHotSearchList(final IExplorePresenter.HotSearchListCallback hotSearchListCallback) {
        HttpUtils.getHttpService().queryHotSearchInfo().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<SearchHotBean>() {
                    @Override
                    public void call(SearchHotBean searchHotBean) {
                        hotSearchListCallback.hotSearchListOK(searchHotBean);
                    }
                });
    }
    //查询搜索中的关键字自动补全数据
    @Override
    public void queryAutoSearchList(String keyword, final IExplorePresenter.AutoSearchListCallback autoSearchListCallback) {
        HttpUtils.getHttpService().queryAutoSearchInfo(keyword).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<SearchAutoTipBean>() {
                    @Override
                    public void call(SearchAutoTipBean searchAutoTipBean) {
                        autoSearchListCallback.autoSearchListOK(searchAutoTipBean);
                    }
                });
    }
}
