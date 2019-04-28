package com.orange.chat2piao.abstractor.impl.activity;

import android.app.Activity;

import com.githang.statusbar.StatusBarCompat;
import com.orange.chat2piao.abstractor.ifc.act.IBaseAct;

public class BaseActImp implements IBaseAct {
    @Override
    public void setStatusBarTranslucent(Activity activity) {
        StatusBarCompat.setTranslucent(activity.getWindow(), true);
    }
}
