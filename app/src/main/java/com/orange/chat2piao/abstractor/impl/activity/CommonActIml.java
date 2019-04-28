package com.orange.chat2piao.abstractor.impl.activity;

import android.app.Activity;

import com.orange.chat2piao.abstractor.ifc.act.ICommonAct;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class CommonActIml implements ICommonAct {

    @Override
    public Unbinder bindViews(Activity activity) {
        return ButterKnife.bind(activity);
    }
}
