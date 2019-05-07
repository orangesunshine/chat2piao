package com.orange.chat2piao.base.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.orange.chat2piao.base.ifc.presenter.IPresenter;
import com.orange.chat2piao.base.ifc.presenter.callback.IInit;
import com.orange.chat2piao.base.ifc.presenter.generate.IGeneratePresenter;
import com.orange.chat2piao.base.ifc.view.IView;
import com.orange.chat2piao.base.ifc.view.ifc.ILoading;
import com.orange.chat2piao.base.ifc.view.ifc.ILoadingDialogFragment;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildLoadDialogFragment;
import com.orange.chat2piao.base.impl.defaultImp.DefaultConfig;
import com.orange.chat2piao.utils.Preconditions;

public abstract class NetActivity extends BaseActivity implements IBuildLoadDialogFragment, ILoading, IInit {
    //views
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
        Preconditions.checkNotNull(mLoadingDialogFragment);
        mLoadingDialogFragment.showLoading(getSupportFragmentManager());
    }

    @Override
    public void dismissLoading() {
        Preconditions.checkNotNull(mLoadingDialogFragment);
        mLoadingDialogFragment.dismissLoading();
    }


    @Override
    public void init(Context context) {

    }
}
