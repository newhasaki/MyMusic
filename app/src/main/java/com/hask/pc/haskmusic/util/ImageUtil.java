package com.hask.pc.haskmusic.util;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hask.pc.haskmusic.R;

public class ImageUtil {

    public static void showLocalImage(Activity activity, ImageView view, int imageId) {
        RequestOptions options = getCommentRequestOptions();
        Glide.with(activity).load(imageId).apply(options).into(view);
    }

    public static RequestOptions getCommentRequestOptions() {
        RequestOptions options = new RequestOptions();
//        options.placeholder(R.drawable.cd_bg);
//        options.error(R.drawable.cd_bg);
//        options.centerCrop();

        //测试，禁用所有缓存
        //options.diskCacheStrategy(DiskCacheStrategy.NONE);
        return options;
    }
}
