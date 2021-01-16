 package com.exc.wuh.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.exc.api.vo.ListBuildingVo;
import com.exc.api.vo.SjcityvideogetVo;
import com.exc.wuh.MapTypeDemo;
import com.exc.wuh.R;

import java.text.SimpleDateFormat;
import java.util.Date;

 public class leftFragment extends Fragment {
    private View rootView;
    private View rightRootview;
    private View leftview;
    private View rightview;
    private TextView closeBtn;
    private TextView buildingDetailBtn;
    private TextView buildingPhotosBtn;
    private TextView address ;
    private TextView name ;
    private TextView phonenum ;
    private TextView lightstyle ;
    private TextView buildname ;
    private TextView screenstyle ;
//    private TextView startBtn;
//    private TextView stopBtn;
    private View scanImageview;
    private View smallviewRecycleview;
    private ViewPager bigviewPager;
    private TextView close_scanImageview;
    private ImageView default_smallimage;
    private TextView imagetitle;
    private ImageView basetitle;
    private TextView buildDetail;
    private TextView buildPhoto;
    private TextView videodescription;

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
        rootView = inflater.inflate(R.layout.activity_leftfragment,parent, false);
        leftview = getActivity().findViewById(R.id.leftview);
        rightview = getActivity().findViewById(R.id.rightview);
        scanImageview = getActivity().findViewById(R.id.scanPhotosview);
        smallviewRecycleview = getActivity().findViewById(R.id.mybanner);
        bigviewPager = getActivity().findViewById(R.id.bigview_pager);
        close_scanImageview = getActivity().findViewById(R.id.close_scanPhotosview);
        default_smallimage = getActivity().findViewById(R.id.default_smallimgage);
        basetitle = getActivity().findViewById(R.id.scanphoto_baseTitle);
        buildDetail = getActivity().findViewById(R.id.scanphoto_buildingDetail);
        buildPhoto = getActivity().findViewById(R.id.scanphoto_buildingPhotos);

        address = rootView.findViewById(R.id.address);
        name = rootView.findViewById(R.id.name);
        phonenum = rootView.findViewById(R.id.phonenum);
        lightstyle = rootView.findViewById(R.id.lightstyle);
        buildname = rootView.findViewById(R.id.buildname);
        screenstyle = rootView.findViewById(R.id.screenstyle);
        buildingDetailBtn = rootView.findViewById(R.id.buildingDetail);
        buildingPhotosBtn = rootView.findViewById(R.id.buildingPhotos);
        closeBtn =rootView.findViewById(R.id.cancel_button);
//        startBtn =rootView.findViewById(R.id.start);
//        stopBtn =rootView.findViewById(R.id.stop);
        videodescription = rootView.findViewById(R.id.videodescription);


        buildingDetailBtn.setSelected(true);
//        startBtn.setSelected(true);

        //建筑详情
        buildingDetailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildingDetailBtn.setSelected(true);
                buildingPhotosBtn.setSelected(false);

                buildDetail.setSelected(true);
                buildPhoto.setSelected(false);
                rightview.setVisibility(View.INVISIBLE);
            }
        });
        //楼宇相册
        buildingPhotosBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                buildingPhotosBtn.setSelected(true);
                buildingDetailBtn.setSelected(false);

                buildDetail.setSelected(false);
                buildPhoto.setSelected(true);

                ((MapTypeDemo)getActivity()).initPhotosView();

                scanImageview.setVisibility(View.VISIBLE);
                smallviewRecycleview.setVisibility(View.VISIBLE);
                bigviewPager.setVisibility(View.VISIBLE);
                close_scanImageview.setVisibility(View.VISIBLE);
                basetitle.setVisibility(View.VISIBLE);
                buildDetail.setVisibility(View.VISIBLE);
                buildPhoto.setVisibility(View.VISIBLE);
            }
        });

        buildDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildingDetailBtn.setSelected(true);
                buildingPhotosBtn.setSelected(false);

                scanImageview.setVisibility(View.INVISIBLE);
                smallviewRecycleview.setVisibility(View.INVISIBLE);
                bigviewPager.setVisibility(View.INVISIBLE);
                close_scanImageview.setVisibility(View.INVISIBLE);
                default_smallimage.setVisibility(View.INVISIBLE);
                basetitle.setVisibility(View.INVISIBLE);
                buildDetail.setVisibility(View.INVISIBLE);
                buildPhoto.setVisibility(View.INVISIBLE);
            }
        });


        //关闭相册
        close_scanImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanImageview.setVisibility(View.INVISIBLE);
                smallviewRecycleview.setVisibility(View.INVISIBLE);
                bigviewPager.setVisibility(View.INVISIBLE);
                close_scanImageview.setVisibility(View.INVISIBLE);
                default_smallimage.setVisibility(View.INVISIBLE);
                buildingPhotosBtn.setSelected(false);
                buildingDetailBtn.setSelected(true);
                basetitle.setVisibility(View.INVISIBLE);
                buildDetail.setVisibility(View.INVISIBLE);
                buildPhoto.setVisibility(View.INVISIBLE);
            }
        });
        //关闭对话框
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftview.setVisibility(View.INVISIBLE);
                rightview.setVisibility(View.INVISIBLE);
                rootView.setVisibility(View.INVISIBLE);
            }
        });

        //开启
//        startBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startBtn.setSelected(!startBtn.isSelected());
//                stopBtn.setSelected(false);
//
//                ((MapTypeDemo)getActivity()).electricitybuildingchannelHttp(1);
//            }
//        });
//
//        //关闭
//        stopBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                stopBtn.setSelected(!stopBtn.isSelected());
//                startBtn.setSelected(false);
//
//                ((MapTypeDemo)getActivity()).electricitybuildingchannelHttp(0);
//            }
//        });

        leftview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void refreshUI(){
        SjcityvideogetVo getvo = ((MapTypeDemo)getActivity()).sjcityvideogetVo;
        if(getvo.getBuilding() != null)
        {
            int buildingTypeSn = getvo.getBuilding().getBuildingTypeSn();
            String buildType = "其它建筑物";
            switch (buildingTypeSn){
                case 3://联机建筑物
                    buildType = "联机建筑物";
                    break;
                case 4://动态建筑物
                    buildType = "动态建筑物";
                    break;
                case 5://开关建筑物
                    buildType = "开关建筑物";
                    break;
                case 6://桥梁建筑物
                    buildType = "桥梁建筑物";
                    break;
                default:
            }


            //建筑名称、地址、建筑类型、竣工时间、楼宇总功率、网络控制方式、强电控制
            address.setText("建筑名称：" + getvo.getBuilding().getName());
            name.setText("地址：" + getvo.getBuilding().getAddr());
            phonenum.setText("建筑类型：" + buildType );
            lightstyle.setText("竣工时间："+ getDateToString(getvo.getBuilding().getBecompleted()));
            buildname.setText("楼宇总功率：" + getvo.getBuilding().getPower() + "KW");
            screenstyle.setText("网络控制方式：" + getvo.getBuilding().getControl());
            videodescription.setText(getvo.getBuilding().getDescription());

            rootView.setVisibility(View.VISIBLE);
            leftview.setVisibility(View.VISIBLE);
        }
    }

    public static String getDateToString(long milSecond) {
        Date date = new Date(milSecond);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
