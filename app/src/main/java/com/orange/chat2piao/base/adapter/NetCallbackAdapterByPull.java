package com.orange.chat2piao.base.adapter;

import com.blankj.utilcode.util.LogUtils;
import com.orange.chat2piao.base.ifc.callback.INetCallback;
import com.orange.chat2piao.base.ifc.callback.IPullCallback;
import com.orange.chat2piao.base.ifc.callback.IPullNetRequest;
import com.orange.chat2piao.base.ifc.component.ILoading;
import com.orange.chat2piao.base.ifc.component.IRefreshNdLoadmore;
import com.orange.chat2piao.base.ifc.view.IPullView;
import com.orange.chat2piao.utils.Preconditions;

public class NetCallbackAdapterByPull<T> implements INetCallback<T> {
    private IRefreshNdLoadmore refreshNdLoadmore;
    private StringBuilder log = new StringBuilder();
    private String lineSeprrate = System.getProperty("line.separator");//换行
    private String indentation = "\u3000\u3000";//缩进

    public NetCallbackAdapterByPull(IRefreshNdLoadmore refreshNdLoadmore) {
        this.refreshNdLoadmore = refreshNdLoadmore;
    }

    @Override
    public void onNetStart() {
        log.append("onNetStart: ");
        log.append(lineSeprrate);
    }

    @Override
    public void onSuccess(T t) {
        log.append("onSuccess: ");
        if (null != t) {
            log.append(indentation);
            log.append(t.toString());
        }
        log.append(lineSeprrate);
    }

    @Override
    public void onComplete() {
        log.append("onComplete: ");
        LogUtils.e(log.toString());
        Preconditions.checkNotNull(refreshNdLoadmore, "null == refreshNdLoadmore");
        refreshNdLoadmore.finishRefresh();
        refreshNdLoadmore.finishLoadmore();
    }

    @Override
    public void onError(int code, Throwable error) {
        log.append("onError: ");
        log.append(indentation);
        log.append("code: ");
        log.append(code);
        log.append(indentation);
        log.append("errorMsg: ");
        Throwable cause = error.getCause();
        while (null != cause) {
            log.append(cause.getMessage());
            cause = cause.getCause();
        }
        log.append(lineSeprrate);
    }
}
