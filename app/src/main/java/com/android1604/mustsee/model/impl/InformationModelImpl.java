package com.android1604.mustsee.model.impl;

import com.android1604.mustsee.bean.TabTitlesBean;
import com.android1604.mustsee.model.IInformationModel;
import com.android1604.mustsee.presenter.IInformationPresenter;
import com.android1604.mustsee.http.HttpUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/6.
 * 请求资讯数据
 */
public class InformationModelImpl implements IInformationModel {

    @Override
    public void getTabTitles(final IInformationPresenter.TabTitlesCallBack customCallBack) {
        HttpUtils.getHttpService().getTabTitles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<TabTitlesBean>() {
                    @Override
                    public void call(TabTitlesBean tabTitlesBean) {
                        customCallBack.success(tabTitlesBean);
                    }
                });

    }
}
