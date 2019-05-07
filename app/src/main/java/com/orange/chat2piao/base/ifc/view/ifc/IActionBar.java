package com.orange.chat2piao.base.ifc.view.ifc;

import androidx.annotation.IdRes;

public interface IActionBar {
    void setLeftImg(@IdRes int imgResId);

    void setLeftText(String leftText);

    void setTitle(String title);

    void setRightImg(@IdRes int imgResId);

    void setRightText(String rightText);
}
