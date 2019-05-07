package com.orange.chat2piao.base.ifc.presenter.callback;

import android.app.Activity;
import android.os.Bundle;

public interface IActivityCreatedNdDestroyCallback {
    //逻辑
    void onActivityCreate(Activity activity, Bundle bundle);

    void onActivityDestroy(Activity context);
}
