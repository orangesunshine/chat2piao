package com.orange.chat2piao.base.app;

import android.app.Application;
import android.content.Context;

public interface IApp {
    /**
     * 初始化全局变量
     * @param context
     */
    void initGlobleVars(Context context);

    /**
     * 获取当前app引用
     * @return
     */
    Application getApplication();

    /**
     * 初始化三方
     * @param context
     */
    void initParty(Context context);
}
