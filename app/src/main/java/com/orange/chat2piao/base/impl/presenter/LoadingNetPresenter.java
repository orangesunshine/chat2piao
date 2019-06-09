package com.orange.chat2piao.base.impl.presenter;

import android.os.Bundle;

import com.orange.chat2piao.base.adapter.NetCallbackAdapterByLoading;
import com.orange.chat2piao.base.ifc.callback.INetCallback;
import com.orange.chat2piao.base.ifc.callback.INetRequest;
import com.orange.chat2piao.base.ifc.component.generate.IBuildNetCallback;
import com.orange.chat2piao.base.ifc.view.INetView;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;
import com.orange.chat2piao.utils.Preconditions;

public abstract class LoadingNetPresenter<V extends INetView, T> extends BasePresenter<V> implements IBuildNetCallback<T>, INetCallback<T>, INetRequest<T> {
    private INetCallback<T> mNetCallback;

    @Override
    public void onActivityCreate(BaseActivity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        mNetCallback = buildNetCallback();
        reqeust(mNetCallback);
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

    // <editor-fold defaultstate="collapsed" desc="创建网络回调">
    @Override
    public INetCallback<T> buildNetCallback() {
        Preconditions.checkNotNull(mView);
        return new NetCallbackAdapterByLoading<>(mView);
    }
    // </editor-fold>
}
