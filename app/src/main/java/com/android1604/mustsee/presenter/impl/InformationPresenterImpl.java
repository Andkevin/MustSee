package com.android1604.mustsee.presenter.impl;

import android.os.Bundle;

import com.android1604.mustsee.bean.SearchContentBean;
import com.android1604.mustsee.bean.TabTitlesBean;
import com.android1604.mustsee.model.IInformationModel;
import com.android1604.mustsee.model.impl.InformationModelImpl;
import com.android1604.mustsee.presenter.IInformationPresenter;
import com.android1604.mustsee.view.IInformationView;

import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 * 关联资讯数据和视图
 */
public class InformationPresenterImpl implements IInformationPresenter,IInformationPresenter.TabTitlesCallBack{
    private IInformationModel informationModel;
    private IInformationView informationView;

    public InformationPresenterImpl(IInformationView informationView) {
        this.informationView = informationView;
        this.informationModel = new InformationModelImpl();
    }

    @Override
    public void getTabTiles() {
        informationModel.getTabTitles(this);
    }

    @Override
    public void getSearchContent() {
        informationModel.getSearchContent(this);
    }

    @Override
    public void success(TabTitlesBean tabTitlesBean) {
        if(tabTitlesBean != null){
            List<TabTitlesBean.BodyBean.DataListBean> dataList = tabTitlesBean.getBody().getDataList();
            for (int i = 0; i < dataList.size(); i++) {
                Bundle bundle = new Bundle();
                String title = dataList.get(i).getTitle();
                String srpId = dataList.get(i).getSrpId();
                if(srpId != null){
                    bundle.putString("srpId",srpId);
                }
                String sortNum = dataList.get(i).getSortNum();
                if(sortNum != null){
                    bundle.putString("sortNum",sortNum);
                }
                String id = dataList.get(i).getId();
                if(id != null){
                    bundle.putString("id",id);
                }
                String category = dataList.get(i).getCategory();
                if(category != null){
                    bundle.putString("category",category);
                }
                String keyword = dataList.get(i).getKeyword();
                if(keyword != null){
                    bundle.putString("keyword",keyword);
                }
                informationView.refreshTabLayout(title,bundle);
            }
        }
    }

    @Override
    public void contentSuccess(SearchContentBean searchContentBean) {
        String content = null;
        if(searchContentBean != null){
            content = searchContentBean.getBody().getContent();
        }
        if(content != null){
            informationView.getSearchContent("大家都在搜:"+content);
        }
    }
}
