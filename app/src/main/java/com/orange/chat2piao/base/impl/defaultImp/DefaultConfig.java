package com.orange.chat2piao.base.impl.defaultImp;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.orange.chat2piao.base.adapter.ActivityLifecycleAdapt;
import com.orange.chat2piao.base.ifc.app.IBuildActivityLifecycleCallbacks;
import com.orange.chat2piao.base.ifc.presenter.callback.IActivityCreatedNdDestroyCallback;
import com.orange.chat2piao.base.ifc.view.ifc.IBindView;
import com.orange.chat2piao.base.ifc.view.ifc.ILoadingDialogFragment;
import com.orange.chat2piao.base.ifc.view.ifc.IPullDownUp;
import com.orange.chat2piao.base.ifc.view.ifc.IStatusBar;
import com.orange.chat2piao.base.ifc.view.ifc.IToast;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildBindView;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildLoadDialogFragment;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildPullDownUp;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildStatusBar;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildToast;
import com.orange.chat2piao.base.impl.app.ActivityLifecycleCallbacksImp;
import com.orange.chat2piao.base.impl.view.ButterKnifeBindView;
import com.orange.chat2piao.base.impl.view.StatusBarTranslucent;
import com.orange.chat2piao.base.impl.view.ToastHelper;
import com.orange.chat2piao.base.ui.dialog.LoadingDialog;

public class DefaultConfig extends ActivityLifecycleAdapt implements IBuildStatusBar, IBuildBindView, IBuildToast, IBuildLoadDialogFragment, IBuildPullDownUp, IBuildActivityLifecycleCallbacks {
    private static volatile DefaultConfig sInstance;

    private DefaultConfig() {
    }

    public static DefaultConfig getInstance() {
        if (null == sInstance) {
            synchronized (DefaultConfig.class) {
                if (null == sInstance) {
                    sInstance = new DefaultConfig();
                }
            }
        }
        return sInstance;
    }

    @Override
    public IStatusBar buildStatusBar() {
        return StatusBarTranslucent.getInstance();
    }

    @Override
    public IBindView buildBindView() {
        return ButterKnifeBindView.getInstance();
    }

    @Override
    public IToast buildToast() {
        return ToastHelper.getInstance();
    }

    @Override
    public ILoadingDialogFragment buildLoadingDialogFragment() {
        return new LoadingDialog();
    }

    @Override
    public IPullDownUp buidPullDownUp() {
        return null;
    }


    @Override
    public Application.ActivityLifecycleCallbacks buildActivityLifecycleCallbacks() {
        return new ActivityLifecycleCallbacksImp();
    }
}
