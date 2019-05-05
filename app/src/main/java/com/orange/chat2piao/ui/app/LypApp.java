package com.orange.chat2piao.ui.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.orange.chat2piao.BuildConfig;
import com.orange.chat2piao.abstractor.adapter.ActivityLifecycleAdapt;
import com.orange.chat2piao.abstractor.ifc.act.IActivityCreated;
import com.orange.chat2piao.abstractor.ifc.act.IBindView;
import com.orange.chat2piao.abstractor.ifc.act.IBuzAct;
import com.orange.chat2piao.abstractor.ifc.act.IContentView;
import com.orange.chat2piao.abstractor.ifc.act.IInitVars;
import com.orange.chat2piao.abstractor.ifc.act.IStatusBarTranslucentAct;
import com.orange.chat2piao.abstractor.ifc.constant.IConst;
import com.orange.chat2piao.utils.LogUtil;
import com.orange.chat2piao.utils.ScreenUtils;

public class LypApp extends Application {
    private static Context sAppContext;

    public static Context getAppContext() {
        return sAppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化变量
        Context context = getApplicationContext();
        initVars(context);
        //初始化三方
        initParty(context);
        //监控actvity生命周期，回调方法
        registerActivityLifecycleCallbacks(new ActivityLifecycleAdapt() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                onActivityCreate(activity, bundle);
            }
        });
    }

    /**
     * 初始化三方
     *
     * @param context
     */
    private void initParty(Context context) {
        LogUtil.init(BuildConfig.DEBUG);
    }

    //初始化变量
    private void initVars(Context context) {
        sAppContext = context;
        IConst.sScreenPoint = ScreenUtils.getScreenSize(context);
    }

    public void onActivityCreate(Activity activity, Bundle bundle) {
        if (activity instanceof IContentView)
            activity.setContentView(((IContentView) activity).getContentLayoutId());

        if (activity instanceof IStatusBarTranslucentAct)
            ((IStatusBarTranslucentAct) activity).setStatusBarTranslucent(activity);

        //commonWrapper->initVars
        if (activity instanceof IInitVars)
            ((IInitVars) activity).initVars(bundle);

        //commonWrapper->bindViews
        if (activity instanceof IBindView)
            ((IBindView) activity).bindViews(activity);

        //BuzViewActivity->initViews、initListener
        if (activity instanceof IBuzAct) {
            ((IBuzAct) activity).initViews(activity);
            ((IBuzAct) activity).initListener(activity);
        }

        //onActivityCreate
        if (activity instanceof IActivityCreated)
            ((IActivityCreated) activity).onActivityCreate(activity);
    }
}
