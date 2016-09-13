package com.android1604.mustsee.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android1604.mustsee.R;
import com.android1604.mustsee.presenter.IInformationPresenter;
import com.android1604.mustsee.presenter.impl.InformationPresenterImpl;
import com.android1604.mustsee.ui.ChannelActivity;
import com.android1604.mustsee.ui.SearchActivity;
import com.android1604.mustsee.view.IInformationView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformationFragment extends Fragment implements IInformationView {

    private IInformationPresenter informationPresenter;
    private TabLayout mTab;
    private ArrayList<String> titleList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPagerAdapter mAdapter;
    private Context mContext;
    private ViewPager mViewPager;
    private ImageView addChannel;
    private TextView mSearchTxt;
    private int currentItem = 0;

    public static InformationFragment newInstance() {
        return new InformationFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        informationPresenter = new InformationPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        mTab = (TabLayout) view.findViewById(R.id.information_tab_layout);
        mViewPager = (ViewPager) view.findViewById(R.id.information_vp);
        addChannel = (ImageView) view.findViewById(R.id.information_add_iv);
        mSearchTxt = (TextView) view.findViewById(R.id.information_search_txt);
        mAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTab.setupWithViewPager(mViewPager);
        initListener();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        informationPresenter.getTabTiles();
        informationPresenter.getSearchContent();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStop() {
        super.onStop();
        titleList.clear();
        fragmentList.clear();
    }

    private void initListener() {
        addChannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentItem = mViewPager.getCurrentItem();
                Intent intent = new Intent(mContext, ChannelActivity.class);
                intent.putExtra("currentItem",currentItem);
                startActivityForResult(intent,1);
            }
        });

        mSearchTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SearchActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data != null){
            currentItem = data.getIntExtra("current", 0);
        }
    }

    @Override
    public void refreshTabLayout(Bundle bundle) {
        String title = bundle.getString("title");
        mTab.addTab(mTab.newTab().setText(title));
        titleList.add(title);
        fragmentList.add(NewsFragment.newInstance(bundle));
        mAdapter.notifyDataSetChanged();
        mViewPager.setCurrentItem(currentItem);
    }

    @Override
    public void getSearchContent(String content) {
        mSearchTxt.setText(content);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList == null ? 0 : fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }
}
