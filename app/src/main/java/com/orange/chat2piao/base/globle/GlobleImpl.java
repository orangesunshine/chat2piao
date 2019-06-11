package com.orange.chat2piao.base.globle;

import android.content.Context;

import com.orange.chat2piao.R;
import com.orange.chat2piao.constant.IInitConst;
import com.orange.chat2piao.buz.app.LypApp;

public class GlobleImpl implements IGloble {
    //static&final
    private static volatile GlobleImpl ourInstance = null;

    public static GlobleImpl getInstance() {
        if (null == ourInstance) {
            synchronized (GlobleImpl.class) {
                if (null == ourInstance) {
                    ourInstance = new GlobleImpl();
                }
            }
        }
        return ourInstance;
    }

    private GlobleImpl() {

    }

    @Override
    public Context getAppContext() {
        return LypApp.getAppContext();
    }

    @Override
    public int getScreenWidth() {
        return (int) (IInitConst.sScreenWidth + 0.5f);
    }

    @Override
    public int getScreenHeight() {
        return (int) (IInitConst.sScreenHeight + 0.5f);
    }

    @Override
    public int placeholder() {
        return R.drawable.shape_picture_placeholder;
    }
}
