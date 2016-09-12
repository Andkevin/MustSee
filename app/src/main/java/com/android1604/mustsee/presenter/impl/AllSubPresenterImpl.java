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
    private static IAllSubModel allSubModel = new AllSubModelImpl();
    private IAllSubView allSubView;
    private static final String CLICKFROMSUBSCRIBE = "subscribe";


    public AllSubPresenterImpl(IAllSubView allSubView) {
        this.allSubView = allSubView;
    }

    @Override
    public void getLeftList() {
        allSubModel.getLeftList(this);
    }

    @Override
    public void getRightList(String parentId) {
        allSubModel.getRightList(parentId,this);
    }

    public static void subAddChannel(String category, String keyword, String srpId) {
        allSubModel.addChannel(category, keyword, srpId, CLICKFROMSUBSCRIBE);
    }

    public static void subDeleteChannel(String category, String keyword, String srpId) {
        allSubModel.deleteChannel(category, keyword, srpId, CLICKFROMSUBSCRIBE);
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
