package com.orange.chat2piao.base.impl.presenter;

import android.os.Bundle;
import android.view.View;

import com.orange.chat2piao.base.ifc.call.activity.IInitVars;
import com.orange.chat2piao.base.ifc.presenter.IPresenter;
import com.orange.chat2piao.base.ifc.view.IView;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;

public class BasePresenter<V extends IView> implements IPresenter<V>, IInitVars {
    //vars
    protected BaseActivity mActivity;
    protected V mView;

    @Override
    public boolean isActivityAlive() {
        return null != mActivity && mActivity.isActivityAlive();
    }


    @Override
    public void onActivityCreate(BaseActivity activity, Bundle bundle) {
        initVars(activity, bundle);
    }

    @Override
    public void onActivityDestroy(BaseActivity context) {
        mActivity = null;
    }

    @Override
    public void attachView(V view) {
        mView = view;
    }

    /**
     * 初始化变量
     *
     * @param activity
     * @param saveInstance
     */
    @Override
    public void initVars(BaseActivity activity, Bundle saveInstance) {
    }
}
