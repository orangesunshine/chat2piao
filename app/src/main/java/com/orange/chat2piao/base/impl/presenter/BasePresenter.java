package com.orange.chat2piao.base.impl.presenter;

import android.os.Bundle;

import com.orange.chat2piao.base.ifc.presenter.IPresenter;
import com.orange.chat2piao.base.ifc.callback.IActvityAlive;
import com.orange.chat2piao.base.ifc.callback.ICreatedNdDestroy;
import com.orange.chat2piao.base.ifc.view.IView;
import com.orange.chat2piao.base.ui.activity.PresenterActivity;

public class BasePresenter<A extends PresenterActivity, V extends IView> implements IActvityAlive, ICreatedNdDestroy<A>, IPresenter<V> {
    //vars
    protected A mActivity;
    protected V mView;

    @Override
    public boolean isActivityAlive() {
        return null != mActivity && mActivity.isActivityAlive();
    }

    @Override
    public void onActivityCreate(A activity, Bundle bundle) {
        mActivity = activity;
    }

    @Override
    public void onActivityDestroy(A context) {
        mActivity = null;
    }

    @Override
    public void attachView(V view) {
        mView = view;
    }
}
