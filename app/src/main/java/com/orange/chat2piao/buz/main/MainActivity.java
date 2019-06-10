package com.orange.chat2piao.buz.main;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.demo.activity.BaseActivityDemo;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;
import com.orange.chat2piao.utils.ActivityUtils;

public class MainActivity extends BaseActivity {
    @Override
    public int getContentLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * 初始化（控件相关）
     */
    @Override
    public void init() {
        super.init();
        clickEvent();
    }

    private void clickEvent() {
        mHolder.setOnItemChildClick(v -> {
            switch (v.getId()) {
                case R.id.btn_base:
                    ActivityUtils.launchActivity(MainActivity.this, BaseActivityDemo.class);
                    break;
                case R.id.btn_presenter:
                    ActivityUtils.launchActivity(MainActivity.this, BaseActivityDemo.class);
                    break;
                case R.id.btn_net_loading:
                    ActivityUtils.launchActivity(MainActivity.this, BaseActivityDemo.class);
                    break;
                case R.id.btn_net_pull:
                    ActivityUtils.launchActivity(MainActivity.this, BaseActivityDemo.class);
                    break;
            }
        }, R.id.btn_base, R.id.btn_presenter, R.id.btn_net_loading, R.id.btn_net_pull);
    }
}
