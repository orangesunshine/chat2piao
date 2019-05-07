package com.orange.chat2piao.base.ifc.presenter.callback;

import android.app.Activity;
import android.os.Bundle;

public interface ICreatedNdDestroy {
    //逻辑
    void onActivityCreate(Activity activity, Bundle bundle);

    //销毁
    void onActivityDestroy(Activity context);
}
