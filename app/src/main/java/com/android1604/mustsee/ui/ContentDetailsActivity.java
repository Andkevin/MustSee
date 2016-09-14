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

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class ContentDetailsActivity extends BaseActivity {
    private static final String TAG = "zengzhen";
    private ListView mListView;
    private String docType;
    private String docId;
    private ImageView backImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_details);
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
        initListener();
    }

    private void initListener() {
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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
