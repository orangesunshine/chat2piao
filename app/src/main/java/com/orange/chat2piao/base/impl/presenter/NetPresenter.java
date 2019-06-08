package com.orange.chat2piao.base.impl.presenter;

import android.os.Bundle;

import com.orange.chat2piao.base.adapter.LoadingNetCallbackAdapter;
import com.orange.chat2piao.base.ifc.callback.INetCallback;
import com.orange.chat2piao.base.ifc.component.generate.IBuildNetCallback;
import com.orange.chat2piao.base.ifc.view.IView;
import com.orange.chat2piao.base.ui.activity.NetActivity;
import com.orange.chat2piao.utils.Preconditions;

public class NetPresenter<A extends NetActivity, V extends IView, T> extends BasePresenter<A, V> implements IBuildNetCallback<T>, INetCallback<T> {
    private INetCallback<T> mNetCallback;

    @Override
    public void onActivityCreate(A activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        mNetCallback = buildNetCallback();
    }

    @Override
    public void onNetStart(String netIfc) {
        Preconditions.checkNotNull(mNetCallback);
        mNetCallback.onNetStart(netIfc);
    }

    @Override
    public void onSuccess(T t) {
        Preconditions.checkNotNull(mNetCallback);
        mNetCallback.onSuccess(t);
    }

    @Override
    public void onFinish() {
        Preconditions.checkNotNull(mNetCallback);
        mNetCallback.onFinish();
    }

    @Override
    public void onError(int code, Throwable error) {
        Preconditions.checkNotNull(mNetCallback);
        mNetCallback.onError(code, error);
    }

    @Override
    public INetCallback<T> buildNetCallback() {
        Preconditions.checkNotNull(mActivity);
        return new LoadingNetCallbackAdapter<>(mActivity.getLoading());
    }
}
