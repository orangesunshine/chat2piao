package com.orange.chat2piao.base.pull;

public interface IPull {

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

    /**
     * 设置能否加载
     *
     * @param enable
     * @return
     */
    void enableLoadMore(boolean enable);
}
