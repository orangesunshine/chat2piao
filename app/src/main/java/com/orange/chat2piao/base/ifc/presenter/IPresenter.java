package com.orange.chat2piao.base.ifc.presenter;

import com.orange.chat2piao.base.ifc.call.activity.IActvityAlive;
import com.orange.chat2piao.base.ifc.call.activity.ICreatedNdDestroy;
import com.orange.chat2piao.base.ifc.view.IView;

public interface IPresenter<V extends IView> extends IActvityAlive, ICreatedNdDestroy {
    void attachView(V view);
}
