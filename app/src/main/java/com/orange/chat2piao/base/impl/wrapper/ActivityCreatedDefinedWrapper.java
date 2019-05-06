package com.orange.chat2piao.base.impl.wrapper;

import android.content.Context;

import com.orange.chat2piao.other.DefinedWrapperAdater;
import com.orange.chat2piao.base.ifc.presenter.callback.IActivityCreatedNdDestroyCallback;

public class ActivityCreatedDefinedWrapper extends DefinedWrapperAdater<IActivityCreatedNdDestroyCallback, Context> {
    public ActivityCreatedDefinedWrapper(Context arg) {
        super(arg);
    }

    @Override
    public void perform() {
        if (null != mIfc) {
            mIfc.onActivityCreate(getArg());
        }
    }
}
