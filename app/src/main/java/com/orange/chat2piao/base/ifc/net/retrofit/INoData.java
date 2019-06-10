package com.orange.chat2piao.base.ifc.net.retrofit;

public interface INoData {
    /**
     * 判断返回data列表是不是有没有更多数据
     *
     * @param data
     * @param <T>
     * @return
     */
    <T> boolean noData(T data);
}
