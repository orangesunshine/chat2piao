package com.orange.chat2piao.abstractor.ifc.net;

/**
 * 网络回调抽象层
 * @param <T>
 */
public interface INetCallback<T> {
    //网络请求开始
    void onNetStart();

    //成功
    void onSuccess(T t);

    //完成
    void onFinish();

    //失败
    void onError(int code, Throwable error);
}
