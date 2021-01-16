package com.exc.utils;

import android.content.Context;

/**
 * 保存User信息
 */
public class UserInfoUtil {

    /***
     * 保存登录信息
     * 用户端
     */
    public static void saveUserInfo(Context context, String userCode, String token) {
        PreferencesUtil.putString(context, ParamsUtil.USERCODE, userCode);
        PreferencesUtil.putString(context, ParamsUtil.TOKEN, token);
        PreferencesUtil.putBoolean(context, ParamsUtil.LOGINSTATUS, true);
    }

    public static String getUserCode(Context context) {
        return PreferencesUtil.getString(context, ParamsUtil.USERCODE);

    }

    public static void saveUserInfo(Context context, String token) {
        PreferencesUtil.putString(context, ParamsUtil.TOKEN, token);
    }
    public static String getToken(Context context) {
        return PreferencesUtil.getString(context, ParamsUtil.TOKEN);
    }

    /**
     * 获取登录状态
     */
    public static boolean getLoginStatus(Context context) {
        return PreferencesUtil.getBoolean(context, ParamsUtil.LOGINSTATUS);
    }

    /**
     * 退出登陆清空标示
     */

    public static void loginExit(Context context) {
        PreferencesUtil.putBoolean(context, ParamsUtil.LOGINSTATUS, false);
    }
}
