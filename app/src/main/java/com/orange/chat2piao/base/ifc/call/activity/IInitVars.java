package com.orange.chat2piao.base.ifc.call.activity;

import android.os.Bundle;
import android.view.View;

import com.orange.chat2piao.base.ui.activity.base.BaseActivity;

public interface IInitVars {
    /**
     * 初始化变量
     *
     * @param saveInstance
     */
    void initVars(BaseActivity activity, Bundle saveInstance);
}
