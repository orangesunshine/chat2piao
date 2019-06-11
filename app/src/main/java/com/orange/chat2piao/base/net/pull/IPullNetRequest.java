package com.orange.chat2piao.base.net.pull;

import androidx.annotation.IntDef;

import com.orange.chat2piao.base.net.INetCallback;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IPullNetRequest<T> extends IPageNetRequest<T> {
    int TYPE_REFRESH = 0x001;
    int TYPE_LOADMORE = 0x002;

    /**
     * 下拉，加载请求网络
     *
     * @param type
     * @param callback
     */
    void pullReqeust(@PullType int type, INetCallback<T> callback);

    @IntDef({TYPE_REFRESH, TYPE_LOADMORE})
    @Retention(RetentionPolicy.SOURCE)
    @interface PullType {
    }
}
