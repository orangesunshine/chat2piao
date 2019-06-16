package com.orange.chat2piao.base.reponse;

import com.orange.chat2piao.constant.IFinalConst;

import java.util.List;

public interface PullData<ITEM> {

    /**
     * DATA转List<ITEM>
     *
     * @return
     */
    List<ITEM> getList();

    /**
     * 没有更多数据
     *
     * @return
     */
    default boolean noMoreData() {
        boolean noMoreData = true;
        List<ITEM> list = getList();
        if (null == list) return noMoreData;
        if (list.size() > IFinalConst.PULL_ITEM_COUNT)
            noMoreData = false;
        return noMoreData;
    }

    /**
     * 没有更多数据
     *
     * @return
     */
    default boolean empty() {
        return null == getList() || getList().isEmpty();
    }
}
