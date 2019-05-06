package com.orange.chat2piao.base.ui.activity;

import android.content.Context;

import com.orange.chat2piao.base.ifc.presenter.IInitPresenter;
import com.orange.chat2piao.base.ifc.presenter.callback.IInit;

public abstract class InitActivity<P extends IInitPresenter> extends BaseActivity<P> implements IInit {

    @Override
    public void initViews(Context context) {

    }

    @Override
    public void initListener(Context context) {

    }
}
