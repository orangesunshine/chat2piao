package com.orange.chat2piao.ui.activity.base;

import android.app.Activity;
import android.os.Bundle;

import com.orange.chat2piao.abstractor.ifc.act.IActivityCreated;
import com.orange.chat2piao.abstractor.ifc.act.IBindView;
import com.orange.chat2piao.abstractor.ifc.act.IContentView;
import com.orange.chat2piao.abstractor.ifc.act.IInitVars;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends StatusBarTranslucentActivity implements IContentView, IInitVars, IBindView, IActivityCreated {
    protected BaseActivity mActivity;

    private Unbinder mUnbinder;

    @Override
    public void initVars(Bundle saveInstance) {
        mActivity = this;
    }

    @Override
    public void bindViews(Activity activity) {
        mUnbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mUnbinder)
            mUnbinder.unbind();
    }
}
