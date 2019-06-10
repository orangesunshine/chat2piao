package com.orange.chat2piao.base.ifc.net;

import com.orange.chat2piao.base.ifc.callback.ILoadingNetCallback;

public interface ILoadingNetRequest<T> {
    void reqeust(ILoadingNetCallback<T> callback);
}
