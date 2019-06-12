package com.orange.chat2piao.base.demo.activity;

import android.app.Activity;
import android.os.Bundle;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.loading.ILoading;
import com.orange.chat2piao.base.mvp.model.net.INetRequest;
import com.orange.chat2piao.base.mvp.model.net.RetrofitUrlApi;
import com.orange.chat2piao.base.mvp.model.net.callback.LoadingNetCallback;
import com.orange.chat2piao.base.mvp.presenter.LoadingPresenter;
import com.orange.chat2piao.base.mvp.view.activity.LoadingNetActivity;
import com.orange.chat2piao.buz.test.response.ConfigResponse;
import com.orange.chat2piao.utils.ReflectionUtils;

import java.lang.reflect.Type;
import java.util.HashMap;

public class BaseLoadingNetActivityDemo extends LoadingNetActivity<LoadingPresenter> implements ILoading {
    @Override
    public int getContentLayoutId() {
        return R.layout.activity_net_loading;
    }

    @Override
    public void onActivityCreate(Activity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        LoadingNetCallback configResponseLoadingNetCallback = new LoadingNetCallback<ConfigResponse>(this);
        Type genericSuperclassActualTypeArgClass = ReflectionUtils.getGenericSuperclassActualTypeArgClass(configResponseLoadingNetCallback);
        mPresenter.concactLoadingNet(new LoadingNetCallback<ConfigResponse>(this),
                (INetRequest<ConfigResponse>) callback -> {
                    HashMap<String, String> headers = new HashMap<>();
                    headers.put("D", "1fd3c28a-66f3-417e-b46e-3221a8ad6975");
                    headers.put("C", "a");
                    RetrofitUrlApi.getInstance().post(headers, "http://172.168.70.35:8091//system-config/front.mvc", new HashMap<>(), callback);
                });
    }
}
