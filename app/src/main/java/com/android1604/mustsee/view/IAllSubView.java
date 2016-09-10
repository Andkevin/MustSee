package com.android1604.mustsee.view;

import com.android1604.mustsee.bean.AllSubLeftBean;
import com.android1604.mustsee.bean.AllSubRightBean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 *
 */
public interface IAllSubView {
    /**
     * 刷新左侧列表
     */
    void refreshLeftList(List<AllSubLeftBean.BodyBean.DataListBean> leftDataList);

    /**
     * 刷新右侧列表
     */
    void refreshRightList( List<AllSubRightBean.BodyBean.DataListBean> rightDataList);
}
