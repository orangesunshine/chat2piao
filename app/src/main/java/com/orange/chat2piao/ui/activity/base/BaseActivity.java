package com.orange.chat2piao.ui.activity.base;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;

import com.githang.statusbar.StatusBarCompat;
import com.orange.chat2piao.abstractor.ifc.act.IBaseAct;
import com.orange.chat2piao.abstractor.ifc.wrapper.IWrapper;

public abstract class BaseActivity extends FragmentActivity implements IBaseAct {
    protected IWrapper mWrapper;

    public void setWrapper(IWrapper wrapper) {
        mWrapper = wrapper;
    }

    @Override
    public void setStatusBarTranslucent(Activity activity) {
        StatusBarCompat.setTranslucent(activity.getWindow(), true);
    }
}
