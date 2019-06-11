package com.orange.chat2piao.base.presenter.ifc;

import com.orange.chat2piao.base.net.INetCallback;
import com.orange.chat2piao.base.net.pull.IPageNetRequest;

public interface IPullNetPresenter<T> extends INetCallback<T>, IPageNetRequest<T> {
}
