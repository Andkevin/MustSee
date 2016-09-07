package com.android1604.mustsee.model;

import com.android1604.mustsee.bean.ExploreInfoBean;
import com.android1604.mustsee.http.HttpUtils;
import com.android1604.mustsee.presenter.IExplorePresenter;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by my on 2016/9/6.
 */
public class ExploreModelImpl implements IExploreModel {
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
}
