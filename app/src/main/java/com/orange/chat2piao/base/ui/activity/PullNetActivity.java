package com.orange.chat2piao.base.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.orange.chat2piao.base.ifc.component.IRefreshNdLoadmore;
import com.orange.chat2piao.base.ifc.component.generate.IBuildHeaderNdFooter;
import com.orange.chat2piao.base.ifc.view.IPullView;
import com.orange.chat2piao.base.impl.globle.GlobleImp;
import com.orange.chat2piao.base.impl.presenter.PullNetPresenter;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;
import com.orange.chat2piao.base.ui.activity.base.PresenterActivity;

public abstract class PullNetActivity<P extends PullNetPresenter> extends PresenterActivity<P> implements IBuildHeaderNdFooter, IPullView {
    // <editor-fold defaultstate="collapsed" desc="headerNdfooter">
    protected IRefreshNdLoadmore mHeaderNdFooter;

    /**
     * 初始化
     *
     * @param content
     * @param bundle
     */
    @Override
    public void initVars(View content, Bundle bundle) {
        super.initVars(content, bundle);
        mHeaderNdFooter = buildHeaderNdFooter();
    }

    @Override
    public void onActivityCreate(BaseActivity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        if (null == mHeaderNdFooter)
            mHeaderNdFooter = GlobleImp.getInstance().buildHeaderNdFooter();
    }

    @Override
    public IRefreshNdLoadmore buildHeaderNdFooter() {
        return GlobleImp.getInstance().buildHeaderNdFooter();
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
