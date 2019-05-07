package com.orange.chat2piao.base.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.ifc.listener.IActionBarCallback;
import com.orange.chat2piao.base.ui.activity.BaseActivity;

import butterknife.BindView;

public class BaseActivityDemo extends BaseActivity {

    @BindView(R.id.tv_demo_base)
    TextView tvDemoBase;

    @Override
    public int getContentLayoutId() {
        return R.layout.demo_base;
    }

    @Override
    public void onActivityCreate(Activity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        mActionBar.setLeftText("返回");
        mActionBar.setRightText("确定");
        mActionBar.setActionBarCallback(new IActionBarCallback() {
            @Override
            public void onLeft() {
                mToast.showToast("onLeft");
            }

            @Override
            public void onCenter() {
                mToast.showToast("onCenter");
            }

            @Override
            public void onRight() {
                mToast.showToast("onRight");
            }
        });
    }
}
