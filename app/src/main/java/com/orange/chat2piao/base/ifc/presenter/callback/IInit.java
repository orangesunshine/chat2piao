package com.orange.chat2piao.base.ifc.presenter.callback;

import android.content.Context;

import com.orange.chat2piao.base.ifc.view.IBaseView;

public interface IInit<P> extends IBaseView<P> {

    //初始化控件
    void initViews(Context context);

    //初始化监听
    void initListener(Context context);
}
