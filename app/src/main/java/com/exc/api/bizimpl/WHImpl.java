package com.exc.api.bizimpl;

import com.badoo.mobile.util.WeakHandler;
import com.exc.api.ApiUrl;
import com.exc.utils.CommonParameter;
import com.exc.utils.HttpUtil;

import java.lang.reflect.Type;

/**
 * .ClassName: AdImpl 请输入该类作用<br/>
 * date: 2019年 11月 20日 16:43<br/>
 *
 * @author ex-hubing002
 */
public class WHImpl {
    private WHImpl() { }

    private HttpUtil httpUtil = HttpUtil.getHttpRequestInstance();
    private static WHImpl whBiz;

    public static WHImpl getInstance() {
        if (null == whBiz) {
            whBiz = new WHImpl();
        }
        return whBiz;
    }

    /**
     * 平板地图--登录
     */
    public void userlogin(WeakHandler handler, CommonParameter hashMap, int successMessage, int failMessage, Type type) {
        httpUtil.post(ApiUrl.URL_USER_LOGIN, handler, hashMap, successMessage, failMessage, type);
    }

    /**
     * 平板地图--窗口查询
     */
    public void partitionQuery(WeakHandler handler, CommonParameter hashMap, int successMessage, int failMessage, Type type) {
        httpUtil.post(ApiUrl.URL_PARTITION_QUERY, handler, hashMap, successMessage, failMessage, type);
    }

    /*
    * 平板地图--站点
    * */
    public void partitionFindlist(WeakHandler handler, CommonParameter hashMap, int successMessage, int failMessage, Type type) {
        httpUtil.post(ApiUrl.URL_PARTITION_FINDLIST, handler, hashMap, successMessage, failMessage, type);
    }

    /*
     * 平板地图--勾选复选框查询站点建筑物
     * */
    public void partitionFindlistbuilding(WeakHandler handler, CommonParameter hashMap, int successMessage, int failMessage, Type type) {
        httpUtil.post(ApiUrl.URL_PARTITION_FINDLISTBUILDING, handler, hashMap, successMessage, failMessage, type);
    }

    /*
     * 根据建筑物ID获取节目列表
     * */
    public void sjcityvideosrcVideo(WeakHandler handler, CommonParameter hashMap, int successMessage, int failMessage, Type type) {
        httpUtil.post(ApiUrl.URL_SJCITYVIDEO_SRCVIDEO, handler, hashMap, successMessage, failMessage, type);
    }

    /**
     * 建筑物强电控制
     */
    public void electricitybuildingchannel(WeakHandler handler, CommonParameter hashMap, int successMessage, int failMessage, Type type) {
        httpUtil.put(ApiUrl.URL_ELECTRICITY_BUILDING_CHANNEL, handler, hashMap, successMessage, failMessage, type);
    }


    /**
     * 楼宇相册
     */
    public void buildingphotonum(WeakHandler handler, CommonParameter hashMap, int successMessage, int failMessage, Type type) {
        httpUtil.post(ApiUrl.URL_BUILDING_PHOTO_NUM, handler, hashMap, successMessage, failMessage, type);
    }


    /**
     * 建筑物详情
     */
    public void sjcityvideoget(WeakHandler handler, CommonParameter hashMap, int successMessage, int failMessage, Type type) {
        httpUtil.post(ApiUrl.URL_SJCITYVIDEO_GET, handler, hashMap, successMessage, failMessage, type);
    }

    /**
     * 分区总览
     */
//    public void partitionhomenew(WeakHandler handler,String agrs, String token, int successMessage, int failMessage, Type type) {
//        httpUtil.get(ApiUrl.PARTITION_HOME_NEW +"?"+ agrs, handler, token, successMessage, failMessage, type);
//    }
    public void partitionhomenew(WeakHandler handler, CommonParameter hashMap, int successMessage, int failMessage, Type type) {
        httpUtil.post(ApiUrl.PARTITION_HOME_NEW, handler, hashMap, successMessage, failMessage, type);
    }

    /**
     * 分区坐标集
     */
    public void partitionhome(WeakHandler handler,String agrs,String token, int successMessage, int failMessage, Type type) {
        httpUtil.get(ApiUrl.PARTITION_HOME +"?"+ agrs, handler, token, successMessage, failMessage, type);
    }


    /**
     * 各分区建筑
     */
    public void homeeoverallHttp(WeakHandler handler, CommonParameter hashMap, int successMessage, int failMessage, Type type) {
        httpUtil.post(ApiUrl.API_PARTITION_HOME_HOMEOVERALL, handler, hashMap, successMessage, failMessage, type);
    }

    /**
     * 获取建设方
     */
    public void partitionBuildHttp(WeakHandler handler, CommonParameter hashMap, int successMessage, int failMessage, Type type) {
        httpUtil.post(ApiUrl.API_PARTITION_BUILD, handler, hashMap, successMessage, failMessage, type);
    }

    /**
     * 图片上传
     */
    public void buildingphotoupload(WeakHandler handler, CommonParameter hashMap, int successMessage, int failMessage, Type type) {
        httpUtil.post(ApiUrl.URL_BUILDING_PHOTO_UPLOAD, handler, hashMap, successMessage, failMessage, type);
    }


    /**
     * 节目切换
     */
    public void sjcityvideodownloadTextFile(WeakHandler handler, CommonParameter hashMap, int successMessage, int failMessage, Type type) {
        httpUtil.post(ApiUrl.URL_SJCITYVIDEO_DOWNLOADTEXTFILE, handler, hashMap, successMessage, failMessage, type);
    }

    /**
     * 获取正在播放的节目信息
     */
    public void sjcityvideogetVid(WeakHandler handler, CommonParameter hashMap, int successMessage, int failMessage, Type type) {
        httpUtil.post(ApiUrl.URL_SJCITYVIDEO_GETVID, handler, hashMap, successMessage, failMessage, type);
    }

    /**
     * 获取正在播放的节目
     */
    public void scriptplaytime(WeakHandler handler, CommonParameter hashMap, int successMessage, int failMessage, Type type) {
        httpUtil.post(ApiUrl.URL_SCRIPT_PLAYTIME, handler, hashMap, successMessage, failMessage, type);
    }
}
