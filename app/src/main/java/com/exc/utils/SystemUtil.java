package com.exc.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.InputType;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * .ClassName: SystemUtils(获取系统相关方法) <br/>
 * date: 2016年1月18日 下午3:33:05 <br/>
 *
 * @author LIUXIN136
 */
public class SystemUtil {

    public static final String WIFI = "WIFI";
    public static final String NETWORK_TYPE_2G = "2G";
    public static final String NETWORK_TYPE_3G = "3G";
    public static final String NETWORK_TYPE_4G = "4G";
    public static final String NETWORK_TYPE_UNKONW = "UNKNOW";
    public static final String NETWORK_TYPE_ETHERNET = "ETHERNET";

    /**
     * isConnect:【判断设备是否联网】. <br/>
     * .@param context .@return.<br/>
     */
    public static boolean isConnect(Context context) {
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        try {
            ConnectivityManager connectivity =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                // 获取网络连接管理的对象
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if (null != info && info.isConnected()) {
                    // 判断当前网络是否已经连接
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * isWifiOpened:【判断设备是否打开wifi开关】. <br/>
     * .@param context .@return.<br/>
     */
    public static boolean isWifiOpened(Context context) {
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivity =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo networkInfo = connectivity.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
        } else {
            return false;
        }
    }

    /**
     * getNetWorkType:【获取网络类型】. <br/>
     * .@param context .@return.<br/>
     */
    public static String getNetWorkType(Context context) {
        String type = "";
        ConnectivityManager connectMgr =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectMgr != null) {
            NetworkInfo info = connectMgr.getActiveNetworkInfo();
            if (null != info && info.isConnected()) {
                if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                    type = WIFI;
                } else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                    switch (info.getSubtype()) {
                        case TelephonyManager.NETWORK_TYPE_GPRS:
                        case TelephonyManager.NETWORK_TYPE_EDGE:
                        case TelephonyManager.NETWORK_TYPE_CDMA:
                        case TelephonyManager.NETWORK_TYPE_1xRTT:
                        case TelephonyManager.NETWORK_TYPE_IDEN:
                            type = NETWORK_TYPE_2G;
                            break;
                        case TelephonyManager.NETWORK_TYPE_UMTS:
                        case TelephonyManager.NETWORK_TYPE_EVDO_0:
                        case TelephonyManager.NETWORK_TYPE_EVDO_A:
                        case TelephonyManager.NETWORK_TYPE_HSDPA:
                        case TelephonyManager.NETWORK_TYPE_HSUPA:
                        case TelephonyManager.NETWORK_TYPE_HSPA:
                        case TelephonyManager.NETWORK_TYPE_EVDO_B:
                        case TelephonyManager.NETWORK_TYPE_EHRPD:
                        case TelephonyManager.NETWORK_TYPE_HSPAP:
                            type = NETWORK_TYPE_3G;
                            break;
                        case TelephonyManager.NETWORK_TYPE_LTE:
                            type = NETWORK_TYPE_4G;
                            break;
                        default:
                            type = NETWORK_TYPE_UNKONW;
                            break;
                    }
                } else if (info.getType() == ConnectivityManager.TYPE_ETHERNET) {
                    type = NETWORK_TYPE_ETHERNET;
                }
            }
        }
        return type;
    }

    /**
     * getVersion:【获取版本名称】. <br/>
     * .@return.<br/>
     */
    public static String getVersion(Context context) {
        String version = "";
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            version = info.versionName;
            if (version == null || "".equals(version)) {
                version = "1.0";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return version;
    }

    /**
     * getVersion:【获取版本号(版本更新)】. <br/>
     * .@return.<br/>
     */
    public static long getVersionCode(Context context) {
        long version = 0;
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            version = info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return version;
    }


    /**
     * getDeviceWH:【获取设备的分辨率】. <br/>
     * .@param context .@return.<br/>
     */
    public static int[] getDeviceWh(Context context) {
        final int[] widthAndHeight = new int[2];
        int width = 0;
        int height = 0;
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        height = dm.heightPixels;
        widthAndHeight[0] = width;
        widthAndHeight[1] = height;
        return widthAndHeight;
    }


    /**
     * getDisplayWidth:【获取屏幕宽度】. <br/>
     * .@param activity .@return.<br/>
     */
    public static int getDisplayWidth(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * getDisplayWidth:【获取屏幕高度度】. <br/>
     * .@param activity .@return.<br/>
     */
    public static int getDisplayHeight(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }


    /**
     * getDisplayWidth:【获取屏幕高度】. <br/>
     * .@param activity .@return.<br/>
     */
    public static int getDisplayHeight(Activity activity) {
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.heightPixels; // 屏幕宽度（像素）
    }

    /**
     * getStatusBarHeight:【获取状态栏高度】. <br/>
     * .@return.<br/>
     */
    public static int getStatusBarHeight(Activity activity) {
        int result = 0;
        int resourceId =
                activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * call:【跳转到拨打电话】. <br/>
     * .@param context .@param phoneNum.<br/>
     */
    public static void call(Context context, String phoneNum) {
        try {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNum));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * call:【直接拨打电话】. <br/>
     * .@param context .@param phoneNum.<br/>
     */
    public static void directCall(Context context, String phoneNum) {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNum));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * getContactPhone:【通过游标获取联系电话】. <br/>
     * .@param cursor .@return.<br/>
     */
    public static String getContactPhone(Context context, Cursor cursor) {
        // TODO Auto-generated method stub
        int phoneColumn = cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);
        int phoneNum = cursor.getInt(phoneColumn);
        String result = "";
        if (phoneNum > 0) {
            // 获得联系人的ID号
            int idColumn = cursor.getColumnIndex(ContactsContract.Contacts._ID);
            String contactId = cursor.getString(idColumn);
            // 获得联系人电话的cursor
            Cursor phone = context.getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactId, null,
                    null);
            if (phone.moveToFirst()) {
                for (; !phone.isAfterLast(); phone.moveToNext()) {
                    int index = phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                    String phoneNumber = phone.getString(index).replace(" ", "");
                    if (phoneNumber.length() >= 11) {
                        result =
                                phoneNumber.substring(phoneNumber.length() - 11, phoneNumber
                                        .length());
                    } else {
                        result = phoneNumber;
                    }
                }
                if (!phone.isClosed()) {
                    phone.close();
                }
            }
        }
        return result;
    }


    /**
     * 获取mac地址
     *
     * @param context
     * @return
     */
    public static String getMac(Context context) {
        String mac = PreferencesUtil.getString(context, "macAddress", "");
        if (TextUtils.isEmpty(mac)) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                mac = getWifiMacAddr(context);
            }
            if (TextUtils.isEmpty(mac)) {
                mac = getLocalEthernetMacAddress();
                if (TextUtils.isEmpty(mac)) {
                    mac = Build.SERIAL;
                }
            }
            mac = mac.replaceAll(":", "");
            PreferencesUtil.putString(context, "macAddress", mac);
        }
        return mac;
    }


    /**
     * 获取以太网地址
     *
     * @return
     */
    private static String getLocalEthernetMacAddress() {
        String mac = null;
        try {
            Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();

            while (localEnumeration.hasMoreElements()) {
                NetworkInterface localNetworkInterface =
                        (NetworkInterface) localEnumeration.nextElement();
                String interfaceName = localNetworkInterface.getDisplayName();
                if (interfaceName == null) {
                    continue;
                }
                if (interfaceName.equals("wlan0")) {
                    mac = convertToMac(localNetworkInterface.getHardwareAddress());
                    if (mac != null && mac.startsWith("0:")) {
                        mac = "0" + mac;
                    }
                    break;
                } else if (interfaceName.equals("eth0")) {
                    mac = convertToMac(localNetworkInterface.getHardwareAddress());
                    if (mac != null && mac.startsWith("0:")) {
                        mac = "0" + mac;
                    }
                    break;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return mac;
    }

    /**
     * mac地址转换
     *
     * @param
     * @return
     */
    private static String convertToMac(byte[] mac) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            byte b = mac[i];
            int value = 0;
            if (b >= 0 && b <= 16) {
                value = b;
                sb.append("0" + Integer.toHexString(value));
            } else if (b > 16) {
                value = b;
                sb.append(Integer.toHexString(value));
            } else {
                value = 256 + b;
                sb.append(Integer.toHexString(value));
            }
            if (i != mac.length - 1) {
                sb.append(":");
            }
        }
        return sb.toString();
    }

    /**
     * 获取WIFI MAC地址
     *
     * @param context
     * @return
     */
    private static String getWifiMacAddr(Context context) {
        String macAddr = "";
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        if (null != info) {
            String addr = info.getMacAddress();
            if (null != addr) {
                macAddr = addr;
            }
        }
        return macAddr;
    }


    /**
     * 获取通用IP
     *
     * @return
     */
    public static String getLocalIpAddress() {
        try {
            for (
                    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    networkInterfaces.hasMoreElements(); ) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                for (Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                     inetAddresses.hasMoreElements(); ) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    //过滤Loopback address, Link-local address
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0.0.0.0";
    }

    /**
     * 屏蔽软键盘并且有光标
     *
     * @param editText
     */
    public static void setSoftInputKeyBord(Activity context, EditText editText) {
        if (Build.VERSION.SDK_INT <= 10) {// 4.0以下 danielinbiti
            editText.setInputType(InputType.TYPE_NULL);
        } else {
            context.getWindow()
                    .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            try {
                Class<EditText> cls = EditText.class;
                Method setShowSoftInputOnFocus;
                setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(editText, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 隐藏键盘
     *
     * @param context 上下文
     */
    public static void hideSoftInput(Context context, EditText et) {
        try {
            InputMethodManager inputMethodManager = ((InputMethodManager) context
                    .getSystemService(Context.INPUT_METHOD_SERVICE));
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(et.getWindowToken(), InputMethodManager
                        .HIDE_NOT_ALWAYS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示键盘
     *
     * @param context 上下文
     */
    public static void showSoftInput(Context context, EditText et) {
        try {
            InputMethodManager inputMethodManager = ((InputMethodManager) context
                    .getSystemService(Context.INPUT_METHOD_SERVICE));
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(et, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * ping 某网络是否可用
     *
     * @param ipOrDomain
     * @return
     */
    public static boolean ping(String ipOrDomain) {
        boolean pingResult = false;
        try {
            // ping -c 3 -w 100 中 ，-c 是指ping的次数 3是指ping 3次 ，-w 100 以秒为单位指定超时间隔，是指超时时间为100秒
            Process p = Runtime.getRuntime().exec("ping -c 3 -w 100 " + ipOrDomain);
            int status = p.waitFor();

            InputStream input = p.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(input));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
            LogUtil.error("ping网络结果---->", buffer.toString());

            if (status == 0) {
                pingResult = true;
            } else {
                pingResult = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pingResult;
    }


    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * 禁止输入框复制粘贴菜单
     */
    public static void disableCopyAndPaste(final EditText editText) {
        try {
            if (editText == null) {
                return;
            }

            editText.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return true;
                }
            });
            editText.setLongClickable(false);
            editText.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        // setInsertionDisabled when user touches the view
                        setInsertionDisabled(editText);
                    }

                    return false;
                }
            });
            editText.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
                @Override
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                @Override
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                @Override
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    return false;
                }

                @Override
                public void onDestroyActionMode(ActionMode mode) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setInsertionDisabled(EditText editText) {
        try {
            Field editorField = TextView.class.getDeclaredField("mEditor");
            editorField.setAccessible(true);
            Object editorObject = editorField.get(editText);

            // if this view supports insertion handles
            Class editorClass = Class.forName("android.widget.Editor");
            Field mInsertionControllerEnabledField = editorClass.getDeclaredField
                    ("mInsertionControllerEnabled");
            mInsertionControllerEnabledField.setAccessible(true);
            mInsertionControllerEnabledField.set(editorObject, false);

            // if this view supports selection handles
            Field mSelectionControllerEnabledField = editorClass.getDeclaredField
                    ("mSelectionControllerEnabled");
            mSelectionControllerEnabledField.setAccessible(true);
            mSelectionControllerEnabledField.set(editorObject, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 跳转到打开通知权限页面
     */
    public static void turnToNotificationDetails(Context context) {
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);

            //这种方案适用于 API 26, 即8.0（含8.0）以上可以用
            intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.getPackageName());
            intent.putExtra(Settings.EXTRA_CHANNEL_ID, context.getApplicationInfo().uid);

            //这种方案适用于 API21——25，即 5.0——7.1 之间的版本可以使用
            intent.putExtra("app_package", context.getPackageName());
            intent.putExtra("app_uid", context.getApplicationInfo().uid);

            context.startActivity(intent);
        } catch (Exception e) {
            // 出现异常则跳转到应用设置界面：锤子坚果3——OC105 API25
            Intent intent = new Intent();

            //下面这种方案是直接跳转到当前应用的设置界面。
            //https://blog.csdn.net/ysy950803/article/details/71910806
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", context.getPackageName(), null);
            intent.setData(uri);
            context.startActivity(intent);
        }
    }

    /**
     * 判断手机是否显示虚拟按键
     *
     * @param activity
     * @return
     */
    public static boolean isNavigationBarShow(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Display display = activity.getWindowManager().getDefaultDisplay();
            Point size = new Point();
            Point realSize = new Point();
            display.getSize(size);
            display.getRealSize(realSize);
            boolean result = realSize.y != size.y;
            return realSize.y != size.y;
        } else {
            boolean menu = ViewConfiguration.get(activity).hasPermanentMenuKey();
            boolean back = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
            if (menu || back) {
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * 直接隐藏虚拟按键并且全屏
     */
    public static void hideNavigationBarAndFullscreen(Activity activity) {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
            View view = activity.getWindow().getDecorView();
            view.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            View decorView = activity.getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    /**
     * 隐藏虚拟按键
     */
    public static void hideNavigationBar(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(0);
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
    }



}
