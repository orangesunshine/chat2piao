package com.orange.chat2piao.base.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentActivity;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.ifc.presenter.callback.IActvityAlive;
import com.orange.chat2piao.base.ifc.presenter.callback.IContentView;
import com.orange.chat2piao.base.ifc.presenter.callback.ICreatedNdDestroy;
import com.orange.chat2piao.base.ifc.view.IView;
import com.orange.chat2piao.base.ifc.view.ifc.IActionBar;
import com.orange.chat2piao.base.ifc.view.ifc.IBindView;
import com.orange.chat2piao.base.ifc.view.ifc.IStatusBar;
import com.orange.chat2piao.base.ifc.view.ifc.IToast;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildActionBar;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildBindView;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildStatusBar;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildToast;
import com.orange.chat2piao.base.impl.globle.GlobleImp;
import com.orange.chat2piao.utils.Preconditions;

public abstract class BaseActivity<T extends BaseActivity> extends FragmentActivity implements IContentView, ICreatedNdDestroy<T>, IActvityAlive, IBuildStatusBar, IBuildActionBar, IBuildBindView, IBuildToast {
    //protected vars
    protected T mActivity;
    private boolean mActivityAlive;

    //views
    protected IStatusBar mStatusBar;
    protected IToast mToast;
    protected IBindView mBindView;
    protected IActionBar mActionBar;

    @Override
    public void onActivityCreate(T activity, Bundle bundle) {
        mActivity = activity;
        mActivityAlive = true;
        FrameLayout content = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        content.removeAllViews();
        FrameLayout flContent = LayoutInflater.from(activity).inflate(R.layout.activity_base, content, true).findViewById(R.id.fl_content);
        LayoutInflater.from(activity).inflate(getContentLayoutId(), flContent, true);
        //bindViews
        mBindView = buildBindView();
        if (null == mBindView)
            mBindView = GlobleImp.getInstance().buildBindView();
        mBindView.bindViews(content);

        //statusbar
        mStatusBar = buildStatusBar();
        if (null == mStatusBar)
            mStatusBar = GlobleImp.getInstance().buildStatusBar();
        mStatusBar.setStatusBar(activity);

        //actionbar
        mActionBar = buildActionBar();
        if (null == mActionBar)
            mActionBar = GlobleImp.getInstance().buildActionBar();
        mActionBar.bindViews(content);

        //toast
        mToast = buildToast();
        if (null == mToast)
            mToast = GlobleImp.getInstance().buildToast();
    }

    @Override
    public void onActivityDestroy(T context) {
        mActivityAlive = false;
        Preconditions.checkNotNull(mBindView);
        mBindView.unbindView();
        Preconditions.checkNotNull(mActionBar);
        mActionBar.unbindView();
    }

    @Override
    public boolean isActivityAlive() {
        return mActivityAlive;
    }

    @Override
    public IStatusBar buildStatusBar() {
        return null;
    }

    @Override
    public IBindView buildBindView() {
        return null;
    }

    @Override
    public IActionBar buildActionBar() {
        return null;
    }

    @Override
    public IToast buildToast() {
        return null;
    }
}
