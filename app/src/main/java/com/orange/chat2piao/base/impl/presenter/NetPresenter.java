package com.orange.chat2piao.base.impl.presenter;

import android.app.Activity;
import android.os.Bundle;

import com.orange.chat2piao.base.ifc.presenter.callback.INetCallback;
import com.orange.chat2piao.base.ifc.view.ifc.ILoading;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildNetCallback;
import com.orange.chat2piao.base.impl.defaultImp.DefaultConfig;
import com.orange.chat2piao.utils.Preconditions;

public class NetPresenter<T> extends InitPresenter implements IBuildNetCallback, INetCallback<T> {
    private ILoading mLoading;
    private INetCallback<T> mNetCallback;

    public NetPresenter(ILoading loading) {
        mLoading = loading;
    }

    @Override
    public void onActivityCreate(Activity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        mNetCallback = buildNetCallback();
        if (null == mNetCallback)
            mNetCallback = DefaultConfig.getInstance().buildNetCallback();
    }

    @Override
    public void onNetStart(ILoading loading, String netIfc) {
        Preconditions.checkNotNull(mNetCallback);
        mNetCallback.onNetStart(loading, netIfc);
    }

    @Override
    public void onSuccess(T t) {
        Preconditions.checkNotNull(mNetCallback);
        mNetCallback.onSuccess(t);
    }

    @Override
    public void onFinish(ILoading loading) {
        Preconditions.checkNotNull(mNetCallback);
        mNetCallback.onFinish(loading);
    }

    @Override
    public void onError(int code, Throwable error) {
        Preconditions.checkNotNull(mNetCallback);
        mNetCallback.onError(code, error);
    }

    @Override
    public INetCallback buildNetCallback() {
        return null;
    }
}
