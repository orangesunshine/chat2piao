package com.orange.chat2piao.base.impl.wrapper;

import android.content.Context;

import com.orange.chat2piao.base.ifc.presenter.callback.IInit;
import com.orange.chat2piao.other.DefinedWrapperAdater;

public class BuzDefinedWrapper extends DefinedWrapperAdater<IInit, Context> {
    public BuzDefinedWrapper(Context arg) {
        super(arg);
    }

    @Override
    public void perform() {
        if (null != mIfc) {
            Context arg = getArg();
            mIfc.initViews(arg);
            mIfc.initListener(arg);
        }
    }
}
