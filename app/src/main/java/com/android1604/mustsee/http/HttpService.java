package com.android1604.mustsee.http;


import com.android1604.mustsee.bean.StartBean;
import com.android1604.mustsee.bean.TabTitlesBean;
import com.android1604.mustsee.bean.ExploreInfoBean;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Administrator on 2016/9/6.
 *  请求网络数据
 */
public interface HttpService {
    //获取欢迎页面图片
    @GET("/headline/webdata/splash.screen.groovy?rheight=1280&appName=com.zhongsou.souyue.headline&netType=WiFi&rwidth=720&machineType=android&token=1e9a8a06-beba-4df0-b86d-e1febf178024&imei=133524136259701&state=5&vc=1.2.1&channel=必看豌豆荚&clientTime=1473210412486&lat=30.578771")
    Observable<StartBean> getStartImage();

    //获取资讯页面Tab标题
    // http://api2.souyue.mobi/headline/subscribe/homepage.channel.list.groovy?appName=com.zhongsou.souyue.headline&netType=WiFi&token=1e9a8a06-beba-4df0-b86d-e1febf178024&imei=133524136259701&state=5&vc=1.2.1&channel=必看豌豆荚&lat=30.578771
    @GET("/headline/subscribe/homepage.channel.list.groovy?appName=com.zhongsou.souyue.headline&netType=WiFi&token=1e9a8a06-beba-4df0-b86d-e1febf178024&imei=133524136259701&state=5&vc=1.2.1&channel=必看豌豆荚&lat=30.578771")
    Observable<TabTitlesBean> getTabTitles();

    @GET("/headline/webdata/love.explore.groovy")
    Observable<ExploreInfoBean> queryExploreInfo();


}
