package com.orange.chat2piao.base.ui.activity;

import android.os.Bundle;

import com.orange.chat2piao.base.ifc.callback.IInit;
import com.orange.chat2piao.base.ifc.component.ILoading;
import com.orange.chat2piao.base.ifc.component.generate.IBuildLoading;
import com.orange.chat2piao.base.impl.globle.GlobleImp;
import com.orange.chat2piao.base.impl.presenter.NetPresenter;
import com.orange.chat2piao.base.impl.component.LoadingImpl;
import com.orange.chat2piao.utils.Preconditions;

public abstract class NetActivity<A extends NetActivity, T, P extends NetPresenter<A, A, T>> extends PresenterActivity<A, P> implements IBuildLoading, ILoading, IInit {
    //views
    protected ILoading mLoading;

    @Override
    public void onActivityCreate(A activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        mLoading = buildLoading();
        if (null == mLoading)
            mLoading = new LoadingImpl(activity, GlobleImp.getInstance().buildLoadingDialogFragment());
    }

    @Override
    public void showLoading() {
        Preconditions.checkNotNull(mLoading);
        mLoading.showLoading();
    }

    @Override
    public void dismissLoading() {
        Preconditions.checkNotNull(mLoading);
        mLoading.dismissLoading();
    }

    @Override
    public ILoading buildLoading() {
        //loading
        return null;
    }

    public ILoading getLoading() {
        return mLoading;
    }
}
