package com.orange.chat2piao.base.presenter;

import com.orange.chat2piao.base.presenter.ifc.ILoadingNetPresenter;
import com.orange.chat2piao.base.view.ILoadingNetView;

public abstract class LoadingNetPresenter<V extends ILoadingNetView, T> extends BasePresenter<V> implements ILoadingNetPresenter<T> {
}
