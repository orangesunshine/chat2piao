package com.orange.chat2piao.base.impl.component;

import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.orange.chat2piao.base.ifc.component.IBindView;
import com.orange.chat2piao.utils.Preconditions;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ButterKnifeBindView implements IBindView {
    private static final ButterKnifeBindView ourInstance = new ButterKnifeBindView();

    public static ButterKnifeBindView getInstance() {
        return ourInstance;
    }

    private ButterKnifeBindView() {
    }

    private Unbinder mUnbinder;

    @Override
    public void bindViews(View view) {
        Preconditions.checkNotNull(view);
        mUnbinder = ButterKnife.bind(ActivityUtils.getActivityByView(view));
    }

    @Override
    public void unbindView() {
        if (null != mUnbinder)
            mUnbinder.unbind();
    }
}
