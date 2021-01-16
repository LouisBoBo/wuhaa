package com.exc.api;

public class ApiUrl {

//    public static final String SERVICES_ADDRESS ="http://192.168.112.78:9702/";
    public static final String SERVICES_ADDRESS ="http://10.192.47.10:9702/";


    //如果有端口
    private static final String PORT = "";

    private static final String ERP_FIX = SERVICES_ADDRESS + PORT;


    /**
     * 登录
     */
    public static final String URL_USER_LOGIN = ERP_FIX +
            "api/user/login";

    /**
     * 平板地图
     * 窗口查询
     */
    public static final String URL_PARTITION_QUERY = ERP_FIX +
            "api/partition/query";

    /**
     * 平板地图--站点
     */
    public static final String URL_PARTITION_FINDLIST = ERP_FIX +
            "api/partition/findlist";

    /**
     * 平板地图--勾选复选框查询站点建筑物
     */
    public static final String URL_PARTITION_FINDLISTBUILDING = ERP_FIX +
            "api/partition/findListBuilding";

    /**
     * 根据建筑物ID获取节目列表
     */
    public static final String URL_SJCITYVIDEO_SRCVIDEO = ERP_FIX +
            "api/sjcityvideo/srcVideo";

    /**
     * 建筑物强电控制
     */
    public static final String URL_ELECTRICITY_BUILDING_CHANNEL = ERP_FIX +
            "api/electricity/building/channel";

    /**
     * 楼宇相册
     */
    public static final String URL_BUILDING_PHOTO_NUM = ERP_FIX +
            "api/building/photo/num";

    /**
     * 建筑物详情
     */
    public static final String URL_SJCITYVIDEO_GET = ERP_FIX +
            "api/sjcityvideo/get";

    /**
     * 分区总览
     */
    public static final String PARTITION_HOME_NEW = ERP_FIX +
            "api/partition/home/new";

    /**
     * 分区坐标集
     */
    public static final String PARTITION_HOME = ERP_FIX +
            "api/partition/home";

    /**
     * 各分区建筑
     */
    public static final String API_PARTITION_HOME_HOMEOVERALL = ERP_FIX + "api/partition/home/homeOverall";

    /**
     * 获取建设方
     */
    public static final String API_PARTITION_BUILD = ERP_FIX + "api/partition/build";

    /**
     * 图片上传
     */
    public static final String URL_BUILDING_PHOTO_UPLOAD = ERP_FIX +
            "api/building/photo/upload";

    /**
     * 节目切换
     */
    public static final String URL_SJCITYVIDEO_DOWNLOADTEXTFILE = ERP_FIX +
            "api/sjcityvideo/downloadTextFile";

    /**
     * 获取正在播放的节目信息
     */
    public static final String URL_SJCITYVIDEO_GETVID = ERP_FIX +
            "api/sjcityvideo/getVid";

    /**
     * 获取正在播放的节目
     */
    public static final String URL_SCRIPT_PLAYTIME = ERP_FIX +
            "api/script/playtime";
}
