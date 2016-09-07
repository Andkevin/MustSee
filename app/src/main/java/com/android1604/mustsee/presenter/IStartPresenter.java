package com.android1604.mustsee.presenter;

import com.android1604.mustsee.bean.StartBean;

/**
 * Created by Administrator on 2016/9/7.
 *
 */
public interface IStartPresenter {
    /**
     * 获取欢迎页图片地址
     */
    void getImageUrl();

     interface StartImageCallBack{
        void success(StartBean startBean);
    }
}
