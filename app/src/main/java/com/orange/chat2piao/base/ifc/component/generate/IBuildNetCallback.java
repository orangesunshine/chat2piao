package com.orange.chat2piao.base.ifc.component.generate;

import com.orange.chat2piao.base.ifc.callback.INetCallback;

public interface IBuildNetCallback<T> {
    INetCallback<T> buildNetCallback();
}
