package com.orange.chat2piao.base.ifc.generate;

import com.orange.chat2piao.base.ifc.call.ILoading;
import com.orange.chat2piao.base.ifc.callback.ILoadingNetCallback;

public interface IBuildLoadingNetCallback<T> {
    ILoadingNetCallback<T> buildLoadingNetCallback(ILoading loading);
}
