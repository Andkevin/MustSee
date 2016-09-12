package com.android1604.mustsee.presenter.impl;

import com.android1604.mustsee.bean.PushChannelBean;
import com.android1604.mustsee.bean.TabTitlesBean;
import com.android1604.mustsee.model.IChannelModel;
import com.android1604.mustsee.model.impl.ChannelModelImpl;
import com.android1604.mustsee.presenter.IChannelPresenter;
import com.android1604.mustsee.view.IChannelView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 *
 */
public class ChannelPresenterImpl implements IChannelPresenter, IChannelPresenter.ChannelCallBack {
    private static IChannelModel channelModel = new ChannelModelImpl();
    private IChannelView channelView;
    private static String CLICKFROMMANAGER = "channel_manager";


    public ChannelPresenterImpl(IChannelView channelView) {
        this.channelView = channelView;
    }

    @Override
    public void getPushChannel() {
        channelModel.getPushChannel(this);
    }

    public static void addChannel(String category, String keyword, String srpId) {
        channelModel.addChannel(category, keyword, srpId, CLICKFROMMANAGER);
    }

    public static void deleteChannel(String category, String keyword, String srpId) {
        channelModel.deleteChannel(category, keyword, srpId, CLICKFROMMANAGER);
    }

    public static void sortChannel(ArrayList<TabTitlesBean.BodyBean.DataListBean> channels){
        channelModel.sortChannel(channels);
    }


    @Override
    public void success(PushChannelBean pushChannelBean) {
        if (pushChannelBean != null) {
            List<PushChannelBean.BodyBean.DataListBean> dataList = pushChannelBean.getBody().getDataList();
            PushChannelBean.BodyBean.DataListBean dataListBean = new PushChannelBean.BodyBean.DataListBean();
            dataListBean.setKeyword("更多频道");
            dataList.add(dataListBean);
            channelView.refreshDragView(dataList);
        }

    }
}
