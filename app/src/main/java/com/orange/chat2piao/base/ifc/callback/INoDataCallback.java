package com.orange.chat2piao.base.ifc.callback;

public interface INoDataCallback<T> {
    /**
     * 判断返回data列表是不是有没有更多数据
     *
     * @param data
     * @param <T>
     * @return
     */
    boolean noData(T data);
}
