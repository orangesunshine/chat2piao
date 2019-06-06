package com.orange.chat2piao.base.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.orange.chat2piao.base.ifc.presenter.IPresenter;
import com.orange.chat2piao.base.ifc.view.IView;
import com.orange.chat2piao.base.ifc.view.ifc.IHeaderNdFooter;
import com.orange.chat2piao.base.ifc.view.ifc.IToast;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildHeaderNdFooter;
import com.orange.chat2piao.base.impl.defaultImp.DefaultConfig;
import com.orange.chat2piao.base.impl.globle.GlobleImp;
import com.orange.chat2piao.base.impl.presenter.NetPresenter;

public abstract class PullActivity<A extends PullActivity, T, P extends NetPresenter<A, A, T>> extends NetActivity<T, P> implements IBuildHeaderNdFooter {
    //views
    protected IHeaderNdFooter mHeaderNdFooter;

    @Override
    public void onActivityCreate(Activity activity, Bundle bundle) {
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
