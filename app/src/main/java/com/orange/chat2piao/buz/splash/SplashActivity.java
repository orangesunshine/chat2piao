package com.orange.chat2piao.buz.splash;

import android.view.View;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.ifc.presenter.IBasePresenter;
import com.orange.chat2piao.base.ui.activity.BaseActivity;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {
    //final
    private final int DURATION_SPLASH = 2000;

    //views
    @BindView(R.id.view_bg)
    View viewBg;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getContentLayoutId() {
        return 0;
    }
}
