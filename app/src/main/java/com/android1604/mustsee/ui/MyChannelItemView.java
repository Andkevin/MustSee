package com.android1604.mustsee.ui;

import android.content.ClipData;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android1604.mustsee.R;
import com.android1604.mustsee.adapter.AbsChannelAdapter;
import com.android1604.mustsee.bean.TabTitlesBean;

/**
 * Created by Administrator on 2016/9/10.
 *
 */
public class MyChannelItemView extends RelativeLayout {
    private final static String TAG = MyChannelItemView.class.getSimpleName();
    private static final ClipData EMPTY_CLIP_DATA = ClipData.newPlainText("", "");
    protected OnSelectedListener mListener;
    protected OnDeleteClickListener mDeleteListener;
    private TabTitlesBean.BodyBean.DataListBean mIDragEntity;
    private TextView title;
    private ImageView delete;
    private int position;
    private boolean flag;

    public MyChannelItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(createClickListener());
        title = (TextView) findViewById(R.id.channel_my_list_txt);
        delete = (ImageView) findViewById(R.id.tagview_delete);

    }

    protected View.OnClickListener createClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (delete.isShown()) {
                    //编辑模式下删除item
                    if (mDeleteListener != null) {
                        mDeleteListener.onDeleteClick(mIDragEntity, position, MyChannelItemView.this);
                    }
                    return;
                }
                //非编辑模式下回调点击item事件
                if (mListener != null) {
                    mListener.onTileSelected(mIDragEntity, position, MyChannelItemView.this);
                }
            }
        };
    }

    public void setFlag(boolean isRed){
        this.flag = isRed;
    }

    public TabTitlesBean.BodyBean.DataListBean getDragEntity() {
        return mIDragEntity;
    }

    public void renderData(TabTitlesBean.BodyBean.DataListBean entity) {
        mIDragEntity = entity;

        if (entity != null && !entity.equals(AbsChannelAdapter.BLANK_ENTRY)) {
            title.setText(mIDragEntity.getKeyword());
            if(flag){
                title.setTextColor(getResources().getColor(R.color.selectedTextColor));
            }else{
                title.setTextColor(getResources().getColor(R.color.colorGray));
            }
            setVisibility(View.VISIBLE);
        } else {
            setVisibility(View.INVISIBLE);
        }
    }


    public void setItemListener(int position, OnSelectedListener listener) {
        mListener = listener;
        this.position = position;
    }

    public void setDeleteClickListener(int position, OnDeleteClickListener listener) {
        this.position = position;
        this.mDeleteListener = listener;
    }


    public interface OnSelectedListener {
        /**
         * Notification that the tile was selected; no specific action is dictated.
         */
        void onTileSelected(TabTitlesBean.BodyBean.DataListBean entity, int position, View view);

    }

    public interface OnDeleteClickListener {
        void onDeleteClick(TabTitlesBean.BodyBean.DataListBean entity, int position, View view);
    }

    public void showDeleteImg() {
        delete.setVisibility(View.VISIBLE);
    }

    public void hideDeleteImg() {
        delete.setVisibility(View.GONE);
    }
}
