package com.orange.chat2piao.base.mvp.model.net.pull;

import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;

public abstract class PullNetRequestImpl<T> implements IPullNetRequest<T> {
    private int curPage = 1;

    @Override
    public void pullReqeust(int type, INetCallback<T> callback) {
        if (TYPE_REFRESH == type) {
            curPage = 1;
        } else if (TYPE_LOADMORE == type) {
            curPage++;
        }

//        request(curPage, callback);
    }
}
