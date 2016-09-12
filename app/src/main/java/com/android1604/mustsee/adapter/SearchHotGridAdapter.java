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
import com.android1604.mustsee.bean.SearchHotBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by my on 2016/9/7.
 */
public class SearchHotGridAdapter extends BaseAdapter{
    private Context mContext;
    private List<SearchHotBean.BodyBean.DataListBean> dataBeanList;

    public SearchHotGridAdapter(Context context, List<SearchHotBean.BodyBean.DataListBean> dataBeanList){
        this.mContext = context;
        this.dataBeanList = dataBeanList;
    }

    @Override
    public int getCount() {
        return dataBeanList == null ? 0 : dataBeanList.size();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.search_hot_grid_item_view, parent, false);
            myViewHolder = new MyViewHolder(convertView);
        }else{
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        SearchHotBean.BodyBean.DataListBean keywordObj = dataBeanList.get(position);
        if(keywordObj != null){
            myViewHolder.keywordTxt.setText(keywordObj.getKeyword());
        }
        return convertView;
    }

    class MyViewHolder {
        private TextView keywordTxt;
        MyViewHolder(View view) {
            keywordTxt = (TextView) view.findViewById(R.id.search_hot_grid_item_keyword_tv);
            view.setTag(this);
        }
    }
}
