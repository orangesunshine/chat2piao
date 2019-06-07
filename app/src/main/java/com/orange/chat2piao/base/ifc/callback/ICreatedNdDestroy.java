package com.orange.chat2piao.base.ifc.callback;

import android.os.Bundle;

import com.orange.chat2piao.base.ui.activity.BaseActivity;

public interface ICreatedNdDestroy<T extends BaseActivity> {
    //逻辑
    void onActivityCreate(T activity, Bundle bundle);

    //销毁
    void onActivityDestroy(T context);
}
