package com.orange.chat2piao.base.ui.recyclerview;

import com.orange.chat2piao.base.ifc.component.IHolder;

public interface IConvertContentView<T> {
    /**
     * 对外提供的方法
     */
    void convert(IHolder holder, T t);
}
