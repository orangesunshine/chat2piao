package com.orange.chat2piao.utils;

import android.content.Context;
import android.content.Intent;

import com.orange.chat2piao.base.mvp.view.activity.base.BaseActivity;

public class ActivityUtils {
    public static void launchActivity(Context context, Class<? extends BaseActivity> clazz) {
        Preconditions.checkNotNull(context);
        context.startActivity(new Intent(context, clazz));
    }
}
