package com.android1604.mustsee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android1604.mustsee.R;
import com.android1604.mustsee.bean.ExploreInfoBean;
import com.android1604.mustsee.bean.ExploreSubscribeBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/9/7.
 */
public class ExploreNewsSubscribeAdapter extends BaseAdapter {
    private Context mContext;
    private List<ExploreSubscribeBean.BodyBean.NewsListBean> newsList = new ArrayList<>();

    public ExploreNewsSubscribeAdapter(Context mContext, ExploreSubscribeBean exploreSubscribeBean) {
        this.mContext = mContext;
        this.newsList.addAll(exploreSubscribeBean.getBody().getNewsList());
    }

    @Override
    public int getCount() {
        return newsList == null ? 0 : newsList.size();
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
    public int getItemViewType(int position) {
        int imgCount = newsList.get(position).getImage().size();
        if (imgCount == 0) {
            return 0;
        } else if (imgCount == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ExploreSubscribeBean.BodyBean.NewsListBean newsBeen = newsList.get(position);
        int viewType = getItemViewType(position);
        View view = null;
        if (viewType == 0) {
            view = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_news_list_type10_img0_view, null);
            TextView titleTxt = (TextView) view.findViewById(R.id.explore_news_list_type10_img0_title_tv);
            TextView sourceTxt = (TextView) view.findViewById(R.id.explore_news_list_type10_img0__source_tv);
            titleTxt.setText(newsBeen.getTitle());
            sourceTxt.setText(newsBeen.getFootView().getSource());
        }
        if (viewType == 1) {
            view = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_news_list_type10_img1_view, null);
            TextView titleTxt = (TextView) view.findViewById(R.id.explore_news_list_type10_img1_title_tv);
            TextView sourceTxt = (TextView) view.findViewById(R.id.explore_news_list_type10_img1_source_tv);
            ImageView imgView = (ImageView) view.findViewById(R.id.explore_news_list_type10_img1_iv);
            titleTxt.setText(newsBeen.getTitle());
            sourceTxt.setText(newsBeen.getFootView().getSource());
            Picasso.with(mContext).load(newsBeen.getImage().get(0)).into(imgView);
        }
        if (viewType == 2) {
            view = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_news_list_type10_img3_view, null);
            TextView titleTxt = (TextView) view.findViewById(R.id.explore_news_list_type10_img3_title_tv);
            TextView sourceTxt = (TextView) view.findViewById(R.id.explore_news_list_type10_img3_source_tv);
            ImageView img1View = (ImageView) view.findViewById(R.id.explore_news_list_type10_img3_iv1);
            ImageView img2View = (ImageView) view.findViewById(R.id.explore_news_list_type10_img3_iv2);
            ImageView img3View = (ImageView) view.findViewById(R.id.explore_news_list_type10_img3_iv3);
            titleTxt.setText(newsBeen.getTitle());
            sourceTxt.setText(newsBeen.getFootView().getSource());
            Picasso.with(mContext).load(newsBeen.getImage().get(0)).into(img1View);
            Picasso.with(mContext).load(newsBeen.getImage().get(1)).into(img2View);
            Picasso.with(mContext).load(newsBeen.getImage().get(2)).into(img3View);
        }
        return view;
    }

}
