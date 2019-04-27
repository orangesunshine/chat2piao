package com.orange.chat2piao.abstractor.impl.act;

import android.app.Activity;

import com.orange.chat2piao.abstractor.ifc.act.IBaseAct;
import com.orange.chat2piao.abstractor.adapter.WrapperAdater;

public class ActWrapper extends WrapperAdater<IBaseAct, Activity>{
    @Override
    public void perform() {
        if (null != mIfc) {
            mIfc.setStatusBarTranslucent(getArg());
        }
    }
}
