package com.orange.chat2piao.base.net;

import com.blankj.utilcode.util.LogUtils;
import com.orange.chat2piao.base.net.INetCallback;
import com.orange.chat2piao.base.pull.IRefreshNdLoadmore;

public class PullNetCallback<T> implements INetCallback<T> {
    private IRefreshNdLoadmore refreshNdLoadmore;
    private StringBuilder log = new StringBuilder();
    private String lineSeprrate = System.getProperty("line.separator");//换行
    private String indentation = "\u3000\u3000";//缩进

    public PullNetCallback(IRefreshNdLoadmore refreshNdLoadmore) {
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
    public void onComplete(boolean noData) {
        log.append("onComplete: ");
        LogUtils.e(log.toString());
        if (null != refreshNdLoadmore) {
            refreshNdLoadmore.finishRefresh(noData);
            refreshNdLoadmore.finishLoadmore(noData);
        }
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
