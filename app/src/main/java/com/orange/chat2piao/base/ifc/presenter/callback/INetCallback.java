package com.orange.chat2piao.base.ifc.presenter.callback;

import com.orange.chat2piao.base.ifc.view.ifc.ILoading;

/**
 * 网络回调抽象层
 *
 * @param <T>
 */
public interface INetCallback<T> {
    //网络请求开始
    void onNetStart(ILoading loading, String netIfc);

    //成功
    void onSuccess(T t);

    //完成
    void onFinish(ILoading loading);

    //失败
    void onError(int code, Throwable error);
}
