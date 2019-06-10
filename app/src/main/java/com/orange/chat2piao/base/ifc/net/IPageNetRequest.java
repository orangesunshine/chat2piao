package com.orange.chat2piao.base.ifc.net;

import com.orange.chat2piao.base.ifc.callback.IPullNetCallback;

public interface IPageNetRequest<T> {
    /**
     * 请求参数curPage网络
     *
     * @param curPage
     * @param callback
     */
    void reqeust(int curPage, IPullNetCallback<T> callback);
}
