package com.exc.wuh;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;

public class OfflineActivity extends AppCompatActivity {
    // MapView 是地图主控件
    private MapView mMapView;
    private BaiduMap mBaiduMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();

        // 构建地图状态
        MapStatus.Builder builder = new MapStatus.Builder();
        // 默认 天安门
        LatLng center = new LatLng(39.915071, 116.403907);
        // 默认 11级
        float zoom = 11.0f;

        // 该Intent是OfflineDemo中查看离线地图调起的
        Intent intent = getIntent();
        if (null != intent) {
            center = new LatLng(intent.getDoubleExtra("y", 39.915071),
                    intent.getDoubleExtra("x", 116.403907));
            zoom = intent.getFloatExtra("level", 11.0f);
        }

        builder.target(center).zoom(zoom);
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(builder.build());

        // 设置地图状态
        mBaiduMap.setMapStatus(mapStatusUpdate);
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
}
