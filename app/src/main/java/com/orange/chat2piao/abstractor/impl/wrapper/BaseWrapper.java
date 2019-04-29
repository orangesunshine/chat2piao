package com.orange.chat2piao.abstractor.impl.wrapper;

import android.app.Activity;

import com.orange.chat2piao.abstractor.adapter.WrapperAdater;
import com.orange.chat2piao.abstractor.ifc.act.IBaseAct;

public class BaseWrapper extends WrapperAdater<IBaseAct, Activity> {

    public BaseWrapper(Activity arg) {
        super(arg);
    }

    @Override
    public void perform() {
        if (null != mIfc) {
            getArg().setContentView(mIfc.getContentLayoutId());
            mIfc.setStatusBarTranslucent(getArg());
        }
    }
}
