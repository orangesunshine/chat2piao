package com.orange.chat2piao.abstractor.adapter;

import com.orange.chat2piao.abstractor.ifc.ILoading;
import com.orange.chat2piao.abstractor.ifc.net.INetCallback;
import com.orange.chat2piao.utils.BeanUtils;
import com.orange.chat2piao.utils.LogUtil;

public abstract class NetCallbackAdapter<T> implements INetCallback<T> {
    @Override
    public void onNetStart(ILoading loading, String netIfc) {
        LogUtil.e("netIfc: " + netIfc);
        BeanUtils.checkNotNull(loading);
        loading.showLoading();
    }

    @Override
    public void onSuccess(T t) {

    }

    @Override
    public void onFinish(ILoading loading) {
        BeanUtils.checkNotNull(loading);
        loading.dismissLoading();
    }

    @Override
    public void onError(int code, Throwable error) {
        LogUtil.e("onError->code: " + code + ", error: " + (null == error ? error.getCause().getMessage() : error.getMessage()));
    }
}
