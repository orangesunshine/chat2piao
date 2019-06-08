package com.orange.chat2piao.base.impl.component;

import android.view.View;
import android.widget.TextView;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.ifc.component.IHeaderNdFooter;
import com.orange.chat2piao.base.ui.recyclerview.ContentViewHolder;
import com.orange.chat2piao.utils.Preconditions;
import com.orange.chat2piao.utils.ViewHelper;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class SwipeRefreshHeaderFooter implements IHeaderNdFooter<SwipeRefreshLayout, TextView> {
    //views
    SwipeRefreshLayout refreshLayout;
    TextView tvFooter;

    private ContentViewHolder mViewHolder;

    @Override
    public void header(SwipeRefreshLayout header) {
        Preconditions.checkNotNull(header);
        header.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light);
    }

    @Override
    public void footer(TextView footer) {
        Preconditions.checkNotNull(footer);
        footer.setTextAppearance(footer.getContext(), R.style.swiperefreshlayout_footer);
    }

    @Override
    public void showHeader() {
        Preconditions.checkNotNull(refreshLayout);
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void showFooter() {
        ViewHelper.setVisible(tvFooter, true);
    }

    @Override
    public void hideHeader() {
        Preconditions.checkNotNull(refreshLayout);
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void hideFooter() {
        ViewHelper.setVisible(tvFooter, false);
    }

    @Override
    public void bindViews(View view) {
        mViewHolder = new ContentViewHolder(view);
        refreshLayout = mViewHolder.getView(R.id.refreshlayout);
        tvFooter = mViewHolder.getView(R.id.refreshlayout_footer);
    }

    @Override
    public void unbindView() {
        if (null != mViewHolder) {
            mViewHolder.clear();
        }
    }
}
