package com.orange.chat2piao.base.ifc.img;

import android.widget.ImageView;

import androidx.annotation.DrawableRes;

public interface IImage {
    /**
     * 设置网络图片
     * @param iv
     * @param url
     */
    void loadImgUrl(ImageView iv, String url);

    /**
     * 设置gif图片
     * @param iv
     * @param resId
     */
    void loadImageResourceAsGif(ImageView iv, int resId);
}
