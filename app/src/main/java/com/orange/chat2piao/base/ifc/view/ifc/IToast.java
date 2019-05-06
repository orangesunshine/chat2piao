package com.orange.chat2piao.base.ifc.view.ifc;

import androidx.annotation.StringRes;

public interface IToast {
    /**
     * 吐司
     *
     * @param msg
     */
    void showToast(String msg);

    void showToast(@StringRes int stringId);

    void showToast(String msg, int duration);
}
