package com.orange.chat2piao.base.ifc.globle;

import android.content.Context;

import com.orange.chat2piao.base.ifc.img.IImage;

public interface IGloble extends IImage {
    //获取全局context
    Context getAppContext();

    //screen width、height
    int getScreenWidth();

    int getScreenHeight();
}
