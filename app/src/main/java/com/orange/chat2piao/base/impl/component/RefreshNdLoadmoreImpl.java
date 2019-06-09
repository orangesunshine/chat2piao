package com.orange.chat2piao.base.impl.component;

import android.view.View;

import com.orange.chat2piao.base.ifc.callback.INetCallback;
import com.orange.chat2piao.base.ifc.component.IBindView;
import com.orange.chat2piao.base.ifc.component.IRefreshNdLoadmore;
import com.orange.chat2piao.base.ui.recyclerview.ContentViewHolder;

public class RefreshNdLoadmoreImpl<H extends View, F extends View> implements IRefreshNdLoadmore, IBindView {
    protected H header;
    protected F footer;
    protected ContentViewHolder mHolder;

    @Override
    public void refresh() {

    }

    @Override
    public void loadmore() {

    }

    @Override
    public void finishRefresh() {

    }

    @Override
    public void finishLoadmore() {

    }

    @Override
    public void bindViews(View view) {
        mHolder = new ContentViewHolder(view);
    }

    @Override
    public void unbindView() {
        if (null != mHolder)
            mHolder.clear();
    }
}
