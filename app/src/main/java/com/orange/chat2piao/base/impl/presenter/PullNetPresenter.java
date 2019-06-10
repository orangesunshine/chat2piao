package com.orange.chat2piao.base.impl.presenter;

import android.os.Bundle;

import com.orange.chat2piao.base.ifc.callback.IPullNetCallback;
import com.orange.chat2piao.base.ifc.generate.IBuildPullNetCallback;
import com.orange.chat2piao.base.ifc.net.IPageNetRequest;
import com.orange.chat2piao.base.impl.callback.PullNetCallback;
import com.orange.chat2piao.base.impl.net.PullNetRequestImpl;
import com.orange.chat2piao.base.ifc.callback.IPullCallback;
import com.orange.chat2piao.base.ifc.generate.IBuildPullNetRequest;
import com.orange.chat2piao.base.ifc.net.IPullNetRequest;
import com.orange.chat2piao.base.ifc.view.IPullView;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;

import static com.orange.chat2piao.base.ifc.net.IPullNetRequest.TYPE_LOADMORE;
import static com.orange.chat2piao.base.ifc.net.IPullNetRequest.TYPE_REFRESH;

public abstract class PullNetPresenter<V extends IPullView, T> extends BasePresenter<V> implements IBuildPullNetCallback<T>, IPullNetCallback<T>, IBuildPullNetRequest<T>, IPageNetRequest<T>, IPullCallback {
    private IPullNetCallback<T> mPullNetCallback;
    private IPullNetRequest<T> mPullNetRequest;

    @Override
    public void onActivityCreate(BaseActivity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        mPullNetCallback = buildPullNetCallback();
        mPullNetRequest = buildPullNetRequest();
        if (null != mView) mView.refresh();
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

    /**
     * 刷新
     */
    @Override
    public void onRefresh() {
        if (null != mPullNetRequest)
            mPullNetRequest.pullReqeust(TYPE_REFRESH, mPullNetCallback);
    }

    /**
     * 加载更多
     */
    @Override
    public void onLoadmore() {
        if (null != mPullNetRequest)
            mPullNetRequest.pullReqeust(TYPE_LOADMORE, mPullNetCallback);
    }

    @Override
    public IPullNetCallback<T> buildPullNetCallback() {
        return new PullNetCallback<T>(mView);
    }

    @Override
    public IPullNetRequest<T> buildPullNetRequest() {
        return new PullNetRequestImpl<>();
    }
}
