package com.orange.chat2piao.base.ifc.callback;

public interface INetRequest<T> {
    void reqeust(INetCallback<T> callback);
}
