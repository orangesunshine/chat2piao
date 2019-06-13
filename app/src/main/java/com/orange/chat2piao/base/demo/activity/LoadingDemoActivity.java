package com.orange.chat2piao.base.demo.activity;

import android.app.Activity;
import android.os.Bundle;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.common.IConvert;
import com.orange.chat2piao.base.loading.DefaultLoading;
import com.orange.chat2piao.base.mvp.model.net.RetrofitUrlApi;
import com.orange.chat2piao.base.mvp.view.activity.PresenterActivity;
import com.orange.chat2piao.utils.NetUtils;

import java.util.HashMap;

public class LoadingDemoActivity extends PresenterActivity {
    @Override
    public int getContentLayoutId() {
        return R.layout.activity_net_loading;
    }

    @Override
    public void onActivityCreate(Activity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        NetUtils.loadingNetData(new DefaultLoading(this), callback -> {
            RetrofitUrlApi.getInstance().post("http://172.168.70.200:8080/ifc/loading", new HashMap<>(), callback);
        }, (IConvert<String>) data -> {
            showToast(data);
        });
    }
}
