package com.orange.chat2piao.base.mvp.view.activity;

import android.os.Bundle;

import com.orange.chat2piao.base.common.DefaultConfig;
import com.orange.chat2piao.base.generate.IBuildHeaderNdFooter;
import com.orange.chat2piao.base.mvp.presenter.LoadingPresenter;
import com.orange.chat2piao.base.mvp.presenter.PullPresenter;
import com.orange.chat2piao.base.pull.IRefreshNdLoadmore;

public abstract class PullNetActivity<P extends PullPresenter> extends PresenterActivity<P> implements IBuildHeaderNdFooter, IRefreshNdLoadmore {
    // <editor-fold defaultstate="collapsed" desc="headerNdfooter">
    protected IRefreshNdLoadmore mHeaderNdFooter;

    /**
     * 初始化
     *
     * @param bundle
     */
    @Override
    public void initVars(Bundle bundle) {
        super.initVars(bundle);
        mHeaderNdFooter = buildHeaderNdFooter();
        if (null == mHeaderNdFooter)
            mHeaderNdFooter = DefaultConfig.getInstance().buildHeaderNdFooter();
    }

    @Override
    public IRefreshNdLoadmore buildHeaderNdFooter() {
        return DefaultConfig.getInstance().buildHeaderNdFooter();
    }

    /**
     * 显示header
     */
    @Override
    public void refresh() {
        if (null != mHeaderNdFooter)
            mHeaderNdFooter.refresh();
    }

    /**
     * 显示footer
     */
    @Override
    public void loadmore() {
        if (null != mHeaderNdFooter)
            mHeaderNdFooter.loadmore();
    }

    /**
     * 隐藏header
     */
    @Override
    public void finishRefresh(boolean noData) {
        if (null != mHeaderNdFooter)
            mHeaderNdFooter.finishRefresh(noData);
    }

    /**
     * 隐藏footer
     */
    @Override
    public void finishLoadmore(boolean noData) {
        if (null != mHeaderNdFooter)
            mHeaderNdFooter.finishLoadmore(noData);
    }
    // </editor-fold>
}
