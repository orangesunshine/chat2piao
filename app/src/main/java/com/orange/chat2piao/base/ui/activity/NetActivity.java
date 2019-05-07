package com.orange.chat2piao.base.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.orange.chat2piao.base.ifc.view.ifc.ILoading;
import com.orange.chat2piao.base.ifc.view.ifc.ILoadingDialogFragment;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildLoadDialogFragment;
import com.orange.chat2piao.base.impl.defaultImp.DefaultConfig;
import com.orange.chat2piao.base.impl.presenter.NetPresenter;
import com.orange.chat2piao.utils.Preconditions;

public abstract class NetActivity<T, P extends NetPresenter<T>> extends InitActivity<P> implements IBuildLoadDialogFragment, ILoading {
    protected ILoadingDialogFragment mLoadingDialogFragment;

    @Override
    public void onActivityCreate(Activity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        //loading
        mLoadingDialogFragment = buildLoadingDialogFragment();
        if (null == mLoadingDialogFragment)
            mLoadingDialogFragment = DefaultConfig.getInstance().buildLoadingDialogFragment();
    }

    @Override
    public ILoadingDialogFragment buildLoadingDialogFragment() {
        return null;
    }

    @Override
    public void showLoading() {
        Preconditions.checkNotNull(mPresenter);
        if (mPresenter.isActivityAlive()) {
            Preconditions.checkNotNull(mLoadingDialogFragment);
            mLoadingDialogFragment.showLoading(getSupportFragmentManager());
        }
    }

    @Override
    public void dismissLoading() {
        Preconditions.checkNotNull(mLoadingDialogFragment);
        mLoadingDialogFragment.dismissLoading();
    }
}
