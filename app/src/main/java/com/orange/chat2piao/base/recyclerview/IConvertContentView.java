package com.orange.chat2piao.base.recyclerview;

public interface IConvertContentView<T> {
    /**
     * 对外提供的方法
     */
    void convert(ContentViewHolder holder, T t);
}
