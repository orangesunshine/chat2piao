package com.orange.chat2piao.base.impl.presenter;

import android.os.Bundle;

import com.orange.chat2piao.base.adapter.NetCallbackAdapterByPull;
import com.orange.chat2piao.base.adapter.PullNetRequestAdapter;
import com.orange.chat2piao.base.ifc.callback.INetCallback;
import com.orange.chat2piao.base.ifc.callback.INetRequest;
import com.orange.chat2piao.base.ifc.callback.IPullCallback;
import com.orange.chat2piao.base.ifc.callback.IPullNetRequest;
import com.orange.chat2piao.base.ifc.callback.generate.IBuildPullNetRequest;
import com.orange.chat2piao.base.ifc.component.generate.IBuildNetCallback;
import com.orange.chat2piao.base.ifc.view.IPullView;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;
import com.orange.chat2piao.utils.Preconditions;

import static com.orange.chat2piao.base.ifc.callback.IPullNetRequest.TYPE_LOADMORE;
import static com.orange.chat2piao.base.ifc.callback.IPullNetRequest.TYPE_REFRESH;

public abstract class PullNetPresenter<V extends IPullView, T> extends BasePresenter<V> implements IBuildPullNetRequest<T>, IBuildNetCallback<T>, INetCallback<T>, INetRequest<T>, IPullCallback {
    private INetCallback<T> mNetCallback;
    private IPullNetRequest<T> mPullNetRequest;

    @Override
    public void onActivityCreate(BaseActivity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        mNetCallback = buildNetCallback();
        mPullNetRequest = buildPullNetRequest();
        if (null != mView) mView.refresh();
    }

    /**
     * 网络请求开始
     */
    @Override
    public void onNetStart() {
        Preconditions.checkNotNull(mNetCallback);
        mNetCallback.onNetStart();
    }

    /**
     * 成功
     *
     * @param t
     */
    @Override
    public void onSuccess(T t) {
        Preconditions.checkNotNull(mNetCallback);
        mNetCallback.onSuccess(t);
    }

    /**
     * 完成
     */
    @Override
    public void onComplete() {
        Preconditions.checkNotNull(mNetCallback);
        mNetCallback.onComplete();
    }

    /**
     * 失败
     *
     * @param code
     * @param error
     */
    @Override
    public void onError(int code, Throwable error) {
        Preconditions.checkNotNull(mNetCallback);
        mNetCallback.onError(code, error);
    }

    /**
     * 刷新
     */
    @Override
    public void onRefresh() {
        if (null != mPullNetRequest)
            mPullNetRequest.reqeust(TYPE_REFRESH, mNetCallback);
    }

    /**
     * 加载更多
     */
    @Override
    public void onLoadmore() {
        if (null != mPullNetRequest)
            mPullNetRequest.reqeust(TYPE_LOADMORE, mNetCallback);
    }

    @Override
    public INetCallback<T> buildNetCallback() {
        Preconditions.checkNotNull(mView);
        return new NetCallbackAdapterByPull<T>(mView);
    }

    @Override
    public IPullNetRequest<T> buildPullNetRequest() {
        return new PullNetRequestAdapter<>(this);
    }
}
