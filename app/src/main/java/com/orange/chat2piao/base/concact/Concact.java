package com.orange.chat2piao.base.concact;

import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.base.mvp.model.net.INetRequest;
import com.orange.chat2piao.base.mvp.model.net.pull.IPullNetRequest;

public class Concact {

    public static <T> void concact(INetRequest request, INetCallback<T> callback) {
        request.request(callback);
    }

    public static <T> void concact(@IPullNetRequest.PullType int type, IPullNetRequest<T> request, INetCallback<T> callback) {
        request.pullReqeust(type, callback);
    }
}
