package com.orange.chat2piao.base.ifc.component;

import android.view.View;

public interface IHeaderNdFooter<H extends View,F extends View> extends IBindView{
    /**
     * 设置header
     * @param header
     */
    void header(H header);

    /**
     * 设置footer
     * @param footer
     */
    void footer(F footer);

    /**
     * 显示header
     */
    void showHeader();

    /**
     * 显示footer
     */
    void showFooter();

    /**
     * 隐藏header
     */
    void hideHeader();

    /**
     * 隐藏footer
     */
    void hideFooter();
}
