package com.orange.chat2piao.base.impl.presenter;

import com.orange.chat2piao.base.ifc.callback.IPullCallback;
import com.orange.chat2piao.base.ifc.view.IView;
import com.orange.chat2piao.base.ui.activity.PullActivity;

public class PullPresenter<A extends PullActivity, V extends IView, T> extends NetPresenter<A, V, T> implements IPullCallback {

    @Override
    public void pullDown() {
        //刷新
    }

    @Override
    public void pullUp() {
        //加载
    }
}
