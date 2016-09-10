package com.android1604.mustsee.model.impl;

import com.android1604.mustsee.bean.AllSubLeftBean;
import com.android1604.mustsee.bean.AllSubRightBean;
import com.android1604.mustsee.http.HttpUtils;
import com.android1604.mustsee.model.IAllSubModel;
import com.android1604.mustsee.presenter.IAllSubPresenter;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/9.
 *
 */
public class AllSubModelImpl implements IAllSubModel{

    @Override
    public void getLeftList(final IAllSubPresenter.AllSubCallBack allSubCallBack) {
        HttpUtils.getHttpService().getLeftList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<AllSubLeftBean>() {
                    @Override
                    public void call(AllSubLeftBean allSubLeftBean) {
                        allSubCallBack.successLeft(allSubLeftBean);
                    }
                });
    }

    @Override
    public void getRightList(String parentId, final IAllSubPresenter.AllSubCallBack allSubCallBack) {
        HttpUtils.getHttpService().getRightList(parentId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<AllSubRightBean>() {
                    @Override
                    public void call(AllSubRightBean allSubRightBean) {
                        allSubCallBack.successRight(allSubRightBean);
                    }
                });
    }

    @Override
    public void addChannel(String category, String keyword, String srpId, String clickFrom) {
        HttpUtils.getHttpService().addChannel(category,keyword,srpId,clickFrom);
    }

    @Override
    public void deleteChannel(String category, String keyword, String srpId, String clickFrom) {
        HttpUtils.getHttpService().deleteChannel(category,keyword,srpId,clickFrom);
    }


}
