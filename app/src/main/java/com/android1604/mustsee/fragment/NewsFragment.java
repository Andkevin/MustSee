package com.android1604.mustsee.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android1604.mustsee.R;
import com.android1604.mustsee.bean.NewsBean;
import com.android1604.mustsee.presenter.INewsPresenter;
import com.android1604.mustsee.presenter.impl.NewsPresenterImpl;
import com.android1604.mustsee.view.INewsView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements INewsView{

    private Context mContext;
    private PullToRefreshListView mListView;
    private INewsPresenter newsPresenter;
    private int indexId;
    private int lastId;
    private ListViewAdapter mAdapter;

    public static NewsFragment newInstance(Bundle bundle) {
        NewsFragment fragment = new NewsFragment();
        if(bundle != null){
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsPresenter = new NewsPresenterImpl(this);
        Bundle bundle = getArguments();
        if(bundle != null){
            return;
        }
        String category = bundle.getString("category","");
        String keyword = bundle.getString("keyword","");
        String srpId = bundle.getString("srpId","");
        newsPresenter.getNewsList(category,keyword,srpId,indexId,lastId);
        mContext = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        mListView = (PullToRefreshListView) view.findViewById(R.id.information_list_lv);
        return view;
    }

    @Override
    public void refreshView(List<NewsBean.BodyBean.NewsListBean> newsList) {
        mAdapter = new ListViewAdapter(newsList);
        mListView.setAdapter(mAdapter);
    }


    class ListViewAdapter extends BaseAdapter{
        private List<NewsBean.BodyBean.NewsListBean> newsList;
        public static final int TYPE_VER = 0;
        public static final int TYPE_HOR = 1;
        public static final int TYPE_BIG = 2;
        public static final int TYPE_PICTURE = 3;
        public static final int TYPE_VIDEO = 4;
        public static final int TYPE_SIZE = 5;

        public ListViewAdapter(List<NewsBean.BodyBean.NewsListBean> newsList) {
            this.newsList = newsList;
        }

        @Override
        public int getCount() {
            return newsList == null ? 0 : newsList.size();
        }

        @Override
        public Object getItem(int position) {
            return newsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getViewTypeCount() {
            return TYPE_SIZE;
        }

        @Override
        public int getItemViewType(int position) {
            String viewType = newsList.get(position).getViewType();
            String footType = newsList.get(position).getFootView().getFootType();
            switch (viewType){
                case "11":
                    return TYPE_HOR;
                case "13":
                    return TYPE_VER;
                case "10":
                    if(footType.equals("4")){
                        return TYPE_PICTURE;
                    }
                    return TYPE_BIG;
                case "80":
                    return TYPE_VIDEO;
            }
            return TYPE_HOR;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            int itemViewType = getItemViewType(position);
            switch (itemViewType){
                case TYPE_VER:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.information_list_ver_item,parent,false);
                    TextView verTitleTxt = (TextView) convertView.findViewById(R.id.item_ver_title_tv);
                    ImageView imageOne = (ImageView) convertView.findViewById(R.id.item_ver_image1_iv);
                    ImageView imageTwo = (ImageView) convertView.findViewById(R.id.item_ver_image2_iv);
                    ImageView imageThree = (ImageView) convertView.findViewById(R.id.item_ver_image3_iv);
                    TextView verFromTxt = (TextView) convertView.findViewById(R.id.item_ver_from_tv);
                    verTitleTxt.setText(newsList.get(position).getTitle());
                    verFromTxt.setText(newsList.get(position).getFootView().getSource());
                    Picasso.with(mContext).load(newsList.get(position).getImage().get(0)).into(imageOne);
                    Picasso.with(mContext).load(newsList.get(position).getImage().get(1)).into(imageTwo);
                    Picasso.with(mContext).load(newsList.get(position).getImage().get(2)).into(imageThree);
                    break;
                case TYPE_HOR:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.information_list_hor_item,parent,false);
                    ImageView imageView = (ImageView) convertView.findViewById(R.id.item_hor_image_iv);
                    TextView horTitleTxt = (TextView) convertView.findViewById(R.id.item_hor_title_tv);
                    TextView horFromTxt = (TextView) convertView.findViewById(R.id.item_hor_from_tv);
                    horTitleTxt.setText(newsList.get(position).getTitle());
                    horFromTxt.setText(newsList.get(position).getFootView().getSource());
                    Picasso.with(mContext).load(newsList.get(position).getImage().get(0)).into(imageView);
                    break;
                case TYPE_BIG:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.information_list_big_item,parent,false);
                    TextView bigTitleTxt = (TextView) convertView.findViewById(R.id.item_big_title_tv);
                    ImageView bigImage = (ImageView) convertView.findViewById(R.id.item_big_image_iv);
                    TextView bigFromTxt = (TextView) convertView.findViewById(R.id.item_big_from_tv);
                    bigTitleTxt.setText(newsList.get(position).getTitle());
                    bigFromTxt.setText(newsList.get(position).getFootView().getSource());
                    Picasso.with(mContext).load(newsList.get(position).getBigImgUrl()).into(bigImage);
                    break;
                case TYPE_PICTURE:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.information_list_picture_item,parent,false);
                    TextView picTitleTxt = (TextView) convertView.findViewById(R.id.item_picture_title_tv);
                    ImageView image = (ImageView) convertView.findViewById(R.id.item_picture_iv);
                    TextView picPraiseTxt = (TextView) convertView.findViewById(R.id.item_picture_praise_tv);
                    TextView picCommentTxt = (TextView) convertView.findViewById(R.id.item_picture_comment_tv);
                    picTitleTxt.setText(newsList.get(position).getTitle());
                    picPraiseTxt.setText(newsList.get(position).getFootView().getUpCount());
                    picCommentTxt.setText(newsList.get(position).getFootView().getCommentCount());
                    Picasso.with(mContext).load(newsList.get(position).getBigImgUrl()).into(image);
                    break;
                case TYPE_VIDEO:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.information_list_video_item,parent,false);
                    TextView vidTitleTxt = (TextView) convertView.findViewById(R.id.item_video_title_tv);
                    TextView vidTimeTxt = (TextView) convertView.findViewById(R.id.item_video_time_tv);
                    ImageView vidImage = (ImageView) convertView.findViewById(R.id.item_video_image_iv);
                    TextView vidPraiseTxt = (TextView) convertView.findViewById(R.id.item_video_praise_tv);
                    TextView vidCommentTxt = (TextView) convertView.findViewById(R.id.item_video_comment_tv);
                    vidTitleTxt.setText(newsList.get(position).getTitle());
                    vidTimeTxt.setText(newsList.get(position).getDuration());
                    vidPraiseTxt.setText(newsList.get(position).getFootView().getUpCount());
                    vidCommentTxt.setText(newsList.get(position).getFootView().getCommentCount());
                    Picasso.with(mContext).load(newsList.get(position).getBigImgUrl()).into(vidImage);
                    break;
            }
            return convertView;
        }
    }
}
