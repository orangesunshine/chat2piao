package com.orange.chat2piao.abstractor.impl.wrapper;

import android.os.Bundle;

import com.orange.chat2piao.abstractor.adapter.WrapperAdater;
import com.orange.chat2piao.abstractor.ifc.act.IInitVars;

public class InitVarsWrapper extends WrapperAdater<IInitVars, Bundle> {

    public InitVarsWrapper(Bundle arg) {
        super(arg);
    }

    @Override
    public void perform() {
        if (null != mIfc) {
            mIfc.initVars(getArg());
        }
    }
}
