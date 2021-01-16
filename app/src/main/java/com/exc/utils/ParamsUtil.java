package com.exc.utils;

/**
 * 项目名称:智慧城市智慧养老 . <br/>
 * 文件名称:ParamsUtil.java . <br/>
 * 所有接口地址都放在这里每个模块用自己的WebURL
 *
 * @author LIUXIN136. <br/>
 */

public class ParamsUtil {

    public static final String MACHINECODE = "machineCode";
    public static final String MACADDRESS = "macAddress";

    public static final String ANDROID = "android";
    public static final String LOGINSTATUS = "0";//未登录状态为0,登录状态为1

    //以下参数放入header
    public static final String TOKEN = "token";
    public static final String TIMESTAMP = "timestamp";
    public static final String REQUESTID = "requestId";
    public static final String USERCODE = "userCode";
    public static final String SIGN = "sign";
    public static final String CHANNELID = "channelId";
    public static final String USERTYPE = "userType";
    public static final String VERSIONVALUE = "v1";
    //以上参数放入header

    //以下参数放入body
    public static final String BRAND = "brand";
    public static final String CLIENTVERSION = "clientVersion";
    public static final String NETWORKTYPE = "networkType";// 加入APP版本号
    public static final String SCREEN = "screen";
    public static final String VERSION = "version";
    //以上参数放入body
}
