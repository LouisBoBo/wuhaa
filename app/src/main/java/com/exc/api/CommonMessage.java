package com.exc.api;

/**
 * 基础库公用常量类
 * Created By zhangyup72 At 2019-07-10
 */
public class CommonMessage {

    //公用广播KEY****************************************************************

    //用户中心开始
    //进入登录页面
    public static final String USER_CENTER_LOGIN = "startLogin";

    //登出广播
    public static final String USER_CENTER_EXITLOGIN = "exitLogin";

    //自动登录广播
    public static final String USER_CENTER_AUTOLOGIN = "autoLogin";

    //更细用户
    public static final String USER_CENTER_UPDATE_USER = "updateUser";

    //平安推送
    public static final String BINDPAPUSH = "bindPAPush";
    /**
     * 解析 SP存储的推送信息
     */
    public static final String HOME_PROCESS_DBMESSAGE = "home_process_dbmessage";    //首页广播-检查本地存储的未处理推送信息
    public static final String ACTION_ANALY_SHARE = "action_analy_share_data";
    public static final String PARM_ANALY_SHARE_DATA = "analy_share_data";
    public static final String RECEVICE_PAPUSH = "com.pingan.elderly.recevice_papush";//接收到平安推送
    public static final String RECEVICE_PAPUSH_PARAM = "recevice_papush_param";//接收到平安推送参数
    public static final String RECEVICE_PAPUSH_CONTENT = "recevice_papush_content";//接收到平安推送标题
    public static final String RECEVICE_PAPUSH_DNA = "recevice_papush_dna";//接收到平安推送标识

    //用户中心结束


    //消息中心开始
    //进入消息中心
    public static final String MESSAGE_CENTER_START_PAGE = "startMessageCenter";

    //更新消息
    public static final String MESSAGE_CENTER_UPDATE = "updateMessage";

    //获取消息总数
    public static final String MESSAGE_CENTER_GET_MESSAGE_COUNT = "getMessageCount";
    //消息中心结束


    //菜单中心
    //进入菜单1
    public static final String MENU_CENTER_TAB1 = "menu_tab1";

    //进入菜单2
    public static final String MENU_CENTER_TAB2 = "menu_tab2";

    //进入菜单3
    public static final String MENU_CENTER_TAB3 = "menu_tab3";

    //进入菜单4
    public static final String MENU_CENTER_TAB4 = "menu_tab4";

    //进入菜单5
    public static final String MENU_CENTER_TAB5 = "menu_tab5";

    //进入菜单6
    public static final String MENU_CENTER_TAB6 = "menu_tab6";
    //菜单结束


    //进入页面开始
    //进入页面1
    public static final String PAGE_CENTER_START1 = "star_page1";  //【老人】/【子女：我的-电子围栏】/【爱护到家：服务人员首页】

    //进入页面2
    public static final String PAGE_CENTER_START2 = "star_page2";//【老人：】/【子女：】/【爱护到家：管理员首页】

    //进入页面3
    public static final String PAGE_CENTER_START3 = "star_page3"; //【老人】引导完善个人信息 / 【子女】引导设置关怀

    //进入页面4
    public static final String PAGE_CENTER_START4 = "star_page4";

    //进入页面5
    public static final String PAGE_CENTER_START5 = "star_page5";    //【老人】用药设置-选择药品页面/【子女】引导完善个人信息

    //进入页面6
    public static final String PAGE_CENTER_START6 = "star_page6";    //跳转大图查看（相册模块）

    //进入页面7
    public static final String PAGE_CENTER_START7 = "star_page7";    //跳转相册详情（相册模块）

    //进入页面8
    public static final String PAGE_CENTER_START8 = "star_page8";    //家人/我的主页

    //进入页面9
    public static final String PAGE_CENTER_START9 = "star_page9";

    //进入页面10
    public static final String PAGE_CENTER_START10 = "star_page10";  //进入我的信息或家人的信息

    public static final String PAGE_CENTER_START11 = "star_page11";  //进入设置关怀

    public static final String PAGE_CENTER_START12 = "star_page12";  //进入个人关怀管理

    public static final String PAGE_CENTER_START13 = "star_page13";  //进入引导关怀设置

