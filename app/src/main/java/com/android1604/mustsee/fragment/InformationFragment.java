package com.android1604.mustsee.fragment;


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

import com.android1604.mustsee.R;
import com.android1604.mustsee.presenter.IInformationPresenter;
import com.android1604.mustsee.presenter.impl.InformationPresenterImpl;
import com.android1604.mustsee.view.IInformationView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformationFragment extends Fragment implements IInformationView,View.OnClickListener {

    private IInformationPresenter informationPresenter;
    private TabLayout mTab;
    private List<String> titleList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPagerAdapter mAdapter;

    public static InformationFragment newInstance() {
        return new InformationFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        informationPresenter = new InformationPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        mTab = (TabLayout) view.findViewById(R.id.information_tab_layout);
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.information_vp);
        ImageView addChannel = (ImageView) view.findViewById(R.id.information_add_iv);
        addChannel.setOnClickListener(this);
        informationPresenter.getTabTiles();
        mAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTab.setupWithViewPager(mViewPager);
        return view;
    }

    @Override
    public void refreshTabLayout(String title,Bundle bundle) {
        mTab.addTab(mTab.newTab().setText(title));
        titleList.add(title);
        fragmentList.add(NewsFragment.newInstance(bundle));
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        //TODO
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
