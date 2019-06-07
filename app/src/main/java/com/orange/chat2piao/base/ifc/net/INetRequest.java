package com.orange.chat2piao.base.ifc.net;

import com.orange.chat2piao.base.ifc.callback.INetCallback;

import java.util.Map;

public interface INetRequest<T> {
    void request(Map<String, String> params, INetCallback<T> callback);//请求网络数据

    void request(INetCallback<T> callback, String... params);

    void request();
}
