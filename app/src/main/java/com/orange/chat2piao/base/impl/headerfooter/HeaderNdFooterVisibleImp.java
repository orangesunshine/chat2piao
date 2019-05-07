package com.orange.chat2piao.base.impl.headerfooter;

import com.orange.chat2piao.base.ifc.view.ifc.IHeaderNdFooter;
import com.orange.chat2piao.utils.Preconditions;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public class HeaderNdFooterVisibleImp implements IHeaderNdFooter {
    SmartRefreshLayout mRefreshLayout;

    public HeaderNdFooterVisibleImp(SmartRefreshLayout refreshLayout) {
        mRefreshLayout = refreshLayout;
    }

    @Override
    public void showHeader() {
        Preconditions.checkNotNull(mRefreshLayout);
        mRefreshLayout.autoRefresh();
    }

    @Override
    public void showFooter() {
        Preconditions.checkNotNull(mRefreshLayout);
        mRefreshLayout.autoLoadMore();
    }

    @Override
    public void hideHeader() {
        Preconditions.checkNotNull(mRefreshLayout);
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void hideFooter() {
        Preconditions.checkNotNull(mRefreshLayout);
        mRefreshLayout.finishLoadMore();
    }
}
