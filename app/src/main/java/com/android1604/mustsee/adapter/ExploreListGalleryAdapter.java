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
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by my on 2016/9/7.
 */
public class ExploreListGalleryAdapter extends BaseAdapter {
    private Context mContext;
    private List<ExploreInfoBean.BodyBean.RecommentListBean> recommentList;

    public ExploreListGalleryAdapter(Context mContext, List<ExploreInfoBean.BodyBean.RecommentListBean> recommentList){
        this.mContext = mContext;
        this.recommentList = recommentList;
    }

    @Override
    public int getCount() {
        return recommentList == null ? 0 : recommentList.size();
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_list_recommend_gallery_item_view, parent, false);
            myViewHolder = new MyViewHolder(convertView);
        }else{
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        myViewHolder.imgView.setImageResource(R.mipmap.ic_launcher);
        ExploreInfoBean.BodyBean.RecommentListBean recommentObj = recommentList.get(position);
        if(recommentObj != null){
            myViewHolder.keywordTxt.setText(recommentObj.getKeyword());
            myViewHolder.titleTxt.setText(recommentObj.getTitle());
            Picasso.with(mContext).load(recommentObj.getImageUrl()).into(myViewHolder.imgView);
        }
        return convertView;
    }

    class MyViewHolder {
        private ImageView imgView;
        private TextView keywordTxt, titleTxt;
        MyViewHolder(View view) {
            imgView = (ImageView) view.findViewById(R.id.explore_list_recommend_gallery_item_img_iv);
            keywordTxt = (TextView) view.findViewById(R.id.explore_list_recommend_gallery_item_keyword_tv);
            titleTxt = (TextView) view.findViewById(R.id.explore_list_recommend_gallery_item_title_tv);
            view.setTag(this);
        }
    }
}
