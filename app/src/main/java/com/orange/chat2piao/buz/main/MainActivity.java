package com.orange.chat2piao.buz.main;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.demo.activity.BaseActivityDemoLoading;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;
import com.orange.chat2piao.utils.ActivityUtils;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @Override
    public int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.tv_base)
    public void onViewClicked() {
        ActivityUtils.launchActivity(mActivity, BaseActivityDemoLoading.class);
    }
}
