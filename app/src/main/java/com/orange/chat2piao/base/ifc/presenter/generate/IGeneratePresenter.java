package com.orange.chat2piao.base.ifc.presenter.generate;

import com.orange.chat2piao.base.ifc.presenter.IPresenter;
import com.orange.chat2piao.base.ifc.presenter.callback.ICreatedNdDestroy;
import com.orange.chat2piao.base.ifc.presenter.callback.IActvityAlive;
import com.orange.chat2piao.base.ifc.view.IView;

public interface IGeneratePresenter<V extends IView, P extends IPresenter<V>> {
    P generatePresenter();
}
