package com.orange.chat2piao.base.pull;

public interface IPullCallback {
    /**
     * 下拉刷新
     */
    void onPullRefresh();

    /**
     * 上拉加载
     */
    void onPullLoadMore();

    /**
     * 获取当前页数
     *
     * @return
     */
    int getCurPage();
}
