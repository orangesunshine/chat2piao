package com.orange.chat2piao.base.demo.activity;

import android.widget.TextView;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.demo.presenter.BasePresenterDemo;
import com.orange.chat2piao.base.ui.activity.BaseActivity;

import butterknife.BindView;

public class BaseActivityDemo extends BaseActivity<BasePresenterDemo> {

    @BindView(R.id.tv_demo_base)
    TextView tvDemoBase;

    @Override
    public int getContentLayoutId() {
        return R.layout.demo_base;
    }

    @Override
    public BasePresenterDemo generatePresenter() {
        return new BasePresenterDemo();
    }
}
