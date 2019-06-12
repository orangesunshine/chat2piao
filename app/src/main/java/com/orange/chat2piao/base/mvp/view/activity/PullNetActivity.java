package com.orange.chat2piao.base.mvp.view.activity;

import android.os.Bundle;
import android.view.View;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.generate.IBuildHeaderNdFooter;
import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.base.mvp.model.net.pull.IPageNetRequest;
import com.orange.chat2piao.base.mvp.presenter.BasePresenter;
import com.orange.chat2piao.base.pull.AbstractPull;
import com.orange.chat2piao.base.pull.SwipePull;
import com.orange.chat2piao.thirdParty.smartfreshlayout.SmartPull;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class PullNetActivity<P extends BasePresenter> extends PresenterActivity<P> implements IBuildHeaderNdFooter, IPageNetRequest {
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
        buildHeaderNdFooter(this);
    }

    @Override
    public void buildHeaderNdFooter(IPageNetRequest request) {
        View view = mHolder.getView(R.id.refreshlayout);
        if (null == view) throw new IllegalStateException("不存在id为refreshlayout的刷新控件");
        if (view instanceof SmartRefreshLayout) {
            mPull = new SmartPull(mHolder, request);
        } else if (view instanceof SwipeRefreshLayout) {
            mPull = new SwipePull(mHolder, request);
        } else {
            throw new IllegalStateException("refreshlayout刷新控件" + view.getClass().getSimpleName() + "不支持");
        }
    }
    // </editor-fold>
}
