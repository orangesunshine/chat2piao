package com.orange.chat2piao.base.ifc.presenter.callback;

import android.app.Activity;

public interface IActivityCreatedNdDestroyCallback {
    //逻辑
    void onActivityCreate(Activity activity);

    void onActivityDestroy(Activity context);
}
