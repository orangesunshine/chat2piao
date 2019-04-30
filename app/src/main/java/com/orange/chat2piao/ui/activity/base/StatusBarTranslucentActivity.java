package com.orange.chat2piao.ui.activity.base;

import android.app.Activity;

import androidx.fragment.app.FragmentActivity;

import com.githang.statusbar.StatusBarCompat;
import com.orange.chat2piao.abstractor.ifc.act.IStatusBarTranslucentAct;
import com.orange.chat2piao.abstractor.ifc.wrapper.IWrapper;

public abstract class StatusBarTranslucentActivity extends FragmentActivity implements IStatusBarTranslucentAct {
    protected IWrapper mWrapper;

    public void setWrapper(IWrapper wrapper) {
        mWrapper = wrapper;
    }

    @Override
    public void setStatusBarTranslucent(Activity activity) {
        StatusBarCompat.setTranslucent(activity.getWindow(), true);
    }
}
