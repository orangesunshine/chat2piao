package com.orange.chat2piao.buz.splash;

import com.orange.chat2piao.base.impl.presenter.BasePresenter;
import com.orange.chat2piao.buz.main.MainActivity;
import com.orange.chat2piao.utils.ActivityUtils;
import com.orange.chat2piao.utils.Preconditions;

public class SplashPresenter extends BasePresenter implements ISplashPresenter {

    @Override
    public void startSplashAnim(ISplashView splashView) {
        Preconditions.checkNotNull(splashView);
        splashView.splashAnim();
    }

    @Override
    public void onAnimOver() {
        if (isActivityAlive())
            ActivityUtils.launchActivity(mActivity, MainActivity.class);
    }
}
