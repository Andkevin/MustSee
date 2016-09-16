package com.android1604.mustsee.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android1604.mustsee.R;
import com.android1604.mustsee.bean.ExploreInfoBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/9/7.
 */
public class ExploreListFoundListAdapter extends BaseAdapter {
    private Context mContext;
    private List<ExploreInfoBean.BodyBean.NewFoundListBean> newFoundList = new ArrayList<>();

    public ExploreListFoundListAdapter(Context mContext, List<ExploreInfoBean.BodyBean.NewFoundListBean> newFoundList){
        this.mContext = mContext;
        this.newFoundList.addAll(newFoundList);
    }

    @Override
    public int getCount() {
        return newFoundList == null ? 0 : newFoundList.size();
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
        int invokeType = newFoundList.get(position).getInvokeType();
        if(invokeType == 95){
            return 0;
        }
        if(invokeType == 10){
            int imgCount = newFoundList.get(position).getImage().size();
            if(imgCount == 0){
                return 1;
            }else if(imgCount == 1){
                return 2;
            }else{
                return 3;
            }
        }
        return -1;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ExploreInfoBean.BodyBean.NewFoundListBean foundObj = newFoundList.get(position);
        int viewType = getItemViewType(position);
        View view = null;
        if(viewType == 0){
            view  = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_list_found_list_item_type95_view, null);
            TextView keywordTxt = (TextView) view.findViewById(R.id.explore_list_found_list_item_type95_keyword_tv);
            TextView readCountTxt = (TextView) view.findViewById(R.id.explore_list_found_list_item_type95_subcount_tv);
            ImageView imgView = (ImageView) view.findViewById(R.id.explore_list_found_list_item_type95_iv);
            keywordTxt.setText(foundObj.getKeyword());
            readCountTxt.setText(String.valueOf(foundObj.getCountSubscribe())+"人已订阅");
            Picasso.with(mContext).load(foundObj.getImageUrl()).into(imgView);
        }
        if(viewType == 1 || viewType == 2){
            view  = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_list_found_list_item_type10_1_view, null);
            TextView titleTxt = (TextView) view.findViewById(R.id.explore_list_found_list_item_type10_1_title_tv);
            TextView sourceTxt = (TextView) view.findViewById(R.id.explore_list_found_list_item_type10_1_source_tv);
            ImageView imgView = (ImageView) view.findViewById(R.id.explore_list_found_list_item_type10_1_iv);
            titleTxt.setText(foundObj.getTitle());
            sourceTxt.setText(foundObj.getFootView().getSource());
            if(viewType == 1){
                imgView.setVisibility(View.GONE);
            }else {
                Picasso.with(mContext).load(foundObj.getImage().get(0)).into(imgView);
            }
        }

        if(viewType == 3){
            view  = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_list_found_list_item_type10_3_view, null);
            TextView titleTxt = (TextView) view.findViewById(R.id.explore_list_found_list_item_type10_3_title_tv);
            TextView sourceTxt = (TextView) view.findViewById(R.id.explore_list_found_list_item_type10_3_source_tv);
            ImageView img1View = (ImageView) view.findViewById(R.id.explore_list_found_list_item_type10_3_iv1);
            ImageView img2View = (ImageView) view.findViewById(R.id.explore_list_found_list_item_type10_3_iv2);
            ImageView img3View = (ImageView) view.findViewById(R.id.explore_list_found_list_item_type10_3_iv3);
            titleTxt.setText(foundObj.getTitle());
            sourceTxt.setText(foundObj.getFootView().getSource());
            Picasso.with(mContext).load(foundObj.getImage().get(0)).into(img1View);
            Picasso.with(mContext).load(foundObj.getImage().get(1)).into(img2View);
            Picasso.with(mContext).load(foundObj.getImage().get(2)).into(img3View);
        }
        return view;
    }

}
