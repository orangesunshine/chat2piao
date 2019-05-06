package com.orange.chat2piao.base.impl.globle;

import android.content.Context;

import com.orange.chat2piao.base.constant.IConst;
import com.orange.chat2piao.base.ifc.globle.IGloble;
import com.orange.chat2piao.base.ui.app.LypApp;

public class GlobleImp implements IGloble {
    //static&final
    private static volatile GlobleImp ourInstance = null;

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
    public int getScreenWidth() {
        return IConst.sScreenPoint.x;
    }

    @Override
    public int getScreenHeight() {
        return IConst.sScreenPoint.y;
    }
}
