package com.orange.chat2piao.base.impl.component;

import com.orange.chat2piao.base.ifc.call.ILoading;
import com.orange.chat2piao.base.ifc.component.ILoadingDialogFragment;
import com.orange.chat2piao.base.impl.globle.GlobleImp;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;

import java.lang.ref.WeakReference;

public class LoadingImpl implements ILoading {
    private WeakReference<BaseActivity> mReference;
    private ILoadingDialogFragment mFragment;

    public LoadingImpl(BaseActivity activity) {
        mReference = new WeakReference<>(activity);
        mFragment = GlobleImp.getInstance().buildLoadingDialogFragment();
    }

    public LoadingImpl(BaseActivity activity,ILoadingDialogFragment fragment) {
        mReference = new WeakReference<>(activity);
        mFragment = fragment;
    }

    @Override
    public void showLoading() {
        if (null != mReference && null != mFragment) {
            BaseActivity baseActivity = mReference.get();
            if (null != baseActivity && baseActivity.isActivityAlive()) {
                mFragment.showLoading(baseActivity.getSupportFragmentManager());
            }
        }
    }

    @Override
    public void dismissLoading() {
        if (null != mReference && null != mFragment) {
            BaseActivity baseActivity = mReference.get();
            if (null != baseActivity && baseActivity.isActivityAlive()) {
                mFragment.dismissLoading();
            }
        }
    }
}
