/**
 * 项目名称:智慧城市智慧养老 . <br/>
 * 文件名称:HttpUtil.java . <br/>
 * 2018.10.10
 *
 * @author LIUXIN136 . <br/>
 */
package com.exc.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.badoo.mobile.util.WeakHandler;
import com.exc.api.CommonMessage;
import com.exc.api.vo.BaseVo;
import com.exc.wuh.MapTypeDemo;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 所有网络请求统一入口
 */

public class HttpUtil {
    private static Context context;
    private String tag = HttpUtil.class.getSimpleName();
    private MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    // 注意，这里没有final
    private static HttpUtil single;
    private OkHttpClient mOkHttpClient;
    private Gson gson;

    private String errorMessage = "网络开了个小差";

    public static void setContext(Context context) {
        HttpUtil.context = context;
    }

    private HttpUtil() {
        OkHttpClient.Builder ClientBuilder = new OkHttpClient.Builder();
        ClientBuilder.readTimeout(30, TimeUnit.SECONDS);// 读取超时
        ClientBuilder.connectTimeout(45, TimeUnit.SECONDS);// 连接超时
        ClientBuilder.writeTimeout(60, TimeUnit.SECONDS);// 写入超时
        mOkHttpClient = ClientBuilder.build();
        gson = new Gson();
    }

    /**
     * .getHttpRequestInstance:单列模式
     */
    public static HttpUtil getHttpRequestInstance() {
        if (null == single) {
            single = new HttpUtil();
        }
        return single;
    }

