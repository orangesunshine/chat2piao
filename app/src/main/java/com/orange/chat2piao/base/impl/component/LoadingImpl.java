package com.orange.chat2piao.base.impl.component;

import com.orange.chat2piao.base.ifc.component.ILoading;
import com.orange.chat2piao.base.ifc.component.ILoadingDialogFragment;
import com.orange.chat2piao.base.ui.activity.BaseActivity;

import java.lang.ref.WeakReference;

public class LoadingImpl implements ILoading {
    private WeakReference<BaseActivity> mReference;
    private ILoadingDialogFragment mFragment;

    public LoadingImpl(BaseActivity activity, ILoadingDialogFragment dialogFragment) {
        mReference = new WeakReference<>(activity);
        mFragment = dialogFragment;
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
