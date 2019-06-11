package com.orange.chat2piao.base.impl.presenter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.orange.chat2piao.base.ifc.callback.IListAdapterCallback;
import com.orange.chat2piao.base.ifc.callback.IPullNetCallback;
import com.orange.chat2piao.base.ifc.callback.IRecyclerViewPullDataCallback;
import com.orange.chat2piao.base.ifc.generate.IBuildRecyclerViewPullDataCallback;
import com.orange.chat2piao.base.ifc.net.IPullNetRequest;
import com.orange.chat2piao.base.ifc.view.IPullView;
import com.orange.chat2piao.base.impl.callback.PullNetCallback;
import com.orange.chat2piao.base.impl.callback.RecyclerViewPullDataCallbackImpl;
import com.orange.chat2piao.base.impl.net.PullNetRequestImpl;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;
import com.orange.chat2piao.base.ui.recyclerview.CommonAdapter;
import com.orange.chat2piao.base.ui.recyclerview.IConvertRecyclerView;

import static com.orange.chat2piao.base.ifc.net.IPullNetRequest.TYPE_LOADMORE;
import static com.orange.chat2piao.base.ifc.net.IPullNetRequest.TYPE_REFRESH;

public abstract class RecyclerViewPullNetPresenter<V extends IPullView, T> extends PullNetPresenter<V, T> implements IBuildRecyclerViewPullDataCallback, IRecyclerViewPullDataCallback {
    protected IPullNetCallback<T> mPullNetCallback;
    protected IPullNetRequest<T> mPullNetRequest;
    protected CommonAdapter<T> mCommonAdapter;
    protected IRecyclerViewPullDataCallback mIRecyclerViewPullDataCallback;

    /**
     * 初始化变量
     *
     * @param activity
     * @param saveInstance
     */
    @Override
    public void initVars(BaseActivity activity, Bundle saveInstance) {
        super.initVars(activity, saveInstance);
        mIRecyclerViewPullDataCallback = buildRecyclerViewPullDataCallback();
    }

    @Override
    public void onActivityCreate(BaseActivity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
    }

    /**
     * 网络请求开始
     */
    @Override
    public void onNetStart() {
        if (null != mPullNetCallback)
            mPullNetCallback.onNetStart();
    }

    /**
     * 成功
     *
     * @param t
     */
    @Override
    public void onSuccess(T t) {
        if (null != mPullNetCallback)
            mPullNetCallback.onSuccess(t);
        if (null == mIRecyclerViewPullDataCallback)
            mIRecyclerViewPullDataCallback = new RecyclerViewPullDataCallbackImpl();
        mIRecyclerViewPullDataCallback.adapterRecyclerViewPullData(mActivity, null, null, mCommonAdapter, 1, false, t, null, null);
    }

    /**
     * 完成
     */
    @Override
    public void onComplete(boolean noData) {
        if (null != mPullNetCallback)
            mPullNetCallback.onComplete(noData);
    }

    /**
     * 失败
     *
     * @param code
     * @param error
     */
    @Override
    public void onError(int code, Throwable error) {
        if (null != mPullNetCallback)
            mPullNetCallback.onError(code, error);
    }

    /**
     * 刷新
     */
    @Override
    public void onRefresh() {
        if (null != mPullNetRequest)
            mPullNetRequest.pullReqeust(TYPE_REFRESH, mPullNetCallback);
    }

    /**
     * 加载更多
     */
    @Override
    public void onLoadmore() {
        if (null != mPullNetRequest)
            mPullNetRequest.pullReqeust(TYPE_LOADMORE, mPullNetCallback);
    }

    @Override
    public IPullNetCallback<T> buildPullNetCallback() {
        return new PullNetCallback<T>(mView);
    }

    @Override
    public IPullNetRequest<T> buildPullNetRequest() {
        return new PullNetRequestImpl<>();
    }

    @Override
    public <DATA, ITEM> CommonAdapter<ITEM> adapterRecyclerViewPullData(Context context, RecyclerView rv, View empty, CommonAdapter<ITEM> adapter, int layout, boolean loadmore, DATA data, IListAdapterCallback<DATA, ITEM> listAdapterCallback, IConvertRecyclerView<ITEM> convertViewHolder) {
        return null;
    }

    @Override
    public IRecyclerViewPullDataCallback buildRecyclerViewPullDataCallback() {
        return new RecyclerViewPullDataCallbackImpl();
    }
}
