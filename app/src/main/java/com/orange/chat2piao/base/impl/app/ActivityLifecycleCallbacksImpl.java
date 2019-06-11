package com.orange.chat2piao.base.impl.app;

import android.app.Activity;
import android.os.Bundle;

import com.orange.chat2piao.base.adapter.ActivityLifecycleAdapt;
import com.orange.chat2piao.base.ifc.call.activity.ICreatedNdDestroy;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;

public class ActivityLifecycleCallbacksImpl extends ActivityLifecycleAdapt {
    @Override
    public void onActivityDestroyed(Activity activity) {
        if (activity instanceof BaseActivity) {
            ((ICreatedNdDestroy) activity).onActivityDestroy((BaseActivity) activity);
        }
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity instanceof BaseActivity) {
            ((ICreatedNdDestroy) activity).onActivityCreate((BaseActivity) activity, bundle);
        }
    }
}
