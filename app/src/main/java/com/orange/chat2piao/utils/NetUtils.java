package com.orange.chat2piao.utils;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.orange.chat2piao.base.loading.ILoading;
import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.base.mvp.model.net.callback.LoadingNetCallback;
import com.orange.chat2piao.base.mvp.model.net.callback.PullNetCallback;
import com.orange.chat2piao.base.mvp.model.net.pull.IPageNetRequest;
import com.orange.chat2piao.base.mvp.model.net.pull.IPullNetRequest;
import com.orange.chat2piao.base.mvp.model.net.pull.IPullNetResultCallback;
import com.orange.chat2piao.base.pull.IPull;
import com.orange.chat2piao.base.reponse.PullData;
import com.orange.chat2piao.constant.IFinalConst;
import com.orange.chat2piao.ui.recyclerview.CommonAdapter;
import com.orange.chat2piao.ui.recyclerview.IConvertRecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

import static com.orange.chat2piao.base.mvp.model.net.pull.IPullNetRequest.TYPE_LOADMORE;

public class NetUtils {

// <editor-fold defaultstate="collapsed" desc="loading网络数据">

    /**
     * netRequest请求网络数据，默认LoadingNetCallback处理，convert自定义处理onSuccess返回
     *
     * @param loading
     * @param netRequest
     * @param convert
     * @param <T>
     */
    public static <T> void loadingNetData(ILoading loading, INetRequest<T> netRequest, IConvert<T> convert) {
        netRequest.request(new LoadingNetCallback<T>(loading) {
            @Override
            public void onSuccess(T t) {
                super.onSuccess(t);
                if (null != convert) {
                    convert.convert(t);
                }
            }
        });
    }

    /**
     * netRequest请求网络数据，netCallback处理返回状态、结果
     *
     * @param netCallback
     * @param netRequest
     * @param <T>
     */
    public static <T> void loadingNetData(INetRequest<T> netRequest, INetCallback<T> netCallback) {
        netRequest.request(netCallback);
    }

    public interface INetRequest<T> {
        void request(INetCallback<T> callback);
    }

    public interface IConvert<T> {
        void convert(T data);
    }
// </editor-fold>

    public static <ITEM> CommonAdapter<ITEM> pullNetData(Context context, int itemLayout, SmartRefreshLayout refreshLayout, RecyclerView rv, View emptyLayout, CommonAdapter<ITEM> adapter,IPull pull, IPageNetRequest<PullData<ITEM>> netRequest, IConvertRecyclerView<ITEM> convertRecyclerView) {
        Preconditions.checkNotNull(refreshLayout, rv, netRequest);
        if (null == adapter)
            adapter = new CommonAdapter<ITEM>(context, itemLayout, convertRecyclerView);
        CommonAdapter<ITEM> finalAdapter = adapter;
        INetCallback itemNetCallback = new PullNetCallback<PullData<ITEM>>(pull){
            @Override
            public void onSuccess(PullData<ITEM> tiem) {
                super.onSuccess(tiem);
            }
        };
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                netRequest.request(finalAdapter.getPageIndex(IFinalConst.TYPE_LOADMORE),itemNetCallback);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                netRequest.request(finalAdapter.getPageIndex(IFinalConst.TYPE_REFRESH),itemNetCallback);
            }
        });
        return adapter;
    }

    public static <DATA, ITEM> void concactPullNet(@IPullNetRequest.PullType int type, RecyclerView rv, View emptyLayout, final CommonAdapter<ITEM> adapter, IPull refreshNdLoadmore, IPullNetRequest<DATA> request, IPullNetResultCallback<DATA, ITEM> resultCallback) {
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
}
