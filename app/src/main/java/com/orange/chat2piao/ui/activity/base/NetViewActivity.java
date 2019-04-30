package com.orange.chat2piao.ui.activity.base;

import android.os.Bundle;

import com.orange.chat2piao.abstractor.ifc.ILoading;
import com.orange.chat2piao.abstractor.ifc.ILoadingDialogFragment;
import com.orange.chat2piao.abstractor.ifc.net.INetCallback;
import com.orange.chat2piao.abstractor.impl.GlobleImp;

public abstract class NetViewActivity<T> extends BuzViewActivity implements INetCallback<T>, ILoading {
    protected ILoadingDialogFragment mILoadingDialog;

    @Override
    public void initVars(Bundle saveInstance) {
        super.initVars(saveInstance);
        mILoadingDialog = GlobleImp.getInstance().getLoadingDialog();
    }

    @Override
    public void showLoading() {
        if (null != mILoadingDialog && null != mActivity && !mActivity.isFinishing())
            mILoadingDialog.showLoading(mActivity.getSupportFragmentManager());
    }

    @Override
    public void dismissLoading() {

    }
}
