package com.orange.chat2piao.base.mvp.model.net;

import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.base.mvp.model.net.callback.LoadingNetCallback;

public interface ILoadingNet {
    // <editor-fold defaultstate="collapsed" desc="loading网络请求">

    /**
     * 请求网络request,并callback回调
     *
     * @param request
     * @param callback
     * @param <T>
     */
    <T> void concactLoadingNet(INetCallback<T> callback, INetRequest<T> request);

    <T> void concactLoadingNet(LoadingNetCallback<T> callback, INetRequest<T> request);
    // </editor-fold>
}
