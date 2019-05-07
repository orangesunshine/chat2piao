package com.orange.chat2piao.base.ifc.presenter.generate;

import com.orange.chat2piao.base.ifc.presenter.callback.IActivityCreatedNdDestroyCallback;
import com.orange.chat2piao.base.ifc.presenter.callback.IActvityAlive;

public interface IGeneratePresenter<P extends IActvityAlive & IActivityCreatedNdDestroyCallback> {
    P generatePresenter();
}
