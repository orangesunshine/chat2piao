package com.orange.chat2piao.base.mvp.view.activity;

import android.os.Bundle;

import com.orange.chat2piao.base.mvp.presenter.BasePresenter;
import com.orange.chat2piao.base.pull.AbstractPull;

public abstract class PullNetActivity<P extends BasePresenter> extends PresenterActivity<P> {
    // <editor-fold defaultstate="collapsed" desc="headerNdfooter">
    protected AbstractPull mPull;

    /**
     * 初始化
     *
     * @param bundle
     */
    @Override
    public void initVars(Bundle bundle) {
        super.initVars(bundle);
        mPull = buildHeaderNdFooter();
    }

    public abstract AbstractPull buildHeaderNdFooter();
    // </editor-fold>
}
