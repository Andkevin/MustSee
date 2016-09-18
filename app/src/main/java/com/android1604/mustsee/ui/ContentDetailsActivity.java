package com.android1604.mustsee.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.android1604.mustsee.BaseActivity;
import com.android1604.mustsee.R;
import com.android1604.mustsee.bean.ContentDetailsBean;
import com.android1604.mustsee.http.HttpUtils;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class ContentDetailsActivity extends BaseActivity {
    private ListView mListView;
    private String docType;
    private String docId;
    private ImageView backImage;
    private ImageView shareImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_details);
        ShareSDK.initSDK(this);
        Intent intent = getIntent();
        docType = intent.getStringExtra("docType");
        docId = intent.getStringExtra("docId");
        loadDatas();
    }

    private void loadDatas() {
        HttpUtils.getHttpService().getContentDeatils(docType,docId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<ContentDetailsBean>() {
            @Override
            public void call(ContentDetailsBean contentDetailsBean) {
                initView(contentDetailsBean);
            }
        });

    }


    private void initView(ContentDetailsBean contentDetailsBean) {
        backImage = (ImageView) findViewById(R.id.content_details_back_iv);
        mListView = (ListView) findViewById(R.id.content_details_list_lv);
        DetailAdapter detailAdapter = new DetailAdapter(contentDetailsBean);
        mListView.setAdapter(detailAdapter);
        shareImage = (ImageView) findViewById(R.id.content_details_share_iv);
        initListener();
    }

    private void initListener() {
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        shareImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareSDK.initSDK(ContentDetailsActivity.this);
                OnekeyShare oks = new OnekeyShare();
                //关闭sso授权
                oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
                //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
                // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
                oks.setTitle("分享");
                // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
//                oks.setTitleUrl("http://sharesdk.cn");
                // text是分享文本，所有平台都需要这个字段
                oks.setText("我是分享文本");
                //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
//                oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
                // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                // url仅在微信（包括好友和朋友圈）中使用
//                oks.setUrl("http://sharesdk.cn");
                // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                oks.setComment("我是测试评论文本");
                // site是分享此内容的网站名称，仅在QQ空间使用
                oks.setSite(getString(R.string.app_name));
                // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                oks.setSiteUrl(docId);

// 启动分享GUI
                oks.show(ContentDetailsActivity.this);
            }
        });
    }

    class DetailAdapter extends BaseAdapter{
        private ContentDetailsBean contentDetailsBean;
        private WebViewClient client = new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        };

        public DetailAdapter(ContentDetailsBean contentDetailsBean) {
            this.contentDetailsBean = contentDetailsBean;
        }

        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String url = contentDetailsBean.getBody().getNotShowData().getShortUrl();
            convertView = LayoutInflater.from(ContentDetailsActivity.this).inflate(R.layout.content_detail_main_item,parent,false);
            WebView webView = (WebView) convertView.findViewById(R.id.content_details_web_view);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(client);
            webView.loadUrl(url);
            return convertView;
        }
    }

}
