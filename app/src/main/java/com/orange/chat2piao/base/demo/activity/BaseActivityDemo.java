package com.orange.chat2piao.base.demo.activity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.PhoneUtils;
import com.orange.chat2piao.R;
import com.orange.chat2piao.base.adapter.LoadingNetCallbackAdapter;
import com.orange.chat2piao.base.constant.IInitConst;
import com.orange.chat2piao.base.impl.net.CommonApi;
import com.orange.chat2piao.base.impl.presenter.BasePresenter;
import com.orange.chat2piao.base.impl.presenter.NetPresenter;
import com.orange.chat2piao.base.ui.activity.BaseActivity;
import com.orange.chat2piao.base.ui.activity.NetActivity;
import com.orange.chat2piao.buz.test.response.ConfigResponse;

import java.util.HashMap;

public class BaseActivityDemo extends NetActivity<NetActivity, ConfigResponse, NetPresenter<NetActivity,NetActivity,ConfigResponse>> {
    @Override
    public int getContentLayoutId() {
        return R.layout.demo_base;
    }

    @Override
    public void onActivityCreate(NetActivity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        IInitConst.sBaseUrl = "http://172.168.70.35:8091";
        HashMap<String, String> headers = new HashMap<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
        }
        headers.put("D", "13b50a9f-73b6-406d-a562-7652c238c969");
        headers.put("C", "a");
        HashMap<String, String> params = new HashMap<>();
        CommonApi.getInstance().post(headers, "system-config", "front.mvc", params, new LoadingNetCallbackAdapter<ConfigResponse>(getLoading()) {
            @Override
            public void onSuccess(ConfigResponse response) {
                super.onSuccess(response);
            }

            @Override
            public void onError(int code, Throwable error) {
                super.onError(code, error);
            }
        });
    }

    @Override
    public void init(Context context) {

    }

    @Override
    public NetPresenter generatePresenter() {
        return null;
    }
}
