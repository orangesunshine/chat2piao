package com.orange.chat2piao.base.ifc.call;

import android.app.Dialog;

public interface IDialogBind {
    /**
     * 绑定控件
     *
     * @param dialog
     */
    void bindViews(Dialog dialog);

    /**
     * 解绑
     */
    void unbindView();
}
