package com.orange.chat2piao.abstractor.ifc;

import android.content.Context;

public interface IGloble {
    //获取全局context
    Context getAppContext();

    //loadingDialog
    ILoadingDialogFragment getLoadingDialog();

    //screen width、height
    int getScreenWidth();
    int getScreenHeight();
}
