package com.android1604.mustsee.presenter.impl;

import android.os.Bundle;

import com.android1604.mustsee.bean.SearchContentBean;
import com.android1604.mustsee.bean.TabTitlesBean;
import com.android1604.mustsee.model.IInformationModel;
import com.android1604.mustsee.model.impl.InformationModelImpl;
import com.android1604.mustsee.presenter.IInformationPresenter;
import com.android1604.mustsee.view.IInformationView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 * 关联资讯数据和视图
 */
public class InformationPresenterImpl implements IInformationPresenter,IInformationPresenter.TabTitlesCallBack{
    private IInformationModel informationModel;
    private IInformationView informationView;
    private static List<TabTitlesBean.BodyBean.DataListBean> datas = new ArrayList<>();

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
            datas.clear();
            for (int i = 0; i < dataList.size(); i++) {
                TabTitlesBean.BodyBean.DataListBean bean = dataList.get(i);
                datas.add(bean);
                Bundle bundle = new Bundle();
                String title = bean.getTitle();
                if(title != null){
                    bundle.putString("title",title);
                }
                String srpId = bean.getSrpId();
                if(srpId != null){
                    bundle.putString("srpId",srpId);
                }
                String sortNum = bean.getSortNum();
                if(sortNum != null){
                    bundle.putString("sortNum",sortNum);
                }
                String id = bean.getId();
                if(id != null){
                    bundle.putString("id",id);
                }
                String category = bean.getCategory();
                if(category != null){
                    bundle.putString("category",category);
                }
                String keyword = bean.getKeyword();
                if(keyword != null){
                    bundle.putString("keyword",keyword);
                }
                informationView.refreshTabLayout(bundle);
            }
        }
    }

    public static List<TabTitlesBean.BodyBean.DataListBean> getData(){
        return datas;
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
