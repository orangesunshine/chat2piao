package com.orange.chat2piao.base.pull;

public interface IPullCallback {
    void onRefresh();

    void onLoadMore();
}
