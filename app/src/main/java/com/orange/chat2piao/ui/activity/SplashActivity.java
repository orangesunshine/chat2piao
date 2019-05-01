package com.orange.chat2piao.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

import com.orange.chat2piao.R;
import com.orange.chat2piao.abstractor.adapter.AnimationListenerAdapter;
import com.orange.chat2piao.abstractor.ifc.act.IBindView;
import com.orange.chat2piao.ui.activity.base.BaseActivity;
import com.orange.chat2piao.ui.activity.base.StatusBarTranslucentActivity;
import com.orange.chat2piao.utils.ActivityUtils;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {
    //final
    private final int DURATION_SPLASH = 2000;

    //views
    @BindView(R.id.view_bg)
    View viewBg;

    //vars
    private AnimationSet mAnimationSet;

    @Override
    public void initVars(Bundle saveInstance) {
        super.initVars(saveInstance);
        mAnimationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1, 0.5f, 1);
        mAnimationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1);
        mAnimationSet.addAnimation(alphaAnimation);
        mAnimationSet.setDuration(DURATION_SPLASH);
        mAnimationSet.setAnimationListener(new AnimationListenerAdapter() {
            @Override
            public void onAnimationEnd(Animation animation) {
                ActivityUtils.launchActivity(mActivity, MainActivity.class);
            }
        });
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void onActivityCreate(Context context) {
        viewBg.startAnimation(mAnimationSet);
    }
}
