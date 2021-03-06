package com.orange.chat2piao.base.mvp.model.net.callback;

public class NetCallbackAdapter<T> implements INetCallback<T> {
    private INetCallback<T> mNetCallback;

    public NetCallbackAdapter(INetCallback<T> netCallback) {
        mNetCallback = netCallback;
    }

    /**
     * 网络请求开始
     */
    @Override
    public void onNetStart() {
        if (null != mNetCallback)
            mNetCallback.onNetStart();
    }

    /**
     * 成功
     *
     * @param t
     */
    @Override
    public void onSuccess(T t) {
        if (null != mNetCallback)
            mNetCallback.onSuccess(t);
    }

    /**
     * 完成
     *
     * @param noData
     */
    @Override
    public void onComplete(boolean noData, boolean emtpy) {
        if (null != mNetCallback)
            mNetCallback.onComplete(noData, emtpy);
    }

    /**
     * 失败
     *
     * @param code
     * @param error
     */
    @Override
    public void onError(int code, Throwable error) {
        if (null != mNetCallback)
            mNetCallback.onError(code, error);
    }
}
