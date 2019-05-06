package com.orange.chat2piao.base.ifc.app;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;

public interface IApp {
    //初始化全局变量
    void initGlobleVars(Context context);

    //获取当前app引用
    Application getApplication();

    //初始化三方
    void initParty(Context context);
}
