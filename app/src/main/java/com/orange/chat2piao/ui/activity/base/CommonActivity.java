package com.orange.chat2piao.ui.activity.base;

import android.app.Activity;

import com.orange.chat2piao.abstractor.ifc.act.ICommonAct;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class CommonActivity extends BaseActivity implements ICommonAct {
    @Override
    public Unbinder bindViews(Activity activity) {
        return ButterKnife.bind(activity);
    }
}
