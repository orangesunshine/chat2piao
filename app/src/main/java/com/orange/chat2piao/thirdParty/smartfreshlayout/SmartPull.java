package com.orange.chat2piao.thirdParty.smartfreshlayout;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.common.IPullConvert;
import com.orange.chat2piao.base.common.holder.IHolder;
import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.base.mvp.model.net.callback.PullNetCallback;
import com.orange.chat2piao.base.mvp.model.net.pull.IPageNetRequest;
import com.orange.chat2piao.base.pull.AbstractPull;
import com.orange.chat2piao.base.pull.IPull;
import com.orange.chat2piao.base.reponse.PullData;
import com.orange.chat2piao.ui.recyclerview.CommonAdapter;
import com.orange.chat2piao.ui.recyclerview.IConvertRecyclerView;
import com.orange.chat2piao.utils.NetUtils;
import com.orange.chat2piao.utils.Preconditions;
import com.orange.chat2piao.utils.ReflectionUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class SmartPull extends AbstractPull<SmartRefreshLayout> implements IPull {

    /**
     * recyclerview 处理网络返回数据
     *
     * @param context
     * @param itemLayoutId
     * @param holder
     * @param pageNetRequest
     * @param convertRecyclerView
     */
    public <T> SmartPull(Context context, int itemLayoutId, IHolder holder, CommonAdapter.IEmptyCallback emptyCallback, IPageNetRequest<T> pageNetRequest, IConvertRecyclerView convertRecyclerView) {
        super(holder, pageNetRequest);
        RecyclerView recyclerView = holder.getView(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        Preconditions.checkNotNull(recyclerView, "null == recyclerView，该构造方法仅用于recycleview");
        Type type = ReflectionUtils.pageNetRequestGenericType(pageNetRequest);

        refreshloadmoreListener(type, pageNetRequest, new PullNetCallback<T>(this) {
            @Override
            public void onSuccess(T data) {
                super.onSuccess(data);
                List datas = null;
                if (null != data && data instanceof PullData) {
                    datas = ((PullData) data).getList();
                    CommonAdapter.newInstance(context, recyclerView, itemLayoutId, datas, mPageIndex > 1, convertRecyclerView);
                    Object tag = recyclerView.getTag();
                    if (null != tag && tag instanceof CommonAdapter) {
                        ((CommonAdapter) tag).setEmptyCallback(emptyCallback);
                    }
                }
            }
        });
        setListener();
    }

    private RefreshLayout refreshloadmoreListener(Type type, IPageNetRequest pageNetRequest, INetCallback netCallback) {
        Preconditions.checkNotNull(refreshLayout);
        return refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                Preconditions.checkNotNull(pageNetRequest, netCallback);
                mPageIndex = 1;
                pageNetRequest.request(mPageIndex, type, netCallback);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Preconditions.checkNotNull(pageNetRequest, netCallback);
                mPageIndex++;
                pageNetRequest.request(mPageIndex, type, netCallback);
            }
        });
    }

    /**
     * recyclerview 处理网络返回数据
     *
     * @param context
     * @param itemLayoutId
     * @param holder
     * @param pageRequest
     * @param convertRecyclerView
     */
    public <T> SmartPull(Context context, int itemLayoutId, IHolder holder, IPageNetRequest<T> pageRequest, IConvertRecyclerView convertRecyclerView) {
        super(holder, pageRequest);
        RecyclerView recyclerView = holder.getView(R.id.recyclerview);
        RecyclerView emptyView = holder.getView(R.id.empty_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        Preconditions.checkNotNull(recyclerView, "null == recyclerView，该构造方法仅用于recycleview");
        if (null != pageRequest) {
            Type[] genericInterfaces = pageRequest.getClass().getGenericInterfaces();
            Type genericInterface = genericInterfaces[0];
            mType = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
        }
        mNetCallback = new PullNetCallback<T>(this) {
            @Override
            public void onSuccess(T data) {
                super.onSuccess(data);
                List datas = null;
                if (null != data && data instanceof PullData) {
                    datas = ((PullData) data).getList();
                    CommonAdapter.newInstance(context, recyclerView, emptyView, itemLayoutId, datas, mPageIndex > 1, convertRecyclerView);
                }
            }
        };
        setListener();
    }

    /**
     * 自定义处理返回数据
     *
     * @param holder
     * @param pageRequest
     */
    public <T> SmartPull(IHolder holder, IPageNetRequest<T> pageRequest, IPullConvert<T> pullConvert, CommonAdapter.IEmptyCallback emptyCallback) {
        super(holder, pageRequest);
        if (null != pageRequest) {
            Type[] genericInterfaces = pageRequest.getClass().getGenericInterfaces();
            Type genericInterface = genericInterfaces[0];
            mType = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
        }
        mNetCallback = new PullNetCallback<T>(this) {
            @Override
            public void onSuccess(T data) {
                super.onSuccess(data);
                if (null != pullConvert) pullConvert.convert(data, mPageIndex > 1);
            }

            @Override
            public void onComplete(boolean noData, boolean empty) {
                super.onComplete(noData, empty);
                if (null != emptyCallback)
                    emptyCallback.empty(empty);
            }
        };
        setListener();
    }

    private void setListener() {
        if (null != refreshLayout) {
            refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    onPullLoadMore();
                }

                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    onPullRefresh();
                }
            });
        }
    }

    @Override
    public void refresh() {
        if (null != refreshLayout) {
            refreshLayout.resetNoMoreData();
            refreshLayout.autoRefresh();
        }
    }

    @Override
    public void loadmore() {
        if (null != refreshLayout)
            refreshLayout.autoLoadMore();
    }

    @Override
    public void finishRefresh(boolean noData) {
        if (null != refreshLayout) {
            if (noData) {
                refreshLayout.finishRefreshWithNoMoreData();
            } else {
                refreshLayout.finishRefresh();
            }
        }
    }

    @Override
    public void finishLoadmore(boolean noData) {
        if (null != refreshLayout) {
            if (noData) {
                refreshLayout.finishLoadMoreWithNoMoreData();
            } else {
                refreshLayout.finishLoadMore();
            }
        }
    }

    /**
     * 设置能否加载
     *
     * @param enable
     * @return
     */
    @Override
    public void enableLoadMore(boolean enable) {
        if (null != refreshLayout)
            refreshLayout.setEnableLoadMore(enable);
    }
}
