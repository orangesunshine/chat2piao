package com.orange.chat2piao.base.ifc.img;

import android.widget.ImageView;

import androidx.annotation.DrawableRes;

public interface IImage {
    void loadImgUrl(ImageView iv, String url);

    @DrawableRes int placeholder();
}
