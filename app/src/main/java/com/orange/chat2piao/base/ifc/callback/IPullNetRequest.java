package com.orange.chat2piao.base.ifc.callback;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IPullNetRequest<T>{
    int TYPE_REFRESH = 0x001;
    int TYPE_LOADMORE = 0x002;

    void reqeust(@PullType int type, INetCallback<T> callback);

    int getCurPage();

    @IntDef({TYPE_REFRESH, TYPE_LOADMORE})
    @Retention(RetentionPolicy.SOURCE)
    @interface PullType {
    }
}
