package com.orange.chat2piao.base.mvp.presenter;

import com.orange.chat2piao.base.mvp.presenter.ifc.IPresenter;
import com.orange.chat2piao.base.mvp.view.IView;

public class BasePresenter<V extends IView> implements IPresenter<V> {
    //vars
    protected V mView;

    @Override
    public void attachView(V view) {
        mView = view;
        initVars();
    }

    /**
     * 初始化变量
     */
    public void initVars() {
    }
}
