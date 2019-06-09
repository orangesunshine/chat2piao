package com.orange.chat2piao.buz.splash;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.adapter.AnimationListenerAdapter;
import com.orange.chat2piao.base.demo.activity.BaseActivityDemoLoading;
import com.orange.chat2piao.base.ui.activity.base.BaseActivity;
import com.orange.chat2piao.utils.ActivityUtils;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {
    //final
    private final int DURATION_SPLASH_ANIM = 2000;

    //views
    @BindView(R.id.view_bg)
    View viewBg;

    //vars
    private AnimationSet mSplashAnim;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void onActivityCreate(BaseActivity activity, Bundle bundle) {
        super.onActivityCreate(activity, bundle);
        Animation animation = viewBg.getAnimation();
        if (null != animation)
            animation.cancel();
        viewBg.startAnimation(getSplashAnim());
    }

    private AnimationSet getSplashAnim() {
        if (null == mSplashAnim) {
            Animation scale = new ScaleAnimation(0.8f, 1, 0.8f, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            Animation alpha = new AlphaAnimation(0.5f, 1);
            mSplashAnim = new AnimationSet(true);
            mSplashAnim.addAnimation(scale);
            mSplashAnim.addAnimation(alpha);
            mSplashAnim.setDuration(DURATION_SPLASH_ANIM);
            mSplashAnim.setAnimationListener(new AnimationListenerAdapter() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    ActivityUtils.launchActivity(mActivity, BaseActivityDemoLoading.class);
                }
            });
        }
        return mSplashAnim;
    }
}
