package com.android1604.mustsee.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2016/9/9.
 *
 */
public class CustomMyChannelGridView extends GridView {
    public CustomMyChannelGridView(Context context) {
        this(context,null);
    }

    public CustomMyChannelGridView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomMyChannelGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST));
    }
}
