package com.orange.chat2piao.base.mvp.presenter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.base.mvp.model.net.IPullNet;
import com.orange.chat2piao.base.mvp.model.net.pull.IPullNetRequest;
import com.orange.chat2piao.base.mvp.model.net.pull.IPullNetResultCallback;
import com.orange.chat2piao.base.mvp.model.net.callback.PullNetCallback;
import com.orange.chat2piao.base.mvp.view.IView;
import com.orange.chat2piao.base.pull.IPull;
import com.orange.chat2piao.ui.recyclerview.CommonAdapter;
import com.orange.chat2piao.utils.Preconditions;

import java.util.List;

import static com.orange.chat2piao.base.mvp.model.net.pull.IPullNetRequest.TYPE_LOADMORE;

public class PullPresenter<V extends IView & IPull> extends BasePresenter<V> implements IPullNet {
    // <editor-fold defaultstate="collapsed" desc="pull网络请求">
    @Override
    public <T> void concactPullNet(@IPullNetRequest.PullType int type, IPullNetRequest<T> request, INetCallback<T> callback) {
        Preconditions.checkNotNull(request);
        request.pullReqeust(type, callback);
    }

    @Override
    public <DATA, ITEM> void concactPullNet(@IPullNetRequest.PullType int type, RecyclerView rv, View emptyLayout, final CommonAdapter<ITEM> adapter, IPull refreshNdLoadmore, IPullNetRequest<DATA> request, IPullNetResultCallback<DATA, ITEM> resultCallback) {
        Preconditions.checkNotNull(request);
        request.pullReqeust(type, new PullNetCallback<DATA>(refreshNdLoadmore) {
            @Override
            public void onSuccess(DATA data) {
                boolean loadmore = false;
                if (type == TYPE_LOADMORE)
                    loadmore = true;
                List<ITEM> datas = null;
                if (null != resultCallback)
                    resultCallback.parseList(data);
                CommonAdapter.adaptDatas(rv, emptyLayout, adapter, loadmore, datas);
            }
        });
    }

    @Override
    public <T> void concactPullNet(int type, IPullNetRequest<T> request, PullNetCallback<T> callback) {
        Preconditions.checkNotNull(request);
        request.pullReqeust(type, callback);
    }
    // </editor-fold>
}
