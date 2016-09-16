package com.android1604.mustsee.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android1604.mustsee.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {
    private Context mContext;

    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_main_page, container, false);
        return view;
    }

}
