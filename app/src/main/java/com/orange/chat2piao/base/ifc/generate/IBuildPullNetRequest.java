package com.orange.chat2piao.base.ifc.generate;

import com.orange.chat2piao.base.ifc.net.IPullNetRequest;

public interface IBuildPullNetRequest<T> {
    IPullNetRequest<T> buildPullNetRequest();
}
