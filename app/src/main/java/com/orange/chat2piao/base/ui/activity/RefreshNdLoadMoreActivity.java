package com.orange.chat2piao.base.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.orange.chat2piao.base.ifc.view.ifc.IHeaderNdFooter;
import com.orange.chat2piao.base.ifc.view.ifc.build.IVisibleHeaderNdFooter;
import com.orange.chat2piao.base.impl.defaultImp.DefaultConfig;
import com.orange.chat2piao.base.impl.presenter.RefreshNdLoadPresenter;
import com.orange.chat2piao.utils.Preconditions;

public abstract class RefreshNdLoadMoreActivity<T, P extends RefreshNdLoadPresenter<T>> extends NetActivity<T, P> implements IVisibleHeaderNdFooter, IHeaderNdFooter {
    protected IHeaderNdFooter mHeaderNdFooter;

    @Override
    public void onActivityCreate(Activity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        //pullndload
        mHeaderNdFooter = visibleHeaderFooter();
        if (null == mHeaderNdFooter)
            mHeaderNdFooter = DefaultConfig.getInstance().visibleHeaderFooter();
    }

    @Override
    public IHeaderNdFooter visibleHeaderFooter() {
        return null;
    }

    @Override
    public void showHeader() {
        Preconditions.checkNotNull(mHeaderNdFooter);
        mHeaderNdFooter.showHeader();
    }

    @Override
    public void showFooter() {
        Preconditions.checkNotNull(mHeaderNdFooter);
        mHeaderNdFooter.showFooter();
    }

    @Override
    public void hideHeader() {
        Preconditions.checkNotNull(mHeaderNdFooter);
        mHeaderNdFooter.showFooter();
    }

    @Override
    public void hideFooter() {
        Preconditions.checkNotNull(mHeaderNdFooter);
        mHeaderNdFooter.showFooter();
    }
}
