package com.orange.chat2piao.base.ifc.callback;

public interface IActionBarCallback {
    /**
     * 标题栏左侧事件
     */
    void onLeft();

    /**
     * 标题栏标题事件
     */
    void onCenter();

    /**
     * 标题栏右侧事件
     */
    void onRight();
}
