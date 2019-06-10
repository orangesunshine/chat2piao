package com.orange.chat2piao.thirdParty.statusbar;

import android.app.Activity;

import com.githang.statusbar.StatusBarCompat;
import com.orange.chat2piao.base.ifc.component.IStatusBar;
import com.orange.chat2piao.utils.Preconditions;

public class StatusBarTranslucent implements IStatusBar {
    private static final StatusBarTranslucent ourInstance = new StatusBarTranslucent();

    public static StatusBarTranslucent getInstance() {
        return ourInstance;
    }

    private StatusBarTranslucent() {
    }

    @Override
    public void setStatusBar(Activity activity) {
        Preconditions.checkNotNull(activity);
        StatusBarCompat.setTranslucent(activity.getWindow(),false);
    }
}
