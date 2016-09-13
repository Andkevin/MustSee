package com.android1604.mustsee.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android1604.mustsee.R;
import com.android1604.mustsee.adapter.NewsListAdapter;
import com.android1604.mustsee.bean.NewsBean;
import com.android1604.mustsee.presenter.INewsPresenter;
import com.android1604.mustsee.presenter.impl.NewsPresenterImpl;
import com.android1604.mustsee.view.INewsView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements INewsView {

    private static final String TAG = "zengzhen";
    private Context mContext;
    private PullToRefreshListView mListView;
    private INewsPresenter newsPresenter;
    private List<NewsBean.BodyBean.NewsListBean> datas = new ArrayList<>();
    private String indexId = "0";
    private String lastId = "0";
    private NewsListAdapter mAdapter;

    public static NewsFragment newInstance(Bundle bundle) {
        NewsFragment fragment = new NewsFragment();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsPresenter = new NewsPresenterImpl(this);
        mContext = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        mListView = (PullToRefreshListView) view.findViewById(R.id.information_list_lv);
        mListView.setMode(PullToRefreshBase.Mode.BOTH);
        mAdapter = new NewsListAdapter(mContext,datas);
        mListView.setAdapter(mAdapter);
        getDatas();
        initListener();
        return view;
    }

    private void initListener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO
            }
        });

        mListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                indexId = "0";
                lastId = "0";
                datas.clear();
                getDatas();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                refreshView.getLoadingLayoutProxy().setRefreshingLabel("推荐中...");
                refreshView.getLoadingLayoutProxy().setPullLabel("下拉刷新");
                refreshView.getLoadingLayoutProxy().setReleaseLabel("松手刷新");
                lastId = datas.get(datas.size() - 1).getId();
                getDatas();
            }
        });
    }

    private void getDatas(){
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        String category = bundle.getString("category", "");
        String keyword = bundle.getString("keyword", "");
        String srpId = bundle.getString("srpId", "");
        Log.d(TAG, "getDatas: category="+category);
        Log.d(TAG, "getDatas: keyword="+keyword);
        Log.d(TAG, "getDatas: srpId="+srpId);
        Log.d(TAG, "getDatas: indexId="+indexId);
        Log.d(TAG, "getDatas: lastId="+lastId);
        newsPresenter.getNewsList(category, keyword, srpId, indexId, lastId);
    }

    @Override
    public void refreshView(List<NewsBean.BodyBean.NewsListBean> newsList) {
        datas.addAll(newsList);
        mAdapter.notifyDataSetChanged();
        mListView.onRefreshComplete();
    }
}
