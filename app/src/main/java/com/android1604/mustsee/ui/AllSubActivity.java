package com.android1604.mustsee.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android1604.mustsee.BaseActivity;
import com.android1604.mustsee.R;
import com.android1604.mustsee.bean.AllSubLeftBean;
import com.android1604.mustsee.bean.AllSubRightBean;
import com.android1604.mustsee.presenter.IAllSubPresenter;
import com.android1604.mustsee.presenter.impl.AllSubPresenterImpl;
import com.android1604.mustsee.view.IAllSubView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AllSubActivity extends BaseActivity implements IAllSubView{

    private IAllSubPresenter allSubPresenter;
    private ImageView backImage;
    private ListView mLeftListView;
    private ListView mRightListView;
    private List<AllSubLeftBean.BodyBean.DataListBean> leftDatas = new ArrayList<>();
    private List<AllSubRightBean.BodyBean.DataListBean> rightDatas = new ArrayList<>();
    private LeftAdapter mLeftAdapter;
    private int curPosition;
    private RightAdapter mRightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_sub);
        initView();
        allSubPresenter = new AllSubPresenterImpl(this);
        allSubPresenter.getLeftList();
    }

    private void initView() {
        backImage = (ImageView) findViewById(R.id.all_sub_back_iv);
        mLeftListView = (ListView) findViewById(R.id.all_sub_left_list_lv);
        mLeftAdapter = new LeftAdapter();
        mLeftListView.setAdapter(mLeftAdapter);
        mRightListView = (ListView) findViewById(R.id.all_sub_right_list_lv);
        mRightAdapter = new RightAdapter();
        mRightListView.setAdapter(mRightAdapter);
        initListener();
    }

    private void initListener() {
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mLeftListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                curPosition = position;
                mLeftAdapter.changeSelected(curPosition);
                String parentId = leftDatas.get(position).getCateId();
                allSubPresenter.getRightList(parentId);
            }
        });

        mRightListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String keyword = rightDatas.get(position).getKeyword();
                Intent intent = new Intent(AllSubActivity.this,ExploreNewsSubActivity.class);
                intent.putExtra("keyword",keyword);
                startActivity(intent);
            }
        });

    }


    @Override
    public void refreshLeftList(List<AllSubLeftBean.BodyBean.DataListBean> leftDataList) {
        leftDatas.addAll(leftDataList);
        mLeftAdapter.notifyDataSetChanged();
        allSubPresenter.getRightList(leftDatas.get(0).getCateId());
    }

    @Override
    public void refreshRightList(List<AllSubRightBean.BodyBean.DataListBean> rightDataList) {
        rightDatas.clear();
        rightDatas.addAll(rightDataList);
        mRightAdapter.notifyDataSetChanged();
    }


    class LeftAdapter extends BaseAdapter{
        private int mSelect = 0;
        @Override
        public int getCount() {
            return leftDatas == null ? 0 : leftDatas.size();
        }

        @Override
        public Object getItem(int position) {
            return leftDatas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if(convertView == null){
                convertView = LayoutInflater.from(AllSubActivity.this).inflate(R.layout.all_sub_left_list_item, parent, false);
            }
            view = convertView;
            TextView textView = (TextView) view.findViewById(R.id.all_sub_left_txt);
            textView.setText(leftDatas.get(position).getCateName());
            if(mSelect==position) {
                textView.setTextColor(Color.RED);
                textView.setBackgroundColor(Color.WHITE);
            }else{
                textView.setTextColor(Color.BLACK);
            }
            return view;
        }

        public void changeSelected(int positon){
            if(positon != mSelect){
                mSelect = positon;
                notifyDataSetChanged();
            }
        }
    }

    class RightAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return rightDatas == null ? 0 : rightDatas.size();
        }

        @Override
        public Object getItem(int position) {
            return rightDatas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder viewHolder;
            if(convertView == null){
                convertView = LayoutInflater.from(AllSubActivity.this).inflate(R.layout.all_sub_right_list_item,parent,false);
                viewHolder = new ViewHolder(convertView);
            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }
            String logo = rightDatas.get(position).getLogo();
            final String category = rightDatas.get(position).getCategory();
            final String keyword = rightDatas.get(position).getKeyword();
            final String srpId = rightDatas.get(position).getSrpId();
            final String subscriber = rightDatas.get(position).getSubscriber();
            viewHolder.keyword.setText(keyword);
            Picasso.with(AllSubActivity.this).load(logo).into(viewHolder.logo);
            switch (subscriber){
                case "1":
                    viewHolder.addImage.setImageResource(R.drawable.subscribe_cancel01);
                    break;
                case "0":
                default:
                    viewHolder.addImage.setImageResource(R.drawable.subscribe_add01);
                    break;
            }
            viewHolder.addImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (subscriber){
                        case "1":
                            viewHolder.addImage.setImageResource(R.drawable.subscribe_add01);
                            AllSubPresenterImpl.subDeleteChannel(category,keyword,srpId);
                            break;
                        case "0":
                            viewHolder.addImage.setImageResource(R.drawable.subscribe_cancel01);
                            AllSubPresenterImpl.subAddChannel(category, keyword,srpId);
                            break;
                    }
                }
            });
            return convertView;
        }

        class ViewHolder{
            private ImageView logo;
            private TextView keyword;
            private ImageView addImage;

            public ViewHolder(View view) {
                this.logo = (ImageView) view.findViewById(R.id.all_sub_right_logo_iv);
                this.keyword = (TextView) view.findViewById(R.id.all_sub_right_keyword_txt);
                this.addImage = (ImageView) view.findViewById(R.id.all_sub_right_add_iv);
                view.setTag(this);
            }

        }
    }

}
