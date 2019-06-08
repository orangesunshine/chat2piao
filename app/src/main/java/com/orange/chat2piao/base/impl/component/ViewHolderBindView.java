package com.orange.chat2piao.base.impl.component;

import android.view.View;

import com.orange.chat2piao.base.ifc.component.IBindView;
import com.orange.chat2piao.base.ui.recyclerview.ContentViewHolder;

public class ViewHolderBindView implements IBindView {
    private ContentViewHolder mHolder;

    @Override
    public void bindViews(View view) {
        mHolder = new ContentViewHolder(view);
    }

    @Override
    public void unbindView() {
        if (null != mHolder)
            mHolder.clear();
    }

    public ContentViewHolder getViewHolder() {
        return mHolder;
    }
}
