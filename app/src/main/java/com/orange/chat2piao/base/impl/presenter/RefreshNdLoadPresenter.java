package com.orange.chat2piao.base.impl.presenter;

import com.orange.chat2piao.base.ifc.presenter.callback.IRefreshNdLoadCallback;
import com.orange.chat2piao.base.ifc.view.ifc.ILoading;

public class RefreshNdLoadPresenter<T> extends NetPresenter<T> implements IRefreshNdLoadCallback {
    public RefreshNdLoadPresenter(ILoading loading) {
        super(loading);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
