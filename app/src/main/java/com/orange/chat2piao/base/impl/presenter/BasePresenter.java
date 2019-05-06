package com.orange.chat2piao.base.impl.presenter;

import android.app.Activity;

import com.orange.chat2piao.base.ifc.presenter.IBasePresenter;
import com.orange.chat2piao.base.ifc.view.IBaseView;

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter {
    //views
    protected V mView;

    //vars
    protected boolean isActivityAlive;

    public BasePresenter(V view) {
        mView = view;
    }

    @Override
    public void onActivityCreate(Activity activity) {
        isActivityAlive = true;
    }

    @Override
    public void onActivityDestroy(Activity activity) {
        isActivityAlive = false;
    }

    @Override
    public boolean isActivityAlive() {
        return isActivityAlive;
    }
}
