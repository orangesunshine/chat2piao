package com.orange.chat2piao.base.mvp.model.net;

import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;

public interface INetRequest<T> {
    void request(INetCallback<T> callback);
}
