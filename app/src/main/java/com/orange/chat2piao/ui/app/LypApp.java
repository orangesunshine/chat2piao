package com.orange.chat2piao.ui.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.orange.chat2piao.BuildConfig;
import com.orange.chat2piao.abstractor.adapter.ActivityLifecycleAdapt;
import com.orange.chat2piao.abstractor.ifc.act.IBaseAct;
import com.orange.chat2piao.abstractor.ifc.act.IBuzAct;
import com.orange.chat2piao.abstractor.ifc.act.ICommonAct;
import com.orange.chat2piao.abstractor.impl.GlobleImp;
import com.orange.chat2piao.abstractor.impl.wrapper.BaseWrapper;
import com.orange.chat2piao.abstractor.impl.wrapper.BuzWrapper;
import com.orange.chat2piao.abstractor.impl.wrapper.CommonWrapper;
import com.orange.chat2piao.ui.activity.base.BaseActivity;
import com.orange.chat2piao.utils.LogUtil;

public class LypApp extends Application {
    private static Context sAppContext;

    public static Context getAppContext() {
        return sAppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化变量
        initVars();
        //初始化三方
        initParty();
        //监控actvity生命周期，回调方法
        registerActivityLifecycleCallbacks(new ActivityLifecycleAdapt() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                onCreateLifecycleWrapper(activity, bundle);
            }
        });
    }

    private void initParty() {
        LogUtil.init(BuildConfig.DEBUG);
    }

    private void initVars() {
        sAppContext = getApplicationContext();
    }

    public void onCreateLifecycleWrapper(Activity activity, Bundle bundle) {
        BaseWrapper wrapper = new BaseWrapper(activity);
        if (activity instanceof IBaseAct)
            wrapper.setIfc((IBaseAct) activity);

        //commonWrapper->initVars、bindViews
        if (activity instanceof ICommonAct)
            wrapper.wrap(new CommonWrapper(activity).setBundle(bundle)).setIfc(activity);

        //BuzActivity->initViews、initListener、onActivityCreate
        if (activity instanceof IBuzAct)
            wrapper.wrap(new BuzWrapper(activity).setIfc((IBuzAct) activity));

        ((BaseActivity) activity).setWrapper(wrapper);
        wrapper.perform();
    }
}
