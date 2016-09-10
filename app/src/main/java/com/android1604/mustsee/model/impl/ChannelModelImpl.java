package com.android1604.mustsee.model.impl;

import com.android1604.mustsee.bean.PushChannelBean;
import com.android1604.mustsee.http.HttpUtils;
import com.android1604.mustsee.model.IChannelModel;
import com.android1604.mustsee.presenter.IChannelPresenter;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/9/9.
 *
 */
public class ChannelModelImpl implements IChannelModel{
    @Override
    public void getPushChannel(final IChannelPresenter.ChannelCallBack channelCallBack) {
        HttpUtils.getHttpService().getPushChannel()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<PushChannelBean>() {
                    @Override
                    public void call(PushChannelBean pushChannelBean) {
                        channelCallBack.success(pushChannelBean);
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
