package com.orange.chat2piao.base.mvp.model;

import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.base.mvp.model.net.pull.IPageNetRequest;
import com.orange.chat2piao.base.mvp.presenter.BasePresenter;
import com.orange.chat2piao.base.mvp.view.IView;

public abstract class PullNetPresenter<V extends IView, T> extends BasePresenter<V> implements IPageNetRequest<T> {

    /**
     * 请求参数curPage网络
     *
     * @param curPage
     * @param callback
     */
    @Override
    public void request(int curPage, INetCallback<T> callback) {
    }
}
