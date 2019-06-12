package com.orange.chat2piao.base.mvp.presenter;

import com.orange.chat2piao.base.loading.ILoading;
import com.orange.chat2piao.base.mvp.model.net.ILoadingNet;
import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.base.mvp.model.net.INetRequest;
import com.orange.chat2piao.base.mvp.model.net.callback.LoadingNetCallback;
import com.orange.chat2piao.base.mvp.view.IView;
import com.orange.chat2piao.utils.Preconditions;

public class LoadingPresenter<V extends ILoading & IView> extends BasePresenter<V> implements ILoadingNet {
    // <editor-fold defaultstate="collapsed" desc="loading网络请求">
    @Override
    public <T> void concactLoadingNet(INetCallback<T> callback, INetRequest<T> request) {
        Preconditions.checkNotNull(request);
        request.request(callback);
    }

    public <T> void concactLoadingNet(LoadingNetCallback<T> callback, INetRequest<T> request) {
        Preconditions.checkNotNull(request);
        request.request(callback);
    }
    // </editor-fold>
}
