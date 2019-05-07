package com.orange.chat2piao.base.adapter;

import com.orange.chat2piao.base.ifc.presenter.callback.INetCallback;
import com.orange.chat2piao.base.ifc.view.ifc.ILoading;

public abstract class NetCallbackAdapter<T> implements INetCallback<T> {
    @Override
    public void onNetStart(ILoading loading, String netIfc) {
    }

    @Override
    public void onSuccess(T t) {
    }

    @Override
    public void onFinish(ILoading loading) {
    }

    @Override
    public void onError(int code, Throwable error) {
    }
}
