package com.orange.chat2piao.abstractor.impl.act;

import android.content.Context;

import com.orange.chat2piao.abstractor.ifc.act.IBuzAct;
import com.orange.chat2piao.abstractor.adapter.WrapperAdater;

public class BuzWrapper extends WrapperAdater<IBuzAct, Context> {
    @Override
    public void perform() {
        if (null != mIfc) {
            Context arg = getArg();
            mIfc.initViews(arg);
            mIfc.initListener(arg);
            mIfc.onActivityCreate(arg);
        }
    }
}