    /**
     * get请求
     *
     * @param url
     * @param handler
     * @param successMessage
     * @param failMessage
     * @param type
     */
    public void get(final String url, final WeakHandler handler,String token, final int successMessage,
                    final int failMessage, final Type type) {
        try {
            //get 添加token
            Request.Builder builder = new Request.Builder();
            builder.addHeader(ParamsUtil.TOKEN, token);

            Request request = builder.url(url).get().build();
            mOkHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    LogUtil.error(tag, "接口地址为" + url + ".....请求异常");
                    sendError(handler, failMessage, errorMessage);
                    ToastUtils.showToast(context, e.getMessage(), false);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.code() == 200) {
                        ResponseBody body = response.body();
                        LogUtil.error(tag, url);
                        if (null != body) {
                            String result = body.string();
                            LogUtil.error(tag, "..........." + result);
                            parseData(handler, successMessage, failMessage, result, type);
                        } else {
                            sendError(handler, failMessage, errorMessage);
                            LogUtil.error(tag, "........... body is null");
                        }
                    } else {
                        sendError(handler, failMessage, errorMessage);
                        LogUtil.error(tag, url);
                        LogUtil.error(tag, response.message());
                    }
                }
            });
        } catch (Exception ex) {
            LogUtil.error(tag, url);
            LogUtil.error(tag, ex.getMessage());
            sendError(handler, failMessage, errorMessage);
        }
    }

    /**
     * post请求
     *
     * @param url
     * @param handler
     * @param hashMap
     * @param successMessage
     * @param failMessage
     * @param type
     */
    public void post(final String url, final WeakHandler handler, final CommonParameter
            hashMap, final int successMessage, final int failMessage, final Type type) {
        try {
            Request.Builder builder = new Request.Builder();

            RequestBody body = RequestBody.create(new Gson().toJson(hashMap.getBody()), JSON);

            Map<String, Object> headers = hashMap.getHead();
            if (null != headers && headers.size() > 0) {
                Set<String> headKeySet = headers.keySet();
                for (String key : headKeySet) {
                    String value = headers.get(key).toString();
                    builder.addHeader(key, value);
                }
            }
            Request request = builder.url(url).post(body).build();

            mOkHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    LogUtil.error(tag, "接口地址为" + url + ".....请求异常");
                    LogUtil.error(tag, hashMap.toString());
                    sendError(handler, failMessage, errorMessage);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.code() == 200) {
                        ResponseBody body = response.body();
                        LogUtil.error(tag, url);
                        LogUtil.error(tag, "param : " + new Gson().toJson(hashMap.getBody()));
                        if (null != body) {
                            String result = body.string();
                            LogUtil.error(tag, "..........." + result);
                            parseData(handler, successMessage, failMessage, result, type);
                        } else {
                            sendError(handler, failMessage, errorMessage);
                            LogUtil.error(tag, "........... body is null");
                        }
                    } else {
                        sendError(handler, failMessage, errorMessage);
                        LogUtil.error(tag, url);
                        LogUtil.error(tag, response.message());
                    }
                }
            });
        } catch (Exception ex) {
            LogUtil.error(tag, url);
            LogUtil.error(tag, ex.getMessage());
            sendError(handler, failMessage, errorMessage);
        }
    }


    /**
     * put请求
     *
     * @param url
     * @param handler
     * @param hashMap
     * @param successMessage
     * @param failMessage
     * @param type
     */
    public void put(final String url, final WeakHandler handler, final CommonParameter
            hashMap, final int successMessage, final int failMessage, final Type type) {
        try {
            Request.Builder builder = new Request.Builder();

            RequestBody body = RequestBody.create(new Gson().toJson(hashMap.getBody()), JSON);

            Map<String, Object> headers = hashMap.getHead();
            if (null != headers && headers.size() > 0) {
                Set<String> headKeySet = headers.keySet();
                for (String key : headKeySet) {
                    String value = headers.get(key).toString();
                    builder.addHeader(key, value);
                }
            }
            Request request = builder.url(url).put(body).build();

            mOkHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    LogUtil.error(tag, "接口地址为" + url + ".....请求异常");
                    LogUtil.error(tag, hashMap.toString());
                    sendError(handler, failMessage, errorMessage);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.code() == 200) {
                        ResponseBody body = response.body();
                        LogUtil.error(tag, url);
                        LogUtil.error(tag, "param : " + new Gson().toJson(hashMap.getBody()));
                        if (null != body) {
                            String result = body.string();
                            LogUtil.error(tag, "..........." + result);
                            parseData(handler, successMessage, failMessage, result, type);
                        } else {
                            sendError(handler, failMessage, errorMessage);
                            LogUtil.error(tag, "........... body is null");
                        }
                    } else {
                        sendError(handler, failMessage, errorMessage);
                        LogUtil.error(tag, url);
                        LogUtil.error(tag, response.message());
                    }
                }
            });
        } catch (Exception ex) {
            LogUtil.error(tag, url);
            LogUtil.error(tag, ex.getMessage());
            sendError(handler, failMessage, errorMessage);
        }
    }
    /**
     * 解析数据,封装成实体对象返回
     *
     * @param handler
     * @param successMessage
     * @param failMessage
     * @param result
     * @param type
     */
    private void parseData(WeakHandler handler, int successMessage, int failMessage, String result,
                           Type type) {
        try {
            Object vo = gson.fromJson(result, type);
            sendMessage(handler, successMessage, vo);
            BaseVo baseVo = (BaseVo) vo;
            if (baseVo.getCode() == 405 || baseVo.getCode() == 404) {//登录token失效,登录被下线
                showAlert("" + baseVo.getMessage());
            }
        } catch (Exception ex) {
            sendError(handler, failMessage, result);
            LogUtil.error(tag, ex.getMessage());
        }
    }

    /**
     * sendMessage:【发送成功消息】. <br/>
     * .@param handler .@param successMessage .@param object.<br/>
     */
    private void sendMessage(WeakHandler handler, int successMessage, Object object) {
        Message message = new Message();
        message.what = successMessage;
        message.obj = object;
        if (null != handler) {
            handler.sendMessage(message);
        }
    }

    /**
     * sendError:【发送失败消息】. <br/>
     * .@param handler .@param failMessage.<br/>
     */
    private void sendError(WeakHandler handler, int failMessage, Object obj) {
        Message message = new Message();
        message.what = failMessage;
        message.obj = obj;
        if (null != handler) {
            handler.sendMessage(message);
        }
    }


    /**
     * 提示信息
     *
     * @param string
     */
    private void showAlert(final String string) {
        ToastUtils.showToast(context.getApplicationContext(), string, false);
        //跳转登录
        LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(new Intent(CommonMessage.USER_CENTER_LOGIN));
        //发送广播退出清除数据库
        LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(new Intent(CommonMessage.USER_CENTER_EXITLOGIN));
    }

    /**
     * get请求
     *
     * @param url
     * @param handler
     * @param successMessage
     * @param failMessage
     * @param type
     */
    public void get(final String url, final Handler handler, final int successMessage,
                    final int failMessage, final Type type) {
        try {
            Request request = new Request.Builder().url(url).get().build();
            mOkHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    LogUtil.error(tag, "接口地址为" + url + ".....请求异常");
                    sendError(handler, failMessage, errorMessage);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.code() == 200) {
                        ResponseBody body = response.body();
                        LogUtil.error(tag, url);
                        if (null != body) {
                            String result = body.string();
                            LogUtil.error(tag, "..........." + result);
                            parseData(handler, successMessage, failMessage, result, type);
                        } else {
                            sendError(handler, failMessage, errorMessage);
                            LogUtil.error(tag, "........... body is null");
                        }
                    } else {
                        sendError(handler, failMessage, errorMessage);
                        LogUtil.error(tag, url);
                        LogUtil.error(tag, response.message());
                    }
                }
            });
        } catch (Exception ex) {
            LogUtil.error(tag, url);
            LogUtil.error(tag, ex.getMessage());
            sendError(handler, failMessage, errorMessage);
        }
    }

    /**
     * post请求
     *
     * @param url
     * @param handler
     * @param hashMap
     * @param successMessage
     * @param failMessage
     * @param type
     */
    public void post(final String url, final Handler handler, final CommonParameter
            hashMap,
                     final int successMessage, final int failMessage, final Type type) {
        try {
            Request.Builder builder = new Request.Builder();

            RequestBody body = RequestBody.create(new Gson().toJson(hashMap.getBody()), JSON);

            Map<String, Object> headers = hashMap.getHead();
            if (null != headers && headers.size() > 0) {
                Set<String> headKeySet = headers.keySet();
                for (String key : headKeySet) {
                    String value = headers.get(key).toString();
                    builder.addHeader(key, value);
                }
            }
            Request request = builder.url(url).post(body).build();

            mOkHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    LogUtil.error(tag, "接口地址为" + url + ".....请求异常");
                    LogUtil.error(tag, hashMap.toString());
                    sendError(handler, failMessage, errorMessage);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.code() == 200) {
                        ResponseBody body = response.body();
                        LogUtil.error(tag, url);
                        LogUtil.error(tag, "param : " + new Gson().toJson(hashMap.getBody()));
                        if (null != body) {
                            String result = body.string();
                            LogUtil.error(tag, "..........." + result);
                            parseData(handler, successMessage, failMessage, result, type);
                        } else {
                            LogUtil.error(tag, "........... body is null");
                            sendError(handler, failMessage, errorMessage);
                        }
                    } else {
                        sendError(handler, failMessage, errorMessage);
                        LogUtil.error(tag, url);
                        LogUtil.error(tag, response.message());
                    }
                }
            });
        } catch (Exception ex) {
            LogUtil.error(tag, url);
            LogUtil.error(tag, ex.getMessage());
            sendError(handler, failMessage, errorMessage);
        }
    }

    /**
     * post同步请求
     *
     * @param url
     * @param hashMap
     * @param type
     */
    public String post(final String url, final CommonParameter
            hashMap, final Type type) {
        try {
            Request.Builder builder = new Request.Builder();

            RequestBody body = RequestBody.create(new Gson().toJson(hashMap.getBody()), JSON);

            Map<String, Object> headers = hashMap.getHead();
            if (null != headers && headers.size() > 0) {
                Set<String> headKeySet = headers.keySet();
                for (String key : headKeySet) {
                    String value = headers.get(key).toString();
                    builder.addHeader(key, value);
                }
            }
            Request request = builder.url(url).post(body).build();
            Response response = mOkHttpClient.newCall(request).execute();
            if (response.code() == 200) {
                ResponseBody responseBody = response.body();
                LogUtil.error(tag, url);
                LogUtil.error(tag, "param : " + new Gson().toJson(hashMap.getBody()));
                if (null != responseBody) {

                    String result = responseBody.string();

                    LogUtil.error(tag, "..........." + result);
                    return result;
                } else {
                    LogUtil.error(tag, "........... body is null");
                }
            }
        } catch (Exception ex) {
            LogUtil.error(tag, url);
            LogUtil.error(tag, ex.getMessage());
        }
        return "";
    }

    /**
     * 解析数据,封装成实体对象返回
     *
     * @param handler
     * @param successMessage
     * @param failMessage
     * @param result
     * @param type
     */
    private void parseData(Handler handler, int successMessage, int failMessage, String result,
                           Type type) {
        try {
            Object vo = gson.fromJson(result, type);
            sendMessage(handler, successMessage, vo);
            BaseVo baseVo = (BaseVo) vo;
            if (baseVo.getCode() == 405 || baseVo.getCode() == 404) {//登录token失效,登录被下线
                showAlert("" + baseVo.getMessage());

            }
        } catch (Exception ex) {
            sendError(handler, failMessage, result);
            LogUtil.error(tag, ex.getMessage());
        }
    }

    /**
     * sendMessage:【发送成功消息】. <br/>
     * .@param handler .@param successMessage .@param object.<br/>
     */
    private void sendMessage(Handler handler, int successMessage, Object object) {
        Message message = new Message();
        message.what = successMessage;
        message.obj = object;
        if (null != handler) {
            handler.sendMessage(message);
        }
    }

    /**
     * sendError:【发送失败消息】. <br/>
     * .@param handler .@param failMessage.<br/>
     */
    private void sendError(Handler handler, int failMessage, Object obj) {
        Message message = new Message();
        message.what = failMessage;
        message.obj = obj;
        if (null != handler) {
            handler.sendMessage(message);
        }
    }
}
