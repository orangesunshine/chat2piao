package com.orange.chat2piao.thirdParty.smartfreshlayout;

import android.view.View;

import com.orange.chat2piao.base.pull.RefreshNdLoadmoreImpl;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class SmartRefreshNdLoadmore extends RefreshNdLoadmoreImpl<SmartRefreshLayout, View> {

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
}
