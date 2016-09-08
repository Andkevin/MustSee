package com.android1604.mustsee.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListViewUtils {
    public static void reMeasureHeightOnSubList(AbsListView listView){
        ListAdapter adapter = listView.getAdapter();
        if(adapter == null){
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, listView);
            listItem.measure(0,0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
//        layoutParams.height = totalHeight + 100 + (listView.getDividerHeight()*(adapter.getCount()-1));
        layoutParams.height = totalHeight - 600;
        if(listView instanceof ListView){
            layoutParams.height = totalHeight + 300;
        }
        listView.setLayoutParams(layoutParams);
    }
}
