package com.orange.chat2piao.thirdParty.smartfreshlayout;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.common.holder.IHolder;
import com.orange.chat2piao.base.mvp.model.net.callback.PullNetCallback;
import com.orange.chat2piao.base.mvp.model.net.pull.IPageNetRequest;
import com.orange.chat2piao.base.pull.AbstractPull;
import com.orange.chat2piao.base.pull.IPull;
import com.orange.chat2piao.base.reponse.PullData;
import com.orange.chat2piao.ui.recyclerview.CommonAdapter;
import com.orange.chat2piao.ui.recyclerview.IConvertRecyclerView;
import com.orange.chat2piao.utils.Preconditions;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

public class SmartPull<ITEM> extends AbstractPull<SmartRefreshLayout, View> {
    protected CommonAdapter<ITEM> mAdapter;

    /**
     * 构造方法用于RecyclerView
     *
     * @param context
     * @param itemLayoutId
     * @param holder
     * @param pageRequest
     * @param convertRecyclerView
     */
    public <T> SmartPull(Context context, int itemLayoutId, IHolder holder, IPageNetRequest<T> pageRequest, IConvertRecyclerView<ITEM> convertRecyclerView) {
        super(holder, pageRequest);
        RecyclerView recyclerView = holder.getView(R.id.recyclerview);
        View emptyView = holder.getView(R.id.empty_view);
        Preconditions.checkNotNull(recyclerView, "null == recyclerView，该构造方法仅用于recycleview");

        mNetCallback = new PullNetCallback<T>(this) {
            @Override
            public void onSuccess(T data) {
                super.onSuccess(data);
                List<ITEM> datas = null;
                if (null != data && data instanceof PullData) {
                    datas = ((PullData)data).getList();
                    mAdapter = CommonAdapter.newInstance(context, recyclerView, emptyView, mAdapter, itemLayoutId, datas, pageIndex > 1, convertRecyclerView);
                }
            }
        };

        setListener();
    }

    private void setListener() {
        if (null != refreshLayout) {
            refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    SmartPull.this.onLoadMore();
                }

                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    SmartPull.this.onRefresh();
                }
            });
        }
    }

    @Override
    public void refresh() {
        if (null != refreshLayout) {
            refreshLayout.resetNoMoreData();
            refreshLayout.autoRefresh();
        }
    }

    @Override
    public void loadmore() {
        if (null != refreshLayout)
            refreshLayout.autoLoadMore();
    }

    @Override
    public void finishRefresh(boolean noData) {
        if (null != refreshLayout) {
            if (noData) {
                refreshLayout.finishRefreshWithNoMoreData();
            } else {
                refreshLayout.finishRefresh();
            }
        }
    }

    @Override
    public void finishLoadmore(boolean noData) {
        if (null != refreshLayout) {
            if (noData) {
                refreshLayout.finishLoadMoreWithNoMoreData();
            } else {
                refreshLayout.finishLoadMore();
            }
        }
    }

    /**
     * 设置能否加载
     *
     * @param enable
     * @return
     */
    @Override
    public void enableLoadMore(boolean enable) {
        if (null != refreshLayout)
            refreshLayout.setEnableLoadMore(enable);
    }

    class SmartPullCallback<DATA, ITEM, T extends PullData<DATA, ITEM>> extends PullNetCallback<T> {

        public SmartPullCallback(IPull refreshNdLoadmore) {
            super(refreshNdLoadmore);
        }

        @Override
        public void onSuccess(T data) {
            super.onSuccess(data);
            List<ITEM> datas = null;
            if (null != data)
                datas = data.getList();
//            mAdapter = CommonAdapter.newInstance(context, recyclerView, emptyView, mAdapter, itemLayoutId, datas, pageIndex > 1, convertRecyclerView);
        }
    }
}
