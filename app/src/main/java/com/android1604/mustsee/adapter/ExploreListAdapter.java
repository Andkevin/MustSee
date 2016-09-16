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
import com.android1604.mustsee.ui.ContentDetailsActivity;
import com.android1604.mustsee.ui.ExploreNewsSubActivity;
import com.android1604.mustsee.ui.SearchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 2016/9/7.
 */
public class ExploreListAdapter extends BaseAdapter {
    private Context mContext;
    private ExploreInfoBean.BodyBean bodyBean;
    private int mGridDataGroup = 0;
    private int mCurGridDataGroup = 0;

    public ExploreListAdapter(Context mContext, ExploreInfoBean.BodyBean bodyBean) {
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
        if (position == 0) {
            view = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_list_hot_view, null);
            setHotTypeData(view);
        }
        if (position == 1) {
            view = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_list_recommend_view, null);
            setRecommendTypeData(view);
        }
        if (position == 2) {
            view = LayoutInflater.from(mContext).inflate(R.layout.fragment_explore_list_found_view, null);
            setFoundTypeData(view);
        }
        return view;
    }

    public void setHotTypeData(View view) {
        final List<ExploreInfoBean.BodyBean.HotSubscribeListBean> curGridAdapterList = new ArrayList<>();
        final List<ExploreInfoBean.BodyBean.HotSubscribeListBean> hotSubscribeList = bodyBean.getHotSubscribeList();
        mGridDataGroup = hotSubscribeList.size()/4;
        curGridAdapterList.clear();
        for (int i = 0; i < 4; i++) {
            curGridAdapterList.add(hotSubscribeList.get(i));
        }
        TextView batchTxt = (TextView) view.findViewById(R.id.fragment_explore_list_hot_item_change_tv);
        GridView mGv = (GridView) view.findViewById(R.id.fragment_explore_list_hot_item_gridview_gv);
        final ExploreListHotGridAdapter gridAdapter = new ExploreListHotGridAdapter(mContext, curGridAdapterList);
        mGv.setAdapter(gridAdapter);
        batchTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurGridDataGroup++;
                mCurGridDataGroup %= mGridDataGroup;
                curGridAdapterList.clear();
                for (int i = 0; i < 4; i++) {
                    curGridAdapterList.add(hotSubscribeList.get(i+mCurGridDataGroup*4));
                }
                gridAdapter.notifyDataSetChanged();
            }
        });
        mGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, ExploreNewsSubActivity.class);
                intent.putExtra("keyword", curGridAdapterList.get(position).getKeyword());
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
                intent.putExtra("keyword", bodyBean.getRecommentList().get(position).getKeyword());
                mContext.startActivity(intent);
            }
        });
    }

    public void setFoundTypeData(View view) {
        ListView mLv = (ListView) view.findViewById(R.id.fragment_explore_list_found_item_list_lv);
        ExploreListFoundListAdapter foundAdapter = new ExploreListFoundListAdapter(mContext, bodyBean.getNewFoundList());
        mLv.setAdapter(foundAdapter);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ExploreInfoBean.BodyBean.NewFoundListBean newsObj = bodyBean.getNewFoundList().get(position);
                int invokeType = newsObj.getInvokeType();
                String keyword = newsObj.getKeyword();
                String docId = newsObj.getDocId();
                String docType = newsObj.getDocType();
                if (invokeType == 95) {
                    Intent intent = new Intent(mContext, ExploreNewsSubActivity.class);
                    intent.putExtra("keyword",keyword);
                    mContext.startActivity(intent);
                } else {
                    Intent intent = new Intent(mContext, ContentDetailsActivity.class);
                    intent.putExtra("docId", docId);
                    intent.putExtra("docType", docType);
                    mContext.startActivity(intent);
                }
            }
        });
    }
}
