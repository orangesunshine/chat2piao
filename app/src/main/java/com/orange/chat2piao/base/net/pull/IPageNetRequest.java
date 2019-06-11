package com.orange.chat2piao.base.net.pull;

import com.orange.chat2piao.base.net.INetCallback;

public interface IPageNetRequest<T> {
    /**
     * 请求参数curPage网络
     *
     * @param curPage
     * @param callback
     */
    void reqeust(int curPage, INetCallback<T> callback);
}
