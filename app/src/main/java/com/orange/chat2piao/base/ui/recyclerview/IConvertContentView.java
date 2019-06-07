package com.orange.chat2piao.base.ui.recyclerview;

public interface IConvertContentView<T> {
    /**
     * 对外提供的方法
     */
    void convert(ContentViewHolder holder, T t);
}
