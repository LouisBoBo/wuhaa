package com.exc.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * ClassName:. LogUtil【打印日志类】 <br/>
 *
 * @author LIUXIN136
 * @data
 */

public class LogUtil {

    private static final String TAG = "Vicinity";

    private static boolean isDebug ;

    private static int logLevel = Log.VERBOSE;

    /**
     * 设置是否是debug模式，debug模式显示日志，反之不显示
     */
    public static void setDebug(boolean debug) {
        isDebug = debug;
    }

    /**
     * 设置log最低显示级别
     */
    public static void setLogLevel(int level) {
        logLevel = level;
    }

    /**
     * verbose:(日志的输出级别类型). <br/>
     */
    public static void verbose(String tag, String msg) {
        if (isDebug && logLevel <= Log.VERBOSE) {
            if (!TextUtils.isEmpty(msg)) {
                Log.v(tag, msg);
            }
        }
    }

    /**
     * debug:(日志的输出级别类型). <br/>
     */
    public static void debug(String tag, String msg) {
        if (isDebug && logLevel <= Log.DEBUG) {
            if (!TextUtils.isEmpty(msg)) {
                Log.d(tag, msg);
            }
        }
    }

    /**
     * info:(日志的输出级别类型). <br/>
     */

    public static void info(String tag, String msg) {
        if (isDebug && logLevel <= Log.INFO) {
            if (!TextUtils.isEmpty(msg)) {
                Log.i(tag, msg);
            }
        }
    }

    /**
     * warn:(日志的输出级别类型). <br/>
     */

    public static void warn(String tag, String msg) {
        if (isDebug && logLevel <= Log.WARN) {
            if (!TextUtils.isEmpty(msg)) {
                Log.w(tag, msg);
            }
        }
    }

    /**
     * error:(日志的输出级别类型). <br/>
     */

    public static void error(String tag, String msg) {
        if (isDebug && logLevel <= Log.ERROR) {
            if (!TextUtils.isEmpty(msg)) {
                Log.e(tag, msg);
            }
        }
    }

    /**
     * error:(打印日志,Tag固定). <br/>
     */
    public static void error(String msg) {
        if (isDebug) {
            if (!TextUtils.isEmpty(msg)) {
                Log.e(TAG, msg);
            }
        }
    }

    /**
     * error:【打印错误日志不同参数】. <br/>
     * .@param msg .@param tr.<br/>
     */
    public static void error(String tag, String msg, Throwable tr) {
        if (!TextUtils.isEmpty(msg)) {
            Log.e(tag, msg, tr);
        }
    }
}
