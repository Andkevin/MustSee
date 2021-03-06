package com.android1604.mustsee.http;


import com.android1604.mustsee.bean.AddBean;
import com.android1604.mustsee.bean.AllSubLeftBean;
import com.android1604.mustsee.bean.AllSubRightBean;
import com.android1604.mustsee.bean.CommentBean;
import com.android1604.mustsee.bean.ContentDetailsBean;
import com.android1604.mustsee.bean.DeleteBean;
import com.android1604.mustsee.bean.ExploreSubscribeBean;
import com.android1604.mustsee.bean.NewsBean;
import com.android1604.mustsee.bean.NewsBean1;
import com.android1604.mustsee.bean.PushChannelBean;
import com.android1604.mustsee.bean.SearchAutoTipBean;
import com.android1604.mustsee.bean.SearchContentBean;
import com.android1604.mustsee.bean.SearchHotBean;
import com.android1604.mustsee.bean.SortBean;
import com.android1604.mustsee.bean.StartBean;
import com.android1604.mustsee.bean.TabTitlesBean;
import com.android1604.mustsee.bean.ExploreInfoBean;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/9/6.
 *  请求网络数据
 */
public interface HttpService {


    /**
     * 获取搜索框的内容
     */
    @GET("/headline/search/searchbox.content.groovy?appName=com.zhongsou.souyue.headline&netType=WiFi&token=1e9a8a06-beba-4df0-b86d-e1febf178024&imei=133524136259701&state=5&vc=1.2.1&channel=必看豌豆荚&lat=30.578771")
    Observable<SearchContentBean> getSearchContent();

    /**
     * 获取欢迎页面图片
     */
    @GET("/headline/webdata/splash.screen.groovy?rheight=1280&appName=com.zhongsou.souyue.headline&netType=WiFi&rwidth=720&machineType=android&token=1e9a8a06-beba-4df0-b86d-e1febf178024&imei=133524136259701&state=5&vc=1.2.1&channel=必看豌豆荚&clientTime=1473210412486&lat=30.578771")
    Observable<StartBean> getStartImage();

    /**
     * 获取资讯页面Tab标题
     */
    // http://api2.souyue.mobi/headline/subscribe/homepage.channel.list.groovy?appName=com.zhongsou.souyue.headline&netType=WiFi&token=1e9a8a06-beba-4df0-b86d-e1febf178024&imei=133524136259701&state=5&vc=1.2.1&channel=必看豌豆荚&lat=30.578771
    @GET("/headline/subscribe/homepage.channel.list.groovy?appName=com.zhongsou.souyue.headline&netType=WiFi&token=1e9a8a06-beba-4df0-b86d-e1febf178024&imei=133524136259701&state=5&vc=1.2.1&channel=必看豌豆荚&lat=30.578771")
    Observable<TabTitlesBean> getTabTitles();

    /**
     *  获取资讯新闻列表
     */
    @POST("/headline/webdata/homepage.news.groovy?appName=com.zhongsou.souyue.headline&netType=WiFi&token=1e9a8a06-beba-4df0-b86d-e1febf178024&imei=133524136259701&state=5&vc=1.2.1&channel=必看豌豆荚&lat=30.578771")
    Observable<NewsBean> getNewsList(@Query("category") String category,@Query("keyword") String keyword,@Query("srpId") String srpId,@Query("indexId") String indexId,@Query("lastId") String lastId);


    /**
     * 请求订阅大全左侧列表
     */
    @GET("/headline/subscribe/subscribe.cate.list.groovy?appName=com.zhongsou.souyue.headline&netType=WiFi&token=1e9a8a06-beba-4df0-b86d-e1febf178024&imei=133524136259701&state=5&vc=1.2.1&channel=必看豌豆荚&lat=30.578771")
    Observable<AllSubLeftBean>  getLeftList();

    /**
     * 请求订阅大全右侧列表
     */
    @POST("/headline/subscribe/cate.children.groovy?appName=com.zhongsou.souyue.headline&netType=WiFi&token=1e9a8a06-beba-4df0-b86d-e1febf178024&imei=133524136259701&state=5&vc=1.2.1&channel=必看豌豆荚&lat=30.578771")
    Observable<AllSubRightBean> getRightList(@Query("parentId") String parentId);

