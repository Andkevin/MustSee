package com.android1604.mustsee.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import com.android1604.mustsee.ui.ExploreNewsSubActivity;
import com.android1604.mustsee.ui.MyListView;
import com.android1604.mustsee.ui.SearchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 2016/9/7.
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
        batchTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "换一批!!!", Toast.LENGTH_SHORT).show();
//                gridAdapter.notifyDataSetChanged();
                Intent intent = new Intent(mContext, SearchActivity.class);
                intent.putExtra("keyword","Hello");
                mContext.startActivity(intent);
            }
        });
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, ExploreNewsSubActivity.class);
                intent.putExtra("keyword",bodyBean.getHotSubscribeList().get(position).getKeyword());
                mContext.startActivity(intent);
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
                Intent intent = new Intent(mContext, ExploreNewsSubActivity.class);
                intent.putExtra("keyword",bodyBean.getRecommentList().get(position).getKeyword());
                mContext.startActivity(intent);
            }
        });
    }

    public void setFoundTypeData(View view) {
        MyListView mLv = (MyListView) view.findViewById(R.id.fragment_explore_list_found_item_list_lv);
        ExploreListFoundListAdapter foundAdapter = new ExploreListFoundListAdapter(mContext, bodyBean.getNewFoundList());
        mLv.setAdapter(foundAdapter);
//        ListViewUtils.reMeasureHeightOnSubList(mLv);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "position=="+position, Toast.LENGTH_SHORT).show();
                int viewID = view.getId();
                Log.d("ExploreListAdatper", "viewID================================="+viewID);
                switch (viewID){
                    case R.layout.fragment_explore_list_found_list_item_type95_view:
                        Intent intent = new Intent(mContext, ExploreNewsSubActivity.class);
                        intent.putExtra("keyword",bodyBean.getNewFoundList().get(position).getKeyword());
                        mContext.startActivity(intent);
                        break;
                }
            }
        });
    }
}
