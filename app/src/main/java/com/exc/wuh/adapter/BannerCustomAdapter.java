package com.exc.wuh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.exc.wuh.R;
import com.exc.wuh.bean.DataBean;
import com.youth.banner.adapter.BannerAdapter;

import java.util.ArrayList;
import java.util.List;


public class BannerCustomAdapter extends BannerAdapter<DataBean, BannerCustomAdapter.Vh> {
    private Context context;


    public BannerCustomAdapter(List<DataBean> mData, Context context) {
        super(mData);
        this.context = context;
    }

    @Override
    public Vh onCreateHolder(ViewGroup parent, int viewType) {
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        View v = LayoutInflater.from(context).inflate(R.layout.activity_banner, parent, false);
        return new Vh(v);
    }

    @Override
    public void onBindView(Vh holder, DataBean data, int position, int size) {
        if (data.viewType != 1) {
            holder.itemView.setBackgroundResource(R.drawable.shape_border_white);
        } else {
            holder.itemView.setBackgroundResource(R.drawable.shape_border_red);
        }

        //图片加载自己实现
        Glide.with(holder.itemView)
                .load(data.imageUrl)
                .placeholder(R.mipmap.icon_smallnormal_none)
                .into(holder.imageView);
        String photoname = data.title !=null?data.title.replace(".jpg",""):"";
        holder.content.setText(photoname);
    }


    class Vh extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView content;

        public Vh(@NonNull View view) {
            super(view);
            imageView = view.findViewById(R.id.banner_imageView);
            content = view.findViewById(R.id.banner_content);
        }
    }
}

