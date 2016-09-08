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
public class ExploreListHotGridAdapter extends BaseAdapter{
    private Context mContext;
    private List<ExploreInfoBean.BodyBean.HotSubscribeListBean> hotSubscribeList;

    public ExploreListHotGridAdapter(Context context, List<ExploreInfoBean.BodyBean.HotSubscribeListBean> hotSubscribeList){
        this.mContext = context;
        this.hotSubscribeList = hotSubscribeList;
    }

    @Override
    public int getCount() {
        return hotSubscribeList == null ? 0 : hotSubscribeList.size();
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
        MyViewHolder myViewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_list_hot_grid_item_view, parent, false);
            myViewHolder = new MyViewHolder(convertView);
        }else{
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        myViewHolder.imgView.setImageResource(R.mipmap.ic_launcher);
        ExploreInfoBean.BodyBean.HotSubscribeListBean hotSubscribeObj = hotSubscribeList.get(position);
        if(hotSubscribeObj != null){
            myViewHolder.titleTxt.setText(hotSubscribeObj.getTitle());
            Log.d("HotGridAdapter","============="+hotSubscribeObj.getTitle());
            myViewHolder.countTxt.setText(String.valueOf(hotSubscribeObj.getCountSubscribe()));
            Picasso.with(mContext).load(hotSubscribeObj.getImageUrl()).into(myViewHolder.imgView);
        }
        return convertView;
    }

    class MyViewHolder {
        private ImageView imgView;
        private TextView titleTxt, countTxt;
        MyViewHolder(View view) {
            imgView = (ImageView) view.findViewById(R.id.fragment_explore_list_hot_grid_item_img_iv);
            titleTxt = (TextView) view.findViewById(R.id.fragment_explore_list_hot_grid_item_keyword_tv);
            countTxt = (TextView) view.findViewById(R.id.fragment_explore_list_hot_grid_item_readcount_tv);
            view.setTag(this);
        }
    }
}
