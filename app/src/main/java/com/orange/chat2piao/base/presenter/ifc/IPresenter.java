package com.orange.chat2piao.base.presenter.ifc;

import com.orange.chat2piao.base.view.IView;

public interface IPresenter<V extends IView> {
    void attachView(V view);
}
