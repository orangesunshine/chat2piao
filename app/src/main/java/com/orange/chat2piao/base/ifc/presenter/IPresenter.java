package com.orange.chat2piao.base.ifc.presenter;

import com.orange.chat2piao.base.ifc.view.IView;

public interface IPresenter<V extends IView> {
    void attachView(IView view);
}
