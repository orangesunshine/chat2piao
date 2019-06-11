package com.orange.chat2piao.base.view.activity;

import android.os.Bundle;

import com.orange.chat2piao.base.pull.IRefreshNdLoadmore;
import com.orange.chat2piao.base.generate.IBuildHeaderNdFooter;
import com.orange.chat2piao.base.view.IPulNetlView;
import com.orange.chat2piao.base.common.DefaultConfig;
import com.orange.chat2piao.base.presenter.PullNetPresenter;
import com.orange.chat2piao.base.view.activity.base.BaseActivity;

public abstract class PullNetActivity<P extends PullNetPresenter> extends PresenterActivity<P> implements IBuildHeaderNdFooter, IPulNetlView {
    // <editor-fold defaultstate="collapsed" desc="headerNdfooter">
    protected IRefreshNdLoadmore mHeaderNdFooter;

    /**
     * 初始化
     *
     * @param activity
     * @param bundle
     */
    @Override
    public void initVars(BaseActivity activity, Bundle bundle) {
        super.initVars(activity, bundle);
        mHeaderNdFooter = buildHeaderNdFooter();
    }

    @Override
    public void onActivityCreate(BaseActivity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
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
