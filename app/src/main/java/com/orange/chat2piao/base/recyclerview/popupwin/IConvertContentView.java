package com.orange.chat2piao.base.recyclerview.popupwin;

import com.orange.chat2piao.base.recyclerview.ContentViewHolder;

public interface IConvertContentView<T> {
    /**
     * 对外提供的方法
     */
    void convert(ContentViewHolder holder, T t);
}
