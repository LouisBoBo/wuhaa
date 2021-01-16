package com.exc.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.exc.wuh.R;


/**
 * 项目名称 :  智慧城市智慧养老
 * 文件名称 ： CustomAlertDialog.java
 * 功能描述 ： 通用底部弹出框
 * 作   者 ： kangshuqian757
 * 日   期 ： 2019/8/2
 */
public class CustomAlertDialog {
    private View rootView;

    private Context context;
    private Dialog dialog;
    private boolean cancelable;

    public CustomAlertDialog(Context context) {
        this.context = context;
    }


    private OnViewInitListener mOnViewInitListener;
    public interface OnViewInitListener {
        void onViewInit(View view);
    }
    public CustomAlertDialog setOnViewInitListener(OnViewInitListener listener) {
        this.mOnViewInitListener = listener;

        if(mOnViewInitListener != null){
            mOnViewInitListener.onViewInit(rootView);
        }

        return this;
    }


    private OnKeyListener mOnKeyListener;
    public interface OnKeyListener {
        boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event);
    }
    public CustomAlertDialog setOnKeyListener(OnKeyListener listener){
        this.mOnKeyListener = listener;

        if(dialog != null && mOnKeyListener != null){
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    mOnKeyListener.onKey(dialog,keyCode,event);
                    return false;
                }
            });
        }
        return this;
    }



    public CustomAlertDialog setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        if(dialog != null){
            dialog.setCancelable(cancelable);
        }
        return this;
    }

    public CustomAlertDialog builder(float heightPrecent) {
        return builder(heightPrecent,Gravity.BOTTOM);
    }

    public CustomAlertDialog builder(float heightPrecent, int gravity) {
        // 定义Dialog布局和参数
        dialog = new Dialog(context, R.style.AlertDialogStyle);
        dialog.setContentView(rootView);
        dialog.setCancelable(false);

        //dialog 居中显示
        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attr = window.getAttributes();
            if (attr != null) {
                attr.width = SystemUtil.getDisplayWidth(context);
                attr.height = (int) (SystemUtil.getDisplayHeight(context) * heightPrecent);
                attr.gravity = gravity;//设置dialog 在布局中的位置
            }
        }

        return this;
    }


    public CustomAlertDialog setLayout(int resId){
        // 获取Dialog布局
        rootView = LayoutInflater.from(context).inflate(resId, null);
        return this;
    }


    public void show() {
        dialog.show();
    }

    public boolean isShowing() {
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    public void dismiss() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
