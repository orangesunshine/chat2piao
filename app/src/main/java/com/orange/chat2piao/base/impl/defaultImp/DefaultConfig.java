package com.orange.chat2piao.base.impl.defaultImp;

import android.app.Application;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.adapter.ActivityLifecycleAdapt;
import com.orange.chat2piao.base.adapter.NetCallbackAdapter;
import com.orange.chat2piao.base.ifc.app.IBuildActivityLifecycleCallbacks;
import com.orange.chat2piao.base.ifc.presenter.callback.INetCallback;
import com.orange.chat2piao.base.ifc.view.ifc.IActionBar;
import com.orange.chat2piao.base.ifc.view.ifc.IBindView;
import com.orange.chat2piao.base.ifc.view.ifc.ILoading;
import com.orange.chat2piao.base.ifc.view.ifc.ILoadingDialogFragment;
import com.orange.chat2piao.base.ifc.view.ifc.IHeaderNdFooter;
import com.orange.chat2piao.base.ifc.view.ifc.IStatusBar;
import com.orange.chat2piao.base.ifc.view.ifc.IToast;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildActionBar;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildBindView;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildLoadDialogFragment;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildNetCallback;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildHeaderNdFooter;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildStatusBar;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildToast;
import com.orange.chat2piao.base.impl.app.ActivityLifecycleCallbacksImp;
import com.orange.chat2piao.base.impl.globle.GlobleImp;
import com.orange.chat2piao.base.impl.view.ButterKnifeBindView;
import com.orange.chat2piao.base.impl.view.CommonActionBar;
import com.orange.chat2piao.base.impl.view.StatusBarTranslucent;
import com.orange.chat2piao.base.impl.view.ToastHelper;
import com.orange.chat2piao.base.ui.dialog.LoadingDialog;
import com.orange.chat2piao.utils.LogUtil;
import com.orange.chat2piao.utils.Preconditions;

public class DefaultConfig extends ActivityLifecycleAdapt implements IBuildStatusBar, IBuildActionBar, IBuildBindView, IBuildToast, IBuildLoadDialogFragment, IBuildNetCallback, IBuildHeaderNdFooter, IBuildActivityLifecycleCallbacks {
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
    public IHeaderNdFooter buildHeaderFooter() {
        return null;
    }


    @Override
    public Application.ActivityLifecycleCallbacks buildActivityLifecycleCallbacks() {
        return new ActivityLifecycleCallbacksImp();
    }

    @Override
    public INetCallback buildNetCallback() {
        StringBuilder log = new StringBuilder();
        return new NetCallbackAdapter() {
            @Override
            public void onNetStart(ILoading loading, String netIfc) {
                log.append("->>>>>onNetStart->netIfc: " + netIfc);
                Preconditions.checkNotNull(loading);
                loading.showLoading();
            }

            @Override
            public void onSuccess(Object o) {
                log.append("\nonSuccess->o: " + String.valueOf(o));
            }

            @Override
            public void onError(int code, Throwable error) {
                log.append("\nonError->code: " + code + ", error: " + (null == error ? error.getCause().getMessage() : error.getMessage()));
                ToastHelper.getInstance().showToast(GlobleImp.getInstance().getAppContext().getString(R.string.net_error));
            }

            @Override
            public void onFinish(ILoading loading) {
                log.append("\nonFinish<<<<<-");
                LogUtil.e(log.toString());
                Preconditions.checkNotNull(loading);
                loading.dismissLoading();
            }
        };
    }

    @Override
    public IActionBar buildActionBar() {
        return new CommonActionBar();
    }
}
