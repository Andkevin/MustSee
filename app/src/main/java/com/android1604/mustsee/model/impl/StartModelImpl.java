package com.android1604.mustsee.model.impl;

import com.android1604.mustsee.bean.StartBean;
import com.android1604.mustsee.model.IStartModel;
import com.android1604.mustsee.presenter.IStartPresenter;
import com.android1604.mustsee.http.HttpUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/7.
 *
 */
public class StartModelImpl implements IStartModel{

    @Override
    public void getStartImage(final IStartPresenter.StartImageCallBack callBack) {
        HttpUtils.getHttpService().getStartImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<StartBean>() {
                    @Override
                    public void call(StartBean startBean) {
                        callBack.success(startBean);
                    }
                });
    }
}
