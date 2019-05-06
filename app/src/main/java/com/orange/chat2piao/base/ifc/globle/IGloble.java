package com.orange.chat2piao.base.ifc.globle;

import android.content.Context;

import com.orange.chat2piao.base.ifc.view.ifc.ILoadingDialogFragment;

public interface IGloble {
    //获取全局context
    Context getAppContext();

    //screen width、height
    int getScreenWidth();
    int getScreenHeight();
}
