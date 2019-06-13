package com.orange.chat2piao.base.common;

import com.orange.chat2piao.base.actbar.CommonActionBar;
import com.orange.chat2piao.base.actbar.IActionBar;
import com.orange.chat2piao.base.generate.IBuildFactory;
import com.orange.chat2piao.base.image.GlideImageImpl;
import com.orange.chat2piao.base.image.IImage;
import com.orange.chat2piao.base.toast.IToast;
import com.orange.chat2piao.base.toast.ToastImpl;

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
    public IToast buildToast() {
        return new ToastImpl();
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
}
