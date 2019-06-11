package com.orange.chat2piao.base.ifc.globle;

import android.content.Context;

import androidx.annotation.DrawableRes;

import com.orange.chat2piao.base.ifc.img.IImage;

public interface IGloble {
    //获取全局context
    Context getAppContext();

    //screen width、height
    int getScreenWidth();

    int getScreenHeight();

    //占位图
    @DrawableRes
    int placeholder();
}
