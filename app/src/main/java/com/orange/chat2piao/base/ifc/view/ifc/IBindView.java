package com.orange.chat2piao.base.ifc.view.ifc;

import android.view.View;

public interface IBindView {
    /**
     * 绑定控件
     *
     * @param view
     */
    void bindViews(View view);

    void unbindView();
}
