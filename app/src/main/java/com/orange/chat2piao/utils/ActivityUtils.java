package com.orange.chat2piao.utils;

import android.content.Context;
import android.content.Intent;

import com.orange.chat2piao.base.ui.activity.base.BaseActivity;

public class ActivityUtils {
    public static void launchActivity(Context context, Class<? extends BaseActivity> clazz) {
        Preconditions.checkNotNull(context);
        context.startActivity(new Intent(context, clazz));
    }
}
