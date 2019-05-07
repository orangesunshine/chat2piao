package com.orange.chat2piao.base.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.orange.chat2piao.base.ifc.presenter.IPresenter;
import com.orange.chat2piao.base.ifc.view.IView;
import com.orange.chat2piao.base.ifc.view.ifc.IHeaderNdFooter;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildHeaderNdFooter;
import com.orange.chat2piao.base.impl.defaultImp.DefaultConfig;

public abstract class RefreshNdLoadMoreActivity<T extends IView, P extends IPresenter<T>> extends PresenterActivity<T, P> implements IBuildHeaderNdFooter {
    //views
    protected IHeaderNdFooter mHeaderNdFooter;

    @Override
    public void onActivityCreate(Activity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        //pullndload
        mHeaderNdFooter = buildHeaderFooter();
        if (null == mHeaderNdFooter)
            mHeaderNdFooter = DefaultConfig.getInstance().buildHeaderFooter();
    }

    @Override
    public IHeaderNdFooter buildHeaderFooter() {
        return null;
    }
}
