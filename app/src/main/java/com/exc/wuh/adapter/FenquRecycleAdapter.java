package com.exc.wuh.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.exc.api.vo.PartitionhomenewVo;
import com.exc.wuh.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FenquRecycleAdapter extends RecyclerView.Adapter<FenquRecycleAdapter.VH> {

    private List<Integer> imageList;
    private List<String> titleList;
    private List<String> paratitionList;
    private PartitionhomenewVo  paratitionVo;
    private boolean is_surveyTop;//是不是全市概况
    public void FenquRecycleAdapter(){ }
    public void setmDatas(){
        imageList = new ArrayList<Integer>();
        imageList.add(R.mipmap.buildtotalnum);
        imageList.add(R.mipmap.buildtotalnum);
        imageList.add(R.mipmap.group4979);
        imageList.add(R.mipmap.energy_total);

        titleList = new ArrayList<String>();
        titleList.add("建筑总数:");
        titleList.add("离线建筑:");
        titleList.add("在线率:");
//        titleList.add("能耗总数:");

        notifyDataSetChanged();
    }

    public void refreshDatas(PartitionhomenewVo vo ,boolean is_surveyTop){
        this.is_surveyTop = is_surveyTop;
        paratitionList = new ArrayList<String>();
        float pressent =0;
        if(vo.getTotalNum() !=0 ){
            pressent = (float) vo.getOnlineNum() / vo.getTotalNum() * 100;
        }
        DecimalFormat decimalFormat =new DecimalFormat("0");
        String distanceString = decimalFormat.format(pressent) + "%";
        paratitionList.add(String.valueOf(vo.getTotalNum()));
        paratitionList.add(String.valueOf(vo.getOfflineNum()));
        paratitionList.add(distanceString);
//        paratitionList.add(vo.getTotalEnergy() + "kwh");

        this.paratitionVo = vo;
        notifyDataSetChanged();
    }
    //③ 在Adapter中实现3个方法
    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_fenqurecycle_item, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

        holder.title.setText(titleList.get(position));
        holder.img.setImageResource(imageList.get(position));
        holder.content.setText("");
        if(this.paratitionVo != null){
            holder.content.setText(paratitionList.get(position));
        }
        if(this.is_surveyTop){
            if(holder.getAdapterPosition() == 1 || holder.getAdapterPosition() == 2){
                holder.itemView.setVisibility(View.INVISIBLE);
            }
        }else {
            holder.itemView.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            //item 点击事件
            public void onClick(View v) {
                itemHolderClick(holder);
            }
        });

    }
    public void itemHolderClick(VH holder){

    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    //② 创建ViewHolder 绑定item元素
    public static class VH extends RecyclerView.ViewHolder{
        public  TextView title;
        public  TextView content;
        public  ImageView img;

        public VH(View v) {
            super(v);
            title =  v.findViewById(R.id.fenqu_title);
            img=v.findViewById(R.id.headimg);
            content = v.findViewById(R.id.fenqu_content);
        }
    }
}

