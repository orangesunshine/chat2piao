package com.orange.chat2piao.base.impl.component;

import android.view.View;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.ifc.component.IAttachHolder;
import com.orange.chat2piao.base.ifc.component.IHolder;
import com.orange.chat2piao.base.ifc.component.IRefreshNdLoadmore;

public class RefreshNdLoadmoreImpl<REFRESH extends View, F extends View> implements IRefreshNdLoadmore, IAttachHolder {
    protected REFRESH refreshLayout;
    protected F footer;
    protected IHolder mHolder;

    @Override
    public void refresh() {

    }

    @Override
    public void loadmore() {

    }

    @Override
    public void finishRefresh(boolean noData) {

    }

    @Override
    public void finishLoadmore(boolean noData) {

    }

    /**
     * 跟视图
     *
     * @param holder
     */
    @Override
    public void attachHolder(IHolder holder) {
        mHolder = holder;
        refreshLayout = holder.getView(R.id.refreshlayout);
        footer = holder.getView(R.id.refreshlayout_footer);
    }
}
