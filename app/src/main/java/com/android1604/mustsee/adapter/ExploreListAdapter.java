package com.android1604.mustsee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android1604.mustsee.R;
import com.android1604.mustsee.bean.ExploreInfoBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by my on 2016/9/7.
 */
public class ExploreListAdapter extends BaseAdapter {
    private Context mContext;
    private ExploreInfoBean.BodyBean bodyBean;

    public ExploreListAdapter(Context mContext, ExploreInfoBean.BodyBean bodyBean){
        this.mContext = mContext;
        this.bodyBean = bodyBean;
    }

    @Override
    public int getCount() {
        return 3;
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
        View view = null;
        if(position == 0){
            view  = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_list_hot_view, null);
            setHotTypeData(view);
        }
        if(position == 1){
            view  = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_list_recommend_view, null);
            setRecommendTypeData(view);
        }
        if(position == 2){
            view  = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_list_found_view, null);
            setFoundTypeData(view);
        }
        return view;
    }

    public void setHotTypeData(View view) {
        //设置一个标识 flag < listsize
        final List<ExploreInfoBean.BodyBean.HotSubscribeListBean> curGridAdapterList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            curGridAdapterList.add(bodyBean.getHotSubscribeList().get(i));
        }
        TextView batchTxt = (TextView) view.findViewById(R.id.fragment_explore_list_hot_item_change_tv);
        GridView mGv = (GridView) view.findViewById(R.id.fragment_explore_list_hot_item_gridview_gv);
        final ExploreListHotGridAdapter gridAdapter = new ExploreListHotGridAdapter(mContext,curGridAdapterList);
        mGv.setAdapter(gridAdapter);
        ListViewUtils.reMeasureHeightOnSubList(mGv);
        batchTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "换一批!!!", Toast.LENGTH_SHORT).show();
                gridAdapter.notifyDataSetChanged();
            }
        });
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TO-DO
            }
        });
    }

    public void setRecommendTypeData(View view) {
        Gallery mGallery = (Gallery) view.findViewById(R.id.fragment_explore_list_recommend_item_gallery);
        ExploreListGalleryAdapter galleryAdapter = new ExploreListGalleryAdapter(mContext, bodyBean.getRecommentList());
        mGallery.setAdapter(galleryAdapter);
        mGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TO-DO
            }
        });
    }

    public void setFoundTypeData(View view) {
        ListView mLv = (ListView) view.findViewById(R.id.fragment_explore_list_found_item_list_lv);
        ExploreListFoundListAdapter foundAdapter = new ExploreListFoundListAdapter(mContext, bodyBean.getNewFoundList());
        mLv.setAdapter(foundAdapter);
        ListViewUtils.reMeasureHeightOnSubList(mLv);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TO-DO
            }
        });
    }
}
