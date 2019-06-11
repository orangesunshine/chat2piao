package com.orange.chat2piao.base.presenter;

import com.orange.chat2piao.base.presenter.ifc.IPullNetPresenter;
import com.orange.chat2piao.base.view.IPulNetlView;
import com.orange.chat2piao.base.net.INetCallback;
import com.orange.chat2piao.base.net.pull.IPullNetRequest;

public abstract class PullNetPresenter<V extends IPulNetlView, T> extends BasePresenter<V> implements IPullNetPresenter<T> {
    protected INetCallback<T> mPullNetCallback;
    protected IPullNetRequest<T> mPullNetRequest;


    @Override
    public void attachView(V view) {
        super.attachView(view);
        if (null != mView) mView.refresh();
    }

    /**
     * 请求参数curPage网络
     *
     * @param curPage
     * @param callback
     */
    @Override
    public void reqeust(int curPage, INetCallback<T> callback) {
    }

    /**
     * 网络请求开始
     */
    @Override
    public void onNetStart() {
        if (null != mPullNetCallback)
            mPullNetCallback.onNetStart();
    }

    /**
     * 成功
     *
     * @param t
     */
    @Override
    public void onSuccess(T t) {
        if (null != mPullNetCallback)
            mPullNetCallback.onSuccess(t);
    }

    /**
     * 完成
     */
    @Override
    public void onComplete(boolean noData) {
        if (null != mPullNetCallback)
            mPullNetCallback.onComplete(noData);
    }

    /**
     * 失败
     *
     * @param code
     * @param error
     */
    @Override
    public void onError(int code, Throwable error) {
        if (null != mPullNetCallback)
            mPullNetCallback.onError(code, error);
    }
}
