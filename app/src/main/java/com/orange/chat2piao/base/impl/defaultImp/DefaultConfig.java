package com.orange.chat2piao.base.impl.defaultImp;

import android.app.Application;
import android.view.View;

import com.orange.chat2piao.base.adapter.ActivityLifecycleAdapt;
import com.orange.chat2piao.base.ifc.component.IActionBar;
import com.orange.chat2piao.base.ifc.component.IAttachHolder;
import com.orange.chat2piao.base.ifc.component.IHolder;
import com.orange.chat2piao.base.ifc.component.IRefreshNdLoadmore;
import com.orange.chat2piao.base.ifc.component.ILoadingDialogFragment;
import com.orange.chat2piao.base.ifc.component.IStatusBar;
import com.orange.chat2piao.base.ifc.component.IToast;
import com.orange.chat2piao.base.ifc.component.generate.IBuildFactory;
import com.orange.chat2piao.base.impl.app.ActivityLifecycleCallbacksImp;
import com.orange.chat2piao.base.impl.component.CommonActionBar;
import com.orange.chat2piao.base.impl.component.DefaultHolder;
import com.orange.chat2piao.base.impl.component.StatusBarTranslucent;
import com.orange.chat2piao.base.impl.component.SwipeRefreshNdLoadmore;
import com.orange.chat2piao.base.impl.component.ToastImpl;
import com.orange.chat2piao.base.ui.dialog.LoadingDialog;

public class DefaultConfig extends ActivityLifecycleAdapt implements IBuildFactory {
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
    public IRefreshNdLoadmore buildHeaderNdFooter() {
        return new SwipeRefreshNdLoadmore();
    }


    @Override
    public Application.ActivityLifecycleCallbacks buildActivityLifecycleCallbacks() {
        return new ActivityLifecycleCallbacksImp();
    }

    @Override
    public IActionBar buildActionBar() {
        return new CommonActionBar();
    }

    @Override
    public IToast buildToast() {
        return new ToastImpl();
    }

    @Override
    public ILoadingDialogFragment buildLoadingDialogFragment() {
        return new LoadingDialog();
    }

    @Override
    public IHolder buildHolder(View view) {
        return new DefaultHolder(view);
    }
}
