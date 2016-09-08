package com.android1604.mustsee.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android1604.mustsee.bean.ExploreInfoBean;

import java.util.List;

/**
 * Created by my on 2016/9/7.
 */
public class ExploreViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<ExploreInfoBean.BodyBean.RollingImagesListBean> rollingImagesList;

    public ExploreViewPagerAdapter(Context mContext,List<ExploreInfoBean.BodyBean.RollingImagesListBean> rollingImagesList){
        this.mContext = mContext;
        this.rollingImagesList = rollingImagesList;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            if(mAdverDatas != null){
//                ImageLoader.init(mContext).loadImage(mAdverDatas.get(position%5), imageView);
//            }
//            container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
