package com.orange.chat2piao.base.common;

import com.orange.chat2piao.base.generate.IBuildFactory;
import com.orange.chat2piao.base.actbar.CommonActionBar;
import com.orange.chat2piao.base.loading.LoadingImpl;
import com.orange.chat2piao.base.pull.SwipeRefreshNdLoadmore;
import com.orange.chat2piao.base.toast.ToastImpl;
import com.orange.chat2piao.base.image.GlideImageImpl;
import com.orange.chat2piao.base.loading.ILoading;
import com.orange.chat2piao.base.actbar.IActionBar;
import com.orange.chat2piao.base.loading.ILoadingDialogFragment;
import com.orange.chat2piao.base.pull.IRefreshNdLoadmore;
import com.orange.chat2piao.base.toast.IToast;
import com.orange.chat2piao.base.image.IImage;
import com.orange.chat2piao.base.view.activity.base.BaseActivity;
import com.orange.chat2piao.ui.dialog.LoadingDialog;

public class DefaultConfig implements IBuildFactory {
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
    public IRefreshNdLoadmore buildHeaderNdFooter() {
        return new SwipeRefreshNdLoadmore();
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
    public ILoading buildLoading(BaseActivity activity, ILoadingDialogFragment fragment) {
        return new LoadingImpl(activity, fragment);
    }
}
