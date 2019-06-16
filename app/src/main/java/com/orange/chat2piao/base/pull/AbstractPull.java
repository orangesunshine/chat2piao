package com.orange.chat2piao.base.pull;

import android.view.View;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.common.holder.IHolder;
import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.base.mvp.model.net.pull.IPageNetRequest;
import com.orange.chat2piao.utils.Preconditions;

import java.lang.reflect.Type;

public class AbstractPull<REFRESH extends View> implements IPullCallback {
    protected Type mType;
    protected int mPageIndex;
    protected REFRESH refreshLayout;
    protected INetCallback mNetCallback;
    protected IPageNetRequest mPageNetRequest;

    public <T> AbstractPull(IHolder holder, IPageNetRequest<T> pageRequest) {
        refreshLayout = holder.getView(R.id.refreshlayout);
        mPageNetRequest = pageRequest;
    }

    public <T> AbstractPull(REFRESH refreshLayout, IPageNetRequest<T> pageRequest) {
        this.refreshLayout = refreshLayout;
        mPageNetRequest = pageRequest;
    }


    /**
     * 下拉刷新
     */
    @Override
    public void onPullRefresh() {
        Preconditions.checkNotNull(mPageNetRequest, mNetCallback);
        mPageIndex = 1;
        mPageNetRequest.request(mPageIndex, mType, mNetCallback);
    }

    /**
     * 上拉加载
     */
    @Override
    public void onPullLoadMore() {
        Preconditions.checkNotNull(mPageNetRequest, mNetCallback);
        mPageIndex++;
        mPageNetRequest.request(mPageIndex, mType, mNetCallback);
    }

    /**
     * 获取当前页数
     *
     * @return
     */
    @Override
    public int getCurPage() {
        return mPageIndex;
    }
}
