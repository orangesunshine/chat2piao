package com.orange.chat2piao.base.globle;

import android.content.Context;

import androidx.annotation.DrawableRes;

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
