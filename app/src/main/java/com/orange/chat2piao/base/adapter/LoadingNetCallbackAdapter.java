package com.orange.chat2piao.base.adapter;

import com.orange.chat2piao.base.ifc.callback.INetCallback;
import com.orange.chat2piao.base.ifc.view.ifc.ILoading;
import com.orange.chat2piao.utils.Preconditions;

public class LoadingNetCallbackAdapter<T> implements INetCallback<T> {
    private ILoading mLoading;
    StringBuilder log = new StringBuilder();

    public LoadingNetCallbackAdapter(ILoading loading) {
        mLoading = loading;
    }

    @Override
    public void onNetStart(String netIfc) {
        log.append("->>>>>onNetStart->netIfc: " + netIfc);
        Preconditions.checkNotNull(mLoading);
        mLoading.showLoading();
    }

    @Override
    public void onSuccess(T t) {
        log.append("\nonSuccess->o: " + String.valueOf(t));
    }

    @Override
    public void onFinish() {
        log.append("\nonFinish<<<<<-");
        Preconditions.checkNotNull(mLoading);
        mLoading.dismissLoading();
    }

    @Override
    public void onError(int code, Throwable error) {
        log.append("\nonError->code: " + code + ", error: " + (null == error ? error.getCause().getMessage() : error.getMessage()));
    }
}
