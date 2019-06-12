package com.orange.chat2piao.base.mvp.model.net.callback;

import android.os.SystemClock;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.orange.chat2piao.base.pull.IPull;
import com.orange.chat2piao.constant.IInitConst;

import static com.orange.chat2piao.constant.IFinalConst.LINE_SEPARATOR;

public class PullNetCallback<T> implements INetCallback<T> {
    private IPull refreshNdLoadmore;
    private StringBuilder log = new StringBuilder();
    private String indentation = "\u3000\u3000";//缩进
    private long startTimeMills = 0;

    public PullNetCallback(IPull refreshNdLoadmore) {
        this.refreshNdLoadmore = refreshNdLoadmore;
    }

    @Override
    public void onNetStart() {
        if (IInitConst.sRecordNetLogSwitch) {
            log.append("onNetStart: ").append(LINE_SEPARATOR);
            startTimeMills = SystemClock.elapsedRealtime();
        }
    }

    @Override
    public void onSuccess(T t) {
        if (IInitConst.sRecordNetLogSwitch) {
            log.append("onSuccess: ");
            if (null != t) {
                log.append(LINE_SEPARATOR).append(indentation).append(t.toString());
            }
            log.append(LINE_SEPARATOR);
        }
    }

    @Override
    public void onComplete(boolean noData) {
        if (null != refreshNdLoadmore) {
            refreshNdLoadmore.finishRefresh(noData);
            refreshNdLoadmore.finishLoadmore(noData);
        }
        if (IInitConst.sRecordNetLogSwitch) {
            log.append("onComplete: ");
            log.append(LINE_SEPARATOR).append(indentation).append("period: ").append(SystemClock.elapsedRealtime() - startTimeMills).append("ms");
            LogUtils.e(log.toString());
        }
    }

    @Override
    public void onError(int code, Throwable error) {
        if (IInitConst.sRecordNetLogSwitch) {
            log.append("onError: ").append(indentation).append("code: ").append(code).append(indentation).append("errorMsg: ");
            StringBuilder errorMsg = new StringBuilder();
            if (null != error) {
                errorMsg.append(error.getMessage());
                Throwable cause = error.getCause();
                while (null != cause) {
                    errorMsg.append(cause.getMessage());
                    cause = cause.getCause();
                }
                if (errorMsg.length() > 0)
                    ToastUtils.showShort(errorMsg);
            }
            log.append(errorMsg).append(LINE_SEPARATOR);
        }
    }
}