    /**
     * 请求推荐的频道
     */
    @GET("/headline/subscribe/my.channel.list.groovy?appName=com.zhongsou.souyue.headline&netType=WiFi&token=1e9a8a06-beba-4df0-b86d-e1febf178024&imei=133524136259701&state=5&vc=1.2.1&channel=必看豌豆荚&lat=30.578771")
    Observable<PushChannelBean> getPushChannel();

    /**
     * 添加频道
     */
    @POST("/headline/subscribe/subscribe.channel.add.groovy?appName=com.zhongsou.souyue.headline&netType=WiFi&token=1e9a8a06-beba-4df0-b86d-e1febf178024&imei=133524136259701&state=5&vc=1.2.1&channel=必看豌豆荚&lat=30.578771")
    Observable<AddBean> addChannel(@Query("category") String category, @Query("keyword") String keyword, @Query("srpId") String srpId, @Query("clickFrom") String clickFrom);


    /**
     * 删除频道
     */
    @POST("/headline/subscribe/subscribe.channel.delete.groovy?appName=com.zhongsou.souyue.headline&netType=WiFi&token=1e9a8a06-beba-4df0-b86d-e1febf178024&imei=133524136259701&state=5&vc=1.2.1&channel=必看豌豆荚&lat=30.578771")
    Observable<DeleteBean> deleteChannel(@Query("category") String category, @Query("keyword") String keyword, @Query("srpId") String srpId, @Query("clickFrom") String clickFrom);


    /**
     * 排序频道
     */
    @POST("/headline/subscribe/channel.sort.groovy?appName=com.zhongsou.souyue.headline&netType=WiFi&token=1e9a8a06-beba-4df0-b86d-e1febf178024&imei=133524136259701&state=5&vc=1.2.1&channel=必看豌豆荚&lat=30.578771")
    Observable<SortBean> sortChannel(@Query("channels")ArrayList<TabTitlesBean.BodyBean.DataListBean> channels);

    //---请求探索主页数据---
    @GET("/headline/webdata/love.explore.groovy")
    Observable<ExploreInfoBean> queryExploreInfo();

    //---查询资讯列表数据---
    @POST("/headline/search/search.content.groovy?token=1e9a8a06-beba-4df0-b86d-e1febf178024")
    Observable<NewsBean1> queryNewsSubList(@Query("keyword") String keyword, @Query("lastId") String lastId);
//    Observable<NewsBean> queryNewsSubList(@Query("keyword") String keyword,@Query("lastId") String lastId);

    //---查询搜索中的热搜数据---
    @GET("/headline/search/hotsearch.list.groovy")
    Observable<SearchHotBean> queryHotSearchInfo();

    //---查询搜索中的关键字自动补全数据---
    @POST("/headline/recommend/search.enjoy.content.groovy")
    Observable<SearchAutoTipBean> queryAutoSearchInfo(@Query("keyword") String keyword);

    //探索添加订阅
    @POST("/headline/subscribe/subscribe.channel.add.groovy?token=1e9a8a06-beba-4df0-b86d-e1febf178024&category=\"\"")
    Observable<AddBean> addSubscribe(@Query("keyword") String keyword, @Query("srpId") String srpId);

    //探索取消订阅
    @POST("/headline/subscribe/subscribe.channel.delete.groovy?token=1e9a8a06-beba-4df0-b86d-e1febf178024")
    Observable<DeleteBean> delSubscribe(@Query("keyword") String keyword, @Query("srpId") String srpId);

    /**
     * 获取新闻详情
     */
    @GET("/headline/detail/detail.main.groovy?appName=com.zhongsou.souyue.headline&netType=WiFi&token=1e9a8a06-beba-4df0-b86d-e1febf178024&imei=133524136259701&state=5&vc=1.2.1&channel=必看豌豆荚&lat=30.578771")
    Observable<ContentDetailsBean> getContentDeatils(@Query("docType") String docType,@Query("docId") String docId);

    /**
     *获取新闻评论
     */
    @GET("/headline/comment/comment.list.groovy?appName=com.zhongsou.souyue.headline&netType=WiFi&token=1e9a8a06-beba-4df0-b86d-e1febf178024&imei=133524136259701&state=5&vc=1.2.1&channel=必看豌豆荚&lat=30.578771")
    Observable<CommentBean> getContentComment(@Query("docType") String docType,@Query("docId") String docId);
}
