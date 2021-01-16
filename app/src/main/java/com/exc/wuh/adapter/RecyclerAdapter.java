package com.exc.wuh.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.exc.api.vo.BaseVo;
import com.exc.api.vo.PartitionBuildVo;
import com.exc.api.vo.PartitionFindlistVo;
import com.exc.api.vo.PartitionQueryVo;
import com.exc.wuh.R;
import com.exc.wuh.bean.User;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.VH> {
    private List<User> mUsers;
    private PartitionFindlistVo partitionlist;
    private List<PartitionQueryVo> querylist;
    private List<PartitionBuildVo> partitionBuildVoList;
    private int styleType; //1分区 2站点 3建筑 4建设单位
    private List<Integer>selectIds;

    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener {
        void onItemPartitionClick(List<Integer> ids,int type,int select_id);  //分区
        void onItemSiteClick(List<Integer> ids,int type,int select_id);       //站点
    }

    public RecyclerAdapter(){ }
    public void setmDatas(List<User> data){
        this.mUsers = data;
        notifyDataSetChanged();
    }
    public void setPartitionBuildVo(List<PartitionBuildVo> data){
        this.styleType =4;
        this.partitionBuildVoList = data;
        notifyDataSetChanged();
    }
    public void setpartitionBulidlist(PartitionFindlistVo data){
        this.styleType =3;
        this.partitionlist = data;
        notifyDataSetChanged();
    }
    public void setquerylist(List<PartitionQueryVo> data){
        this.styleType =1;
        this.querylist = data;
        notifyDataSetChanged();
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener = listener;
    }
    //③ 在Adapter中实现3个方法
    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycle_item, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

        if(this.styleType == 1){
            holder.content.setText(querylist.get(position).getName());

            boolean is_select = querylist.get(holder.getAdapterPosition()).isSelect();
            holder.img.setImageResource(is_select?R.mipmap.newselect: R.mipmap.newunselect);
        }else if(this.styleType == 3) {
            List<PartitionFindlistVo.ListBean> list = partitionlist.getList();
            holder.content.setText(list.get(position).getName());

            boolean is_select = partitionlist.getList().get(holder.getAdapterPosition()).isSelect();
            holder.img.setImageResource(is_select?R.mipmap.newselect: R.mipmap.newunselect);
        }else if(this.styleType == 4){
            holder.content.setText(partitionBuildVoList.get(position).getName());
            boolean is_select = partitionBuildVoList.get(holder.getAdapterPosition()).isSelect();
            holder.img.setImageResource(is_select?R.mipmap.newselect: R.mipmap.newunselect);
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

        if(this.styleType == 1)
        {
            boolean is_select = querylist.get(holder.getAdapterPosition()).isSelect();
            if(is_select){
                holder.img.setImageResource(R.mipmap.newunselect);
                querylist.get(holder.getAdapterPosition()).setSelect(false);
            }else {
                holder.img.setImageResource(R.mipmap.newselect);
                querylist.get(holder.getAdapterPosition()).setSelect(true);
            }

        }else if(this.styleType == 3) {
            boolean is_select = partitionlist.getList().get(holder.getAdapterPosition()).isSelect();
            if(is_select){
                holder.img.setImageResource(R.mipmap.newunselect);
                partitionlist.getList().get(holder.getAdapterPosition()).setSelect(false);
            }else {
                holder.img.setImageResource(R.mipmap.newselect);
                partitionlist.getList().get(holder.getAdapterPosition()).setSelect(true);
            }
        }else if(this.styleType == 4){
            boolean is_select = partitionBuildVoList.get(holder.getAdapterPosition()).isSelect();
            if(is_select){
                holder.img.setImageResource(R.mipmap.newunselect);
                partitionBuildVoList.get(holder.getAdapterPosition()).setSelect(false);
            }else {
                holder.img.setImageResource(R.mipmap.newselect);
                partitionBuildVoList.get(holder.getAdapterPosition()).setSelect(true);
            }
        }

        getSelectIDs(holder.getAdapterPosition());
    }

    public void getSelectIDs(int selectid){
        this.selectIds = new ArrayList<Integer>();

        if(this.styleType == 1){
            for (int i=0;i<querylist.size();i++)
            {
                boolean is_select = querylist.get(i).isSelect();
                if(is_select){
                    this.selectIds.add(querylist.get(i).getId());
                }
            }
            onItemClickListener.onItemSiteClick(this.selectIds,this.styleType,selectid);
        }else if(this.styleType == 3) {

            for(int i=0;i<partitionlist.getList().size();i++)
            {
                boolean is_select = partitionlist.getList().get(i).isSelect();
                if(is_select){
                    this.selectIds.add(partitionlist.getList().get(i).getId());
                }
            }
            onItemClickListener.onItemSiteClick(this.selectIds,this.styleType,selectid);
        }else if(this.styleType == 4){
            for (int i=0;i<partitionBuildVoList.size();i++)
            {
                boolean is_select = partitionBuildVoList.get(i).isSelect();
                if(is_select){
                    this.selectIds.add(partitionBuildVoList.get(i).getId());
                }
            }
            onItemClickListener.onItemSiteClick(this.selectIds,1,selectid);
        }

    }
    @Override
    public int getItemCount() {

        if(this.styleType == 1){
            return querylist ==null?0:querylist.size();
        }else if(this.styleType == 3){
            return partitionlist==null?0:partitionlist.getList().size();
        }else {
            return partitionBuildVoList==null?0:partitionBuildVoList.size();
        }
    }

    //② 创建ViewHolder 绑定item元素
    public static class VH extends RecyclerView.ViewHolder{
        public final TextView content;
        public ImageView img;
        public boolean isclick;
        public VH(View v) {
            super(v);
            content =  v.findViewById(R.id.textView);
            img=v.findViewById(R.id.imageView);
            isclick = false;
        }
    }
}
