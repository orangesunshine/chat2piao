package com.orange.chat2piao.base.impl.presenter;

import com.orange.chat2piao.base.ifc.presenter.callback.IInit;
import com.orange.chat2piao.base.ifc.presenter.callback.INetCallback;
import com.orange.chat2piao.base.ifc.view.ifc.ILoading;

public class NetPresenter<T> extends InitPresenter implements INetCallback<T> {
    private ILoading mLoading;

    public NetPresenter(ILoading loading) {
        mLoading = loading;
    }

    @Override
    public int getContentLayoutId() {
        return 0;
    }

    @Override
    public void onNetStart(ILoading loading, String netIfc) {
        if(null != mLoading)
            mLoading.showLoading();
    }

    @Override
    public void onSuccess(T t) {

    }

    @Override
    public void onFinish(ILoading loading) {
        if(null != mLoading)
            mLoading.dismissLoading();
    }

    @Override
    public void onError(int code, Throwable error) {

    }
}
