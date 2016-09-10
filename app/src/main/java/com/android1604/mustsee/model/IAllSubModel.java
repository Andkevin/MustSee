package com.android1604.mustsee.model;


import com.android1604.mustsee.presenter.IAllSubPresenter;

/**
 * Created by Administrator on 2016/9/9.
 *
 */
public interface IAllSubModel {

    /**
     * 请求订阅大全左侧列表
     */
    void getLeftList(IAllSubPresenter.AllSubCallBack allSubCallBack);


    /**
     * 请求阅读大全右侧列表
     */
    void getRightList(String parentId,IAllSubPresenter.AllSubCallBack allSubCallBack);

    /**
     * 添加频道
     */
    void addChannel(String category,String keyword,String srpId,String clickFrom);


    /**
     * 删除频道
     */
    void deleteChannel(String category,String keyword,String srpId,String clickFrom);
}
