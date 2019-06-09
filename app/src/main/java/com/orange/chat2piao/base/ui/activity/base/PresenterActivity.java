package com.orange.chat2piao.base.ui.activity.base;

import android.os.Bundle;

import com.orange.chat2piao.base.ifc.presenter.IGeneratePresenter;
import com.orange.chat2piao.base.ifc.view.IView;
import com.orange.chat2piao.base.impl.presenter.BasePresenter;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;

public abstract class PresenterActivity<P extends BasePresenter> extends BaseActivity implements IGeneratePresenter<P>, IView {
    // <editor-fold defaultstate="collapsed" desc="presenter">
    //vars
    protected P mPresenter;

    @Override
    public void onActivityCreate(BaseActivity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        if (null != mPresenter)
            mPresenter.attachView(this);
    }

    @Override
    public void initVars(Bundle bundle) {
        super.initVars(bundle);
        mPresenter = generatePresenter();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="吐司方法">
    @Override
    public void showToast(CharSequence text) {
        if(null != mToast)
            mToast.showToast(text);
    }

    @Override
    public void showToast(int stringId) {
        if(null != mToast)
            mToast.showToast(stringId);
    }
    // </editor-fold>
}
