package com.android1604.mustsee.adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.android1604.mustsee.R;
import com.android1604.mustsee.bean.TabTitlesBean;
import com.android1604.mustsee.ui.DragDropGirdView;
import com.android1604.mustsee.ui.MyChannelItemView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/10.
 * 
 */
public class MyChannelAdapter extends AbsChannelAdapter implements View.OnLongClickListener, MyChannelItemView.OnDeleteClickListener {
    private boolean  isEditing =false;
    private static final ClipData EMPTY_CLIP_DATA = ClipData.newPlainText("", "");
    private MyChannelItemView.OnSelectedListener mListener;
    private MyChannelItemView.OnDeleteClickListener deleteClickListener;
    private OnFirstDragStartCallback callback;
    private int current;

    public MyChannelAdapter(Context context, AbsChannelAdapter.DragDropListener dragDropListener, MyChannelItemView.OnDeleteClickListener deleteClickListener) {
        super(context, dragDropListener);
        this.deleteClickListener =deleteClickListener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyChannelItemView view =null;
        if(convertView!=null&&convertView instanceof MyChannelItemView){
            view =(MyChannelItemView)convertView;
        }else{
            view = (MyChannelItemView)View.inflate(mContext, R.layout.channel_my_list_item, null);
        }
        if(isEditing && position >= 2){
            view.showDeleteImg();
        }else{
            view.hideDeleteImg();
        }
        if(current == position){
            view.setFlag(true);
        }else{
            view.setFlag(false);
        }
        //设置点击监听
        view.setItemListener(position, mListener);
        view.setOnLongClickListener(this);
        //设置删除监听
        view.setDeleteClickListener(position, deleteClickListener);
        //绑定数据
        view.renderData(getItem(position));
        return view;
    }

    @Override
    protected TabTitlesBean.BodyBean.DataListBean getDragEntity(View view) {
        return ((MyChannelItemView)view).getDragEntity();
    }

    public void setItemSelectedListener(MyChannelItemView.OnSelectedListener mListener){
        this.mListener =mListener;
    }
    @Override
    public boolean onLongClick(View v) {
        //开启编辑模式
        startEdittingStatus(v);
        return true;
    }
    //删除按钮点击时
    @Override
    public void onDeleteClick(TabTitlesBean.BodyBean.DataListBean entity, int position, View view) {
        channels.remove(position);
        refreshData();

    }

    public void setCurrent(int current){
        this.current = current;
    }
    public void refreshData(){
        notifyDataSetChanged();
        mDragDropListener.onDataSetChangedForResult(channels);
    }
    public ArrayList<TabTitlesBean.BodyBean.DataListBean> getData(){
        return channels;
    }
    public void setFirtDragStartCallback(OnFirstDragStartCallback callback) {
        this.callback = callback;
    }

    public interface OnFirstDragStartCallback {
        void firstDragStartCallback();
    }

    public boolean isEditing() {
        return isEditing;
    }

    public void cancelEditingStatus(){
        isEditing =false;
        notifyDataSetChanged();
    }
    public void startEdittingStatus(View v){
        if(!isEditing){
            isEditing =true;
            if(callback!=null){
                callback.firstDragStartCallback();
            }
            notifyDataSetChanged();

        }
        v.startDrag(EMPTY_CLIP_DATA, new View.DragShadowBuilder(),
                DragDropGirdView.DRAG_FAVORITE_TILE, 0);
    }

}
