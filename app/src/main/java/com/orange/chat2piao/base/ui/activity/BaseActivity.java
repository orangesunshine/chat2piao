package com.orange.chat2piao.base.ui.activity;

import android.app.Activity;

import androidx.fragment.app.FragmentActivity;

import com.orange.chat2piao.base.ifc.presenter.IBasePresenter;
import com.orange.chat2piao.base.ifc.view.IBaseView;
import com.orange.chat2piao.base.ifc.view.ifc.IBindView;
import com.orange.chat2piao.base.ifc.view.ifc.IStatusBar;
import com.orange.chat2piao.base.ifc.view.ifc.IToast;
import com.orange.chat2piao.base.impl.defaultImp.DefaultConfig;
import com.orange.chat2piao.utils.Preconditions;

public abstract class BaseActivity<P extends IBasePresenter> extends FragmentActivity implements IBaseView<P> {
    //protected vars
    protected BaseActivity mActivity;
    protected P mPresenter;

    //views
    protected IStatusBar mStatusBar;
    protected IToast mToast;
    protected IBindView mBind;

    @Override
    public void onActivityCreate(Activity activity) {
        mActivity = this;
        activity.setContentView(getContentLayoutId());

        //statusbar
        mStatusBar = buildStatusBar();
        if (null == mStatusBar)
            mStatusBar = DefaultConfig.getInstance().buildStatusBar();
        mStatusBar.setStatusBar(activity);

        //bindViews
        mBind = buildBindView();
        if (null == mBind)
            mBind = DefaultConfig.getInstance().buildBindView();
        mBind.bindViews(activity);

        //toast
        mToast = buildToast();
        if (null == mToast)
            mToast = DefaultConfig.getInstance().buildToast();

        //presenter
        mPresenter = generatePresenter();
        Preconditions.checkNotNull(mPresenter);
        mPresenter.onActivityCreate(activity);
    }

    @Override
    public void onActivityDestroy(Activity context) {
        mBind.unbindView();
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
