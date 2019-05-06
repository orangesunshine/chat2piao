package com.orange.chat2piao.base.ifc.view.ifc;

import android.app.Activity;

import butterknife.Unbinder;

public interface IBindView {
    /**
     * 绑定控件
     *
     * @param activity
     */
    void bindViews(Activity activity);

    void unbindView();
}
