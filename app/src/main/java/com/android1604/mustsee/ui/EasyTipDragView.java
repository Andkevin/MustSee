package com.android1604.mustsee.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android1604.mustsee.R;
import com.android1604.mustsee.adapter.AbsChannelAdapter;
import com.android1604.mustsee.adapter.MyChannelAdapter;
import com.android1604.mustsee.adapter.PushChannelAdapter;
import com.android1604.mustsee.bean.PushChannelBean;
import com.android1604.mustsee.bean.TabTitlesBean;
import com.android1604.mustsee.presenter.impl.ChannelPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wenhuaijun on 2016/5/27 0027.
 *
 */
public class EasyTipDragView extends RelativeLayout implements AbsChannelAdapter.DragDropListener, MyChannelItemView.OnDeleteClickListener, View.OnClickListener{
    private CustomPushChannelGridView mPushGridView;
    private List<PushChannelBean.BodyBean.DataListBean> pushDatas = new ArrayList<>();
    private ImageView closeImg;
    private Context mContext;
    private ArrayList<TabTitlesBean.BodyBean.DataListBean> lists;
    private OnDataChangeResultCallback dataResultCallback;
    private OnCompleteCallback completeCallback;
    private boolean isOpen= false;
    private TextView manageTxt;
    private PushChannelAdapter mPushChannelAdapter;
    private MyChannelAdapter mMyChannelAdapter;
    private DragDropGirdView mMyGridView;
    private int current;

    public EasyTipDragView(Context context) {
        this(context,null);
    }

    public EasyTipDragView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public EasyTipDragView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EasyTipDragView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
        initView();
    }

    private void initView(){
        if(isInEditMode()){
            return ;
        }
        close();
        mMyChannelAdapter = new MyChannelAdapter(getContext(),this,this);
        mMyChannelAdapter.setFirtDragStartCallback(new MyChannelAdapter.OnFirstDragStartCallback() {
            @Override
            public void firstDragStartCallback() {
                //第一次开始拖动item触发回调
                closeImg.setVisibility(View.GONE);
                manageTxt.setText("完成");
            }
        });
        mPushChannelAdapter = new PushChannelAdapter(mContext,pushDatas);
        //加载view
        View view  = LayoutInflater.from(getContext()).inflate(R.layout.easy_tag_drag_view,this);
        closeImg =(ImageView)view.findViewById(R.id.drag_close_img);
        manageTxt =(TextView)view.findViewById(R.id.channel_manage_txt);
        mMyGridView =(DragDropGirdView)view.findViewById(R.id.channel_my_gv);
        mMyGridView.getDragDropController().addOnDragDropListener(mMyChannelAdapter);
        mMyGridView.setDragShadowOverlay((ImageView) view.findViewById(R.id.tile_drag_shadow_overlay));
        mMyGridView.setAdapter(mMyChannelAdapter);
        mPushGridView =(CustomPushChannelGridView)view.findViewById(R.id.channel_push_gv);

        mPushGridView.setAdapter(mPushChannelAdapter);
        mPushGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == mPushChannelAdapter.getData().size()-1){
                    Intent intent = new Intent(mContext,AllSubActivity.class);
                    mContext.startActivity(intent);
                    return;
                }
                String category = mPushChannelAdapter.getData().get(position).getCategory();
                String keyword = mPushChannelAdapter.getData().get(position).getKeyword();
                String srpId = mPushChannelAdapter.getData().get(position).getSrpId();
                TabTitlesBean.BodyBean.DataListBean bean = new TabTitlesBean.BodyBean.DataListBean();
                bean.setCategory(category);
                bean.setKeyword(keyword);
                bean.setSrpId(srpId);
                mMyChannelAdapter.getData().add(bean);
                mMyChannelAdapter.refreshData();
                mPushChannelAdapter.getData().remove(position);
                mPushChannelAdapter.refreshData();
                mMyChannelAdapter.setCurrent(mMyChannelAdapter.getData().size()-1);
                ChannelPresenterImpl.addChannel(category,keyword,srpId);
            }
        });
        closeImg.setOnClickListener(this);
        manageTxt.setTag("manage");
        manageTxt.setOnClickListener(this);
    }

    @Override
    public DragDropGirdView getDragDropGirdView() {
        return mMyGridView;
    }

    public void setCurrent(int current){
        this.current = current;
        mMyChannelAdapter.setCurrent(current);
        mMyChannelAdapter.refreshData();
    }

    @Override
    public void onDataSetChangedForResult(ArrayList<TabTitlesBean.BodyBean.DataListBean> lists) {
        this.lists =lists;
        if(dataResultCallback!=null){
            dataResultCallback.onDataChangeResult(lists);
        }
    }

    @Override
    public void onDeleteClick(TabTitlesBean.BodyBean.DataListBean entity, int position, View view) {
        TabTitlesBean.BodyBean.DataListBean bean = mMyChannelAdapter.getData().get(position);
        String category = bean.getCategory();
        String keyword = bean.getKeyword();
        String srpId = bean.getSrpId();
        if(category != null && keyword != null && srpId != null) {
            mMyChannelAdapter.getData().remove(position);
            mMyChannelAdapter.refreshData();
            ChannelPresenterImpl.deleteChannel(category,keyword,srpId);
        }
    }
    public void setDragData(List<TabTitlesBean.BodyBean.DataListBean> tips){
        mMyChannelAdapter.setData(tips);
    }

    public void setPushDatas(List<PushChannelBean.BodyBean.DataListBean> pushChannels){
        pushDatas.addAll(pushChannels);
    }


    public void setDataResultCallback(OnDataChangeResultCallback dataResultCallback) {
        this.dataResultCallback = dataResultCallback;
    }
    public void setOnCompleteCallback(OnCompleteCallback callback){
        this.completeCallback =callback;
    }

    public void setSelectedListener(MyChannelItemView.OnSelectedListener selectedListener) {
        mMyChannelAdapter.setItemSelectedListener(selectedListener);
    }
    public void close(){
        setVisibility(View.GONE);
        isOpen =false;
    }
    public void open(){
        setVisibility(View.VISIBLE);
        isOpen =true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.drag_close_img:
                //关闭，不回调数据
                close();
                break;
            case R.id.channel_manage_txt:
                String tag = (String) manageTxt.getTag();
                switch (tag){
                    case "manage":
                        manageTxt.setText("完成");
                        manageTxt.setTag("complete");
                        mMyChannelAdapter.startEdittingStatus(v);
                        break;
                    case "complete":
                        //完成关闭，回调数据
                        manageTxt.setTag("manage");
                        manageTxt.setText("管理");
                        mMyChannelAdapter.cancelEditingStatus();
                        if(completeCallback!=null){
                            completeCallback.onComplete(lists);
                        }
                        break;
                }
        }
    }
    //每次由于拖动排序,添加或者删除item时会回调
    public interface OnDataChangeResultCallback{
        void onDataChangeResult(ArrayList<TabTitlesBean.BodyBean.DataListBean> tips);
    }
    //在最后点击"完成"关闭EasyTipDragView时回调
    public interface OnCompleteCallback{
        void onComplete(ArrayList<TabTitlesBean.BodyBean.DataListBean> tips);
    }

    public boolean isOpen() {
        return isOpen;
    }
    //点击返回键监听
    public boolean onKeyBackDown(){
        //如果处于编辑模式，则取消编辑模式
        if(mMyChannelAdapter.isEditing()){
            mMyChannelAdapter.cancelEditingStatus();
            return true;
        }else{
            //关闭该view
            close();
            return false;
        }
    }


}
