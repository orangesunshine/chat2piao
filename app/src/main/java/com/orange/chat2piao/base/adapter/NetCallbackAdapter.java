package com.orange.chat2piao.base.adapter;

import com.orange.chat2piao.base.ifc.presenter.callback.INetCallback;
import com.orange.chat2piao.base.ifc.view.ifc.ILoading;
import com.orange.chat2piao.utils.LogUtil;
import com.orange.chat2piao.utils.Preconditions;

public abstract class NetCallbackAdapter<T> implements INetCallback<T> {
    @Override
    public void onNetStart(ILoading loading, String netIfc) {
        LogUtil.e("netIfc: " + netIfc);
        Preconditions.checkNotNull(loading);
        loading.showLoading();
    }

    @Override
    public void onSuccess(T t) {

    }

    @Override
    public void onFinish(ILoading loading) {
        Preconditions.checkNotNull(loading);
        loading.dismissLoading();
    }

    @Override
    public void onError(int code, Throwable error) {
        LogUtil.e("onError->code: " + code + ", error: " + (null == error ? error.getCause().getMessage() : error.getMessage()));
    }
}
