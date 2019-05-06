package com.orange.chat2piao.base.ui.app;

import android.content.Context;

public class LypApp extends BaseApplication {
    private static Context sAppContext;

    public static Context getAppContext() {
        return sAppContext;
    }

    @Override
    public void initGlobleVars(Context context) {
        super.initGlobleVars(context);
        sAppContext = getApplicationContext();
    }
}
