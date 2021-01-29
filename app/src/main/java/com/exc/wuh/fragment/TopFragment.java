package com.exc.wuh.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.exc.api.vo.PartitionhomenewVo;
import com.exc.wuh.MapTypeDemo;
import com.exc.wuh.R;
import com.exc.wuh.adapter.FenquRecycleAdapter;

public class TopFragment extends Fragment {
    private View rootView;
    private View topView;
    private View Bmapview;
    private FenquRecycleAdapter adapter;
    private RecyclerView mRecyclerView;
    private TextView close_fragment;
    private TextView fenqu_describution;
    private TextView fenqu_titleview;
    private TextView fenqu_textview;
    private TextView nenghao_textview;
    private View group_searchview;
    private Integer partitionId;
    private Integer partitionCount;
    private boolean is_surveyTop;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == rootView) {
            createView(inflater, container);
        }
        ViewGroup viewGroup = (ViewGroup) rootView.getParent();
        if (null != viewGroup) {
            viewGroup.removeAllViewsInLayout();
        }
        return rootView;
    }
    /**
     * 如果已经创建,不需要重复创建
     */
    private void createView(LayoutInflater inflater, ViewGroup parent) {
        rootView = inflater.inflate(R.layout.activity_topfragment,parent, false);
        topView = getActivity().findViewById(R.id.topview);

        fenqu_titleview = rootView.findViewById(R.id.fenqu_titleview);
        fenqu_textview = rootView.findViewById(R.id.fenqu_textview);
        fenqu_describution = rootView.findViewById(R.id.fenqu_contentview);
        close_fragment = rootView.findViewById(R.id.close_fragment);
        group_searchview = getActivity().findViewById(R.id.group_searchview);
        Bmapview = getActivity().findViewById(R.id.bmapView);
        nenghao_textview = rootView.findViewById(R.id.fenqu_content);
        close_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topView.setVisibility(View.INVISIBLE);
                group_searchview.setVisibility(View.VISIBLE);
                ((MapTypeDemo)getActivity()).clearMapview(true);
            }
        });
        topView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topView.setVisibility(View.INVISIBLE);
                group_searchview.setVisibility(View.VISIBLE);
                ((MapTypeDemo)getActivity()).clearMapview(false);
                if(!is_surveyTop){
                    ((MapTypeDemo)getActivity()).fenqutotal(partitionId);
                }
            }
        });

        mRecyclerView = rootView.findViewById(R.id.fenqu_recycleview);
        GridLayoutManager manager = new GridLayoutManager(getActivity(),3);
        mRecyclerView.setLayoutManager(manager);

        adapter = new FenquRecycleAdapter();
        adapter.setmDatas();
        mRecyclerView.setAdapter(adapter);
    }

    public void refreshUI(PartitionhomenewVo vo,boolean is_surveyTop){
        vo.setTotalNum(this.partitionCount!=null?this.partitionCount:0);
        this.is_surveyTop = is_surveyTop;
        String ss = vo.getDescription().toString();
        adapter.refreshDatas(vo,is_surveyTop);
        fenqu_describution.setText(vo.getDescription().toString());
        nenghao_textview.setText(String.valueOf(vo.getTotalEnergy()) + "kwh");
        if(is_surveyTop){
            fenqu_titleview.setText("武汉市总览");
            fenqu_textview.setText("项目概况");
        }else {
            fenqu_titleview.setText("分区总览");
            fenqu_textview.setText("分区介绍");
        }
    }

    public void setPartitionId(Integer partitionId){
        this.partitionId = partitionId;
    }
    public void setPartitionCount(Integer partitionCount){
        this.partitionCount = partitionCount;
    }
}
