package com.orange.chat2piao.base.mvp.model.net.callback;

import com.orange.chat2piao.base.pull.IPull;

public class PullNetCallback<T> extends DefaultNetCallback<T> {
    private IPull pull;

    public PullNetCallback(IPull pull) {
        this.pull = pull;
    }

    @Override
    public void onComplete(boolean noData, boolean empty) {
        super.onComplete(noData, empty);
        if (null != pull) {
            pull.finishRefresh(noData);
            pull.finishLoadmore(noData);
        }
    }
}
