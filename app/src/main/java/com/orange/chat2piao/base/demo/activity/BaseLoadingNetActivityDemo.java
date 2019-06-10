package com.orange.chat2piao.base.demo.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.adapter.NetCallbackAdapterByLoading;
import com.orange.chat2piao.base.ifc.presenter.IPresenter;
import com.orange.chat2piao.base.impl.net.UrlCommonApi;
import com.orange.chat2piao.base.ui.activity.LoadingNetActivity;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;

import java.util.HashMap;

public class BaseLoadingNetActivityDemo extends LoadingNetActivity {
    @Override
    public int getContentLayoutId() {
        return R.layout.activity_net_loading;
    }

    /**
     * 创建生命周期回调，默认loading
     *
     * @param activity
     * @param bundle
     */
    @Override
    public void onActivityCreate(BaseActivity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        //        IInitConst.sBaseUrl = "http://192.168.254.103:8080";
//        IInitConst.sBaseUrl = "http://192.168.254.103:8080";
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
        UrlCommonApi.getInstance().post(headers, "http://192.168.254.103:8080/ifc/hello", params, new NetCallbackAdapterByLoading<String>(this) {
            @Override
            public void onSuccess(String response) {
                super.onSuccess(response);
                showToast(response);
            }

            @Override
            public void onError(int code, Throwable error) {
                super.onError(code, error);
            }
        });
    }

    @Override
    public IPresenter generatePresenter() {
        return null;
    }
}
