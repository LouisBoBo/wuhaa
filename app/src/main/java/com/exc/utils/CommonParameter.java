package com.exc.utils;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称:智慧城市智慧养老 . <br/>
 * 文件名称:CommonParameter.java . <br/>
 * 所有接口地址都走公用参数
 *
 * @author LIUXIN . <br/>
 */

public class CommonParameter {

    public static String userType;

    private Context context;
    private HashMap<String, Object> hashMap;
    private HashMap<String, Object> headers;

    //构造函数方法
    public CommonParameter(Context context, HashMap<String, Object> hashMap) {
        this.context = context;
        try {
            this.hashMap = hashMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getFullUrl:【拼接必需的参数，返回完整的url】. <br/>
     * .@param url .@return.<br/>
     */
    public String getFullUrl(String url) {
        String ipFullAdd;
        StringBuilder builder = new StringBuilder();
        builder.append(url);
        builder.append(url);
        ipFullAdd = builder.toString();
        return ipFullAdd;
    }

    /**
     * 包入Head
     *
     * @return
     */
    //todo 可能会增加头信息
    public Map<String, Object> getHead() {
        headers = new HashMap<>();
        try {
            headers.put(ParamsUtil.TOKEN, UserInfoUtil.getToken(context));
//            headers.put("Content-Type", "application/json;charset=UTF-8");
//            headers.put(ParamsUtil.USERCODE, UserInfoUtil.getUserCode(context));
//            headers.put(ParamsUtil.TIMESTAMP, ParamSignUtil.getTimestamp());
//            headers.put(ParamsUtil.REQUESTID, ParamSignUtil.getRequestId());
//            headers.put(ParamsUtil.CHANNELID, ParamsUtil.ANDROID);
//            headers.put(ParamsUtil.VERSION, ParamsUtil.VERSIONVALUE);//字符串 + 版本code
//            headers.put(ParamsUtil.USERTYPE, userType);
//            headers.put(ParamsUtil.SIGN, ParamSignUtil.sign(signBodyHead()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return headers;
    }

    /**
     * 包入Body
     *
     * @return
     */
    public Map<String, Object> getBody() {
//        hashMap.put(ParamsUtil.BRAND, android.os.Build.BRAND);
//        hashMap.put(ParamsUtil.CLIENTVERSION, SystemUtil.getVersionCode(context));
//        hashMap.put(ParamsUtil.MACHINECODE, SystemUtil.getMac(context));
//        hashMap.put(ParamsUtil.NETWORKTYPE, SystemUtil.getNetWorkType(context));
//        hashMap.put(ParamsUtil.SCREEN, SystemUtil.getDisplayHeight(context) + "x" + SystemUtil
//                .getDisplayWidth(context));
        return hashMap;
    }

    /**
     * 用于签名验证
     *
     * @return
     */
    private Map<String, Object> signBodyHead() {
        Map<String, Object> headBody = new HashMap<>();
        headBody.putAll(hashMap);
        headBody.putAll(headers);
        return headBody;
    }

}