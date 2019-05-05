package com.orange.chat2piao.abstractor.impl.wrapper;

import android.app.Activity;

import com.orange.chat2piao.abstractor.adapter.WrapperAdater;
import com.orange.chat2piao.abstractor.ifc.act.IStatusBarTranslucentAct;

public class StatusBarTranslucentWrapper extends WrapperAdater<IStatusBarTranslucentAct, Activity> {
    public StatusBarTranslucentWrapper(Activity arg) {
        super(arg);
    }

    @Override
    public void perform() {
        if (null != mIfc) {
            mIfc.setStatusBarTranslucent(getArg());
        }
    }
}