    public static final String PAGE_CENTER_START14 = "star_page14";  //跳转上传任务进度界面（相册模块）

    public static final String PAGE_CENTER_START15 = "star_page15";  //跳转播放视频

    public static final String PAGE_CENTER_START16 = "star_page16";  //文件下载功能（相册模块）

    public static final String PAGE_CENTER_START17 = "star_page17";  //我的视频相册（相册模块）

    public static final String PAGE_CENTER_START18 = "star_page18";  //相册主页（相册模块）


    //进入页面结束

    //版本更新
    //app版本更新
    public static final String APP_VERSION_UPDATE = "appUpdate";

    public static final String APP_AGREEMENT = "appAgreement";
    public static final String APP_AGREEMENT_AGREE = "appAgreementAgree";
    public static final String APP_PERMISSION_SHOW = "appPermissionShow";     //展示权限说明
    public static final String APP_PERMISSION_KNOW = "appPermissionKnow";   //了解了权限说明
    public static final String APP_SCRAM_SHOW = "appScramShow";     //展示诈骗权限
    public static final String APP_SCRAM_KNOW = "appScramKnow";   //了解了诈骗权限


    //参数传递
    public static final String INTENT_KEY_DATA_0 = "data_0";
    public static final String INTENT_KEY_DATA_1 = "data_1";
    public static final String INTENT_KEY_DATA_2 = "data_2";
    public static final String INTENT_KEY_DATA_3 = "data_3";
    public static final String INTENT_KEY_DATA_4 = "data_4";
    public static final String INTENT_KEY_DATA_5 = "data_5";
    public static final String INTENT_KEY_DATA_6 = "data_6";
    public static final String INTENT_KEY_DATA_7 = "data_7";

    //网络开始请求返回消息类型******************************************************************
    public static final int MSG_REQUEST_SUCCESS_1 = 1000;
    public static final int MSG_REQUEST_SUCCESS_2 = 1001;
    public static final int MSG_REQUEST_SUCCESS_3 = 1002;
    public static final int MSG_REQUEST_SUCCESS_4 = 1003;
    public static final int MSG_REQUEST_SUCCESS_5 = 1004;
    public static final int MSG_REQUEST_SUCCESS_6 = 1005;
    public static final int MSG_REQUEST_SUCCESS_7 = 1006;
    public static final int MSG_REQUEST_SUCCESS_8 = 1007;
    public static final int MSG_REQUEST_SUCCESS_9 = 1008;
    public static final int MSG_REQUEST_SUCCESS_10 =1009;
    public static final int MSG_REQUEST_SUCCESS_11 =1010;
    public static final int MSG_REQUEST_SUCCESS_12 =1011;
    public static final int MSG_REQUEST_SUCCESS_13 =1012;
    public static final int MSG_REQUEST_SUCCESS_14 =1013;
    public static final int MSG_REQUEST_SUCCESS_15 =1014;
    public static final int MSG_REQUEST_SUCCESS_16 =1016;

    public static final int MSG_REQUEST_FAILURE_1 = 2001;
    public static final int MSG_REQUEST_FAILURE_2 = 2002;
    public static final int MSG_REQUEST_FAILURE_3 = 2003;
    public static final int MSG_REQUEST_FAILURE_4 = 2004;
    public static final int MSG_REQUEST_FAILURE_5 = 2005;
    public static final int MSG_REQUEST_FAILURE_6 = 2006;
    public static final int MSG_REQUEST_FAILURE_7 = 2007;
    public static final int MSG_REQUEST_FAILURE_8 = 2008;
    public static final int MSG_REQUEST_FAILURE_9 = 2009;
    public static final int MSG_REQUEST_FAILURE_10 =2010;
    public static final int MSG_REQUEST_FAILURE_11 =2011;
    public static final int MSG_REQUEST_FAILURE_12 =2012;
    public static final int MSG_REQUEST_FAILURE_13 =2013;
    public static final int MSG_REQUEST_FAILURE_14 =2014;
    public static final int MSG_REQUEST_FAILURE_15 =2015;
    public static final int MSG_REQUEST_FAILURE_16 =2016;

    //成功消息
    public static final int REQUEST_SUCCESS = 200;
    //失败消息
    public static final int REQUEST_FAILURE = -1;
    //网络请求结束返回消息类型******************************************************************

