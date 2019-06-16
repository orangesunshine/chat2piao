package com.orange.chat2piao.base.common;

public interface IPullConvert<T> {
    void convert(T data, boolean loadmore);
}
