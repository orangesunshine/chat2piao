package com.orange.chat2piao.base.impl.wrapper;

import android.os.Bundle;

import com.orange.chat2piao.other.DefinedWrapperAdater;
import com.orange.chat2piao.base.ifc.presenter.callback.IInitVars;

public class InitVarsDefinedWrapper extends DefinedWrapperAdater<IInitVars, Bundle> {

    public InitVarsDefinedWrapper(Bundle arg) {
        super(arg);
    }

    @Override
    public void perform() {
        if (null != mIfc) {
            mIfc.initVars(getArg());
        }
    }
}
