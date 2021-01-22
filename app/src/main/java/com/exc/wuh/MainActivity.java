package com.exc.wuh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.GroundOverlayOptions;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolygonOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.map.offline.MKOLSearchRecord;
import com.baidu.mapapi.map.offline.MKOLUpdateElement;
import com.baidu.mapapi.map.offline.MKOfflineMap;
import com.baidu.mapapi.map.offline.MKOfflineMapListener;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
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
import com.exc.wuh.DB.DB;
import com.exc.wuh.Dao.UserDao;
import com.exc.wuh.adapter.RecyclerAdapter;
import com.exc.wuh.bean.User;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

public class MainActivity extends AppCompatActivity {

    //百度地图相关
    private com.baidu.mapapi.map.MapView mp;
    private LocationClient mLocationClient;
    private UiSettings mUiSettings;
    private CheckBox mAllGesturesCB;
    private CheckBox mZoomCB;
    private CheckBox mOverlookCB;
    private CheckBox mRotateCB;
    private CheckBox mScrollCB;
    private CheckBox mDoublezoomCB;
    private BaiduMap mMap;
    private OverlayOptions ooGround;
    private DistrictSearch mDistrictSearch;
    private GeoCoder mCoder;
    private MyLocationListener myLocationListener;
    private MKOfflineMap mOffline;

    //搜索相关
    private EditText mEditText;
    private RecyclerView mRecyclerView;
    private RecyclerAdapter adapter;
    private AnimationSet animationSet;
    private AnimationSet manimationSet;
    private TranslateAnimation translateAnimation;

    //收到消息回主UI刷新界面
    Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 123:
                    adapter.setmDatas(list);
                break;
            }

            super.handleMessage(msg);
        }
    };
    private List<User> list;
    private OnGetGeoCoderResultListener listener1;
    private OnGetDistricSearchResultListener searchlistener;
    private MKOfflineMapListener offlineMaplistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestMyPermissions();
        initLocation();
