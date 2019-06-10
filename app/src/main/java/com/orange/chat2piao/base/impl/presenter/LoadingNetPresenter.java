package com.orange.chat2piao.base.impl.presenter;

import android.os.Bundle;

import com.orange.chat2piao.base.impl.callback.LoadingNetCallback;
import com.orange.chat2piao.base.ifc.callback.ILoadingNetCallback;
import com.orange.chat2piao.base.ifc.generate.IBuildLoadingNetCallback;
import com.orange.chat2piao.base.ifc.net.ILoadingNetRequest;
import com.orange.chat2piao.base.ifc.view.INetView;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;

public abstract class LoadingNetPresenter<V extends INetView, T> extends BasePresenter<V> implements IBuildLoadingNetCallback<T>, ILoadingNetCallback<T>, ILoadingNetRequest<T> {
    private ILoadingNetCallback<T> mNetCallback;

    @Override
    public void onActivityCreate(BaseActivity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        mNetCallback = buildLoadingNetCallback();
        reqeust(mNetCallback);
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
     */
    @Override
    public void onComplete() {
        if (null != mNetCallback)
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
        if (null != mNetCallback)
            mNetCallback.onError(code, error);
    }

    // <editor-fold defaultstate="collapsed" desc="创建网络回调">
    @Override
    public ILoadingNetCallback<T> buildLoadingNetCallback() {
        return new LoadingNetCallback<>(mView);
    }
    // </editor-fold>
}
