package com.android1604.mustsee.presenter;

import com.android1604.mustsee.bean.AllSubLeftBean;
import com.android1604.mustsee.bean.AllSubRightBean;

/**
 * Created by Administrator on 2016/9/9.
 *
 */
public interface IAllSubPresenter {
    /**
     * 获取左侧列表
     */
    void getLeftList();

    /**
     * 获取右侧列表
     */
    void getRightList(String parentId);


    interface AllSubCallBack {
        void successLeft(AllSubLeftBean allSubLeftBean);
        void successRight(AllSubRightBean allSubRightBean);
    }
}
