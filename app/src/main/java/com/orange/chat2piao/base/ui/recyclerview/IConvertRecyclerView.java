package com.orange.chat2piao.base.ui.recyclerview;

public interface IConvertRecyclerView<T> {
    /**
     * 对外提供的方法
     */
    void convert(CommonViewHolder holder, T t, boolean selected);
}
