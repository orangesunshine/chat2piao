package com.orange.chat2piao.base.ifc.component;

import android.view.ViewGroup;

import com.orange.chat2piao.base.ifc.callback.IActionBarCallback;

import androidx.annotation.DrawableRes;

public interface IActionBar<T extends ViewGroup>{
    /**
     * 设置左侧图标
     *
     * @param imgResId
     */
    void setLeftImg(@DrawableRes int imgResId);

    void setLeftText(String leftText);

    void setTitle(String title);

    /**
     * 设置右侧图标
     *
     * @param imgResId
     */
    void setRightImg(@DrawableRes int imgResId);

    void setRightText(String rightText);

    /**
     * 标题栏事件回调
     *
     * @param actionBarCallback
     */
    void setActionBarCallback(IActionBarCallback actionBarCallback);
}
