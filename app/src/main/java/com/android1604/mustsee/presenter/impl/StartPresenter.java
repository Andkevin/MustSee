package com.android1604.mustsee.presenter.impl;

import com.android1604.mustsee.bean.StartBean;
import com.android1604.mustsee.model.IStartModel;
import com.android1604.mustsee.model.impl.StartModel;
import com.android1604.mustsee.presenter.IStartPresenter;
import com.android1604.mustsee.view.IStartView;

/**
 * Created by Administrator on 2016/9/7.
 */
public class StartPresenter implements IStartPresenter, IStartPresenter.StartImageCallBack {
    private IStartView startView;
    private IStartModel startModel;


    public StartPresenter(IStartView startView) {
        this.startView = startView;
        startModel = new StartModel();
    }

    @Override
    public void getImageUrl() {
        startModel.getStartImage(this);
    }

    @Override
    public void success(StartBean startBean) {
        String url = null;
        if (startBean != null) {
            url = startBean.getBody().getSplashScreen().getUrl();
        }
        if (url != null) {
            startView.refreshView(url);
        } else {
            startView.refreshView();
        }
    }
}
