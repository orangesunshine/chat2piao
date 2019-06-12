package com.orange.chat2piao.base.pull;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.common.holder.IHolder;
import com.orange.chat2piao.base.mvp.model.net.pull.IPageNetRequest;
import com.orange.chat2piao.utils.ViewUtils;

public class SwipePull extends AbstractPull<SwipeRefreshLayout, TextView> {
    private boolean noData;

    public <T> SwipePull(IHolder holder, IPageNetRequest<T> pageRequest) {
        super(holder, pageRequest);
        refreshLayout.setOnRefreshListener(() -> SwipePull.this.onRefresh());
        RecyclerView recyclerView = holder.getView(R.id.recyclerview);
    }

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
        ViewUtils.setVisible(footer, false);
    }

    /**
     * 设置能否加载
     *
     * @param enable
     * @return
     */
    @Override
    public void enableLoadMore(boolean enable) {

    }
}
