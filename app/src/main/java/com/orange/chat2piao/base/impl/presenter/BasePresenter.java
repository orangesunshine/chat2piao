package com.orange.chat2piao.base.impl.presenter;

import android.os.Bundle;

import com.orange.chat2piao.base.ifc.presenter.IPresenter;
import com.orange.chat2piao.base.ifc.view.IView;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;

public class BasePresenter<V extends IView> implements IPresenter<V> {
    //vars
    protected BaseActivity mActivity;
    protected V mView;

    @Override
    public boolean isActivityAlive() {
        return null != mActivity && mActivity.isActivityAlive();
    }


    @Override
    public void onActivityCreate(BaseActivity activity, Bundle bundle) {
        mActivity = activity;
    }

    @Override
    public void onActivityDestroy(BaseActivity context) {
        mActivity = null;
    }

    @Override
    public void attachView(V view) {
        mView = view;
    }
}
