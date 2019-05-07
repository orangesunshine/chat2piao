package com.orange.chat2piao.base.ui.activity;

import android.content.Context;

import com.orange.chat2piao.base.ifc.presenter.callback.IInit;
import com.orange.chat2piao.base.impl.presenter.InitPresenter;

public abstract class InitActivity<P extends InitPresenter> extends BaseActivity<P> implements IInit {

    @Override
    public void initViews(Context context) {

    }

    @Override
    public void initListener(Context context) {

    }
}
