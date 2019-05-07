package com.orange.chat2piao.base.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.orange.chat2piao.base.ifc.presenter.IPresenter;
import com.orange.chat2piao.base.ifc.presenter.generate.IGeneratePresenter;
import com.orange.chat2piao.base.ifc.view.IView;

public abstract class PresenterActivity<V extends IView, P extends IPresenter<V>> extends NetActivity implements IGeneratePresenter<V, P> {
    //vars
    protected IPresenter<V> mPresenter;

    @Override
    public void onActivityCreate(Activity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        mPresenter = generatePresenter();
    }
}
