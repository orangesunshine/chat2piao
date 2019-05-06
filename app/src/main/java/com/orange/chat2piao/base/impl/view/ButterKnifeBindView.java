package com.orange.chat2piao.base.impl.view;

import android.app.Activity;

import com.orange.chat2piao.base.ifc.view.ifc.IBindView;
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
    public void bindViews(Activity activity) {
        Preconditions.checkNotNull(activity);
        mUnbinder = ButterKnife.bind(activity);
    }

    @Override
    public void unbindView() {
        if (null != mUnbinder)
            mUnbinder.unbind();
    }
}
