package com.orange.chat2piao.base.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.orange.chat2piao.base.ifc.presenter.callback.IActivityCreatedNdDestroyCallback;
import com.orange.chat2piao.base.ifc.presenter.callback.IContentView;
import com.orange.chat2piao.base.ifc.presenter.generate.IGeneratePresenter;
import com.orange.chat2piao.base.ifc.view.ifc.IBindView;
import com.orange.chat2piao.base.ifc.view.ifc.IStatusBar;
import com.orange.chat2piao.base.ifc.view.ifc.IToast;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildBindView;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildStatusBar;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildToast;
import com.orange.chat2piao.base.impl.defaultImp.DefaultConfig;
import com.orange.chat2piao.base.impl.presenter.BasePresenter;
import com.orange.chat2piao.utils.Preconditions;

public abstract class BaseActivity<P extends BasePresenter> extends FragmentActivity implements IContentView, IBuildBindView, IBuildToast, IBuildStatusBar, IActivityCreatedNdDestroyCallback, IGeneratePresenter<P> {
    //protected vars
    protected BaseActivity mActivity;
    protected P mPresenter;

    //views
    protected IStatusBar mStatusBar;
    protected IToast mToast;
    protected IBindView mBindView;

    @Override
    public void onActivityCreate(Activity activity, Bundle bundle) {
        mActivity = this;
        activity.setContentView(getContentLayoutId());

        //statusbar
        mStatusBar = buildStatusBar();
        if (null == mStatusBar)
            mStatusBar = DefaultConfig.getInstance().buildStatusBar();
        mStatusBar.setStatusBar(activity);

        //bindViews
        mBindView = buildBindView();
        if (null == mBindView)
            mBindView = DefaultConfig.getInstance().buildBindView();
        mBindView.bindViews(activity);

        //toast
        mToast = buildToast();
        if (null == mToast)
            mToast = DefaultConfig.getInstance().buildToast();

        //presenter
        mPresenter = generatePresenter();
        Preconditions.checkNotNull(mPresenter);
        mPresenter.onActivityCreate(activity, bundle);
    }

    @Override
    public void onActivityDestroy(Activity context) {
        mBindView.unbindView();
        Preconditions.checkNotNull(mPresenter);
        mPresenter.onActivityDestroy(context);
    }

    @Override
    public IStatusBar buildStatusBar() {
        return null;
    }

    @Override
    public IToast buildToast() {
        return null;
    }

    @Override
    public IBindView buildBindView() {
        return null;
    }
}
