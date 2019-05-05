package com.orange.chat2piao.abstractor.impl.wrapper;

import android.content.Context;

import com.orange.chat2piao.abstractor.adapter.WrapperAdater;
import com.orange.chat2piao.abstractor.ifc.act.IActivityCreated;

public class ActivityCreatedWrapper extends WrapperAdater<IActivityCreated, Context> {
    public ActivityCreatedWrapper(Context arg) {
        super(arg);
    }

    @Override
    public void perform() {
        if (null != mIfc) {
            mIfc.onActivityCreate(getArg());
        }
    }
}
