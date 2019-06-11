package com.orange.chat2piao.ui.recyclerview;

public interface IConvertRecyclerView<T> {
    /**
     * 对外提供的方法
     */
    void convert(RecyclerViewHolder holder, T t, boolean selected);
}
