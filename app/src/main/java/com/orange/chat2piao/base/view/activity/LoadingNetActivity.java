package com.orange.chat2piao.base.view.activity;

import android.os.Bundle;

import com.orange.chat2piao.base.loading.ILoading;
import com.orange.chat2piao.base.view.ILoadingNetView;
import com.orange.chat2piao.base.loading.LoadingImpl;
import com.orange.chat2piao.base.presenter.LoadingNetPresenter;

public abstract class LoadingNetActivity<P extends LoadingNetPresenter> extends PresenterActivity<P> implements ILoadingNetView {
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
}
