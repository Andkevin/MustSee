package com.android1604.mustsee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android1604.mustsee.R;
import com.android1604.mustsee.bean.SearchAutoTipBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 2016/9/7.
 */
public class SearchAutoListAdapter extends BaseAdapter{
    private Context mContext;
    private List<SearchAutoTipBean.BodyBean.DataListBean> autoTipList = new ArrayList<>();

    public SearchAutoListAdapter(Context context, List<SearchAutoTipBean.BodyBean.DataListBean> autoTipList){
        this.mContext = context;
        this.autoTipList = autoTipList;
    }

    @Override
    public int getCount() {
        return autoTipList == null ? 0 : autoTipList.size();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.search_autolist_item, parent, false);
            myViewHolder = new MyViewHolder(convertView);
        }else{
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        String keyword = autoTipList.get(position).getKeyword();
        if(keyword != null){
            myViewHolder.keywordTxt.setText(keyword);
        }
        return convertView;
    }

    class MyViewHolder {
        private TextView keywordTxt;
        MyViewHolder(View view) {
            keywordTxt = (TextView) view.findViewById(R.id.search_autolist_item_keyword_tv);
            view.setTag(this);
        }
    }
}
