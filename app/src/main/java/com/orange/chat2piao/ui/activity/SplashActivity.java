package com.orange.chat2piao.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

import com.orange.chat2piao.R;
import com.orange.chat2piao.ui.activity.base.CommonActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends CommonActivity {
    @BindView(R.id.view_bg)
    View viewBg;
    private AnimationSet mAnimationSet;

    @Override
    public void initVars(Bundle saveInstance) {
        mAnimationSet = new AnimationSet(true);
        mAnimationSet.addAnimation(new ScaleAnimation(0.5f, 1, 0.5f, 1));
        mAnimationSet.addAnimation(new AlphaAnimation(0.5f, 1));
        viewBg.startAnimation(mAnimationSet);
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_splash;
    }
}
