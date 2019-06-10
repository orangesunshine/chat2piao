package com.orange.chat2piao.base.ifc.callback;

/**
 * 网络回调抽象层
 *
 * @param <T>
 */
public interface ILoadingNetCallback<T> {
    /**
     * 网络请求开始
     */
    void onNetStart();

    /**
     * 成功
     *
     * @param t
     */
    void onSuccess(T t);

    /**
     * 完成
     */
    void onComplete();

    /**
     * 失败
     *
     * @param code
     * @param error
     */
    void onError(int code, Throwable error);
}
