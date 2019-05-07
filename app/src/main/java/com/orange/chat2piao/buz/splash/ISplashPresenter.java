package com.orange.chat2piao.buz.splash;

import com.orange.chat2piao.base.ifc.presenter.IPresenter;

public interface ISplashPresenter extends IPresenter {
    /**
     * 页面可见
     *
     * @param splashView
     */
    void startSplashAnim(ISplashView splashView);

    //动画结束
    void onAnimOver();
}
