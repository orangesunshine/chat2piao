package com.orange.chat2piao.base.net;

import com.orange.chat2piao.base.net.INetCallback;
import com.orange.chat2piao.base.net.pull.IPageNetRequest;
import com.orange.chat2piao.base.net.pull.IPullNetRequest;

public class PullNetRequestImpl<T> implements IPullNetRequest<T> {
    private int curPage = 1;
    private IPageNetRequest<T> mPageNetRequest;

    public PullNetRequestImpl(IPageNetRequest<T> pageNetRequest) {
        mPageNetRequest = pageNetRequest;
    }

    public PullNetRequestImpl() {
    }

    @Override
    public void pullReqeust(int type, INetCallback<T> callback) {
        if (TYPE_REFRESH == type) {
            curPage = 1;
        } else if (TYPE_LOADMORE == type) {
            curPage++;
        }

        reqeust(curPage, callback);
    }

    /**
     * 请求参数curPage网络
     *
     * @param curPage
     * @param callback
     */
    @Override
    public void reqeust(int curPage, INetCallback<T> callback) {
        if (null != mPageNetRequest)
            mPageNetRequest.reqeust(curPage, callback);
    }
}
