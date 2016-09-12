package com.android1604.mustsee.model;

import com.android1604.mustsee.bean.TabTitlesBean;
import com.android1604.mustsee.presenter.IChannelPresenter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/9.
 *
 */
public interface IChannelModel {
    /**
     * 获取推荐的频道
     */
    void getPushChannel(IChannelPresenter.ChannelCallBack channelCallBack);

    /**
     * 添加频道
     */
    void addChannel(String category,String keyword,String srpId,String clickFrom);


    /**
     * 删除频道
     */
    void deleteChannel(String category,String keyword,String srpId,String clickFrom);

    /**
     * 排序频道
     */
    void sortChannel(ArrayList<TabTitlesBean.BodyBean.DataListBean> channels);
}
