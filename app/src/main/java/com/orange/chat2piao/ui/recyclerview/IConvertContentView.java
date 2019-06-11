package com.orange.chat2piao.ui.recyclerview;

import com.orange.chat2piao.base.common.holder.IHolder;

public interface IConvertContentView<T> {
    /**
     * 对外提供的方法
     */
    void convert(IHolder holder, T t);
}
