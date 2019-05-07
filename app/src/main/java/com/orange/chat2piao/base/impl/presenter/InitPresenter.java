package com.orange.chat2piao.base.impl.presenter;

import android.app.Activity;
import android.os.Bundle;

import com.orange.chat2piao.base.ifc.presenter.callback.IInitVars;

public class InitPresenter extends BasePresenter implements IInitVars {

    @Override
    public void onActivityCreate(Activity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        initVars(bundle);
    }

    @Override
    public void initVars(Bundle saveInstance) {

    }
}
