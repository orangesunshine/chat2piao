package com.orange.chat2piao.abstractor.impl.wrapper;

import android.content.Context;

import com.orange.chat2piao.abstractor.ifc.act.IBuzAct;
import com.orange.chat2piao.abstractor.adapter.WrapperAdater;

public class BuzWrapper extends WrapperAdater<IBuzAct, Context> {
    public BuzWrapper(Context arg) {
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
