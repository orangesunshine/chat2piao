package com.orange.chat2piao.thirdParty.smartfreshlayout;

import android.view.View;

import androidx.annotation.NonNull;

import com.orange.chat2piao.base.common.holder.IHolder;
import com.orange.chat2piao.base.mvp.model.net.pull.IPageNetRequest;
import com.orange.chat2piao.base.pull.AbstractPull;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

public class SmartPull extends AbstractPull<SmartRefreshLayout, View> {

    public <T> SmartPull(IHolder holder, IPageNetRequest<T> pageRequest) {
        super(holder, pageRequest);
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
            refreshLayout.autoRefresh();
            refreshLayout.resetNoMoreData();
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
}
