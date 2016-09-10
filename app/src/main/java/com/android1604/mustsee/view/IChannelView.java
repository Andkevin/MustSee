package com.android1604.mustsee.view;

import com.android1604.mustsee.bean.PushChannelBean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 *
 */
public interface IChannelView {
    /**
     * 刷新推荐频道
     */
    void refreshPushChannel(List<PushChannelBean.BodyBean.DataListBean> pushChannelList);
}
