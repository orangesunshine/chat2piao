package com.orange.chat2piao.base.impl.presenter;

import android.app.Activity;
import android.os.Bundle;

import com.orange.chat2piao.base.ifc.presenter.callback.IActivityCreatedNdDestroyCallback;
import com.orange.chat2piao.base.ifc.presenter.callback.IActvityAlive;

public class BasePresenter implements IActvityAlive, IActivityCreatedNdDestroyCallback {
    //vars
    protected boolean isActivityAlive;
    protected Activity mActivity;

    @Override
    public void onActivityCreate(Activity activity, Bundle bundle) {
        isActivityAlive = true;
        mActivity = activity;
    }

    @Override
    public void onActivityDestroy(Activity activity) {
        isActivityAlive = false;
        mActivity = null;
    }

    @Override
    public boolean isActivityAlive() {
        return null != mActivity && isActivityAlive;
    }
}
