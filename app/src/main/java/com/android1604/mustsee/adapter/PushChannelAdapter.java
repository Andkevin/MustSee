package com.android1604.mustsee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android1604.mustsee.R;
import com.android1604.mustsee.bean.PushChannelBean;

import java.util.List;

/**
 * Created by Administrator on 2016/9/10.
 *
 */
public class PushChannelAdapter extends BaseAdapter{
    private List<PushChannelBean.BodyBean.DataListBean> datas;
    private Context mContext;

    public PushChannelAdapter(Context mContext,List<PushChannelBean.BodyBean.DataListBean> datas) {
        this.datas = datas;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if(position != datas.size()-1){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.channel_list_item,parent,false);
            textView = (TextView) convertView.findViewById(R.id.channel_list_txt);

        }else{
            convertView = LayoutInflater.from(mContext).inflate(R.layout.channel_list_more_item,parent,false);
            textView = (TextView) convertView.findViewById(R.id.channel_list_more_txt);
        }
        String keyword = datas.get(position).getKeyword();
        textView.setText(keyword);
        return convertView;
    }

    public List<PushChannelBean.BodyBean.DataListBean> getData() {
        return datas;
    }
    public void setData(List<PushChannelBean.BodyBean.DataListBean> datas) {
        this.datas = datas;
    }
    public void refreshData(){
        notifyDataSetChanged();
    }
}
