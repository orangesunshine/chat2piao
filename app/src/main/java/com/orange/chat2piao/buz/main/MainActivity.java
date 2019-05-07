package com.orange.chat2piao.buz.main;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.ui.activity.BaseActivity;
import com.orange.chat2piao.buz.splash.SplashPresenter;

public class MainActivity extends BaseActivity {
    @Override
    public int getContentLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public Object generatePresenter() {
        return new SplashPresenter();
    }
}
