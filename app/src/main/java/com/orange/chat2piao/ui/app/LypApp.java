package com.orange.chat2piao.ui.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.orange.chat2piao.abstractor.adapter.ActivityLifecycleAdapt;
import com.orange.chat2piao.abstractor.impl.GlobleImp;
import com.orange.chat2piao.ui.activity.base.BaseActivity;

public class LypApp extends Application {
    private static Context sAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化变量
        initVars();
        //初始化三方
        GlobleImp.getInstance().initParty();
        //监控actvity生命周期，回调方法
        registerActivityLifecycleCallbacks(new ActivityLifecycleAdapt(){
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (activity instanceof BaseActivity) {
                }
            }
        });
    }

    private void initVars() {
        sAppContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return sAppContext;
    }
}
