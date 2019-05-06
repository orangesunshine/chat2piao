package com.orange.chat2piao.base.impl.presenter;

import android.os.Bundle;

import com.orange.chat2piao.base.ifc.presenter.IInitPresenter;
import com.orange.chat2piao.base.ifc.presenter.callback.IInit;

public abstract class InitPresenter<V extends IInit> extends BasePresenter<V> implements IInitPresenter {

    public InitPresenter(V view) {
        super(view);
    }

    @Override
    public void initVars(Bundle saveInstance) {

    }
}
