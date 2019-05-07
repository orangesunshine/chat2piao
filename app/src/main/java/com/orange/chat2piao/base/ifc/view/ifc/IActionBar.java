package com.orange.chat2piao.base.ifc.view.ifc;

import android.view.ViewGroup;

import com.orange.chat2piao.base.ifc.listener.IActionBarCallback;

import androidx.annotation.DrawableRes;

public interface IActionBar<T extends ViewGroup> extends IBindView {
    void setLeftImg(@DrawableRes int imgResId);

    void setLeftText(String leftText);

    void setTitle(String title);

    void setRightImg(@DrawableRes int imgResId);

    void setRightText(String rightText);

    void setActionBarCallback(IActionBarCallback actionBarCallback);
}
