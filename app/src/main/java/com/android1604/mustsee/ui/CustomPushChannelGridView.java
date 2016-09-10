package com.android1604.mustsee.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2016/9/9.
 *
 */
public class CustomPushChannelGridView extends GridView {
    public CustomPushChannelGridView(Context context) {
        super(context);
    }

    public CustomPushChannelGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomPushChannelGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST));
    }
}
