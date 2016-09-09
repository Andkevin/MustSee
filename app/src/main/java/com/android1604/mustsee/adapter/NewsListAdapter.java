package com.android1604.mustsee.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.android1604.mustsee.R;
import com.android1604.mustsee.bean.NewsBean;
import com.squareup.picasso.Picasso;

import java.util.List;



/**
 * Created by Administrator on 2016/9/8.
 */
public class NewsListAdapter extends BaseAdapter implements View.OnClickListener {
    private static final String TAG = "zengzhen";
    private List<NewsBean.BodyBean.NewsListBean> newsList;
    private Context mContext;
    public static final int TYPE_VER = 0;
    public static final int TYPE_HOR = 1;
    public static final int TYPE_BIG = 2;
    public static final int TYPE_PICTURE = 3;
    public static final int TYPE_VIDEO = 4;
    public static final int TYPE_SIZE = 5;
    private VideoView videoView;
    private ImageView vidImage;
    private TextView vidTitleTxt;
    private TextView vidTimeTxt;
    private ImageView vidPlay;

    public NewsListAdapter(Context mContext, List<NewsBean.BodyBean.NewsListBean> newsList) {
        this.mContext = mContext;
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
        switch (viewType) {
            case "11":
                return TYPE_HOR;
            case "13":
                return TYPE_VER;
            case "10":
                if (footType.equals("4")) {
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
        switch (itemViewType) {
            case TYPE_VER:
                convertView = LayoutInflater.from(mContext).inflate(R.layout.information_list_ver_item, parent, false);
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
                convertView = LayoutInflater.from(mContext).inflate(R.layout.information_list_hor_item, parent, false);
                ImageView imageView = (ImageView) convertView.findViewById(R.id.item_hor_image_iv);
                TextView horTitleTxt = (TextView) convertView.findViewById(R.id.item_hor_title_tv);
                TextView horFromTxt = (TextView) convertView.findViewById(R.id.item_hor_from_tv);
                horTitleTxt.setText(newsList.get(position).getTitle());
                horFromTxt.setText(newsList.get(position).getFootView().getSource());
                if (newsList.get(position).getImage() == null || newsList.get(position).getImage().size() == 0) {
                    imageView.setVisibility(View.GONE);
                } else {
                    Picasso.with(mContext).load(newsList.get(position).getImage().get(0)).into(imageView);
                }
                break;
            case TYPE_BIG:
                convertView = LayoutInflater.from(mContext).inflate(R.layout.information_list_big_item, parent, false);
                TextView bigTitleTxt = (TextView) convertView.findViewById(R.id.item_big_title_tv);
                ImageView bigImage = (ImageView) convertView.findViewById(R.id.item_big_image_iv);
                TextView bigFromTxt = (TextView) convertView.findViewById(R.id.item_big_from_tv);
                bigTitleTxt.setText(newsList.get(position).getTitle());
                bigFromTxt.setText(newsList.get(position).getFootView().getSource());
                if (!"".equals(newsList.get(position).getImage()) && newsList.get(position).getImage() != null) {
                    Log.d(TAG, "getView: " + newsList.get(position).getBigImgUrl());
                    Picasso.with(mContext).load(newsList.get(position).getBigImgUrl()).into(bigImage);
                } else {
                    bigImage.setVisibility(View.GONE);
                }
                break;
            case TYPE_PICTURE:
                convertView = LayoutInflater.from(mContext).inflate(R.layout.information_list_picture_item, parent, false);
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
                convertView = LayoutInflater.from(mContext).inflate(R.layout.information_list_video_item, parent, false);
                vidTitleTxt = (TextView) convertView.findViewById(R.id.item_video_title_tv);
                vidTimeTxt = (TextView) convertView.findViewById(R.id.item_video_time_tv);
                vidImage = (ImageView) convertView.findViewById(R.id.item_video_image_iv);
                vidPlay = (ImageView) convertView.findViewById(R.id.item_video_play_iv);
                TextView vidPraiseTxt = (TextView) convertView.findViewById(R.id.item_video_praise_tv);
                TextView vidCommentTxt = (TextView) convertView.findViewById(R.id.item_video_comment_tv);
                videoView = (VideoView) convertView.findViewById(R.id.item_video_vv);
                videoView.setVideoURI(Uri.parse(newsList.get(position).getPhoneImageUrl()));
                vidTitleTxt.setText(newsList.get(position).getTitle());
                vidTimeTxt.setText(newsList.get(position).getDuration());
                vidPraiseTxt.setText(newsList.get(position).getFootView().getUpCount());
                vidCommentTxt.setText(newsList.get(position).getFootView().getCommentCount());
                Picasso.with(mContext).load(newsList.get(position).getBigImgUrl()).into(vidImage);
                vidImage.setOnClickListener(this);
                break;
        }
        return convertView;
    }

    @Override
    public void onClick(View view) {
        vidImage.setVisibility(View.GONE);
        vidTitleTxt.setVisibility(View.GONE);
        vidTimeTxt.setVisibility(View.GONE);
        vidPlay.setVisibility(View.GONE);
        MediaController controller = new MediaController(mContext);
        videoView.setMediaController(controller);
        videoView.start();
    }
}
