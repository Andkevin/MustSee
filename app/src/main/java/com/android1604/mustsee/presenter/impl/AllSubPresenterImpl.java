package com.android1604.mustsee.presenter.impl;

import com.android1604.mustsee.bean.AllSubLeftBean;
import com.android1604.mustsee.bean.AllSubRightBean;
import com.android1604.mustsee.model.IAllSubModel;
import com.android1604.mustsee.model.impl.AllSubModelImpl;
import com.android1604.mustsee.presenter.IAllSubPresenter;
import com.android1604.mustsee.view.IAllSubView;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 *
 */
public class AllSubPresenterImpl implements IAllSubPresenter,IAllSubPresenter.AllSubCallBack {
    private IAllSubModel allSubModel;
    private IAllSubView allSubView;
    private String clickFrom = "subscribe";


    public AllSubPresenterImpl(IAllSubView allSubView) {
        this.allSubView = allSubView;
        this.allSubModel = new AllSubModelImpl();
    }

    @Override
    public void getLeftList() {
        allSubModel.getLeftList(this);
    }

    @Override
    public void getRightList(String parentId) {
        allSubModel.getRightList(parentId,this);
    }

    @Override
    public void addChannel(String category, String keyword, String srpId) {
        allSubModel.addChannel(category, keyword, srpId, clickFrom);
    }

    @Override
    public void deleteChannel(String category, String keyword, String srpId) {
        allSubModel.deleteChannel(category, keyword, srpId, clickFrom);
    }

    @Override
    public void successLeft(AllSubLeftBean allSubLeftBean) {
        if(allSubLeftBean != null){
            List<AllSubLeftBean.BodyBean.DataListBean> dataList = allSubLeftBean.getBody().getDataList();
            allSubView.refreshLeftList(dataList);
        }
    }

    @Override
    public void successRight(AllSubRightBean allSubRightBean) {
        if(allSubRightBean != null){
            List<AllSubRightBean.BodyBean.DataListBean> dataList = allSubRightBean.getBody().getDataList();
            allSubView.refreshRightList(dataList);
        }
    }
}
