package com.android1604.mustsee.http;

import com.android1604.mustsee.bean.ExploreInfoBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by my on 2016/9/6.
 */
public interface HttpService {

    /**
     * 请求'探索'主页数据
     */
    @GET("/headline/webdata/love.explore.groovy")
    Observable<ExploreInfoBean> queryExploreInfo();


}
