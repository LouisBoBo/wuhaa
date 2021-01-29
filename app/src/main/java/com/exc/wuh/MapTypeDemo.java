package com.exc.wuh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Point;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.WindowManager;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.badoo.mobile.util.WeakHandler;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.clusterutil.clustering.Cluster;
import com.baidu.mapapi.clusterutil.clustering.ClusterItem;
import com.baidu.mapapi.clusterutil.clustering.ClusterManager;
import com.baidu.mapapi.map.Arc;
import com.baidu.mapapi.map.ArcOptions;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polygon;
import com.baidu.mapapi.map.PolygonOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.map.offline.MKOfflineMap;
import com.baidu.mapapi.map.offline.MKOfflineMapListener;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapapi.search.district.DistrictSearch;
import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.baidu.mapapi.utils.SpatialRelationUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.bumptech.glide.Glide;
import com.exc.api.ApiUrl;
import com.exc.api.CommonMessage;
import com.exc.api.CommonParameterKey;
import com.exc.api.bizimpl.WHImpl;
import com.exc.api.vo.BaseVo;
import com.exc.api.vo.BuildingphotonumVo;
import com.exc.api.vo.BuildingphotouploadVo;
import com.exc.api.vo.CityVideoSrcVo;
import com.exc.api.vo.ElectricitybuildingchannelVo;
import com.exc.api.vo.HomeOverAllVo;
import com.exc.api.vo.ListBuildingVo;
import com.exc.api.vo.PartitionBuildVo;
import com.exc.api.vo.PartitionFindlistVo;
import com.exc.api.vo.PartitionQueryVo;
import com.exc.api.vo.PartitionhomeVo;
import com.exc.api.vo.PartitionhomenewVo;
import com.exc.api.vo.PatitionInfoVo;
import com.exc.api.vo.SjcityvideodownloadTextFileVo;
import com.exc.api.vo.SjcityvideogetVidVo;
import com.exc.api.vo.SjcityvideogetVo;
import com.exc.api.vo.UserLoginVo;
import com.exc.db.BuildingDao;
import com.exc.db.BuildingDetailDao;
import com.exc.db.PartitionDao;
import com.exc.db.WhDb;
import com.exc.utils.CommonParameter;
import com.exc.utils.CustomAlertDialog;
import com.exc.utils.GlideShowUtil;
import com.exc.utils.ToastUtils;
import com.exc.utils.UserInfoUtil;
import com.exc.wuh.DB.DB;
import com.exc.wuh.Dao.UserDao;
import com.exc.wuh.adapter.BannerCustomAdapter;
import com.exc.wuh.adapter.RecyclerAdapter;
import com.exc.wuh.adapter.smallPhotoAdapter;
import com.exc.wuh.bean.DataBean;
import com.exc.wuh.bean.User;
import com.exc.wuh.fragment.leftFragment;
import com.exc.wuh.fragment.rightFragment;
import com.exc.wuh.fragment.TopFragment;
import com.exc.wuh.view.CustomDialog;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.listener.OnPageChangeListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

import static com.baidu.mapapi.utils.CoordinateConverter.CoordType.BD09LL;


/**
 * 基础地图类型
 */
public class MapTypeDemo extends AppCompatActivity {

    private static ViewPager bigviewPager;
    private TextView imagetitle;
    private View scanPhotoview;
    private static boolean isFirstComming;
    private RecyclerView smallImageRecycleview;
    private int select_position;
    public static boolean isSmallImgClick;
    private PolygonOptions oldmPolygonOptions;
    private Polyline mPolyline;
    private Polygon mPolygon;
    private String clickDistrict;
    private LatLng centerlatlng;
    private static boolean isShowPolygon;
    private InfoWindow infoWindow;
    private InfoWindow numinfoWindow;
    private Button popbutton;
    private TextView popnumbutton;
    private Banner<Object, BannerAdapter> banner;//新增
    private BannerCustomAdapter adpter;
    private List<LatLng> centerlatLngList;
    private List<Integer> buildCountList;
    private boolean total_isclear;
    private boolean partition_isclear;
    private boolean city_isclear;

    //ClusterItem接口的实现类
    public class MyItem implements ClusterItem {
        private final LatLng mPosition;//点
        private Bundle buns;//00000000000000000000000000额外信息
        private ListBuildingVo.BuildingListBean building;//建筑信息

        public ListBuildingVo.BuildingListBean getBuilding() {
            return building;
        }

        public MyItem(LatLng latLng, ListBuildingVo.BuildingListBean build) {
            mPosition = latLng;
            building = build;
        }

        @Override
        public LatLng getPosition() {
            return mPosition;
        }

        @Override
        public Bundle getExtraInfo() {
            return buns;
        }

        @Override
        public BitmapDescriptor getBitmapDescriptor() {//点图标
            int buildingTypeSn = building.getBuildingTypeSn();
            int isOnline = building.getIsOnline();
            int image = R.mipmap.newest_other_build;

            switch (buildingTypeSn) {
                case 3://联机建筑物
                    image = R.mipmap.newest_linkage_build;
                    break;
                case 4://动态建筑物
                    image = R.mipmap.newest_dongtai_build;
                    break;
                case 5://开关建筑物
                    image = R.mipmap.newest_switch_build;
                    break;
                case 6://桥梁建筑
                    image = R.mipmap.newest_bridge_build;
                default:
            }
            return BitmapDescriptorFactory.fromResource(image);
        }
    }

    public class PopMyItem implements ClusterItem {
        private final LatLng mPosition;//点
        private Bundle buns;//00000000000000000000000000额外信息
        private ListBuildingVo.BuildingListBean building;//建筑信息

        public ListBuildingVo.BuildingListBean getBuilding() {
            return building;
        }

        public PopMyItem(LatLng latLng, ListBuildingVo.BuildingListBean build) {
            mPosition = latLng;
            building = build;
        }

        @Override
        public LatLng getPosition() {
            return mPosition;
        }

        @Override
        public Bundle getExtraInfo() {
            return buns;
        }

        @Override
        public BitmapDescriptor getBitmapDescriptor() {//点图标
            int buildingTypeSn = building.getBuildingTypeSn();
            int isOnline = building.getIsOnline();
            int image = R.mipmap.newsetother_online;


            //动态创建一个View用于显示位置信息
            TextView popnumbutton = new TextView(getApplicationContext());
            //设置view是背景图片

            popnumbutton.setBackgroundResource(R.drawable.shape_point_normal);
            //设置view的内容（位置信息）
            popnumbutton.setGravity(Gravity.CENTER);
            popnumbutton.setText("888");
            popnumbutton.setTextSize(17);
            popnumbutton.setTextColor(Color.WHITE);

            TextPaint paint = popnumbutton.getPaint();
            paint.setFakeBoldText(true);
            BitmapDescriptor descriptor =  BitmapDescriptorFactory.fromView(popnumbutton);
            return descriptor;
        }
    }

    public class Part {
        private List<List<Float>> points;

        public List<List<Float>> getPoints() {
            return points;
        }

        public void setPoints(List<List<Float>> points) {
            this.points = points;
        }
    }

    // MapView 是地图主控件
    private com.baidu.mapapi.map.MapView mMapView;
    private BaiduMap mBaiduMap;
    private DistrictSearch mDistrictSearch;
    private GeoCoder mCoder;
    private OnGetGeoCoderResultListener listener1;
    private OnGetDistricSearchResultListener searchlistener;
    private ImageView signoutImg;
    private ClusterManager<MyItem> mClusterManager;
    private List<ClusterManager<MyItem>> clusterManagers;
    private List<ClusterManager<PopMyItem>> popclusterManagers;
    private List<Marker> nummarkerList;
    private TextView backcenter;
    private ReverseGeoCodeResult selectreverseGeoCodeResult;
    private LatLng clickpoint;
    private LatLng centerpoint;

    //搜索相关
    private EditText mEditText;
    private RecyclerView mRecyclerView;
    private RecyclerAdapter adapter;
    private AnimationSet animationSet;
    private AnimationSet manimationSet;
    private TranslateAnimation translateAnimation;
    private View group_searchview;

    //列表筛选
    private View selectTagView;
    private TextView fenquTag, constructionTag, jianzuTag, confirmTag, cancleTag, close_recycleview;
    private int select_adapterid;
    private ImageView selectImageview;
    private TextView selectTextview;
    private boolean isfenqu_allselect;//分区是否全选
    private ImageView defaultimg;

    private CustomDialog customDialog;

    //收到消息回主UI刷新界面
    Handler myHandler = new Handler() {
        @SuppressLint("HandlerLeak")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 123://站点
                    buildingDao.insert(partitionlist.getList());

                    break;
                case 456://分区
                    partitionDao.insert(querylist);

                    break;
                case 789://建筑
                    buildingDao.insert(partitionjianzulist.getList());
                    getMarkerbuildData();

                    break;
                case 1012://建筑
                    adapter.setpartitionBulidlist(partitionjianzulist);

                    break;
                case 1011:
                    topview.setVisibility(View.VISIBLE);
                    topFragment.refreshUI(partitionhomenewVo,false);
                    isShowPolygon = true;
                    break;
                case 1013://marker所有建筑
                    buildingDetailDao.insert(buildinglist.getBuildingList());
                    break;
                case 1014:
                    topview.setVisibility(View.VISIBLE);
                    topFragment.refreshUI(partitionhomenewVo,true);
                    break;
                case 1015://画出所有分区的边界
                    surveyTopView();
                    setPopupNumInfo(centerpoint);
                    alldrawPoint();
                    break;
                default:
            }

