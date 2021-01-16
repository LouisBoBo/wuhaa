package com.exc.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;

import java.io.File;

public class GlideShowUtil {

    /**
     * 显示圆形图片
     */
    public static void showCircleImage(Context context, ImageView imageView, String filePath) {
        if (isContextInvalid(context)) {
            return;
        }
        File picFile = loadFile(filePath);
        //非文件时，则为http形式
        Glide.with(context).load(picFile == null ? filePath : picFile)
            .apply(GlideInit.getSingle().requestHeadOptions().transform(new CircleCrop())).into
            (imageView);
    }

    /**
     * 显示普通图片
     */
    public static void showImage(Context context, ImageView imageView, String filePath) {
        showImage(context, imageView, filePath, null);
    }

    /**
     * 显示普通图片
     */
    public static void showImage(Context context, ImageView imageView, String filePath,
                                 RequestListener<Drawable> listener) {
        if (isContextInvalid(context)) {
            return;
        }
        File picFile = loadFile(filePath);
        //非文件时，则为http形式
        Glide.with(context).load(picFile == null ? filePath : picFile).apply(GlideInit.getSingle()
            .requestCommonOptions().dontTransform())
            .listener(listener)
            .into(imageView);
    }

    /**
     * 显示普通图片
     */
    public static void showImage(Context context, ImageView imageView, String filePath,
                                 int errorResId, int placeholderResId) {
        if (isContextInvalid(context)) {
            return;
        }
        File picFile = loadFile(filePath);
        //非文件时，则为http形式
        Glide
            .with(context)
            .load(picFile == null ? filePath : picFile)
            .error(errorResId)
            .placeholder(placeholderResId)
            .into(imageView);
    }

    /**
     * 显示Banner图片
     */
    public static void showBannerImage(Context context, ImageView imageView, String filePath) {
        if (isContextInvalid(context)) {
            return;
        }
        File picFile = loadFile(filePath);
        //非文件时，则为http形式
        Glide.with(context).load(picFile == null ? filePath : picFile).apply(GlideInit.getSingle()
            .requestBannerOptions().dontTransform()).into
            (imageView);
    }

    /**
     * 加载本地资源图片，一般用在Adapter里面，为了优化图片加载效率
     */
    public static void showLocalImage(Context context, ImageView imageView, int resId) {
        if (isContextInvalid(context)) {
            return;
        }
        Glide
            .with(context)
            .load(resId)
            .apply(GlideInit.getSingle().requestCommonOptions().dontTransform())
            .into(imageView);
    }

    /**
     * 加载本地资源图片，一般用在Adapter里面，为了优化图片加载效率
     */
    public static void showLocalImage(Context context, Object path, ImageView imageView) {
        if (isContextInvalid(context)) {
            return;
        }
        Glide
            .with(context)
            .load(path)
            .apply(GlideInit.getSingle().requestCommonOptions().dontTransform())
            .into(imageView);
    }

    /**
     * 显示圆角图片
     */
    public static void showRoundedCorners(Context context, ImageView imageView, String filePath) {
        showRoundedCorners(context, imageView, filePath, 20, RoundedCornersCrop.CornerType.ALL);
    }

    /**
     * 显示圆角图片
     */
    public static void showRoundedCorners(Context context, ImageView imageView, String filePath,
                                          int mRadius) {
        showRoundedCorners(context, imageView, filePath, mRadius,
            RoundedCornersCrop.CornerType.ALL);
    }

    /**
     * 显示圆角图片
     */
    public static void showRoundedCorners(Context context, ImageView imageView, String filePath,
                                          int mRadius, RoundedCornersCrop.CornerType cornerType) {
        if (isContextInvalid(context)) {
            return;
        }
        File picFile = loadFile(filePath);
        //非文件时，则为http形式
        //增加new CenterCrop(),处理与android:scaleType="centerCrop"导致圆角无效
        Glide.with(context).load(picFile == null ? filePath : picFile)
            .apply(GlideInit.getSingle().requestCommonOptions().transform(
                new CenterCrop(), new RoundedCornersCrop
                    (mRadius, 0, cornerType))).into
            (imageView);
    }

    /**
     * 显示圆角图片
     */
    public static void showRoundedCorners(Context context, ImageView imageView, String filePath,
                                          int errorResId, int placeholderResId, int roundRadius) {
        if (isContextInvalid(context)) {
            return;
        }
        File picFile = loadFile(filePath);
        //非文件时，则为http形式
        Glide
            .with(context)
            .load(picFile == null ? filePath : picFile)
            .apply
                (
                    GlideInit
                        .getSingle()
                        .requestOptions(errorResId, placeholderResId)
                        .transform(new RoundedCorners(roundRadius))
                )
            .into(imageView);
    }

    /**
     * 检查图片url是否为文件目录
     *
     * @param path 图片url
     * @return
     */
    public static File loadFile(String path) {
        File mFile = null;
        if (!TextUtils.isEmpty(path) && path.contains("file://")) {
            mFile = new File(path);
        }
        return mFile;
    }

    /**
     * 判断Context是否是无效的
     */
    private static boolean isContextInvalid(Context context) {
        boolean result = false;
        if (context == null) {
            result = true;
        }
        if (context instanceof Activity) {
            result = ((Activity) context).isFinishing() || ((Activity) context).isDestroyed();
        }
        return result;
    }
}
