package com.orange.chat2piao.base.impl.defaultImp;

import android.app.Application;
import android.view.View;

import com.orange.chat2piao.base.adapter.ActivityLifecycleAdapt;
import com.orange.chat2piao.base.ifc.call.ILoading;
import com.orange.chat2piao.base.ifc.callback.ILoadingNetCallback;
import com.orange.chat2piao.base.ifc.component.IActionBar;
import com.orange.chat2piao.base.ifc.call.IHolder;
import com.orange.chat2piao.base.ifc.component.IRefreshNdLoadmore;
import com.orange.chat2piao.base.ifc.component.ILoadingDialogFragment;
import com.orange.chat2piao.base.ifc.component.IStatusBar;
import com.orange.chat2piao.base.ifc.component.IToast;
import com.orange.chat2piao.base.ifc.generate.IBuildLoadingFactory;
import com.orange.chat2piao.base.ifc.img.IImage;
import com.orange.chat2piao.base.ifc.net.IPullNetRequest;
import com.orange.chat2piao.base.impl.app.ActivityLifecycleCallbacksImpl;
import com.orange.chat2piao.base.impl.callback.LoadingNetCallback;
import com.orange.chat2piao.base.impl.component.CommonActionBar;
import com.orange.chat2piao.base.impl.component.DefaultHolder;
import com.orange.chat2piao.base.impl.component.LoadingImpl;
import com.orange.chat2piao.base.impl.img.GlideImageImpl;
import com.orange.chat2piao.base.impl.net.PullNetRequestImpl;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;
import com.orange.chat2piao.thirdParty.statusbar.StatusBarTranslucent;
import com.orange.chat2piao.base.impl.component.SwipeRefreshNdLoadmore;
import com.orange.chat2piao.base.impl.component.ToastImpl;
import com.orange.chat2piao.base.ui.dialog.LoadingDialog;

public class DefaultConfig implements IBuildLoadingFactory {
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

    /**
     * 三方
     *
     * @return
     */
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
        return new ActivityLifecycleCallbacksImpl();
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

    /**
     * 三方
     *
     * @return
     */
    @Override
    public IImage buildImage() {
        return new GlideImageImpl();
    }

    @Override
    public ILoadingNetCallback buildLoadingNetCallback(ILoading loading) {
        return new LoadingNetCallback(loading);
    }

    @Override
    public IPullNetRequest buildPullNetRequest() {
        return new PullNetRequestImpl();
    }

    @Override
    public ILoading buildLoading(BaseActivity activity, ILoadingDialogFragment fragment) {
        return new LoadingImpl(activity, fragment);
    }
}
