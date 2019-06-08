package com.orange.chat2piao.base.ifc.callback;

/**
 * 网络回调抽象层
 *
 * @param <T>
 */
public interface INetCallback<T> {
    /**
     * 网络请求开始
     * @param netIfc 网络地址
     */
    void onNetStart(String netIfc);

    /**
     * 成功
     * @param t
     */
    void onSuccess(T t);

    /**
     * 完成
     */
    void onFinish();

    /**
     * 失败
     * @param code
     * @param error
     */
    void onError(int code, Throwable error);
}
