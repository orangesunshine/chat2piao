package com.orange.chat2piao.base.mvp.model.net.callback;

import com.orange.chat2piao.base.loading.ILoading;

public class LoadingNetCallback<T> extends DefaultNetCallback<T> {
    private ILoading loading;

    public LoadingNetCallback(ILoading loading) {
        this.loading = loading;
    }

    @Override
    public void onNetStart() {
        super.onNetStart();
        if (null != loading)
            loading.showLoading();
    }

    @Override
    public void onComplete(boolean noData, boolean empty) {
        super.onComplete(noData, empty);
        if (null != loading)
            loading.dismissLoading();
    }
}
