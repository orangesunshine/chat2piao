package com.orange.chat2piao.base.ifc.generate;

import com.orange.chat2piao.base.ifc.callback.IPullNetCallback;

public interface IBuildPullNetCallback<T> {
    IPullNetCallback<T> buildPullNetCallback();
}
