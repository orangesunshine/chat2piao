package com.orange.chat2piao.base.ifc.callback;

public interface IPullCallback {
    /**
     * 刷新
     */
    void pullDown();

    /**
     * 加载更多
     */
    void pullUp();
}
