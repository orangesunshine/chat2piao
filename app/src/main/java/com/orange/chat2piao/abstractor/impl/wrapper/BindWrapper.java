package com.orange.chat2piao.abstractor.impl.wrapper;

import android.app.Activity;

import com.orange.chat2piao.abstractor.adapter.WrapperAdater;
import com.orange.chat2piao.abstractor.ifc.act.IBindView;

public class BindWrapper extends WrapperAdater<IBindView, Activity> {
    public BindWrapper(Activity arg) {
        super(arg);
    }

    @Override
    public void perform() {
        if (null != mIfc) {
            mIfc.bindViews(getArg());
        }
    }
}
