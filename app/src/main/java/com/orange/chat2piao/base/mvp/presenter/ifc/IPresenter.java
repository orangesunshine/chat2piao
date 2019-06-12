package com.orange.chat2piao.base.mvp.presenter.ifc;

import com.orange.chat2piao.base.mvp.view.IView;

public interface IPresenter<V extends IView> {
    void attachView(V view);
}
