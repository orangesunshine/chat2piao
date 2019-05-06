package com.orange.chat2piao.base.ifc.view;

import com.orange.chat2piao.base.ifc.presenter.callback.IActivityCreatedNdDestroyCallback;
import com.orange.chat2piao.base.ifc.presenter.callback.IContentView;
import com.orange.chat2piao.base.ifc.presenter.generate.IGeneratePresenter;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildBindView;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildStatusBar;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildToast;

public interface IBaseView<P> extends IView, IContentView, IBuildBindView, IBuildToast, IBuildStatusBar, IActivityCreatedNdDestroyCallback, IGeneratePresenter<P> {
}
