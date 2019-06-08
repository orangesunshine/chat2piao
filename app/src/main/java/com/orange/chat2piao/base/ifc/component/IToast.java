package com.orange.chat2piao.base.ifc.component;

import androidx.annotation.StringRes;

public interface IToast {
    /**
     * 吐司
     *
     * @param msg 消息
     */
    void showToast(String msg);

    void showToast(@StringRes int stringId);

    void showToast(String msg, int duration);
}
