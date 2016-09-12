package com.android1604.mustsee.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.android1604.mustsee.bean.TabTitlesBean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 * 资讯页面视图接口
 */
public interface IInformationView {
    /**
     * 刷新资讯Tab列表
     */
    void refreshTabLayout(Bundle bundle);

    /**
     * 获取搜索框中内容
     */
    void getSearchContent(String content);
}
