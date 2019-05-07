package com.orange.chat2piao.base.ifc.presenter.callback;

import android.content.Context;

public interface IInit{

    //初始化控件
    void initViews(Context context);

    //初始化监听
    void initListener(Context context);
}