    //消息开始等待时间
    public static final long MSG_REQUEST_WAIT_1 = 1000;
    public static final long MSG_REQUEST_WAIT_2 = 2000;
    public static final long MSG_REQUEST_WAIT_3 = 3000;
    public static final long MSG_REQUEST_WAIT_4 = 4000;
    public static final long MSG_REQUEST_WAIT_5 = 5000;
    public static final long MSG_REQUEST_WAIT_6 = 6000;
    public static final long MSG_REQUEST_WAIT_7 = 200;
    public static final long MSG_REQUEST_WAIT_8 = 300;
    public static final long MSG_REQUEST_WAIT_9 = 400;
    public static final long MSG_REQUEST_WAIT_10 = 500;
    //消息结束等待时间

    //相关广播成功消息开始
    public static final String MESSAGE_SUCCESS1 = "message_success1";//用于登录成功
    public static final String MESSAGE_SUCCESS2 = "message_success2";//记住登录历史记录
    public static final String MESSAGE_SUCCESS3 = "message_success3";//已被使用
    public static final String MESSAGE_SUCCESS4 = "message_success4";//添加家人成功
    public static final String MESSAGE_SUCCESS5 = "message_success5";//引导关怀设置成功
    public static final String MESSAGE_SUCCESS6 = "message_success6";//文件下载成功
    public static final String MESSAGE_SUCCESS7 = "message_success7";
    public static final String MESSAGE_SUCCESS8 = "message_success8";
    public static final String MESSAGE_SUCCESS9 = "message_success9";
    public static final String MESSAGE_SUCCESS10 = "message_succes10";
    //相关广播成功消息结束


    //相关广播失败消息开始
    public static final String MESSAGE_FAILURE_1 = "message_failure_1";
    public static final String MESSAGE_FAILURE_2 = "message_failure_2";
    public static final String MESSAGE_FAILURE_3 = "message_failure_3";
    public static final String MESSAGE_FAILURE_4 = "message_failure_4";
    public static final String MESSAGE_FAILURE_5 = "message_failure_5";
    public static final String MESSAGE_FAILURE_6 = "message_failure_6";
    public static final String MESSAGE_FAILURE_7 = "message_failure_7";
    public static final String MESSAGE_FAILURE_8 = "message_failure_8";
    public static final String MESSAGE_FAILURE_9 = "message_failure_9";
    public static final String MESSAGE_FAILURE_10 = "message_failure_10";
    //相关广播失败消息结束


    //普通MESS消息开始
    public static final int ORDINARY_MESSAGE0 = 0x110;
    public static final int ORDINARY_MESSAGE1 = 0x111;
    public static final int ORDINARY_MESSAGE2 = 0x112;
    public static final int ORDINARY_MESSAGE3 = 0x113;
    public static final int ORDINARY_MESSAGE4 = 0x114;
    public static final int ORDINARY_MESSAGE5 = 0x115;
    public static final int ORDINARY_MESSAGE6 = 0x116;
    public static final int ORDINARY_MESSAGE7 = 0x117;
    public static final int ORDINARY_MESSAGE8 = 0x118;
    public static final int ORDINARY_MESSAGE9 = 0x119;
    //普通MESS消息结束

    //分享相关ID,用于回调中区分分享事件开始
    public static final String SHARE_ROUTER_ID_0 = "share_router_id_0";//长者端：【邀请朋友一起玩】/
    public static final String SHARE_ROUTER_ID_1 = "share_router_id_1";
    public static final String SHARE_ROUTER_ID_2 = "share_router_id_2";
    public static final String SHARE_ROUTER_ID_3 = "share_router_id_3";
    public static final String SHARE_ROUTER_ID_4 = "share_router_id_4";
    public static final String SHARE_ROUTER_ID_5 = "share_router_id_5";
    public static final String SHARE_ROUTER_ID_6 = "share_router_id_6";
    public static final String SHARE_ROUTER_ID_7 = "share_router_id_7";
    public static final String SHARE_ROUTER_ID_8 = "share_router_id_8";
    public static final String SHARE_ROUTER_ID_9 = "share_router_id_9";
    //分享相关ID结束
}
