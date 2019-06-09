package com.orange.chat2piao.base.ifc.callback.generate;

import com.orange.chat2piao.base.ifc.callback.IPullNetRequest;

public interface IBuildPullNetRequest<T> {
    IPullNetRequest<T> buildPullNetRequest();
}
