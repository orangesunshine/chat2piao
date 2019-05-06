package com.orange.chat2piao.base.impl.wrapper;

import android.app.Activity;

import com.orange.chat2piao.other.DefinedWrapperAdater;
import com.orange.chat2piao.base.ifc.view.ifc.IBindView;

public class BindDefinedWrapper extends DefinedWrapperAdater<IBindView, Activity> {
    public BindDefinedWrapper(Activity arg) {
        super(arg);
    }

    @Override
    public void perform() {
        if (null != mIfc) {
            mIfc.bindViews(getArg());
        }
    }
}
