package com.orange.chat2piao.base.ifc.callback;

import android.os.Bundle;

import com.orange.chat2piao.base.ui.activity.BaseActivity;

public interface ICreatedNdDestroy<T extends BaseActivity> {
    /**
     * 逻辑
     * @param activity
     * @param bundle
     */
    void onActivityCreate(T activity, Bundle bundle);

    /**
     * 销毁
     * @param context
     */
    void onActivityDestroy(T context);
}
