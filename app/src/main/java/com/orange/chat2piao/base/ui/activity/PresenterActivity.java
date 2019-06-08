package com.orange.chat2piao.base.ui.activity;

import android.os.Bundle;

import com.orange.chat2piao.base.ifc.presenter.generate.IGeneratePresenter;
import com.orange.chat2piao.base.ifc.view.IView;
import com.orange.chat2piao.base.impl.presenter.BasePresenter;

public abstract class PresenterActivity<A extends PresenterActivity, P extends BasePresenter<A, A>> extends BaseActivity<A> implements IGeneratePresenter<A, P>, IView {
    //vars
    protected P mPresenter;

    @Override
    public void onActivityCreate(A activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        mPresenter = generatePresenter();
        if (null != mPresenter)
            mPresenter.attachView(activity);
    }
}
