package com.orange.chat2piao.abstractor.impl;

import android.content.Context;

import com.orange.chat2piao.abstractor.ifc.IGloble;
import com.orange.chat2piao.abstractor.ifc.ILoading;
import com.orange.chat2piao.abstractor.ifc.ILoadingDialogFragment;
import com.orange.chat2piao.ui.app.LypApp;
import com.orange.chat2piao.ui.dialog.LoadingDialog;

public class GlobleImp implements IGloble {
    //static&final
    private static volatile GlobleImp ourInstance = null;

    //vars
    private int mScreenWidth, mScreenHeight;

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
    public ILoadingDialogFragment getLoadingDialog() {
        return new LoadingDialog();
    }

    @Override
    public int getScreenWidth() {
        return mScreenWidth;
    }

    @Override
    public int getScreenHeight() {
        return mScreenHeight;
    }
}
