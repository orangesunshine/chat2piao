package com.orange.chat2piao.base.ui.activity;

import android.os.Bundle;

import com.orange.chat2piao.base.ifc.component.IHeaderNdFooter;
import com.orange.chat2piao.base.ifc.component.generate.IBuildHeaderNdFooter;
import com.orange.chat2piao.base.impl.globle.GlobleImp;
import com.orange.chat2piao.base.impl.presenter.NetPresenter;

public abstract class PullActivity<A extends PullActivity, T, P extends NetPresenter<A, A, T>> extends NetActivity<A, T, P> implements IBuildHeaderNdFooter {
    //views
    protected IHeaderNdFooter mHeaderNdFooter;

    @Override
    public void onActivityCreate(A activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        //pullndload
        mHeaderNdFooter = buildHeaderNdFooter();
        if (null == mHeaderNdFooter)
            mHeaderNdFooter = GlobleImp.getInstance().buildHeaderNdFooter();
    }

    @Override
    public IHeaderNdFooter buildHeaderNdFooter() {
        return null;
    }
}
