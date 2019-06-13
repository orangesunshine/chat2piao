package com.orange.chat2piao.base.reponse;

import com.orange.chat2piao.constant.IFinalConst;

import java.util.List;

public abstract class PullData<DATA, ITEM> extends BaseResponse<DATA> {

    /**
     * DATA转List<ITEM>
     *
     * @return
     */
    public abstract List<ITEM> getList();

    /**
     * 没有更多数据
     *
     * @return
     */
    public boolean noMoreData() {
        boolean noMoreData = true;
        List<ITEM> list = getList();
        if (null == list) return noMoreData;
        if (list.size() == IFinalConst.PULL_ITEM_COUNT)
            noMoreData = false;
        return noMoreData;
    }
}
