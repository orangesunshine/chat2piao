package com.orange.chat2piao.thirdParty.smartfreshlayout;

import android.view.View;

import androidx.annotation.NonNull;

import com.orange.chat2piao.base.common.IConvert;
import com.orange.chat2piao.base.common.holder.IHolder;
import com.orange.chat2piao.base.mvp.model.net.callback.PullNetCallback;
import com.orange.chat2piao.base.mvp.model.net.pull.IPageNetRequest;
import com.orange.chat2piao.base.pull.AbstractPullRefresh;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

public class SmartPullRefresh extends AbstractPullRefresh<SmartRefreshLayout, View> {
    /**
     * @param holder
     * @param pageRequest
     */
    public <T> SmartPullRefresh(IHolder holder, IPageNetRequest<T> pageRequest, IConvert<T> convert) {
        super(holder, pageRequest);
        mNetCallback = new PullNetCallback<T>(this) {
            @Override
            public void onSuccess(T data) {
                super.onSuccess(data);
                if (null != convert)
                    convert.convert(data);
            }
        };
        setListener();
    }

    private void setListener() {
        if (null != refreshLayout) {
            refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    SmartPullRefresh.this.onLoadMore();
                }

                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    SmartPullRefresh.this.onRefresh();
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
}
