package com.orange.chat2piao.base.ifc.view.ifc;

import android.view.View;

public interface IHeaderNdFooter<H extends View,F extends View> extends IBindView{
    //设置header
    void header(H header);

    //设置footer
    void footer(F footer);

    //显示header
    void showHeader();

    //显示footer
    void showFooter();

    void hideHeader();

    void hideFooter();
}
