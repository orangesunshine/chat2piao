package com.orange.chat2piao.base.impl.view;

import android.view.View;

import com.orange.chat2piao.base.ifc.view.ifc.IBindView;

public class ViewHolderBindView implements IBindView {
    private ViewHolder mViewHolder;

    @Override
    public void bindViews(View view) {
        mViewHolder = new ViewHolder(view);
    }

    @Override
    public void unbindView() {
        if (null != mViewHolder)
            mViewHolder.clear();
    }

    public ViewHolder getViewHolder() {
        return mViewHolder;
    }
}
