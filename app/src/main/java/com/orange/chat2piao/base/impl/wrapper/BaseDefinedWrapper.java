package com.orange.chat2piao.base.impl.wrapper;

import android.app.Activity;

import com.orange.chat2piao.other.DefinedWrapperAdater;
import com.orange.chat2piao.base.ifc.presenter.callback.IContentView;

public class BaseDefinedWrapper extends DefinedWrapperAdater<IContentView, Activity> {

    public BaseDefinedWrapper(Activity arg) {
        super(arg);
    }

    @Override
    public void perform() {
        if (null != mIfc)
            getArg().setContentView(mIfc.getContentLayoutId());
    }
}
