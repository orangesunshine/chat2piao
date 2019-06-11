package com.orange.chat2piao.base.toast;

import androidx.annotation.StringRes;

public interface IToast {
    /**
     * 吐司
     *
     * @param text 消息
     */
    void showToast(CharSequence text);

    void showToast(@StringRes int stringId);
}
