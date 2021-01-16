package com.exc.utils;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.exc.wuh.R;

public class GlideInit {

    private static GlideInit single;

    private static RequestOptions options;
    private static RequestOptions headOptions;
    private static RequestOptions commonOptions;
    private static RequestOptions bannerOptions;

    private GlideInit() {
    }

    public static GlideInit getSingle() {
        if (null == single) {
            single = new GlideInit();
        }
        return single;
    }

    /**
     * 初始化Glide相关配置
     *
     * @return
     */
    public RequestOptions requestHeadOptions() {
        if (null == headOptions) {
            headOptions = new RequestOptions();
            headOptions.centerCrop();
            headOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
            headOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
            headOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

            headOptions.placeholder(R.mipmap.icon_head_circle_none);
            headOptions.error(R.mipmap.icon_head_circle_none);
        }

        return headOptions;
    }

    /**
     * 初始化Glide相关配置
     *
     * @return
     */
    public RequestOptions requestCommonOptions() {
        if (null == commonOptions) {
            commonOptions = new RequestOptions();
            commonOptions.centerCrop();
            commonOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
            commonOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
            commonOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

            commonOptions.placeholder(R.mipmap.icon_normal_none);
            commonOptions.error(R.mipmap.icon_normal_none);
        }
        return commonOptions;
    }

    /**
     * 初始化Glide相关配置
     *
     * @return
     */
    public RequestOptions requestBannerOptions() {
        if (null == bannerOptions) {
            bannerOptions = new RequestOptions();
            bannerOptions.centerCrop();
            bannerOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
            bannerOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
            bannerOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

            bannerOptions.placeholder(new ColorDrawable(Color.parseColor("#fff2f2f2")));
            bannerOptions.error(new ColorDrawable(Color.parseColor("#fff2f2f2")));
        }
        return bannerOptions;
    }

    /**
     * 初始化Glide相关配置
     *
     * @return
     */
    public RequestOptions requestOptions(int errorResId, int placeholderResId) {
        if (null == options) {
            options = new RequestOptions();
            options.centerCrop();
            options.diskCacheStrategy(DiskCacheStrategy.ALL);
            options.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
            options.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

            options.placeholder(placeholderResId);
            options.error(errorResId);
        }
        return options;
    }
}
