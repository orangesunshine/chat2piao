package com.orange.chat2piao.base.impl.component;

import android.view.View;
import android.widget.TextView;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.ui.recyclerview.ContentViewHolder;
import com.orange.chat2piao.utils.Preconditions;
import com.orange.chat2piao.utils.ViewHelper;

public class SwipeRefreshNdLoadmore extends RefreshNdLoadmoreImpl<SwipeRefreshLayout, TextView> {

    @Override
    public void refresh() {
        Preconditions.checkNotNull(header);
        header.setRefreshing(true);
    }

    @Override
    public void loadmore() {
        ViewHelper.setVisible(footer, true);
    }

    @Override
    public void finishRefresh() {
        Preconditions.checkNotNull(header);
        header.setRefreshing(false);
    }

    @Override
    public void finishLoadmore() {
        ViewHelper.setVisible(footer, false);
    }

    @Override
    public void bindViews(View view) {
        super.bindViews(view);
        header = mHolder.getView(R.id.refreshlayout);
        footer = mHolder.getView(R.id.refreshlayout_footer);
        Preconditions.checkNotNull(header, "null == header");
        header.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light);
    }
}
