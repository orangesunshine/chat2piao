package com.orange.chat2piao.base.impl.component;

import android.widget.TextView;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.ifc.component.IHolder;
import com.orange.chat2piao.utils.Preconditions;
import com.orange.chat2piao.utils.ViewHelper;

public class SwipeRefreshNdLoadmore extends RefreshNdLoadmoreImpl<SwipeRefreshLayout, TextView> {
    private boolean noData;

    @Override
    public void refresh() {
        resetNoData();
        if (null != refreshLayout)
            refreshLayout.setRefreshing(true);
    }

    @Override
    public void loadmore() {
        if (null != mHolder)
            mHolder.setVisible(R.id.refreshlayout_footer, true);
    }

    @Override
    public void finishRefresh(boolean noData) {
        noData(noData);
        if (null != refreshLayout)
            refreshLayout.setRefreshing(false);
    }

    /**
     * 没有更多数据
     *
     * @param noData
     */
    private void noData(boolean noData) {
        if (this.noData != noData) {
            this.noData = noData;
            if (null != mHolder)
                mHolder.setText(R.id.refreshlayout_footer, noData ? R.string.no_more_data : R.string.loadmore_footer);
        }
    }

    private void resetNoData() {
        this.noData = false;
        if (null != mHolder)
            mHolder.setText(R.id.refreshlayout_footer, R.string.loadmore_footer);
    }

    @Override
    public void finishLoadmore(boolean noData) {
        noData(noData);
        ViewHelper.setVisible(footer, false);
    }

    /**
     * 跟视图
     *
     * @param holder
     */
    @Override
    public void attachHolder(IHolder holder) {
        super.attachHolder(holder);
        if (null != refreshLayout)
            refreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                    android.R.color.holo_green_light, android.R.color.holo_orange_light);
    }
}
