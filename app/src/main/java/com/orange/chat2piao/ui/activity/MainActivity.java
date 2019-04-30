package com.orange.chat2piao.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.orange.chat2piao.R;
import com.orange.chat2piao.abstractor.ifc.ILoading;
import com.orange.chat2piao.ui.activity.base.Pull2LoadViewActivity;
import com.orange.chat2piao.utils.BeanUtils;

public class MainActivity extends Pull2LoadViewActivity {

    @Override
    public void onActivityCreate(Context context) {
        showLoading();
    }

    @Override
    public void initViews(Context context) {

    }

    @Override
    public void initListener(Context context) {

    }

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initVars(Bundle saveInstance) {
        super.initVars(saveInstance);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onNetStart(ILoading loading, String netIfc) {

    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onFinish(ILoading loading) {

    }

    @Override
    public void onError(int code, Throwable error) {

    }

    public void launchMainActivity(Context context) {
        BeanUtils.checkNotNull(context);
        context.startActivity(new Intent(context, MainActivity.class));
    }
}