package com.orange.chat2piao.base.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.orange.chat2piao.base.ifc.component.ILoading;
import com.orange.chat2piao.base.ifc.component.ILoadingDialogFragment;
import com.orange.chat2piao.base.ifc.component.generate.IBuildLoading;
import com.orange.chat2piao.base.ifc.component.generate.IBuildLoadingDialogFragment;
import com.orange.chat2piao.base.ifc.view.INetView;
import com.orange.chat2piao.base.impl.component.LoadingImpl;
import com.orange.chat2piao.base.impl.globle.GlobleImp;
import com.orange.chat2piao.base.impl.presenter.LoadingNetPresenter;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;
import com.orange.chat2piao.base.ui.activity.base.PresenterActivity;
import com.orange.chat2piao.utils.Preconditions;

public abstract class LoadingNetActivity<P extends LoadingNetPresenter> extends PresenterActivity<P> implements IBuildLoading, IBuildLoadingDialogFragment, INetView {
    // <editor-fold defaultstate="collapsed" desc="loading">
    protected ILoading mLoading;

    /**
     * 创建生命周期回调，默认loading
     *
     * @param activity
     * @param bundle
     */
    @Override
    public void onActivityCreate(BaseActivity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        if (null == mLoading)
            mLoading = new LoadingImpl(activity);
    }

    /**
     * 初始化
     *
     * @param content
     * @param bundle
     */
    @Override
    public void initVars(View content, Bundle bundle) {
        super.initVars(content, bundle);
        mLoading = buildLoading();
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

    /**
     * 创建loading
     *
     * @return
     */
    @Override
    public ILoading buildLoading() {
        return new LoadingImpl(mActivity, buildLoadingDialogFragment());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="LoadingDialogFragment">

    /**
     * 创建LoadingDialogFragment
     *
     * @return
     */
    @Override
    public ILoadingDialogFragment buildLoadingDialogFragment() {
        return GlobleImp.getInstance().buildLoadingDialogFragment();
    }
    // </editor-fold>
}
