package com.orange.chat2piao.base.generate;

import com.orange.chat2piao.base.mvp.presenter.ifc.IPresenter;

public interface IBuildPresenter<P extends IPresenter> {
    P generatePresenter();
}