//        handleDB();
        initSearchView();
    }

    //数据库处理数据
    public void handleDB(){

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                        UserDao dao = DB.getInstance(MainActivity.this).getUserDao();
                        dao.deleteAll();

                        User user = new User();
                        for (int i =0; i<5; i++){
                            user.setUid(i);
                            user.setAge(28);
                            user.setName("xiaohu"+i);

                            DB.getInstance(MainActivity.this).getUserDao().insert(user);
                        }
                    }
                }).start();
    }
    //输入框
    public void initSearchView(){
        //进
        animationSet = new AnimationSet(true);
        translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f, Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,-2.0f, Animation.RELATIVE_TO_SELF,0f);
        translateAnimation.setDuration(1000);
        animationSet.addAnimation(translateAnimation);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(1000);
        animationSet.addAnimation(alphaAnimation);

        //出
        manimationSet = new AnimationSet(true);
        TranslateAnimation mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -2.0f);
        mShowAction.setDuration(1000);
        manimationSet.addAnimation(mShowAction);

        AlphaAnimation malphaAnimation = new AlphaAnimation(1, 0);
        malphaAnimation.setDuration(1000);
        manimationSet.addAnimation(malphaAnimation);




        mEditText = findViewById(R.id.ed_search);
        mRecyclerView = findViewById(R.id.recycleview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter();
        //渐变色动画

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
        mRecyclerView.setBackgroundColor(Color.alpha(0));

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            //文本改变之前执行
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            //文本改变的时候执行
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //如果长度为0
                if (s.length() == 0) {

                } else {//长度不为0

                }
            }

            @Override
            //文本改变之后执行
            public void afterTextChanged(Editable s) {
                String ss = s.toString();
                queryData(ss);
            }
        });

    }

    //输入框输入完查询数据
    public void queryData(String ss){
        new Thread(new Runnable() {
            @Override
            public void run() {
                UserDao dao = DB.getInstance(MainActivity.this).getUserDao();
                if (TextUtils.isEmpty(ss.trim())) {
                    list = null;
                    mRecyclerView.setBackgroundColor(Color.alpha(0));
                }else {
                    list = dao.getUserfromname(ss.trim());
                    if(list.size()>0){
                        mRecyclerView.setBackgroundColor(Color.WHITE);
                    }else {
                        mRecyclerView.setBackgroundColor(Color.alpha(0));
                    }
                }

                myHandler.sendEmptyMessage(123);
            }

        }).start();
    }


    //地图权限
    private void requestMyPermissions() {
        //获取地图控件引用
        mp =  findViewById(R.id.bmapView);
        mMap = mp.getMap();
        mMap.setMyLocationEnabled(true);

        BaiduMap.OnMapClickListener listener = new BaiduMap.OnMapClickListener() {
            /**
             * 地图单击事件回调函数
             *
             * @param point 点击的地理坐标
             */
            @Override
            public void onMapClick(LatLng point) {
                hideInput();
                geoCoder(point);
                DistrictSearch();

                mEditText.setText("");
                mMap.clear();
            }

            /**
             * 地图内 Poi 单击事件回调函数
             *
             * @param mapPoi 点击的 poi 信息
             */
            @Override
            public void onMapPoiClick(MapPoi mapPoi) {
                hideInput();
                mEditText.setText("");
            }

        };

        BaiduMap.OnMarkerClickListener marklistener = new BaiduMap.OnMarkerClickListener() {
            /**
             * 地图 Marker 覆盖物点击事件监听函数
             * @param marker 被点击的 marker
             */
            @Override
            public boolean onMarkerClick(Marker marker){
                marker.remove();
                return true;
            };

        };

        //设置地图单击事件监听
        mMap.setOnMapClickListener(listener);
        //设置mark单击事件监听
        mMap.setOnMarkerClickListener(marklistener);


        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //没有授权，编写申请权限代码
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        } else {
            Log.d("requestMyPermissions", "requestMyPermissions: 有写SD权限");
        }
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //没有授权，编写申请权限代码
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
        } else {
            Log.d("requestMyPermissions", "requestMyPermissions: 有读SD权限");
        }


        mpOffline();
    }
    //定位当前位置
    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mp == null){
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mMap.setMyLocationData(locData);

            //切换到当前坐标
            MapStatus.Builder builder =new MapStatus.Builder();
            MapStatus s = builder.target(new LatLng(locData.latitude,locData.longitude)).zoom(16).build();
            mMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(s),1000);

            //注销监听
            mLocationClient.unRegisterLocationListener(myLocationListener);

        }
    }
    //定位初始化
    public  void initLocation(){
        // 开启定位图层
        mLocationClient = new LocationClient(this);

        //通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);

        //设置locationClientOption
        mLocationClient.setLocOption(option);

        //注册LocationListener监听器
        myLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myLocationListener);
        //开启地图定位图层
        mLocationClient.start();

        marker();

        //跳转离线地图
        searchMpOffline();
    }
    //点击地图隐藏输入框
    public void hideInput(){
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        View v = getWindow().peekDecorView();
        if (null != v) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
        OfflineInent();
    };
    //新开一个离线界面
    public void OfflineInent (){
        ArrayList<MKOLUpdateElement> localMapList=mOffline.getAllUpdateInfo();
        
        Intent intent = new Intent();
//        intent.putExtra("customStyle", true);
//        intent.putExtra("x", e.geoPt.longitude);
//        intent.putExtra("y", e.geoPt.latitude);
//        intent.putExtra("level", 13.0f);
        intent.setClass(MainActivity.this, OfflineDemo.class);
        startActivity(intent);
    }
    //标记位置
    public void marker(){
        //定义Maker坐标点
        LatLng point = new LatLng(22.546343191420238, 113.94811805583142);
        //构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.mipmap.jianzhu);
        //构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions()
                .position(point) //必传参数
                .icon(bitmap) //必传参数
                .draggable(true)
        //设置平贴地图，在地图中双指下拉查看效果
                .flat(true)
                .alpha(0.5f);

        //在地图上添加Marker，并显示
        mMap.addOverlay(option);
    }

    //覆盖物
    public void groundOvelay(){

        //定义Ground的显示地理范围
        LatLng southwest = new LatLng(22.546343191420238, 113.94811805583142);
        LatLng northeast   = new LatLng(22.556343191420238, 113.95811805583142);

        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(northeast)
                .include(southwest)
                .build();

        //定义Ground显示的图片
        BitmapDescriptor bdGround = BitmapDescriptorFactory.fromResource(R.mipmap.unselect);
        //定义GroundOverlayOptions对象
        ooGround = new GroundOverlayOptions()
                .positionFromBounds(bounds)
                .image(bdGround)
                .transparency(0.8f); //覆盖物透明度

        //在地图中添加Ground覆盖物
        mMap.addOverlay(ooGround);
    }
    //检索行政区边界
    public void DistrictSearch(){
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
        mDistrictSearch.searchDistrict(new DistrictSearchOption()
                .cityName("深圳市")
                .districtName("福田区"));
    }
    public void onNewGetDistrictResult(DistrictResult districtResult) {
        if (null != districtResult && districtResult.error == SearchResult.ERRORNO.NO_ERROR) {
            mMap.clear();
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
                                    mMap.addOverlay(ooPolyline11);
                                    OverlayOptions ooPolygon = new PolygonOptions().points(polyline)
                                            .stroke(new Stroke(5, 0xAA00FF88)).fillColor(0xAAFFFF00);
                                    mMap.addOverlay(ooPolygon);
                                    for (LatLng latLng : polyline) {
                                        builder.include(latLng);
                                    }
                                }

                                mMap.setMapStatus(MapStatusUpdateFactory
                                        .newLatLngBounds(builder.build()));
                            }

                        }).start();

            }
        }
    }
    //创建逆地理编码检索
    public void geoCoder(LatLng point){
        listener1 = new OnGetGeoCoderResultListener () {
            @Override
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {

            }

            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    //没有找到检索结果
                    Log.d("","没有找到检索结果");

                    return;
                } else {
                    //详细地址
                    String address = reverseGeoCodeResult.getAddress();
                    //行政区号
                    int adCode = reverseGeoCodeResult. getCityCode();
                    String city = reverseGeoCodeResult.getAddressDetail().city;
                    String district = reverseGeoCodeResult.getAddressDetail().district;

                    if(city.length() > 0 && district.length() > 0){
                        mDistrictSearch.setOnDistrictSearchListener(searchlistener);
                        mDistrictSearch.searchDistrict(new DistrictSearchOption()
                                .cityName(city)
                                .districtName(district));
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

    //离线地图
    public void mpOffline(){

        mOffline = new MKOfflineMap();
        offlineMaplistener = new MKOfflineMapListener() {
            @Override
            public void onGetOfflineMapState(int i, int i1) {

            }
        };
        // 传入MKOfflineMapListener，离线地图状态发生改变时会触发该回调
        mOffline.init(offlineMaplistener);


        ArrayList<MKOLSearchRecord> records = mOffline.searchCity("武汉市");
        if (records != null && records.size() == 1) {
            // 开始下载离线地图
            mOffline.start(records.get(0).cityID);
        }
    }
    public void searchMpOffline(){
        ArrayList<MKOLUpdateElement> localMapList=mOffline.getAllUpdateInfo();
        Log.i("tag","isok");
        if(localMapList.size() > 0){
            addOffinelineMap(localMapList.get(1).geoPt);
        }else {
            mpOffline();
        }
    }
    public void addOffinelineMap(LatLng point){

        // 构建地图状态
        MapStatus.Builder builder = new MapStatus.Builder();
        // 默认 天安门
        LatLng center = new LatLng(point.latitude, point.longitude);
        // 默认 11级
        float zoom = 14.0f;

        builder.target(center).zoom(zoom);
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(builder.build());

        // 设置地图状态
        mMap.setMapStatus(mapStatusUpdate);
    }


    //地图生命周期三个方法
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mp.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mp.onPause();
    }
    @Override
    protected void onDestroy() {

        mLocationClient.stop();
        mMap.setMyLocationEnabled(false);
        mp.onDestroy();
        mp = null;
        super.onDestroy();
    }

}
