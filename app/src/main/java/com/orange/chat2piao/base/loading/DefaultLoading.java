package com.orange.chat2piao.base.loading;

import com.orange.chat2piao.base.mvp.view.activity.base.BaseActivity;
import com.orange.chat2piao.ui.dialog.LoadingDialog;

import java.lang.ref.WeakReference;

public class DefaultLoading implements ILoading {
    private WeakReference<BaseActivity> mReference;
    private ILoadingDialogFragment mFragment;

    public DefaultLoading(BaseActivity activity) {
        mReference = new WeakReference<>(activity);
        mFragment = new LoadingDialog();
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
