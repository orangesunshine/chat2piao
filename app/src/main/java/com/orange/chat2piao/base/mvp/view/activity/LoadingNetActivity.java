package com.orange.chat2piao.base.mvp.view.activity;

import android.os.Bundle;

import com.orange.chat2piao.base.loading.ILoading;
import com.orange.chat2piao.base.loading.LoadingImpl;
import com.orange.chat2piao.base.mvp.presenter.LoadingPresenter;

public abstract class LoadingNetActivity<P extends LoadingPresenter> extends PresenterActivity<P> implements ILoading {
    // <editor-fold defaultstate="collapsed" desc="loading">
    protected ILoading mLoading;

    /**
     * 初始化
     *
     * @param bundle
     */
    @Override
    public void initVars(Bundle bundle) {
        super.initVars(bundle);
        mLoading = new LoadingImpl(mActivity);
    }

    /**
     * 显示loading
     */
    @Override
    public void showLoading() {
        if (null != mLoading)
            mLoading.showLoading();
    }

    /**
     * 隐藏loading
     */
    @Override
    public void dismissLoading() {
        if (null != mLoading)
            mLoading.dismissLoading();
    }
    // </editor-fold>
}
