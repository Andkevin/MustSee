package com.android1604.mustsee.presenter.impl;

import com.android1604.mustsee.bean.PushChannelBean;
import com.android1604.mustsee.model.IChannelModel;
import com.android1604.mustsee.model.impl.ChannelModelImpl;
import com.android1604.mustsee.presenter.IChannelPresenter;
import com.android1604.mustsee.view.IChannelView;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 *
 */
public class ChannelPresenterImpl implements IChannelPresenter,IChannelPresenter.ChannelCallBack {
    private IChannelModel channelModel;
    private IChannelView channelView;
    private String clickFrom = "channel_manager";


    public ChannelPresenterImpl(IChannelView channelView) {
        this.channelView = channelView;
        this.channelModel = new ChannelModelImpl();
    }

    @Override
    public void getPushChannel() {
        channelModel.getPushChannel(this);
    }

    @Override
    public void addChannel(String category, String keyword, String srpId) {
        channelModel.addChannel(category, keyword, srpId, clickFrom);
    }

    @Override
    public void deleteChannel(String category, String keyword, String srpId) {
        channelModel.deleteChannel(category, keyword, srpId, clickFrom);
    }


    @Override
    public void success(PushChannelBean pushChannelBean) {
        if(pushChannelBean != null){
            List<PushChannelBean.BodyBean.DataListBean> dataList = pushChannelBean.getBody().getDataList();
            PushChannelBean.BodyBean.DataListBean dataListBean = new PushChannelBean.BodyBean.DataListBean();
            dataListBean.setKeyword("更多频道");
            dataList.add(dataListBean);
            channelView.refreshPushChannel(dataList);
        }

    }
}
