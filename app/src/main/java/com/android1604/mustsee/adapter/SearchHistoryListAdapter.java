package com.android1604.mustsee.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android1604.mustsee.R;
import com.android1604.mustsee.bean.SearchHotBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * Created by Kevin on 2016/9/7.
 */
public class SearchHistoryListAdapter extends BaseAdapter{
    private Context mContext;
    private List<String> searchHistoryList = new ArrayList<>();

    public SearchHistoryListAdapter(Context context, List<String> searchHistoryList){
        this.mContext = context;
        this.searchHistoryList = searchHistoryList;
    }

    @Override
    public int getCount() {
        return searchHistoryList == null ? 0 : searchHistoryList.size();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.search_def_history_list_item, parent, false);
            myViewHolder = new MyViewHolder(convertView);
        }else{
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        String keyword = searchHistoryList.get(position);
        if(keyword != null){
            myViewHolder.keywordTxt.setText(keyword);
        }
        return convertView;
    }

    class MyViewHolder {
        private TextView keywordTxt;
        MyViewHolder(View view) {
            keywordTxt = (TextView) view.findViewById(R.id.search_def_history_list_item_keyword_tv);
            view.setTag(this);
        }
    }
}
