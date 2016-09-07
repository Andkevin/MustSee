package com.android1604.mustsee.model;

import com.android1604.mustsee.presenter.IStartPresenter;

/**
 * Created by Administrator on 2016/9/7.
 *
 */
public interface IStartModel {
    /**
     * 网络请求欢迎页面图片
     * @param callBack
     */
    void getStartImage(IStartPresenter.StartImageCallBack callBack);
}
