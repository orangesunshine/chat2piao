package com.orange.chat2piao.abstractor.impl.wrapper;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.orange.chat2piao.abstractor.adapter.WrapperAdater;
import com.orange.chat2piao.abstractor.ifc.act.ICommonAct;
import com.orange.chat2piao.abstractor.ifc.wrapper.IWrapper;

public class CommonWrapper extends WrapperAdater<ICommonAct, Activity> {
    private Bundle mBundle;

    public CommonWrapper(Activity arg) {
        super(arg);
    }

    @Override
    public void perform() {
        if (null != mIfc) {
            mIfc.initVars(mBundle);
            mIfc.bindViews(getArg());
        }
    }

    public CommonWrapper setBundle(Bundle bundle) {
        mBundle = bundle;
        return this;
    }
}
