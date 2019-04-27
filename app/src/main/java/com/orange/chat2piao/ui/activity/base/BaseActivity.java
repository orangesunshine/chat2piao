package com.orange.chat2piao.ui.activity.base;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;

import com.githang.statusbar.StatusBarCompat;
import com.orange.chat2piao.abstractor.ifc.act.IBaseAct;

public class BaseActivity extends FragmentActivity implements IBaseAct {
    @Override
    public void setStatusBarTranslucent(Activity activity) {
        StatusBarCompat.setTranslucent(activity.getWindow(),true);
    }
}
