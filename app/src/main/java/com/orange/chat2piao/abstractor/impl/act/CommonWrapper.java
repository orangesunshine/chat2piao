package com.orange.chat2piao.abstractor.impl.act;

import android.os.Bundle;

import com.orange.chat2piao.abstractor.ifc.act.ICommonAct;
import com.orange.chat2piao.abstractor.adapter.WrapperAdater;

public class CommonWrapper extends WrapperAdater<ICommonAct, Bundle> {
    @Override
    public void perform() {
        if (null != mIfc) {
            mIfc.initVars(getArg());
            mIfc.bindViews();
        }
    }
}
