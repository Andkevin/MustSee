package com.android1604.mustsee.presenter;

import com.android1604.mustsee.bean.PushChannelBean;

/**
 * Created by Administrator on 2016/9/9.
 *
 */
public interface IChannelPresenter {
    /**
     * 获取推荐的频道
     */
    void getPushChannel();


    interface ChannelCallBack{
        void success(PushChannelBean pushChannelBean);
    }
}
