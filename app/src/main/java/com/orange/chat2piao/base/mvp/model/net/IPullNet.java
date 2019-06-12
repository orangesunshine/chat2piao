package com.orange.chat2piao.base.mvp.model.net;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.base.mvp.model.net.callback.PullNetCallback;
import com.orange.chat2piao.base.mvp.model.net.pull.IPullNetRequest;
import com.orange.chat2piao.base.mvp.model.net.pull.IPullNetResultCallback;
import com.orange.chat2piao.base.pull.IPull;
import com.orange.chat2piao.ui.recyclerview.CommonAdapter;

public interface IPullNet {
    // <editor-fold defaultstate="collapsed" desc="pull网络请求">
    <T> void concactPullNet(@IPullNetRequest.PullType int type, IPullNetRequest<T> request, INetCallback<T> callback);

    <DATA, ITEM> void concactPullNet(@IPullNetRequest.PullType int type, RecyclerView rv, View emptyLayout, final CommonAdapter<ITEM> adapter, IPull refreshNdLoadmore, IPullNetRequest<DATA> request, IPullNetResultCallback<DATA, ITEM> resultCallback);

    <T> void concactPullNet(@IPullNetRequest.PullType int type, IPullNetRequest<T> request, PullNetCallback<T> callback);
    // </editor-fold>
}
