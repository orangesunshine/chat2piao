package com.orange.chat2piao.base.ui.app;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ProcessUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.orange.chat2piao.base.constant.IInitConst;
import com.orange.chat2piao.base.ifc.app.IApp;
import com.orange.chat2piao.base.ifc.app.IBuildActivityLifecycleCallbacks;
import com.orange.chat2piao.base.impl.defaultImp.DefaultConfig;

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
        IInitConst.sScreenWidth = ScreenUtils.getScreenWidth();
        IInitConst.sScreenHeight = ScreenUtils.getScreenHeight();
    }

    @Override
    public Application getApplication() {
        return this;
    }

    @Override
    public void initParty(Context context) {
        initLog();
    }

    // init it in ur application
    private void initLog() {
        LogUtils.Config config = LogUtils.getConfig()
                .setLogSwitch(AppUtils.isAppDebug())// 设置 log 总开关，包括输出到控制台和文件，默认开
                .setConsoleSwitch(AppUtils.isAppDebug())// 设置是否输出到控制台开关，默认开
                .setGlobalTag(null)// 设置 log 全局标签，默认为空
                // 当全局标签不为空时，我们输出的 log 全部为该 tag，
                // 为空时，如果传入的 tag 为空那就显示类名，否则显示 tag
                .setLogHeadSwitch(true)// 设置 log 头信息开关，默认为开
                .setLog2FileSwitch(false)// 打印 log 时是否存到文件的开关，默认关
                .setDir("")// 当自定义路径为空时，写入应用的/cache/log/目录中
                .setFilePrefix("")// 当文件前缀为空时，默认为"util"，即写入文件为"util-yyyy-MM-dd.txt"
                .setBorderSwitch(true)// 输出日志是否带边框开关，默认开
                .setSingleTagSwitch(true)// 一条日志仅输出一条，默认开，为美化 AS 3.1 的 Logcat
                .setConsoleFilter(LogUtils.V)// log 的控制台过滤器，和 logcat 过滤器同理，默认 Verbose
                .setFileFilter(LogUtils.V)// log 文件过滤器，和 logcat 过滤器同理，默认 Verbose
                .setStackDeep(5)// log 栈深度，默认为 1
                .setStackOffset(0)// 设置栈偏移，比如二次封装的话就需要设置，默认为 0
                .setSaveDays(3);// 设置日志可保留天数，默认为 -1 表示无限时长
        LogUtils.e(ProcessUtils.getCurrentProcessName());
    }

    @Override
    public ActivityLifecycleCallbacks buildActivityLifecycleCallbacks() {
        return null;
    }
}
