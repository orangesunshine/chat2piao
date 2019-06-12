package com.orange.chat2piao.base.pull;

import android.view.View;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.common.holder.IHolder;
import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.base.mvp.model.net.callback.PullNetCallback;
import com.orange.chat2piao.base.mvp.model.net.pull.IPageNetRequest;

public abstract class AbstractPull<REFRESH extends View, F extends View> implements IPull, IPullCallback {
    protected REFRESH refreshLayout;
    protected F footer;
    protected IHolder mHolder;
    protected int pageIndex;//当前页下标
    protected IPageNetRequest mPageRequest;//网络请求（自带page参数）
    protected INetCallback mNetCallback;//网络结果回调

    public <T> AbstractPull(IHolder holder, IPageNetRequest<T> pageRequest) {
        mPageRequest = pageRequest;
        mNetCallback = new PullNetCallback<T>(this){
            @Override
            public void onSuccess(T data) {
                super.onSuccess(data);
                
            }
        };
        refreshLayout = holder.getView(R.id.refreshlayout);
        footer = holder.getView(R.id.refreshlayout_footer);
    }

    @Override
    public void refresh() {
    }

    @Override
    public void loadmore() {
    }

    @Override
    public void onRefresh() {
        pageIndex = 1;
        mPageRequest.request(pageIndex, mNetCallback);
    }

    @Override
    public void onLoadMore() {
        pageIndex++;
        mPageRequest.request(pageIndex, mNetCallback);
    }

    public int getCurPage() {
        return pageIndex;
    }
}
