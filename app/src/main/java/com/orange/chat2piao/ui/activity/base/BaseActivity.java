package com.orange.chat2piao.ui.activity.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.githang.statusbar.StatusBarCompat;
import com.orange.chat2piao.abstractor.ifc.ILoading;
import com.orange.chat2piao.abstractor.ifc.ILoadingDialogFragment;
import com.orange.chat2piao.abstractor.ifc.act.IActivityCreated;
import com.orange.chat2piao.abstractor.ifc.act.IActivityType;
import com.orange.chat2piao.abstractor.ifc.act.IBindView;
import com.orange.chat2piao.abstractor.ifc.act.IBuzAct;
import com.orange.chat2piao.abstractor.ifc.act.IContentView;
import com.orange.chat2piao.abstractor.ifc.act.IInitVars;
import com.orange.chat2piao.abstractor.ifc.act.IStatusBarTranslucentAct;
import com.orange.chat2piao.abstractor.ifc.act.pullload.IPullndLoad;
import com.orange.chat2piao.abstractor.ifc.constant.IConst;
import com.orange.chat2piao.abstractor.ifc.net.INetCallback;
import com.orange.chat2piao.abstractor.impl.GlobleImp;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<T> extends FragmentActivity implements IActivityType, IStatusBarTranslucentAct, IContentView, IInitVars, IBindView, IActivityCreated, IBuzAct, INetCallback<T>, ILoading, IPullndLoad {
    private Unbinder mUnbinder;
    protected BaseActivity mActivity;
    protected ILoadingDialogFragment mILoadingDialog;

    @Override
    public int getActivityType() {
        return IConst.ACTIVITY_TYPE_BASE;
    }

    @Override
    public void setStatusBarTranslucent(Activity activity) {
        StatusBarCompat.setTranslucent(activity.getWindow(), true);
    }

    @Override
    public void initVars(Bundle saveInstance) {
        mActivity = this;
        mILoadingDialog = GlobleImp.getInstance().getLoadingDialog();
    }

    @Override
    public void bindViews(Activity activity) {
        mUnbinder = ButterKnife.bind(this);
    }


    @Override
    public void showLoading() {
        if (null != mILoadingDialog && null != mActivity && !mActivity.isFinishing())
            mILoadingDialog.showLoading(mActivity.getSupportFragmentManager());
    }

    @Override
    public void dismissLoading() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mUnbinder)
            mUnbinder.unbind();
    }
}
