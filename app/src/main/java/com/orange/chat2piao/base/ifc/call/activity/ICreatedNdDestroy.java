package com.orange.chat2piao.base.ifc.call.activity;

import android.os.Bundle;

import com.orange.chat2piao.base.ui.activity.base.BaseActivity;

public interface ICreatedNdDestroy<ACT extends BaseActivity> {
    /**
     * 创建生命周期回调
     *
     * @param activity
     * @param bundle
     */
    void onActivityCreate(ACT activity, Bundle bundle);

    /**
     * 销毁生命周期回调
     *
     * @param context
     */
    void onActivityDestroy(ACT context);
}
