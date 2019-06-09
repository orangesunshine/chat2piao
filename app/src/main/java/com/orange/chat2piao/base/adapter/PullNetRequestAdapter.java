package com.orange.chat2piao.base.adapter;

import com.orange.chat2piao.base.ifc.callback.INetCallback;
import com.orange.chat2piao.base.ifc.callback.INetRequest;
import com.orange.chat2piao.base.ifc.callback.IPullNetRequest;

public class PullNetRequestAdapter<T> implements IPullNetRequest<T> {
    private int curPage = 1;
    private INetRequest<T> netRequest;

    public PullNetRequestAdapter(INetRequest<T> netRequest) {
        this.netRequest = netRequest;
    }

    @Override
    public void reqeust(int type, INetCallback<T> callback) {
        if (TYPE_REFRESH == type) {
            curPage = 1;
        } else if (TYPE_LOADMORE == type) {
            curPage++;
        }
        if (null != netRequest)
            netRequest.reqeust(callback);
    }

    @Override
    public int getCurPage() {
        return curPage;
    }
}
