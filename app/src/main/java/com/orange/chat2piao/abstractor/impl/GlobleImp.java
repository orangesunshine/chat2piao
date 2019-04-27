package com.orange.chat2piao.abstractor.impl;

import android.content.Context;

import com.orange.chat2piao.BuildConfig;
import com.orange.chat2piao.abstractor.ifc.IGloble;
import com.orange.chat2piao.ui.app.LypApp;
import com.orange.chat2piao.utils.LogUtil;

public class GlobleImp implements IGloble {
    //static&final
    private static volatile GlobleImp ourInstance=null;

    //vars

    public static GlobleImp getInstance() {
        if (null == ourInstance) {
            synchronized (GlobleImp.class) {
                if (null == ourInstance) {
                    ourInstance = new GlobleImp();
                }
            }
        }
        return ourInstance;
    }

    private GlobleImp() {
    }

    @Override
    public Context getAppContext() {
        return LypApp.getAppContext();
    }

    @Override
    public void initParty() {
        LogUtil.init(BuildConfig.DEBUG);
    }
}
