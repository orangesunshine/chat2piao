package com.orange.chat2piao.base.impl.app;

import android.app.Activity;
import android.os.Bundle;

import com.orange.chat2piao.base.adapter.ActivityLifecycleAdapt;
import com.orange.chat2piao.base.ifc.presenter.callback.ICreatedNdDestroy;

public class ActivityLifecycleCallbacksImp extends ActivityLifecycleAdapt {
    @Override
    public void onActivityDestroyed(Activity activity) {
        if (activity instanceof ICreatedNdDestroy) {
            ((ICreatedNdDestroy) activity).onActivityDestroy(activity);
        }
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity instanceof ICreatedNdDestroy) {
            ((ICreatedNdDestroy) activity).onActivityCreate(activity, bundle);
        }
    }
}
