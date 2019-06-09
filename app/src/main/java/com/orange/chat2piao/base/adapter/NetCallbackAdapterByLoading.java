package com.orange.chat2piao.base.adapter;

import android.os.SystemClock;

import com.blankj.utilcode.util.LogUtils;
import com.orange.chat2piao.base.ifc.callback.INetCallback;
import com.orange.chat2piao.base.ifc.component.ILoading;
import com.orange.chat2piao.utils.Preconditions;

public class NetCallbackAdapterByLoading<T> implements INetCallback<T> {
    private ILoading loading;
    private StringBuilder log = new StringBuilder();
    private String lineSeprrate = System.getProperty("line.separator");//换行
    private String indentation = "\u3000\u3000";//缩进
    private long startTimeMills = 0;

    public NetCallbackAdapterByLoading(ILoading loading) {
        this.loading = loading;
    }

    @Override
    public void onNetStart() {
        startTimeMills = SystemClock.elapsedRealtime();
        log.append("onNetStart: ").append(lineSeprrate);
        Preconditions.checkNotNull(loading);
        loading.showLoading();
    }

    @Override
    public void onSuccess(T t) {
        log.append("onSuccess: ");
        if (null != t)
            log.append(lineSeprrate).append(indentation).append(t.toString());
        log.append(lineSeprrate);
    }

    @Override
    public void onComplete() {
        log.append("onComplete: ");
        log.append(lineSeprrate).append(indentation).append("period: ").append(SystemClock.elapsedRealtime() - startTimeMills).append("ms");
        LogUtils.e(log.toString());
        Preconditions.checkNotNull(loading);
        loading.dismissLoading();
    }

    @Override
    public void onError(int code, Throwable error) {
        log.append("onError: ");
        log.append(lineSeprrate).append(indentation).append("code: ").append(code);

        Throwable cause = error.getCause();
        while (null != cause) {
            log.append(cause.getMessage());
            cause = cause.getCause();
        }
        log.append(lineSeprrate).append(indentation).append("errorMsg: ").append(lineSeprrate);
    }
}
