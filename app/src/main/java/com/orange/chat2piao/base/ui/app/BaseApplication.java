package com.orange.chat2piao.base.ui.app;

import android.app.Application;
import android.content.Context;

import com.orange.chat2piao.BuildConfig;
import com.orange.chat2piao.base.constant.IConst;
import com.orange.chat2piao.base.ifc.app.IApp;
import com.orange.chat2piao.base.ifc.app.IBuildActivityLifecycleCallbacks;
import com.orange.chat2piao.base.impl.defaultImp.DefaultConfig;
import com.orange.chat2piao.utils.LogUtil;
import com.orange.chat2piao.utils.ScreenUtils;

public class BaseApplication extends Application implements IApp, IBuildActivityLifecycleCallbacks {
    private ActivityLifecycleCallbacks mActivityLifecycleCallbacks;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化变量
        Context context = getApplicationContext();
        initGlobleVars(context);
        //初始化三方
        initParty(context);
        //监控actvity生命周期，回调方法
        mActivityLifecycleCallbacks = buildActivityLifecycleCallbacks();
        if (null == mActivityLifecycleCallbacks)
            mActivityLifecycleCallbacks = DefaultConfig.getInstance().buildActivityLifecycleCallbacks();
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks);
    }

    @Override
    public void initGlobleVars(Context context) {
        IConst.sScreenPoint = ScreenUtils.getScreenSize(context);
    }

    @Override
    public Application getApplication() {
        return this;
    }

    @Override
    public void initParty(Context context) {
        LogUtil.init(BuildConfig.DEBUG);
    }

    @Override
    public ActivityLifecycleCallbacks buildActivityLifecycleCallbacks() {
        return null;
    }
}