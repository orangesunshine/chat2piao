package com.orange.chat2piao.base.mvp.model.net.callback;

/**
 * 网络回调抽象层
 *
 * @param <T>
 */
public interface INetCallback<T> {
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
     * @param noData 没有更多数据：用于pull
     * @param empty  结果数据为空
     */
    void onComplete(boolean noData, boolean empty);

    /**
     * 失败
     *
     * @param code
     * @param error
     */
    void onError(int code, Throwable error);
}
