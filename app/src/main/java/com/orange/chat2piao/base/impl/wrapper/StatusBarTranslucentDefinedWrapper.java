package com.orange.chat2piao.base.impl.wrapper;

import android.app.Activity;

import com.orange.chat2piao.other.DefinedWrapperAdater;
import com.orange.chat2piao.base.ifc.view.ifc.IStatusBar;

public class StatusBarTranslucentDefinedWrapper extends DefinedWrapperAdater<IStatusBar, Activity> {
    public StatusBarTranslucentDefinedWrapper(Activity arg) {
        super(arg);
    }

    @Override
    public void perform() {
        if (null != mIfc) {
            mIfc.setStatusBar(getArg());
        }
    }
}
