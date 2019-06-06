package com.orange.chat2piao.base.ifc.presenter.generate;

import com.orange.chat2piao.base.impl.presenter.BasePresenter;
import com.orange.chat2piao.base.ui.activity.PresenterActivity;

public interface IGeneratePresenter<A extends PresenterActivity, P extends BasePresenter<A, A>> {
    P generatePresenter();
}
