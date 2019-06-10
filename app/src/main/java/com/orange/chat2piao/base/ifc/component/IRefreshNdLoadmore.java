package com.orange.chat2piao.base.ifc.component;

public interface IRefreshNdLoadmore {

    /**
     * 刷新
     */
    void refresh();

    /**
     * 加载
     */
    void loadmore();

    /**
     * 刷新完成
     */
    void finishRefresh(boolean noData);

    /**
     * 加载完成
     */
    void finishLoadmore(boolean noData);
}
