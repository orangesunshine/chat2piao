package com.orange.chat2piao.base.pull;

public class PullAdapter implements IPull {
    protected IPull mPull;

    /**
     * 刷新
     */
    @Override
    public void refresh() {
        if (null != mPull)
            mPull.refresh();
    }

    /**
     * 加载
     */
    @Override
    public void loadmore() {
        if (null != mPull)
            mPull.loadmore();
    }

    /**
     * 刷新完成
     *
     * @param noData
     */
    @Override
    public void finishRefresh(boolean noData) {
        if (null != mPull)
            mPull.finishRefresh(noData);
    }

    /**
     * 加载完成
     *
     * @param noData
     */
    @Override
    public void finishLoadmore(boolean noData) {
        if (null != mPull)
            mPull.finishLoadmore(noData);
    }

    /**
     * 设置能否加载
     *
     * @param enable
     * @return
     */
    @Override
    public void enableLoadMore(boolean enable) {
        if (null != mPull)
            mPull.enableLoadMore(enable);
    }
}
