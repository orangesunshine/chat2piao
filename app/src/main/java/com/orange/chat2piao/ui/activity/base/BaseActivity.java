package com.orange.chat2piao.ui.activity.base;

import android.support.v4.app.FragmentActivity;

import com.orange.chat2piao.abstractor.ifc.wrapper.IWrapper;

public class BaseActivity extends FragmentActivity{
    protected IWrapper mWrapper;

    public void setWrapper(IWrapper wrapper) {
        mWrapper = wrapper;
    }
}
