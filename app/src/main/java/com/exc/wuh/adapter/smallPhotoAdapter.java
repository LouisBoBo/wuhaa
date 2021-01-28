package com.exc.wuh.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.exc.api.ApiUrl;
import com.exc.api.vo.SjcityvideogetVo;
import com.exc.utils.GlideShowUtil;
import com.exc.wuh.MapTypeDemo;
import com.exc.wuh.R;

import java.util.ArrayList;
import java.util.List;

public class smallPhotoAdapter extends RecyclerView.Adapter<smallPhotoAdapter.VH> {
    private List<SjcityvideogetVo.BuildingBean.ImageListBean> imageList;
    private Context DemoConext;

    public void setmDatas(SjcityvideogetVo sjcityvideogetVo, Context Demo) {
        imageList = sjcityvideogetVo.getBuilding().getImageList();
        DemoConext = Demo;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public smallPhotoAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_smallphoto_item, parent, false);
        return new smallPhotoAdapter.VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        SjcityvideogetVo.BuildingBean.ImageListBean bean = imageList.get(position);
        String url = ApiUrl.IMAGE_SERVICES_ADDRESS + bean.getPhotoName() + "." + bean.getFileType();
        holder.img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        GlideShowUtil.showImage(DemoConext, holder.img, url, R.mipmap.icon_smallnormal_none, R.mipmap.icon_smallnormal_none);

        String name = bean.getRealName().replace(".jpg","");
        name.replace(".png","");
        holder.imagename.setText(name);

        if (bean.getSelect()) {
            holder.itemView.setBackgroundResource(R.drawable.background_photo_selector);
        } else {
            holder.itemView.setBackgroundResource(R.drawable.background_photo_unselector);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            //item 点击事件
            public void onClick(View v) {
                itemHolderClick(holder);
            }
        });
    }

    @SuppressLint("ResourceType")
    public void itemHolderClick(smallPhotoAdapter.VH holder) {

        for (int i = 0; i < imageList.size(); i++) {
            if (holder.getAdapterPosition() == i) {
                imageList.get(holder.getAdapterPosition()).setSelect(true);
            } else {
                imageList.get(i).setSelect(false);
            }
        }

//        if(MapTypeDemo.isSmallImgClick ){
            MapTypeDemo.setCurrentBigImg(holder.getPosition());
//        }else{
//            notifyDataSetChanged();
//
//        }



        Log.i("sjfasj", "点击了");
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    //② 创建ViewHolder 绑定item元素
    public static class VH extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView imagename;

        public VH(View v) {
            super(v);
            img = v.findViewById(R.id.smallImage);
            imagename = v.findViewById(R.id.imagename);
        }
    }

    public void refreshUI(int position) {
        for (int i = 0; i < imageList.size(); i++) {
            if (position == i) {
                imageList.get(position).setSelect(true);
            } else {
                imageList.get(i).setSelect(false);
            }
        }
        notifyDataSetChanged();
    }
}
