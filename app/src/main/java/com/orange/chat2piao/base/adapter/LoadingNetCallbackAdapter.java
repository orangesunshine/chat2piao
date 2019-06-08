package com.orange.chat2piao.base.adapter;

import com.blankj.utilcode.util.LogUtils;
import com.orange.chat2piao.base.ifc.callback.INetCallback;
import com.orange.chat2piao.base.ifc.component.ILoading;
import com.orange.chat2piao.utils.Preconditions;

public class LoadingNetCallbackAdapter<T> implements INetCallback<T> {
    private ILoading mLoading;
    private StringBuilder log = new StringBuilder();

    public LoadingNetCallbackAdapter(ILoading loading) {
        mLoading = loading;
    }

    @Override
    public void onNetStart(String netIfc) {
        log.append("->>>>>onNetStart->netIfc: ");
        log.append(netIfc);
        Preconditions.checkNotNull(mLoading);
        mLoading.showLoading();
    }

    @Override
    public void onSuccess(T t) {
        log.append("\nonSuccess->o: ");
        log.append(null != t ? t : "");
    }

    @Override
    public void onFinish() {
        log.append("\nonFinish<<<<<-");
        LogUtils.e(log.toString());
        Preconditions.checkNotNull(mLoading);
        mLoading.dismissLoading();
    }

    @Override
    public void onError(int code, Throwable error) {
        log.append("\nonError->code: ");
        log.append(code);
        log.append(", error: ");
        Throwable cause = error.getCause();
        while (null != cause) {
            log.append(cause.getMessage());
            cause = cause.getCause();
        }
    }
}