            super.handleMessage(msg);
        }
    };

    //数据源
    private PartitionFindlistVo partitionjianzulist;//站点数据
    private PartitionFindlistVo orangpartitionjianzulist;//原始站点数据
    private PartitionFindlistVo partitionlist;//站点数据
    private List<PartitionQueryVo> querylist;//分区数据
    private List<PartitionQueryVo> beforequerylist;
    private PartitionFindlistVo beforepartitionjianzulist;
    private PartitionFindlistVo beforepartitionlist;
    private ListBuildingVo buildinglist;//建筑
    private List<CityVideoSrcVo> cityVideoSrcVoList;//节目列表
    private List<BuildingphotonumVo> buildingphotonumVoList; //楼宇相册
    public ListBuildingVo.BuildingListBean selectBuilding;//选择的建筑
    public SjcityvideogetVo sjcityvideogetVo;//建筑详情
    private SjcityvideodownloadTextFileVo sjcityvideodownloadTextFileVo; //节目
    private ElectricitybuildingchannelVo electricitybuildingchannelVo;//建筑物强电
    private List<SjcityvideogetVidVo> SjcityvideogetVidVolist;
    private PartitionhomenewVo partitionhomenewVo;//分区总览
    private List<PartitionhomeVo> partitionhomeVoList;//分区坐标集
    private List<ListBuildingVo> listBuildingVos;
    private BaseVo<HomeOverAllVo> homeOverAllVo;
    private List<PartitionBuildVo> partitionBuildVoList;
    private List<PatitionInfoVo> patitionInfoVoList;

    private List<User> list;
    UserDao dao;
    PartitionDao partitionDao;
    BuildingDao buildingDao;
    BuildingDetailDao buildingDetailDao;

    //网络请求相关
    private WHImpl whBiz;
    private BaseVo<List<PartitionQueryVo>> mVo;
    private BaseVo<UserLoginVo> mUserVo;
    private BaseVo<PartitionFindlistVo> listVo;
    private BaseVo<ListBuildingVo> buildingVo;
    private BaseVo<List<CityVideoSrcVo>> cityVideoVo;
    private BaseVo<SjcityvideogetVo> sjcityvideogetVoBaseVo;
    private BaseVo<ElectricitybuildingchannelVo> buildingchannelVo;
    private BaseVo<List<BuildingphotonumVo>> buildingphotonumVo;
    private BaseVo<SjcityvideodownloadTextFileVo> downTextFile;
    private BaseVo<BuildingphotouploadVo> photouploadVo;
    private BaseVo<List<SjcityvideogetVidVo>> SjcityvideogetVidBaseVo;
    private BaseVo<PartitionhomenewVo> partitionhomenewVoBaseVo;
    private BaseVo<List<PartitionhomeVo>> PartitionhomeBaseVo;

    //fragment
    private leftFragment leftFragment;
    private rightFragment rightFragment;
    private TopFragment topFragment;
    private FrameLayout leftview;
    private FrameLayout rightview;
    private FrameLayout topview;



    private int buildingID; //所选建筑物ID
    //todo 接口回调处理
    private WeakHandler mHandler = new WeakHandler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            customDialog.dismiss();
            switch (msg.what) {
                case CommonMessage.MSG_REQUEST_SUCCESS_1:
                    try {
                        mVo = (BaseVo<List<PartitionQueryVo>>) msg.obj;
                        querylist = mVo.getData();

                        myHandler.sendEmptyMessage(456);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case CommonMessage.MSG_REQUEST_SUCCESS_2:
                    try {
                        listVo = (BaseVo<PartitionFindlistVo>) msg.obj;
                        partitionlist = getNewPartitionFindlistVo(listVo.getData());

                        myHandler.sendEmptyMessage(123);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case CommonMessage.MSG_REQUEST_SUCCESS_3:
                    try {
                        listVo = (BaseVo<PartitionFindlistVo>) msg.obj;
                        orangpartitionjianzulist = getNewPartitionFindlistVo(listVo.getData());
                        partitionjianzulist = orangpartitionjianzulist;

                        myHandler.sendEmptyMessage(789);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case CommonMessage.MSG_REQUEST_SUCCESS_14:
                    try {
                        listVo = (BaseVo<PartitionFindlistVo>) msg.obj;
                        partitionjianzulist = getNewPartitionFindlistVo(listVo.getData());

                        myHandler.sendEmptyMessage(1012);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case CommonMessage.MSG_REQUEST_SUCCESS_4:
                    try {
                        buildingVo = (BaseVo<ListBuildingVo>) msg.obj;
                        buildinglist = buildingVo.getData();

                        markerList(buildinglist,true);
                        myHandler.sendEmptyMessage(1013);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case CommonMessage.MSG_REQUEST_SUCCESS_5:
                    try {
                        cityVideoVo = (BaseVo<List<CityVideoSrcVo>>) msg.obj;
                        cityVideoSrcVoList = cityVideoVo.getData();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case CommonMessage.MSG_REQUEST_SUCCESS_6:
                    try {
                        sjcityvideogetVoBaseVo = (BaseVo<SjcityvideogetVo>) msg.obj;
                        sjcityvideogetVo = sjcityvideogetVoBaseVo.getData();

                        if(sjcityvideogetVo!=null && sjcityvideogetVo.getBuilding() !=null){
                            //刷新界面
                            mRecyclerView.setVisibility(View.GONE);
                            selectTagView.setVisibility(View.GONE);
                            leftview.setVisibility(View.VISIBLE);
                            leftFragment.refreshUI();//刷新建筑详情数据
                        }else {
                            ToastUtils.showToast(MapTypeDemo.this, sjcityvideogetVoBaseVo.getMessage(), false);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case CommonMessage.MSG_REQUEST_SUCCESS_7:
                    try {
                        buildingchannelVo = (BaseVo<ElectricitybuildingchannelVo>) msg.obj;
                        electricitybuildingchannelVo = buildingchannelVo.getData();

                        if (buildingchannelVo.getCode() == 200) {
                            ToastUtils.showToast(MapTypeDemo.this, "下发成功", false);
                        } else {
                            ToastUtils.showToast(MapTypeDemo.this, "下发失败", false);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case CommonMessage.MSG_REQUEST_SUCCESS_8:
                    try {
                        buildingphotonumVo = (BaseVo<List<BuildingphotonumVo>>) msg.obj;
                        buildingphotonumVoList = buildingphotonumVo.getData();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case CommonMessage.MSG_REQUEST_SUCCESS_9:
                    try {
                        photouploadVo = (BaseVo<BuildingphotouploadVo>) msg.obj;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case CommonMessage.MSG_REQUEST_SUCCESS_10:
                    try {
                        downTextFile = (BaseVo<SjcityvideodownloadTextFileVo>) msg.obj;
                        if (downTextFile.getCode() == 200) {
                            sjcityvideodownloadTextFileVo = downTextFile.getData();
                        } else {
                            ToastUtils.showToast(MapTypeDemo.this, downTextFile.getMessage(), false);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case CommonMessage.MSG_REQUEST_SUCCESS_11:
                    try {
                        SjcityvideogetVidBaseVo = (BaseVo<List<SjcityvideogetVidVo>>) msg.obj;
                        SjcityvideogetVidVolist = SjcityvideogetVidBaseVo.getData();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case CommonMessage.MSG_REQUEST_SUCCESS_12:
                    try {
                        partitionhomenewVoBaseVo = (BaseVo<PartitionhomenewVo>) msg.obj;
                        if (partitionhomenewVoBaseVo.getCode() == 200) {
                            partitionhomenewVo = partitionhomenewVoBaseVo.getData();
                            myHandler.sendEmptyMessage(1011);
                        } else {
                            ToastUtils.showToast(MapTypeDemo.this, partitionhomenewVoBaseVo.getMessage(), false);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        ToastUtils.showToast(MapTypeDemo.this, "数据异常", false);
                    }
                    break;
                case CommonMessage.MSG_REQUEST_SUCCESS_13:
                    try {
                        partitionhomeVoList = ((BaseVo<List<PartitionhomeVo>>) msg.obj).getData();
                        if(partitionhomeVoList.size()>0){

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case CommonMessage.MSG_REQUEST_SUCCESS_15:

                    homeOverAllVo = (BaseVo<HomeOverAllVo>) msg.obj;
                    if(homeOverAllVo.getCode() == 200){
                        myHandler.sendEmptyMessage(1015);
                    }
                    break;
                case CommonMessage.MSG_REQUEST_SUCCESS_16:
                    partitionBuildVoList = ((BaseVo<List<PartitionBuildVo>>) msg.obj).getData();
                    break;
                default:
                    showError();
            }
            return false;
        }
    });

    public PartitionQueryVo addQueryFirstItem() {
        PartitionQueryVo vo = new PartitionQueryVo();
        vo.setId(0);
        vo.setName("全选");
        return vo;
    }

    public PartitionFindlistVo getNewPartitionFindlistVo(PartitionFindlistVo vovo) {
        beforepartitionlist = vovo;
        return beforepartitionlist;
    }

    public MapTypeDemo() {
    }


    /**
     * 平板地图--站点
     */
    private void getPartitionFindlistHttp() {
        int[] ids = new int[0];

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(CommonParameterKey.TYPE, 2);       //类型1分区，2站点，3建筑物
        hashMap.put(CommonParameterKey.NAME, "");
        hashMap.put(CommonParameterKey.ID, ids);         //ID数组
        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<PartitionFindlistVo>>() {
        }.getType();

        whBiz.partitionFindlist(mHandler, commonParameter,
                CommonMessage.MSG_REQUEST_SUCCESS_2, CommonMessage.MSG_REQUEST_FAILURE_2, type);
    }

    /**
     * 平板地图--分区
     */
    private void getPartitionQueryHttp() {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(CommonParameterKey.TYPE, 1);       //类型1分区，2站点，3建筑物
        hashMap.put(CommonParameterKey.ID, "");        //ID数组
        hashMap.put(CommonParameterKey.NAME, "");       //建筑名称
        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<List<PartitionQueryVo>>>() {
        }.getType();

        whBiz.partitionQuery(mHandler, commonParameter,
                CommonMessage.MSG_REQUEST_SUCCESS_1, CommonMessage.MSG_REQUEST_FAILURE_1, type);
    }

    /**
     * 建设单位
     */
    private void partitionBuildHttp() {

        HashMap<String, Object> hashMap = new HashMap<>();

        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<List<PartitionBuildVo>>>() {
        }.getType();

        whBiz.partitionBuildHttp(mHandler, commonParameter,
                CommonMessage.MSG_REQUEST_SUCCESS_16, CommonMessage.MSG_REQUEST_FAILURE_16, type);
    }
    /**
     * 平板地图--建筑
     */
    private void getPartitionFindlistjiazuHttp(List<Integer> ids) {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(CommonParameterKey.TYPE, 13);       //类型1分区，2站点，3建筑物
        hashMap.put(CommonParameterKey.NAME, "");
        hashMap.put(CommonParameterKey.ID, ids);         //ID数组
        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<PartitionFindlistVo>>() {
        }.getType();
        if (null != customDialog) {
            customDialog.dismiss();
            customDialog = new CustomDialog(MapTypeDemo.this);
            customDialog.show();
        }
        if (ids.size() > 0) {
            whBiz.partitionFindlist(mHandler, commonParameter,
                    CommonMessage.MSG_REQUEST_SUCCESS_14, CommonMessage.MSG_REQUEST_FAILURE_3, type);
        } else {
            whBiz.partitionFindlist(mHandler, commonParameter,
                    CommonMessage.MSG_REQUEST_SUCCESS_3, CommonMessage.MSG_REQUEST_FAILURE_3, type);
        }

    }

    /**
     * 站点建筑物
     */
    private void findListBuildingHttp(List<Integer> ids, int styletype) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(CommonParameterKey.TYPE, styletype);       //类型1分区，2站点，3建筑物
        hashMap.put(CommonParameterKey.ID, ids);      //ID数组
        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<ListBuildingVo>>() {
        }.getType();
        if (null != customDialog) {
            customDialog.dismiss();
            customDialog = new CustomDialog(MapTypeDemo.this);
            customDialog.show();
        }
        whBiz.partitionFindlistbuilding(mHandler, commonParameter,
                CommonMessage.MSG_REQUEST_SUCCESS_4, CommonMessage.MSG_REQUEST_FAILURE_4, type);
    }

    /**
     * 根据建筑物ID获取节目列表
     */
    private void sjcityvideosrcVideoHttp(int building_id) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(CommonParameterKey.ID, building_id);        //建筑物ID
        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<List<CityVideoSrcVo>>>() {
        }.getType();

        whBiz.sjcityvideosrcVideo(mHandler, commonParameter,
                CommonMessage.MSG_REQUEST_SUCCESS_5, CommonMessage.MSG_REQUEST_FAILURE_5, type);
    }

    /**
     * 建筑物详情
     */
    private void sjcityvideogetHttp(int building_id, String build_name) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(CommonParameterKey.ID, building_id);        //建筑物ID
        hashMap.put(CommonParameterKey.NAME, build_name);      //建筑物详情
        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<SjcityvideogetVo>>() {
        }.getType();
        if (null != customDialog) {
            customDialog.dismiss();
            customDialog = new CustomDialog(MapTypeDemo.this);
            customDialog.show();
        }
        whBiz.sjcityvideoget(mHandler, commonParameter,
                CommonMessage.MSG_REQUEST_SUCCESS_6, CommonMessage.MSG_REQUEST_FAILURE_6, type);
    }

    /**
     * 建筑物强电控制
     */
    public void electricitybuildingchannelHttp(int state) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(CommonParameterKey.ID, buildingID);      //建筑物ID
        hashMap.put(CommonParameterKey.CHANNELTYPEID, 0);    //回路类型id 全关/全开传0 全部设置为0
        hashMap.put(CommonParameterKey.STATE, state);            //开关状态: 0关 1开
        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<ElectricitybuildingchannelVo>>() {
        }.getType();
        if (null != customDialog) {
            customDialog.dismiss();
            customDialog = new CustomDialog(MapTypeDemo.this);
            customDialog.show();
        }
        whBiz.electricitybuildingchannel(mHandler, commonParameter,
                CommonMessage.MSG_REQUEST_SUCCESS_7, CommonMessage.MSG_REQUEST_FAILURE_7, type);
    }

    /**
     * 分区总览
     */
    public void partitionhomenewHttp(int partitionId) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(CommonParameterKey.ID, partitionId);      //分区ID
        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<PartitionhomenewVo>>() {
        }.getType();

        String arg = CommonParameterKey.PARTITIONID + "=" + partitionId;
//        if (null != customDialog) {
//            customDialog.dismiss();
//            customDialog = new CustomDialog(MapTypeDemo.this);
//            customDialog.show();
//        }

        whBiz.partitionhomenew(mHandler,commonParameter,CommonMessage.MSG_REQUEST_SUCCESS_12,CommonMessage.MSG_REQUEST_FAILURE_12,type);
    }

    /**
     * 分区坐标集
     */
    public void partitionhomeHttp() {
        HashMap<String, Object> hashMap = new HashMap<>();
        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<List<PartitionhomeVo>>>() {
        }.getType();

        String arg = "";
        whBiz.partitionhome(mHandler, arg, UserInfoUtil.getToken(this), CommonMessage.MSG_REQUEST_SUCCESS_13, CommonMessage.MSG_REQUEST_FAILURE_13, type);
    }

    /**
     * 各分区建筑
     */
    public void homeeoverallHttp(){
        HashMap<String, Object> hashMap = new HashMap<>();
        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<HomeOverAllVo>>() {
        }.getType();

        if (null != customDialog) {
            customDialog.dismiss();
            customDialog = new CustomDialog(MapTypeDemo.this);
            customDialog.show();
        }
        whBiz.homeeoverallHttp(mHandler, commonParameter,
                CommonMessage.MSG_REQUEST_SUCCESS_15, CommonMessage.MSG_REQUEST_FAILURE_15, type);
    }
    /**
     * 楼宇相册
     */
    public void buildingphotonumHttp() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(CommonParameterKey.TYPE, 1);               //建筑物ID
        hashMap.put(CommonParameterKey.BUILDINGNUM, "");    //回路类型id 全关/全开传0 全部设置为0
        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<List<BuildingphotonumVo>>>() {
        }.getType();

        whBiz.buildingphotonum(mHandler, commonParameter,
                CommonMessage.MSG_REQUEST_SUCCESS_8, CommonMessage.MSG_REQUEST_FAILURE_8, type);
    }

    /**
     * 图片上传
     */
    private void photouploadHttp() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(CommonParameterKey.FILETYPE, 1);        //文件类型 1 图片 2文档
        hashMap.put(CommonParameterKey.FILE, "");            //图片文件
        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<BuildingphotouploadVo>>() {
        }.getType();

        whBiz.buildingphotonum(mHandler, commonParameter,
                CommonMessage.MSG_REQUEST_SUCCESS_9, CommonMessage.MSG_REQUEST_FAILURE_9, type);
    }

    /**
     * 节目切换
     */
    private void downloadTextFileHttp(CityVideoSrcVo videoSrcVo) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(CommonParameterKey.BUILDINGID, buildingID);        //建筑ID
        hashMap.put(CommonParameterKey.DURATION, videoSrcVo.getDuration());    //播放时长
        hashMap.put(CommonParameterKey.FILENAME, videoSrcVo.getName());        //节目名称
        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<SjcityvideodownloadTextFileVo>>() {
        }.getType();

        whBiz.sjcityvideodownloadTextFile(mHandler, commonParameter,
                CommonMessage.MSG_REQUEST_SUCCESS_10, CommonMessage.MSG_REQUEST_FAILURE_10, type);
    }

    /**
     * 获取正在播放的节目信息
     */
    private void sjcityvideogetVidHttp() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(CommonParameterKey.VIDNAME, "");        //节目名称
        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<SjcityvideodownloadTextFileVo>>() {
        }.getType();

        whBiz.sjcityvideogetVid(mHandler, commonParameter,
                CommonMessage.MSG_REQUEST_SUCCESS_11, CommonMessage.MSG_REQUEST_FAILURE_11, type);
    }

    /**
     * 获取正在播放的节目
     */
    private void scriptplaytimeHttp() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(CommonParameterKey.NODEID, "");        //节点ID
        hashMap.put(CommonParameterKey.BUILDINGID, buildingID);        //节点ID
        hashMap.put(CommonParameterKey.SITEIDARRAY, new ArrayList<String>());        //节点ID
        CommonParameter commonParameter = new CommonParameter(this, hashMap);
        Type type = new TypeToken<BaseVo<SjcityvideodownloadTextFileVo>>() {
        }.getType();

    }

    //todo 请求出错时处理
    private void showError() {

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isFirstComming = true;
        isSmallImgClick = false;
        isShowPolygon = false;
        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        copyToDevice(getApplicationContext());

        partitionDao = WhDb.getInstance(this).getPartitionDao();
        buildingDao = WhDb.getInstance(this).getBuildingDao();
        buildingDetailDao = WhDb.getInstance(this).getBuildingDetailDao();
        whBiz = WHImpl.getInstance();

        initOffLineMap();
        initMapView();
        initSearchView();
        DistrictSearch();
        initData();
        initFragment();
    }

    /**
     * 构建离线地图
     */
    public void initOffLineMap() {
        MKOfflineMap mOffline = new MKOfflineMap();
        mOffline.init(new MKOfflineMapListener() {
            @Override
            public void onGetOfflineMapState(int i, int i1) {

            }
        });
    }

    /**
     * 构建地图
     */
    public void initMapView() {
        setContentView(R.layout.activity_map_type);
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        signoutImg = findViewById(R.id.signoutImg);
        //初始化点聚合管理类
        mClusterManager = new ClusterManager<MyItem>(this, mBaiduMap);

        // 构建地图状态
        MapStatus.Builder builder = new MapStatus.Builder();
        // 默认 天安门
        LatLng center = new LatLng(30.52, 114.31);
        centerpoint = center;
        // 默认 11级
        float zoom = 10.00001f;

        builder.target(center).zoom(zoom);
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(builder.build());

        // 设置地图状态
        mBaiduMap.setMapStatus(mapStatusUpdate);

        BaiduMap.OnMapClickListener listener = new BaiduMap.OnMapClickListener() {
            /**
             * 地图单击事件回调函数
             *
             * @param point 点击的地理坐标
             */
            @Override
            public void onMapClick(LatLng point) {
                clickpoint = point;
                hideInput();
                clickdrawPoint(point);
            }

            /**
             * 地图内 Poi 单击事件回调函数
             *
             * @param mapPoi 点击的 poi 信息
             */
            @Override
            public void onMapPoiClick(MapPoi mapPoi) {
                hideInput();
            }

        };

        BaiduMap.OnMapStatusChangeListener listener1 = new BaiduMap.OnMapStatusChangeListener() {
            /**
             * 手势操作地图，设置地图状态等操作导致地图状态开始改变。
             *
             * @param status 地图状态改变开始时的地图状态
             */
            @Override
            public void onMapStatusChangeStart(MapStatus status) {
                Log.i("sjfasj", "状态开始改变");
            }

            /**
             * 手势操作地图，设置地图状态等操作导致地图状态开始改变。
             *
             * @param status 地图状态改变开始时的地图状态
             *
             * @param reason 地图状态改变的原因
             */

            //用户手势触发导致的地图状态改变,比如双击、拖拽、滑动底图
            //int REASON_GESTURE = 1;
            //SDK导致的地图状态改变, 比如点击缩放控件、指南针图标
            //int REASON_API_ANIMATION = 2;
            //开发者调用,导致的地图状态改变
            //int REASON_DEVELOPER_ANIMATION = 3;
            @Override
            public void onMapStatusChangeStart(MapStatus status, int reason) {
                Log.i("sjfasj", "ok");
            }

            /**
             * 地图状态变化中
             *
             * @param status 当前地图状态
             */
            @Override
            public void onMapStatusChange(MapStatus status) {
                Log.i("sjfasj", "变化中");
            }

            /**
             * 地图状态改变结束
             *
             * @param status 地图状态改变结束后的地图状态
             */
            @Override
            public void onMapStatusChangeFinish(MapStatus status) {
                Log.i("sjfasj", "改变结束");
            }
        };
        //设置地图状态监听
        mBaiduMap.setOnMapStatusChangeListener(listener1);

        //设置地图单击事件监听
        mBaiduMap.setOnMapClickListener(listener);

        mBaiduMap.setOnMapStatusChangeListener(mClusterManager);
        // 设置maker点击时的响应
        mBaiduMap.setOnMarkerClickListener(mClusterManager);

        //点击建筑物数量
        mClusterManager.setOnClusterClickListener(new ClusterManager.OnClusterClickListener<MyItem>() {
            @Override
            public boolean onClusterClick(Cluster<MyItem> cluster) {
                Toast.makeText(MapTypeDemo.this,
                        "有" + cluster.getSize() + "个点", Toast.LENGTH_SHORT).show();

                LatLng latLng = new LatLng(cluster.getPosition().latitude, cluster.getPosition().longitude);
                performZoomIn(latLng);

                return false;
            }
        });

        //点击建筑物
        mClusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<MyItem>() {
            @Override
            public boolean onClusterItemClick(MyItem item) {

                if(mPolygon != null){
                    mPolygon.remove();//先清除以前的边界
                }

                topview.setVisibility(View.INVISIBLE);
                group_searchview.setVisibility(View.VISIBLE);
                selectreverseGeoCodeResult = null;

                selectBuilding = item.getBuilding();
                buildingID = selectBuilding.getId();

                getSupportFragmentManager().beginTransaction().replace(R.id.leftview, leftFragment).commitAllowingStateLoss();
                getSupportFragmentManager().beginTransaction().replace(R.id.rightview, rightFragment).commitAllowingStateLoss();

                sjcityvideogetHttp(selectBuilding.getId(), selectBuilding.getName());

                return false;
            }
        });

        //退出登录
        signoutImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MapTypeDemo.this, LoginActivity.class);
                startActivity(intent);
                finish();

                mBaiduMap.clear();
                mBaiduMap.hideInfoWindow();
            }
        });
    }

    class Pp {
        public float getLat() {
            return lat;
        }

        public void setLat(float lat) {
            this.lat = lat;
        }

        public float getLng() {
            return lng;
        }

        public void setLng(float lng) {
            this.lng = lng;
        }

        private float lat;
        private float lng;
    }


    //画边界
    public void alldrawPoint(){
        if(mPolygon != null){
            mPolygon.remove();//先清除以前的边界
        }
        buildCountList = new ArrayList<>();
        centerlatLngList = new ArrayList<>();

        String pos = "";
        for (int i = 0; i < homeOverAllVo.getData().getPartition().size(); i++) {
            String name = homeOverAllVo.getData().getPartition().get(i).getName();
            for (PatitionInfoVo patitionInfoVo : patitionInfoVoList) {
                String partname = patitionInfoVo.getName();
                if(name.equals(partname)){
                    pos = homeOverAllVo.getData().getPartition().get(i).getCoordinate();

                    List<List<Float>> ps = new Gson().fromJson(pos, new TypeToken<List<List<Float>>>() {
                    }.getType());
                    if (ps == null) {
                        continue;
                    }

                    List<LatLng> points = new ArrayList<>();
                    for (int j = 0; j < ps.size(); j++) {
                        LatLng latLng = new LatLng(ps.get(j).get(1), ps.get(j).get(0));

                        points.add(latLng);
                    }

                    if(points.size()>5)
                    {
                        //构造PolygonOptions
                        oldmPolygonOptions = new PolygonOptions()
                                .points(points)
                                .fillColor(patitionInfoVo.getBcoclor()) //填充颜色
                                .stroke(new Stroke(5, 000000)); //边框宽度和颜色
                        //在地图上显示多边形
                        mPolygon = (Polygon) mBaiduMap.addOverlay(oldmPolygonOptions);
                        mPolygon.setZIndex(-99999);

                        if(homeOverAllVo.getData().getPartition().get(i).getHierarchy() == 2){
                            mPolygon.setZIndex(0);
                        }
                    }

                    break;
                }
            }

            //获取分区边界的中心点
            if(homeOverAllVo.getData().getPartition().get(i).getCentralPoint() !=null)
            {
                String list[] = homeOverAllVo.getData().getPartition().get(i).getCentralPoint().split(",");
                double lat = convertToDouble(list[0],2021);
                double lnt = convertToDouble(list[1],2021);
                LatLng centerlatlng = new LatLng(lnt, lat);

                centerlatLngList.add(centerlatlng);
                buildCountList.add(homeOverAllVo.getData().getPartition().get(i).getCount());
            }
        }

        markerCenterList(centerlatLngList,buildCountList);
    }
    //把String转化为double
    public static double convertToDouble(String number, double defaultValue) {
        if (TextUtils.isEmpty(number)) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(number);
        } catch (Exception e) {
            return defaultValue;
        }

    }

    public void clickdrawPoint(LatLng point) {

        String pos = "";
        for (int i = 1; i < homeOverAllVo.getData().getPartition().size(); i++) {
            pos = homeOverAllVo.getData().getPartition().get(i).getCoordinate();

            List<List<Float>> ps = new Gson().fromJson(pos, new TypeToken<List<List<Float>>>() {
            }.getType());
            if (ps == null) {
                continue;
            }

            List<LatLng> points = new ArrayList<>();
            for (int j = 0; j < ps.size(); j++) {
                LatLng latLng = new LatLng(ps.get(j).get(1), ps.get(j).get(0));
                points.add(latLng);
            }

            boolean result = SpatialRelationUtil.isPolygonContainsPoint(points, point);

            LatLng centerlatlng = new LatLng(0,0);
            int partitionCount = 0;
            int partitionId = 0;
            if (result) {

                //获取点击的分区名称
                clickDistrict = homeOverAllVo.getData().getPartition().get(i).getName();

                //获取分区边界的中心点
                String list[] = homeOverAllVo.getData().getPartition().get(i).getCentralPoint().split(",");
                if(list.length >1){
                    double lat = convertToDouble(list[0],2021);
                    double lnt = convertToDouble(list[1],2021);
                    centerlatlng = new LatLng(lnt, lat);
                }

                partitionCount = homeOverAllVo.getData().getPartition().get(i).getCount();
                partitionId = homeOverAllVo.getData().getPartition().get(i).getId();

                for(int k=0;k<homeOverAllVo.getData().getPartition().size();k++){
                    boolean top_result = false;

                    //分区边界是否悬浮 优先级最高优先处理
                    if(homeOverAllVo.getData().getPartition().get(k).getHierarchy() == 2){
                        String top_pos = homeOverAllVo.getData().getPartition().get(k).getCoordinate();
                        List<List<Float>> top_ps = new Gson().fromJson(top_pos, new TypeToken<List<List<Float>>>() {
                        }.getType());

                        if(top_pos.length() > 10){
                            List<LatLng> top_points = new ArrayList<>();
                            for (int j = 0; j < top_ps.size(); j++) {
                                LatLng latLng = new LatLng(top_ps.get(j).get(1), top_ps.get(j).get(0));
                                top_points.add(latLng);
                            }
                            top_result = SpatialRelationUtil.isPolygonContainsPoint(top_points,point);

                            if(top_result){
                                clickDistrict= homeOverAllVo.getData().getPartition().get(k).getName();
                                partitionCount = homeOverAllVo.getData().getPartition().get(k).getCount();
                                partitionId = homeOverAllVo.getData().getPartition().get(k).getId();

                                points = top_points;
                                //获取分区边界的中心点
                                if(homeOverAllVo.getData().getPartition().get(k).getCentralPoint() !=null)
                                {
                                    String lalist[] = homeOverAllVo.getData().getPartition().get(k).getCentralPoint().split(",");
                                    double latp = convertToDouble(lalist[0],2021);
                                    double lntp = convertToDouble(lalist[1],2021);
                                    centerlatlng = new LatLng(lntp, latp);
                                }
                                break;
                            }
                        }

                    }
                }

                if(mPolygon != null){
                    mPolygon.remove();//先清除以前的边界
                }

                //构造PolygonOptions
                oldmPolygonOptions = new PolygonOptions()
                        .points(points)
                        .fillColor(0x4DD58462) //填充颜色
                        .stroke(new Stroke(5, 0xAAD58462)); //边框宽度和颜色
                //在地图上显示多边形
                mPolygon = (Polygon) mBaiduMap.addOverlay(oldmPolygonOptions);
                mPolygon.setZIndex(-99999);

                //在地图上显示气泡
                setPopupTipsInfo(centerlatlng,clickDistrict);

                if (querylist.size() > 0) {

                    group_searchview.setVisibility(View.INVISIBLE);
                    topview.setVisibility(View.INVISIBLE);
                    leftview.setVisibility(View.INVISIBLE);

                    topFragment.setPartitionId(partitionId);
                    topFragment.setPartitionCount(partitionCount);
                    getSupportFragmentManager().beginTransaction().replace(R.id.topview, topFragment).commitAllowingStateLoss();
                    partitionhomenewHttp(partitionId);//分区总览
                }

                break;
            }
        }

    }

    //画气泡
    public void drawPop(LatLng point){
        BitmapDescriptor mbitmap = BitmapDescriptorFactory.fromResource(R.mipmap.icon_marka);
        MarkerOptions ooA = new MarkerOptions().position(point).icon(mbitmap);
        mBaiduMap.addOverlay(ooA);
    }
    //画线路
    public void drawLine(){
        BitmapDescriptor mRedTexture = BitmapDescriptorFactory.fromAsset("icon_road_red_arrow.png");
        BitmapDescriptor mBlueTexture = BitmapDescriptorFactory.fromAsset("icon_road_blue_arrow.png");
        BitmapDescriptor mGreenTexture = BitmapDescriptorFactory.fromAsset("icon_road_green_arrow.png");

        // 添加多颜色分段的折线绘制
        LatLng latLngAA = new LatLng(39.965, 116.444);
        LatLng latLngBB = new LatLng(39.925, 116.494);
        LatLng latLngCC = new LatLng(39.955, 116.534);
        LatLng latLngDD = new LatLng(39.905, 116.594);
        LatLng latLngEE = new LatLng(39.965, 116.644);
        List<LatLng> pointsList = new ArrayList<LatLng>();
        pointsList.add(latLngAA);
        pointsList.add(latLngBB);
        pointsList.add(latLngCC);
        pointsList.add(latLngDD);
        pointsList.add(latLngEE);
        // 折线每个点的颜色值
        List<Integer> colorValue = new ArrayList<Integer>();
        colorValue.add(0xAAFF0000);
        colorValue.add(0xAA00FF00);
        colorValue.add(0xAA0000FF);
        // 覆盖物参数配置
        OverlayOptions ooPolylineA = new PolylineOptions()
                .width(10)// 设置折线线宽， 默认为 5， 单位：像素
                .points(pointsList)// 设置折线坐标点列表
                .colorsValues(colorValue);// 设置折线每个点的颜色值，每一个点带一个颜色值，绘制时按照索引依次取值
        // 添加覆盖物
        mPolyline = (Polyline) mBaiduMap.addOverlay(ooPolylineA);


        // 添加多纹理分段的折线绘制
        LatLng latLngAAA = new LatLng(39.865, 116.444);
        LatLng latLngBBB = new LatLng(39.825, 116.494);
        LatLng latLngCCC = new LatLng(39.855, 116.534);
        LatLng latLngDDD = new LatLng(39.805, 116.594);
        List<LatLng> pointsListA = new ArrayList<LatLng>();
        pointsListA.add(latLngAAA);
        pointsListA.add(latLngBBB);
        pointsListA.add(latLngCCC);
        pointsListA.add(latLngDDD);
        // 折线多纹理分段绘制的纹理队列
        List<BitmapDescriptor> textureList = new ArrayList<BitmapDescriptor>();
        textureList.add(mRedTexture);
        textureList.add(mBlueTexture);
        textureList.add(mGreenTexture);
        // 折线每个点的纹理索引
        List<Integer> textureIndexs = new ArrayList<Integer>();
        textureIndexs.add(0);
        textureIndexs.add(1);
        textureIndexs.add(2);
        // 覆盖物参数配置
        OverlayOptions ooPolylineAA = new PolylineOptions().width(10)
                .points(pointsListA)
                .dottedLine(true) // 设置折线是否虚线
                .customTextureList(textureList)// 设置折线多纹理分段绘制的纹理队列
                .textureIndex(textureIndexs);// 设置折线每个点的纹理索引
        // 添加覆盖物
        mPolyline = (Polyline) mBaiduMap.addOverlay(ooPolylineAA);
    }

    //初始化添加覆盖物mark
    private void markerpop(LatLng latLng,int buildcount) {

        //动态创建一个View用于显示位置信息
        TextView popnumbutton = new TextView(getApplicationContext());
        //设置view是背景图片

        popnumbutton.setBackgroundResource(R.drawable.shape_point_partition_normal);
        //设置view的内容（位置信息）
        popnumbutton.setGravity(Gravity.CENTER);
        popnumbutton.setText(String.valueOf(buildcount));
        popnumbutton.setTextSize(17);
        popnumbutton.setTextColor(Color.WHITE);
        //将View转换为BitmapDescriptor

        BitmapDescriptor mbitmap = BitmapDescriptorFactory.fromView(popnumbutton);

        //设置覆盖物添加的方式与效果
        MarkerOptions markerOptions = new MarkerOptions()
                .position(latLng)//mark出现的位置
                .icon(mbitmap)  //mark图标
                .draggable(false)//mark可拖拽
                .animateType(MarkerOptions.MarkerAnimateType.none)//从天而降的方式
                ;
        markerOptions.clickable(true);
        markerOptions.visible(false);

        //添加mark
        Marker marker = (Marker) (mBaiduMap.addOverlay(markerOptions));//地图上添加mark
        marker.setVisible(false);
        marker.setClickable(true);
        nummarkerList.add(marker);
    }

    //想根据Mark中的经纬度信息，获取当前的位置语义化结果，需要使用地理编码查询和地理反编码请求
    //在地图中显示一个信息窗口
    private void setPopupTipsInfo(LatLng latLng,String patitionnum){
        final String[] addr = new String[1];
        //实例化一个地理编码查询对象
        GeoCoder geoCoder = GeoCoder.newInstance();
        //设置反地理编码位置坐标
        ReverseGeoCodeOption option = new ReverseGeoCodeOption();
        option.location(latLng);
        //发起反地理编码请求
        geoCoder.reverseGeoCode(option);
        //为地理编码查询对象设置一个请求结果监听器
        geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
            @Override
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {

            }

            //当获取到反编码信息结果的时候会调用
            @SuppressLint("ResourceAsColor")
            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                //获取地理反编码位置信息
                addr[0] = reverseGeoCodeResult.getAddress();
                //获取地址的详细内容对象，此类表示地址解析结果的层次化地址信息。
                ReverseGeoCodeResult.AddressComponent addressDetail = reverseGeoCodeResult.getAddressDetail();
                Log.d("ssssfdghdsdfga",patitionnum);

                //动态创建一个View用于显示位置信息
                Button popbutton = new Button(getApplicationContext());
                //设置view是背景图片
                popbutton.setBackgroundResource(R.mipmap.newlocationtip);
                //设置view的内容（位置信息）
                popbutton.setGravity(1);
                popbutton.setText(patitionnum);
                int movepop = patitionnum.equals("两江四岸")?-50:60;
                //在地图中显示一个信息窗口，可以设置一个View作为该窗口的内容，也可以设置一个 BitmapDescriptor 作为该窗口的内容
                infoWindow = new InfoWindow(BitmapDescriptorFactory.fromView(popbutton), latLng, movepop, new InfoWindow.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick() {
                        //当InfoWindow被点击后隐藏
                        mBaiduMap.hideInfoWindow();
                    }
                });
                //显示信息窗口
                mBaiduMap.showInfoWindow(infoWindow);
            }
        });
        geoCoder.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    private void setPopupNumInfo(LatLng latLng){
        final String[] addr = new String[1];
        //实例化一个地理编码查询对象
        GeoCoder geoCoder = GeoCoder.newInstance();
        //设置反地理编码位置坐标
        ReverseGeoCodeOption option = new ReverseGeoCodeOption();
        option.location(latLng);
        //发起反地理编码请求
        geoCoder.reverseGeoCode(option);
        //为地理编码查询对象设置一个请求结果监听器
        geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
            @Override
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {

            }

            //当获取到反编码信息结果的时候会调用
            @SuppressLint("ResourceAsColor")
            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {

                Number count = homeOverAllVo.getData().getNumber();
                //动态创建一个View用于显示位置信息
                popnumbutton = new TextView(getApplicationContext());
                //设置view是背景图片
                popnumbutton.setBackgroundResource(R.drawable.shape_point_normal);
                //设置view的内容（位置信息）
                popnumbutton.setGravity(Gravity.CENTER);
                popnumbutton.setText(String.valueOf(count));
                popnumbutton.setTextSize(17);
                popnumbutton.setTextColor(Color.WHITE);

                TextPaint paint = popnumbutton.getPaint();
                paint.setFakeBoldText(true);

                //在地图中显示一个信息窗口，可以设置一个View作为该窗口的内容，也可以设置一个 BitmapDescriptor 作为该窗口的内容
                numinfoWindow = new InfoWindow(BitmapDescriptorFactory.fromView(popnumbutton), latLng, 0, new InfoWindow.OnInfoWindowClickListener() {

                    @Override
                    public void onInfoWindowClick() {
                        //当InfoWindow被点击后隐藏
                        mBaiduMap.hideInfoWindow();
                        performZoomIn(centerpoint);
                    }
                });

                //显示信息窗口
                mBaiduMap.showInfoWindow(numinfoWindow);
            }
        });
        geoCoder.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));

    }

    private void surveyTopView(){
        getSupportFragmentManager().beginTransaction().replace(R.id.topview, topFragment).commitAllowingStateLoss();
        group_searchview.setVisibility(View.INVISIBLE);
        topview.setVisibility(View.VISIBLE);

        int count = homeOverAllVo.getData().getNumber();
        double energy = homeOverAllVo.getData().getEnergy();
        topFragment.setPartitionCount(count);

        partitionhomenewVo = new PartitionhomenewVo();
        partitionhomenewVo.setDataSource(1);
        partitionhomenewVo.setDescription("“武汉军运会重点保障线路景观艺术照明工程”共10条重点保障线路，覆盖2267栋建构筑物，分为背景建筑和主题建筑。其中，仅含开关控制的建筑约949栋，含有变化效果的建筑约1318栋，其中又分为需要联动播放片源（主题建筑）和简单色彩明暗变化两种。");
        partitionhomenewVo.setOfflineNum(0);
        partitionhomenewVo.setOnlineNum(0);
        partitionhomenewVo.setTotalEnergy(energy);
        partitionhomenewVo.setTotalNum(count);

        myHandler.sendEmptyMessage(1014);
    }
    /**
     * 处理地图放大;
     */
    public void performZoomIn(LatLng latLng) {

        float zoomMaxLevel = mBaiduMap.getMaxZoomLevel();
        float zoomLevel = mBaiduMap.getMapStatus().zoom;

        zoomLevel += 2.0;
        if (zoomLevel > zoomMaxLevel) {
            zoomLevel = zoomMaxLevel;
        }

        MapStatus.Builder builder = new MapStatus.Builder();
        builder.target(latLng).zoom(zoomLevel);
        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
    }

    public void initData() {

        clusterManagers = new ArrayList<>();
        popclusterManagers = new ArrayList<>();
        nummarkerList = new ArrayList<>();
        total_isclear = false;
        partition_isclear = false;
        city_isclear = false;

        initboundaryData();
        //各分区
        homeeoverallHttp();

        //查询所有分区
        List<PartitionQueryVo> pvos = partitionDao.query();
        if (pvos.size() > 0) {
            querylist = pvos;
        } else {
            getPartitionQueryHttp();//获取分区
        }

        //查询所有建筑
        List<PartitionFindlistVo.ListBean> bvos = buildingDao.query();
        if (bvos.size() > 0) {
            PartitionFindlistVo findlistVo = new PartitionFindlistVo();
            findlistVo.setList(bvos);
            orangpartitionjianzulist = findlistVo;
            partitionjianzulist = findlistVo;

            getMarkerbuildData();
        } else {
            List<Integer> ids = new ArrayList<>();
            getPartitionFindlistjiazuHttp(ids);//获取建筑
        }

        //获取建设单位
        partitionBuildHttp();
        //获得分区坐标集
        partitionhomeHttp();
    }

    public void initboundaryData(){
        //分区名称 边界颜色
        String[] p={"总控区","黄陂区","新洲区","江岸区/50所平台","东西湖区","硚口区","江汉区","汉阳区","经开区","青山区","洪山区","武昌区","东湖风景区","东湖高新区","江夏区","两江四岸"};
        int[] c={0xFFfde6cc,0xFFfde6cc,0xFFfbf3ce,0xFFe3d6ff,0xFFffc7f1,0xFFffd1d1,0xFFfffdba,0xFFe3d6ff,0xFFc7fdec,0xFFfffdba,0xFFffd1d1,0xFFc7fdec,0xFF9898ff,0xFF9898ff,0xFFe3d6ff,0xFF9898ff};
        int[] b={0x8Afde6cc,0x8Afde6cc,0x8Afbf3ce,0x8Ae3d6ff,0x8Affc7f1,0x8Affd1d1,0x8Afffdba,0x8Ae3d6ff,0x8Ac7fdec,0x8Afffdba,0x8Affd1d1,0x8Ac7fdec,0x8A9898ff,0x8A9898ff,0x8Ae3d6ff,0x8A9898ff};

        patitionInfoVoList = new ArrayList<>();
        for(int i=0;i<p.length;i++){

            PatitionInfoVo vo = new PatitionInfoVo();
            vo.setName(p[i]);
            vo.setColcor(c[i]);
            vo.setBcoclor(b[i]);
            patitionInfoVoList.add(vo);
        }
    }
    public void getMarkerbuildData() {
        //查询所有marker建筑
        List<ListBuildingVo.BuildingListBean> bdvos = buildingDetailDao.query();
        if (bdvos.size() > 0) {
            ListBuildingVo findlistVo = new ListBuildingVo();
            findlistVo.setBuildingList(bdvos);
            buildinglist = findlistVo;

            markerList(buildinglist,false);
        } else {
            List<Integer> ids = new ArrayList<>();
            for (int i = 0; i < partitionjianzulist.getList().size(); i++) {
                ids.add(partitionjianzulist.getList().get(i).getId());
            }
            findListBuildingHttp(ids, 3);
        }
    }

    //将离线文件写入设备
    public static void copyToDevice(Context context) {
        try {

            // 这个数组用来存放离线地图文件的名称
            String fileName[] = {
                    "lanzhou_36.dat",
                    "wuhan_218.dat",
                    "quanguogailue.dat",
                    "DVUserdat.cfg",
                    // 如果有其他的就加进来，因为是确定的所以说这样写尽管不合适，但是也行...
            };
            // 这个是百度地图在没有网络的时候读取离线文件的目录，也就是说我们要把APP assets文件夹下的百度离线地图包放到这个文件夹下。
            String path = dirSelect(context);
            // 每个文件的路径，也是个数组
            String filepath[] = {
                    path + "/" + fileName[0],
                    path + "/" + fileName[1],
                    path + "/" + fileName[2],
                    path + "/" + fileName[3],
                    // 也是，fileName数组有几个就写几个。。。
            };
            File file = new File(path);
            if (!file.exists()) { // 判断一下这个路径有没有，没有的话就创建一下
                file.mkdir();
            }
            // 循环我们的地图文件
            for (int i = 0; i < fileName.length; i++) {
                // 如果这个地图文件没有
                if (!(new File(filepath[i])).exists()) {
                    // 如果手机内存没有这个文件就去创建一个文件
                    new File(filepath[i]).createNewFile();
                    // 一个流操作，把APP assets文件下对应的文件放进去，循环完成就OK了。
                    InputStream is = context.getAssets().open("baidu/" + fileName[i]);
                    FileOutputStream fos = new FileOutputStream(filepath[i]);
                    byte[] buffer = new byte[8192];
                    int count = 0;
                    while ((count = is.read(buffer)) > 0) {
                        fos.write(buffer, 0, count);
                    }
                    fos.close();
                    is.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String dirSelect(Context context) {
        //安卓10做适配
        final String BAIDU = "/BaiduMapSDKNew/vmp";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            return context.getExternalFilesDir(BAIDU).getPath();
        } else {
            return Environment.getExternalStorageDirectory() + BAIDU;
        }
    }

    //搜索界面
    public void initSearchView() {

        mEditText = findViewById(R.id.ed_search);
        mEditText.setClickable(true);

        mRecyclerView = findViewById(R.id.recycleview);
        backcenter = findViewById(R.id.backcenter);
        group_searchview = findViewById(R.id.group_searchview);
        selectTagView = findViewById(R.id.group_buttons);
        selectImageview = findViewById(R.id.selectimageView);
        selectTextview = findViewById(R.id.selecttextView);
        close_recycleview = findViewById(R.id.close_recycleview);
        fenquTag = findViewById(R.id.button_fenqu);
        jianzuTag = findViewById(R.id.button_jianzu);
        constructionTag = findViewById(R.id.button_construction);
        confirmTag = findViewById(R.id.button_confirm);
        cancleTag = findViewById(R.id.button_cancle);
        defaultimg = findViewById(R.id.default_smallimgage);
        selectTagView.setClickable(true);
        mRecyclerView.setClickable(true);

        selectTagView.setVisibility(View.GONE);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(glm);
        adapter = new RecyclerAdapter();

        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
        //放大动画，里面联合渐变色动画
        ScaleInAnimationAdapter animationAdapter = new ScaleInAnimationAdapter(alphaAdapter);
        alphaAdapter.setFirstOnly(false);
        //设置放大动画是否只走一次
        animationAdapter.setFirstOnly(false);
        //设置渐变色动画的       alphaAdapter.setDuration(500);时间
        //设置放大动画的时间
        animationAdapter.setDuration(500);
        //适配放大动画（放大动画里有渐变色动画）
        mRecyclerView.setAdapter(animationAdapter);
        mRecyclerView.setVisibility(View.GONE);

        //标签点击
        selectTagView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }

        });

        //列表点击
        mRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }

        });

        //列表item点击
        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemPartitionClick(List<Integer> ids, int type, int select_id) {
                select_adapterid = select_id;
                if (ids.size() > 0) {
                    findListBuildingHttp(ids, type);
                } else {
                    buildinglist = null;
                    clearBaiduMap();
                }

            }

            @Override
            public void onItemSiteClick(List<Integer> ids, int type, int select_id) {
                select_adapterid = select_id;
                if (ids.size() > 0) {
                    findListBuildingHttp(ids, type);
                } else {
                    buildinglist = null;
                    clearBaiduMap();
                }
            }
        });

        //输入框文本改变
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            //文本改变之前执行
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i("sjfasj", "ok");
            }

            @Override
            //文本改变的时候执行
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //如果长度不为0
                if (s.length() != 0) {

                    //根据模糊条件查建筑
                    List<PartitionFindlistVo.ListBean> bvoByLike = buildingDao.query(s.toString());
                    //刷新列表
                    PartitionFindlistVo findlistVo = new PartitionFindlistVo();
                    findlistVo.setList(bvoByLike);
                    partitionjianzulist = findlistVo;
                    adapter.setpartitionBulidlist(findlistVo);

                    fenquTag.setSelected(false);
                    jianzuTag.setSelected(true);
                    constructionTag.setSelected(false);

                    selectImageview.setSelected(false);
                    selectImageview.setImageResource(selectImageview.isSelected() ? R.mipmap.newselect : R.mipmap.newunselect);
                } else {
                    selectImageview.setSelected(false);
                    selectImageview.setImageResource(selectImageview.isSelected() ? R.mipmap.newselect : R.mipmap.newunselect);

                    if (fenquTag.isSelected()) {
                        adapter.setquerylist(querylist);
                    } else {
                        adapter.setpartitionBulidlist(partitionjianzulist);
                    }
                }
            }

            @Override
            //文本改变之后执行
            public void afterTextChanged(Editable s) {
                Log.i("sjfasj", "ok");
            }

        });

        //输入框点击
        mEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                fenquTag.setSelected(true);
                jianzuTag.setSelected(false);
                constructionTag.setSelected(false);

                adapter.setquerylist(querylist);
                selectTagView.setVisibility(View.VISIBLE);
                mRecyclerView.setVisibility(View.VISIBLE);

                if(isShowPolygon){
                    isShowPolygon = false;
                    for (int i=0;i<orangpartitionjianzulist.getList().size();i++){
                        orangpartitionjianzulist.getList().get(i).setSelect(false);
                    }
                }

                if (fenquTag.isSelected()) {
                    selectImageview.setSelected(getAllSelectImageStatus(1));
                } else {
                    selectImageview.setSelected(getAllSelectImageStatus(0));
                }
                selectImageview.setImageResource(selectImageview.isSelected() ? R.mipmap.newselect : R.mipmap.newunselect);
                return false;
            }
        });

        //分区
        fenquTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fenquTag.setSelected(true);
                jianzuTag.setSelected(false);
                constructionTag.setSelected(false);

                selectImageview.setSelected(getAllSelectImageStatus(1));
                selectImageview.setImageResource(selectImageview.isSelected() ? R.mipmap.newselect : R.mipmap.newunselect);

                adapter.setquerylist(querylist);
            }
        });

        //建筑
        jianzuTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fenquTag.setSelected(false);
                jianzuTag.setSelected(true);
                constructionTag.setSelected(false);

                if (mEditText.getText().length() > 0 || isShowPolygon == true) {
                    adapter.setpartitionBulidlist(partitionjianzulist);
                    selectImageview.setSelected(getAllSelectImageStatus(2));
                } else {

                    List<Integer> ids = new ArrayList<Integer>();
                    for (int i = 0; i < querylist.size(); i++) {
                        PartitionQueryVo queryVo = querylist.get(i);
                        if (queryVo.isSelect()) {
                            ids.add(queryVo.getId());
                        }
                    }

                    if (ids.size() > 0 && isfenqu_allselect == false) {
                        getPartitionFindlistjiazuHttp(ids);
                        selectImageview.setSelected(false);
                    } else {
                        partitionjianzulist = orangpartitionjianzulist;
                        adapter.setpartitionBulidlist(partitionjianzulist);
                        selectImageview.setSelected(getAllSelectImageStatus(2));
                    }
                }
                selectImageview.setImageResource(selectImageview.isSelected() ? R.mipmap.newselect : R.mipmap.newunselect);
            }
        });
        //建设单位
        constructionTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fenquTag.setSelected(false);
                jianzuTag.setSelected(false);
                constructionTag.setSelected(true);

                selectImageview.setSelected(getAllSelectImageStatus(3));
                selectImageview.setImageResource(selectImageview.isSelected() ? R.mipmap.newselect : R.mipmap.newunselect);

                adapter.setPartitionBuildVo(partitionBuildVoList);
            }
        });

        //全选
        selectImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectImageview.setSelected(!selectImageview.isSelected());
                selectImageview.setImageResource(selectImageview.isSelected() ? R.mipmap.newselect : R.mipmap.newunselect);
                if(selectImageview.isSelected()){
                    isFirstComming = true;
                }
                handelAllselect(selectImageview.isSelected());

                if (fenquTag.isSelected()) {
                    isfenqu_allselect = selectImageview.isSelected() ? true : false;
                }

            }
        });
        selectTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageview.setSelected(!selectImageview.isSelected());
                selectImageview.setImageResource(selectImageview.isSelected() ? R.mipmap.newselect : R.mipmap.newunselect);
                handelAllselect(selectImageview.isSelected());

                if (fenquTag.isSelected()) {
                    isfenqu_allselect = selectImageview.isSelected() ? true : false;
                }
            }
        });

        //关闭列表
        close_recycleview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageview.setSelected(false);
                selectImageview.setImageResource(selectImageview.isSelected() ? R.mipmap.newselect : R.mipmap.newunselect);

                selectTagView.setVisibility(View.INVISIBLE);
                mRecyclerView.setVisibility(View.INVISIBLE);
            }
        });

        //地图回到中心点
        backcenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topview.setVisibility(View.INVISIBLE);
                leftview.setVisibility(View.INVISIBLE);
                rightview.setVisibility(View.INVISIBLE);
                selectTagView.setVisibility(View.INVISIBLE);
                mRecyclerView.setVisibility(View.INVISIBLE);
                group_searchview.setVisibility(View.VISIBLE);

                surveyTopView();

                LatLng latLng = new LatLng(30.52, 114.31);
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(latLng).zoom(10.00001f);
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
            }
        });

        customDialog = new CustomDialog(this);
    }

    public boolean getAllSelectImageStatus(int datatype){
        List<Integer> ids = new ArrayList<Integer>();
        if(datatype ==1){
            for(int i=0;i<querylist.size();i++){
                if(querylist.get(i).isSelect()){
                    ids.add(querylist.get(i).getId());
                }
            }
            return  (ids.size() == querylist.size())?true:false;
        }else if(datatype ==2) {

            for(int i=0;i<partitionjianzulist.getList().size();i++){
                if(partitionjianzulist.getList().get(i).isSelect()){
                    ids.add(partitionjianzulist.getList().get(i).getId());
                }
            }
            return  (ids.size() == partitionjianzulist.getList().size() || ids.size()+1 == partitionjianzulist.getList().size() || ids.size()-1 == partitionjianzulist.getList().size())?true:false;
        }else if (datatype ==3){
            for(int i=0;i<partitionBuildVoList.size();i++){
                if(partitionBuildVoList.get(i).isSelect()){
                    ids.add(partitionBuildVoList.get(i).getId());
                }
            }
            return  (ids.size() == partitionBuildVoList.size())?true:false;
        }else {
            return false;
        }
    }
    public void initFragment() {
        leftFragment = new leftFragment();
        rightFragment = new rightFragment();
        topFragment = new TopFragment();

        leftview = findViewById(R.id.leftview);
        rightview = findViewById(R.id.rightview);
        topview = findViewById(R.id.topview);

        leftview.setVisibility(View.INVISIBLE);
        rightview.setVisibility(View.INVISIBLE);
        topview.setVisibility(View.INVISIBLE);
    }

    //全选
    public void handelAllselect(boolean is_select) {
        clearBaiduMap();

        List<Integer> select_ids = new ArrayList<>();
        if (fenquTag.isSelected()) {
            for (int i = 0; i < querylist.size(); i++) {
                querylist.get(i).setSelect(is_select ? true : false);
            }

            adapter.setquerylist(querylist);

            if (is_select) {
                getMarkerbuildData();
            }
        } else if(jianzuTag.isSelected()) {
            for (int i = 0; i < partitionjianzulist.getList().size(); i++) {
                partitionjianzulist.getList().get(i).setSelect(is_select ? true : false);
                select_ids.add(partitionjianzulist.getList().get(i).getId());
            }
            adapter.setpartitionBulidlist(partitionjianzulist);

            if (is_select) {
                findListBuildingHttp(select_ids, 3);
            }
        }else if(constructionTag.isSelected()){
            for (int i = 0; i < partitionBuildVoList.size(); i++) {
                partitionBuildVoList.get(i).setSelect(is_select ? true : false);
                select_ids.add(partitionBuildVoList.get(i).getId());
            }
            adapter.setPartitionBuildVo(partitionBuildVoList);

            if (is_select) {
                findListBuildingHttp(select_ids, 1);
            }
        }
    }

    //输入框输入完查询数据
    public void queryData(String ss) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                UserDao dao = DB.getInstance(MapTypeDemo.this).getUserDao();
                if (TextUtils.isEmpty(ss.trim())) {
                    list = null;
                    mRecyclerView.setVisibility(View.INVISIBLE);
                } else {
                    list = dao.getUserfromname(ss.trim());
                    if (list.size() > 0) {
                        mRecyclerView.setVisibility(View.VISIBLE);

                    } else {
                        mRecyclerView.setVisibility(View.INVISIBLE);
                    }
                }
            }

        }).start();
    }

    //数据库处理数据
    public void handleDB() {

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        dao = DB.getInstance(MapTypeDemo.this).getUserDao();
                        List<User> users = dao.getAllUsers();
                        if (users.size() > 0) {
                            dao.deleteAll();
                        }

                        User user = new User();
                        for (int i = 1; i < 6; i++) {
                            user.setUid(i);
                            user.setAge(28);
                            user.setName("xiaohu" + i);

                            DB.getInstance(MapTypeDemo.this).getUserDao().insert(user);
                        }
                    }
                }).start();
    }

    //检索行政区边界
    public void DistrictSearch() {
        mDistrictSearch = DistrictSearch.newInstance();
        searchlistener = new OnGetDistricSearchResultListener() {
            @Override
            public void onGetDistrictResult(DistrictResult districtResult) {
                //对检索所得行政区划边界数据进行处理
                onNewGetDistrictResult(districtResult);
                mDistrictSearch.destroy();
            }
        };

        mDistrictSearch.setOnDistrictSearchListener(searchlistener);
    }

    public void onNewGetDistrictResult(DistrictResult districtResult) {
        if (null != districtResult && districtResult.error == SearchResult.ERRORNO.NO_ERROR) {
            mBaiduMap.clear();
            //获取边界坐标点，并展示
            if (districtResult.error == SearchResult.ERRORNO.NO_ERROR) {
                List<List<LatLng>> polyLines = districtResult.getPolylines();
                if (polyLines == null) {
                    return;
                }
                LatLngBounds.Builder builder = new LatLngBounds.Builder();

                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                for (List<LatLng> polyline : polyLines) {
                                    OverlayOptions ooPolyline11 = new PolylineOptions().width(10)
                                            .points(polyline).dottedLine(true).color(Color.BLUE);
                                    mBaiduMap.addOverlay(ooPolyline11);
                                    OverlayOptions ooPolygon = new PolygonOptions().points(polyline)
                                            .stroke(new Stroke(5, 0xAA00FF88)).fillColor(0xAAFFFF00);
                                    mBaiduMap.addOverlay(ooPolygon);
                                    for (LatLng latLng : polyline) {
                                        builder.include(latLng);
                                    }
                                }

                                mBaiduMap.setMapStatus(MapStatusUpdateFactory
                                        .newLatLngBounds(builder.build()));
                            }

                        }).start();

            }
        }
    }

    //创建逆地理编码检索
    public void geoCoder(LatLng point) {
        listener1 = new OnGetGeoCoderResultListener() {
            @Override
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
                Log.d("", "没有找到检索结果");
            }

            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (selectreverseGeoCodeResult != null && selectreverseGeoCodeResult.getAdcode() == reverseGeoCodeResult.getAdcode()) {
                    mBaiduMap.clear();
                    topview.setVisibility(View.INVISIBLE);
                    group_searchview.setVisibility(View.VISIBLE);
                    selectreverseGeoCodeResult = null;
                    return;
                }
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    //没有找到检索结果
                    Log.d("", "没有找到检索结果");

                    return;
                } else {
                    selectreverseGeoCodeResult = reverseGeoCodeResult;
                    //详细地址
                    String address = reverseGeoCodeResult.getAddress();
                    //行政区号
                    int adCode = reverseGeoCodeResult.getCityCode();
                    String city = reverseGeoCodeResult.getAddressDetail().city;
                    String district = reverseGeoCodeResult.getAddressDetail().district;

                    if (city.length() > 0 && district.length() > 0) {
                        mDistrictSearch.setOnDistrictSearchListener(searchlistener);
                        mDistrictSearch.searchDistrict(new DistrictSearchOption()
                                .cityName(city)
                                .districtName(district));
                    }

                    int partitionId = 0;
                    if (querylist.size() > 0) {
                        List<PartitionQueryVo> pvos = partitionDao.namequery(district);
                        partitionId = pvos.size() > 0 ? pvos.get(0).getId() : 0;

                        topFragment.setPartitionId(partitionId);
                        getSupportFragmentManager().beginTransaction().replace(R.id.topview, topFragment).commitAllowingStateLoss();
                        partitionhomenewHttp(partitionId);//分区总览
                        group_searchview.setVisibility(View.INVISIBLE);
                    }

                }
                mCoder.destroy();
            }
        };


        mCoder = GeoCoder.newInstance();
        mCoder.setOnGetGeoCodeResultListener(listener1);

        mCoder.reverseGeoCode(new ReverseGeoCodeOption()
                .location(point)
                // 设置是否返回新数据 默认值0不返回，1返回
                .newVersion(1)
                // POI召回半径，允许设置区间为0-1000米，超过1000米按1000米召回。默认值为1000
                .radius(500));

    }

    //清理地图
    public void clearMapview(boolean close) {
        if(mPolygon != null){
            mPolygon.remove();//先清除以前的边界
            mBaiduMap.hideInfoWindow(infoWindow);
        }
        if(!close){
            mEditText.setText("");
        }
    }
    public void clearBaiduMap(){
        for (ClusterManager<MyItem> clusterManager : clusterManagers) {
            clusterManager.clearItems();
        }
        for (Marker marker : nummarkerList) {
            marker.setVisible(false);
        }

        mBaiduMap.clear();
        alldrawPoint();

        LatLng latLng = new LatLng(centerpoint.latitude+0.001, centerpoint.longitude+0.001);
        centerpoint = latLng;
        MapStatus.Builder builder = new MapStatus.Builder();
        builder.target(latLng).zoom(mBaiduMap.getMapStatus().zoom);
        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
    }

    //分区总览
    public void fenqutotal(Integer partitionId) {
        //根据模糊条件查建筑
        List<PartitionFindlistVo.ListBean> bvoByLike = buildingDao.query(partitionId);

        //刷新列表
        PartitionFindlistVo findlistVo = new PartitionFindlistVo();
        findlistVo.setList(bvoByLike);
        partitionjianzulist = findlistVo;
        adapter.setpartitionBulidlist(findlistVo);

        fenquTag.setSelected(false);
        jianzuTag.setSelected(true);
        constructionTag.setSelected(false);
        selectImageview.setSelected(false);
        selectImageview.setImageResource(selectImageview.isSelected() ? R.mipmap.newselect : R.mipmap.newunselect);

        selectTagView.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    //标记建筑位置
    private void marker(List<LatLng> points, LatLngBounds.Builder builder1,ListBuildingVo buildinglist) {
        ClusterManager<MyItem> mClusterManager = new ClusterManager<MyItem>(this, mBaiduMap);
        mClusterManager.mRenderer.setMinClusterSize(10);
        mClusterManager.clearItems();

        List<MyItem> items = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            ListBuildingVo.BuildingListBean build = buildinglist.getBuildingList().get(i);
            items.add(new MyItem(points.get(i), build));
        }
        mClusterManager.addItems(items);
        clusterManagers.add(mClusterManager);

        // 设置地图监听，当地图状态发生改变时，进行点聚合运算
        mBaiduMap.setOnMapStatusChangeListener(mClusterManager);
        // 设置maker点击时的响应
        mBaiduMap.setOnMarkerClickListener(mClusterManager);

        //点击建筑物数量
        mClusterManager.setOnClusterClickListener(new ClusterManager.OnClusterClickListener<MyItem>() {
            @Override
            public boolean onClusterClick(Cluster<MyItem> cluster) {
                Toast.makeText(MapTypeDemo.this,
                        "有" + cluster.getSize() + "个点", Toast.LENGTH_SHORT).show();

                LatLng latLng = new LatLng(cluster.getPosition().latitude, cluster.getPosition().longitude);
                performZoomIn(latLng);

                return false;
            }
        });

        //点击建筑物
        mClusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<MyItem>() {
            @Override
            public boolean onClusterItemClick(MyItem item) {

                if(mPolygon != null){
                    mPolygon.remove();//先清除以前的边界
                }

                topview.setVisibility(View.INVISIBLE);
                group_searchview.setVisibility(View.VISIBLE);
                selectreverseGeoCodeResult = null;

                selectBuilding = item.getBuilding();
                buildingID = selectBuilding.getId();

                getSupportFragmentManager().beginTransaction().replace(R.id.leftview, leftFragment).commitAllowingStateLoss();
                getSupportFragmentManager().beginTransaction().replace(R.id.rightview, rightFragment).commitAllowingStateLoss();

                sjcityvideogetHttp(selectBuilding.getId(), selectBuilding.getName());

                return false;
            }
        });

        LatLngBounds latlngBounds = builder1.build();
        MapStatusUpdate us = MapStatusUpdateFactory.newLatLngBounds(builder1.build());
        MapStatusUpdateFactory.newLatLngBounds(latlngBounds, mMapView.getWidth(), mMapView.getHeight());
        mBaiduMap.animateMapStatus(us);

        if (isFirstComming) {
            LatLng latLng = new LatLng(centerpoint.latitude+0.00001, centerpoint.longitude+0.00001);
            centerpoint = latLng;
            MapStatus.Builder builder = new MapStatus.Builder();
            builder.target(latLng).zoom(10.1001f);
            mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
            isFirstComming = false;
        }
        else {
            LatLng point = centerpoint;
            LatLng latLng = new LatLng(point.latitude+0.00001, point.longitude+0.00001);
            clickpoint = latLng;
            MapStatus.Builder builder = new MapStatus.Builder();
            builder.target(latLng).zoom(12.2001f);
            mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
        }
    }

    //获取建筑群坐标
    public void markerList(ListBuildingVo buildinglist,boolean isselect_fresh) {

        if(isselect_fresh){
            clearBaiduMap();
        }

        final List<LatLng> points = new ArrayList<>();
        if (buildinglist != null && buildinglist.getBuildingList().size() > 0) {
            for (int i = 0; i < buildinglist.getBuildingList().size(); i++) {
                LatLng markerLatlng = new LatLng(buildinglist.getBuildingList().get(i).getLatitude(), buildinglist.getBuildingList().get(i).getLongitude());
                CoordinateConverter converter = new CoordinateConverter()
                        .from(CoordinateConverter.CoordType.COMMON)
                        .coord(markerLatlng);
                //转换坐标P
                LatLng desLatLng = converter.convert();
                points.add(desLatLng);
            }
            //将所有点的经纬度放在一个集合中。
            LatLngBounds.Builder builder1 = new LatLngBounds.Builder();
            for (LatLng p : points) {
                builder1 = builder1.include(p);
            }
            marker(points, builder1,buildinglist);
        }

        baiduMapChangeState();
    }
    //标记分区中心数量
    public void markerCenterList(List<LatLng> centerlatLngList , List<Integer> buildCountList){
        //将所有点的经纬度放在一个集合中。
        LatLngBounds.Builder builder1 = new LatLngBounds.Builder();
        for (LatLng p : centerlatLngList) {
            builder1 = builder1.include(p);
        }
        markercenter(centerlatLngList, buildCountList,builder1);

        baiduMapChangeState();
    }
    public void markercenter(List<LatLng> centerlatLngList,List<Integer> buildCountList,LatLngBounds.Builder builder1){

        ClusterManager<PopMyItem> newClusterManager = new ClusterManager<PopMyItem>(this, mBaiduMap);
        newClusterManager.mRenderer.setMinClusterSize(4);

        // 设置地图监听，当地图状态发生改变时，进行点聚合运算
        mBaiduMap.setOnMapStatusChangeListener(newClusterManager);
        // 设置maker点击时的响应
        mBaiduMap.setOnMarkerClickListener(newClusterManager);

        List<PopMyItem> items = new ArrayList<>();
        for (int i = 0; i < centerlatLngList.size(); i++) {
            markerpop(centerlatLngList.get(i),buildCountList.get(i));
        }
    }
    //点聚合分组
    public void markervoList(HomeOverAllVo homeOverAllVo){

        for(int i=0;i<homeOverAllVo.getPartition().size();i++){

            HomeOverAllVo.PartitionBean PartitionBean = homeOverAllVo.getPartition().get(i);

            ListBuildingVo buildingVo = new ListBuildingVo();
            List<ListBuildingVo.BuildingListBean> buildingList = new ArrayList<>();
            for (HomeOverAllVo.PartitionBean.BuildingBean buildingBean : PartitionBean.getBuilding()) {
                ListBuildingVo.BuildingListBean buildingListBean = new ListBuildingVo.BuildingListBean();
                buildingListBean.setName(buildingBean.getName());
                buildingListBean.setId(buildingBean.getId());
                buildingListBean.setLatitude(buildingBean.getLatitude());
                buildingListBean.setLongitude(buildingBean.getLongitude());
                buildingList.add(buildingListBean);
            }
            buildingVo.setBuildingList(buildingList);
            markerList(buildingVo,false);
        }
    }

    //地图改变监听
    public void baiduMapChangeState(){
        mBaiduMap.setOnMapStatusChangeListener(new BaiduMap.OnMapStatusChangeListener() {
            @Override
            public void onMapStatusChangeStart(MapStatus mapStatus) {

            }

            @Override
            public void onMapStatusChangeStart(MapStatus mapStatus, int i) {

            }

            @Override
            public void onMapStatusChange(MapStatus mapStatus) {
                if(mapStatus.zoom < 10.2)//武汉市总数
                {
                    if(total_isclear == false){
                        total_isclear = true;
                        partition_isclear = false;
                        city_isclear = false;
                        mBaiduMap.showInfoWindow(numinfoWindow);
                        for (ClusterManager<MyItem> clusterManager : clusterManagers) {
                            for (Marker marker : clusterManager.getClusterMarkerCollection().getMarkers()) {
                                marker.setVisible(false);
                            }
                        }

                        for (Marker marker : nummarkerList) {
                            marker.setVisible(false);
                        }
                    }
                }
                else if(mapStatus.zoom < 12.2){
                    if(partition_isclear == false){
                        total_isclear = false;
                        partition_isclear = true;
                        city_isclear = false;

                        for (ClusterManager<MyItem> clusterManager : clusterManagers) {
                            for (Marker marker : clusterManager.getClusterMarkerCollection().getMarkers()) {
                                marker.setVisible(false);
                            }
                        }
                        for (Marker marker : nummarkerList) {
                            marker.setVisible(true);
                        }

                        mBaiduMap.hideInfoWindow();
                    }

                }
                else {
                    for (ClusterManager<MyItem> clusterManager : clusterManagers) {
                        clusterManager.onMapStatusChange(mapStatus);
                    }

                    if(city_isclear == false){
                        total_isclear = false;
                        partition_isclear = false;
                        city_isclear = true;

                        for (ClusterManager<MyItem> clusterManager : clusterManagers) {
                            for (Marker marker : clusterManager.getClusterMarkerCollection().getMarkers()) {
                                marker.setVisible(true);
                            }
                        }
                        for (Marker marker : nummarkerList) {
                            marker.setVisible(false);
                        }
                        mBaiduMap.hideInfoWindow();
                    }
                }
            }

            @Override
            public void onMapStatusChangeFinish(MapStatus mapStatus) {

            }
        });

        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                //各分区建筑总数marker点击
                for (Marker nummarker : nummarkerList) {
                    if(marker.equals(nummarker)){
                        MapStatus.Builder builder = new MapStatus.Builder();
                        builder.target(marker.getPosition()).zoom(12.50f);
                        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
                        marker.setVisible(false);
                    }

                }
                return false;
            }
        });
    }
    //点击地图隐藏输入框
    public void hideInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        View v = getWindow().peekDecorView();
        if (null != v) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }

        mRecyclerView.setVisibility(View.GONE);
        selectTagView.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 在activity执行onResume时必须调用mMapView. onResume ()
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 在activity执行onPause时必须调用mMapView. onPause ()
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 在activity执行onDestroy时必须调用mMapView.onDestroy()
        mMapView.onDestroy();
    }


    /**
     * 轮播图
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void initPhotosView() {
        scanPhotoview = findViewById(R.id.scanPhotosview);
        bigviewPager = findViewById(R.id.bigview_pager);
        bigviewPager.setAdapter(new SamplePagerAdapter());

        DisplayMetrics dm = getResources().getDisplayMetrics();//新增
        banner = findViewById(R.id.mybanner);
        banner.setVisibility(View.VISIBLE);
        banner.setBannerGalleryEffect(dm.densityDpi, 1, 1f);

        if(sjcityvideogetVo.getBuilding() == null){
            return;
        }
        List<DataBean> datas = DataBean.setDatas(sjcityvideogetVo.getBuilding().getImageList());
        adpter = new BannerCustomAdapter(datas, this);
        banner.setAdapter(adpter)
                .addBannerLifecycleObserver(this)//添加生命周期观察者
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(Object data, int position) {
                        select_position = position;
                        banner.setCurrentItem(position);
                        for (int i = 0; i < datas.size(); i++) {
                            datas.get(i).viewType = 0;
                        }
                        datas.get(position).viewType = 1;
                        bigviewPager.setCurrentItem(position);
                    }
                }).addOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                select_position = position;
            }

            @Override
            public void onPageSelected(int position) {
                select_position = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state == 0){
                    banner.setCurrentItem(select_position);
                    for (int i = 0; i < datas.size(); i++) {
                        datas.get(i).viewType = 0;
                    }
                    datas.get(select_position).viewType = 1;
                    bigviewPager.setCurrentItem(select_position);
                    adpter.notifyDataSetChanged();
                }
            }
        });

        if (datas != null && datas.size() > 0) {
            datas.get(0).viewType = 1;
            banner.setCurrentItem(0);
        }

        if (sjcityvideogetVo.getBuilding().getImageList().size() > 0) {
            SjcityvideogetVo.BuildingBean.ImageListBean bean = sjcityvideogetVo.getBuilding().getImageList().get(0);
            defaultimg.setVisibility(View.INVISIBLE);

        } else {
            defaultimg.setVisibility(View.VISIBLE);
        }
        bigviewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                SjcityvideogetVo.BuildingBean.ImageListBean bean = sjcityvideogetVo.getBuilding().getImageList().get(position);
            }
        });

        bigviewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                banner.setCurrentItem(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        scanPhotoview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    class SamplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            if(sjcityvideogetVo.getBuilding() != null){
                if (sjcityvideogetVo.getBuilding().getImageList().size() > 0) {
                    return sjcityvideogetVo.getBuilding().getImageList().size();
                } else
                    return 0;
            }else {
                return 0;
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public View instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
            SjcityvideogetVo.BuildingBean.ImageListBean bean = sjcityvideogetVo.getBuilding().getImageList().get(position);
            String url = ApiUrl.IMAGE_SERVICES_ADDRESS + bean.getPhotoName() + "." + bean.getFileType();

            photoView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            GlideShowUtil.showImage(MapTypeDemo.this, photoView, url, R.mipmap.icon_normal_none, R.mipmap.icon_normal_none);
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }

    public static void setCurrentBigImg(int position) {
        isSmallImgClick = true;
        bigviewPager.setCurrentItem(position);
    }
}
