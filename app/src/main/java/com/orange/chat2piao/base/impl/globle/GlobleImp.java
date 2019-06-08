package com.orange.chat2piao.base.impl.globle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;

import com.orange.chat2piao.base.constant.IInitConst;
import com.orange.chat2piao.base.ifc.globle.IGloble;
import com.orange.chat2piao.base.ifc.img.IImage;
import com.orange.chat2piao.base.ifc.listener.IActionBarCallback;
import com.orange.chat2piao.base.ifc.component.IActionBar;
import com.orange.chat2piao.base.ifc.component.IBindView;
import com.orange.chat2piao.base.ifc.component.IHeaderNdFooter;
import com.orange.chat2piao.base.ifc.component.ILoadingDialogFragment;
import com.orange.chat2piao.base.ifc.component.IStatusBar;
import com.orange.chat2piao.base.ifc.component.IToast;
import com.orange.chat2piao.base.ifc.component.build.IBuildFactory;
import com.orange.chat2piao.base.impl.component.ButterKnifeBindView;
import com.orange.chat2piao.base.impl.component.CommonActionBar;
import com.orange.chat2piao.base.impl.component.StatusBarTranslucent;
import com.orange.chat2piao.base.impl.defaultImp.DefaultConfig;
import com.orange.chat2piao.base.impl.img.GlideImageImpl;
import com.orange.chat2piao.base.ui.app.LypApp;
import com.orange.chat2piao.base.ui.dialog.LoadingDialog;

public class GlobleImp implements IGloble, IBuildFactory, IImage, IStatusBar, IActionBar, IBindView, IToast, ILoadingDialogFragment, IHeaderNdFooter, Application.ActivityLifecycleCallbacks {
    //static&final
    private static volatile GlobleImp ourInstance = null;
    private IImage mDefaultImage = new GlideImageImpl();
    private IStatusBar mStatusBar;
    private IActionBar mActionBar;
    private IBindView mBindView;
    private IToast mToast;
    private ILoadingDialogFragment mLoadingDialogFragment;
    private IHeaderNdFooter mHeaderNdFooter;
    private Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;

    public static GlobleImp getInstance() {
        if (null == ourInstance) {
            synchronized (GlobleImp.class) {
                if (null == ourInstance) {
                    ourInstance = new GlobleImp();
                }
            }
        }
        return ourInstance;
    }

    private GlobleImp() {
        DefaultConfig instance = DefaultConfig.getInstance();
    }

    @Override
    public Context getAppContext() {
        return LypApp.getAppContext();
    }

    @Override
    public int getScreenWidth() {
        return (int) (IInitConst.sScreenWidth + 0.5f);
    }

    @Override
    public int getScreenHeight() {
        return (int) (IInitConst.sScreenHeight + 0.5f);
    }

    @Override
    public void loadImgUrl(ImageView iv, String url) {
        if (null != mDefaultImage)
            mDefaultImage.loadImgUrl(iv, url);
    }

    @Override
    public int placeholder() {
        int id = -1;
        if (null != mDefaultImage)
            id = mDefaultImage.placeholder();
        return id;
    }

    @Override
    public void loadImageResourceAsGif(ImageView iv, int resId) {

    }

    @Override
    public Application.ActivityLifecycleCallbacks buildActivityLifecycleCallbacks() {
        return null;
    }

    @Override
    public IActionBar buildActionBar() {
        return new CommonActionBar();
    }

    @Override
    public IBindView buildBindView() {
        return ButterKnifeBindView.getInstance();
    }

    @Override
    public IHeaderNdFooter buildHeaderNdFooter() {
        return null;
    }

    @Override
    public IStatusBar buildStatusBar() {
        return StatusBarTranslucent.getInstance();
    }

    @Override
    public IToast buildToast() {
        return null;
    }

    @Override
    public ILoadingDialogFragment buildLoadingDialogFragment() {
        return new LoadingDialog();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (null == mActivityLifecycleCallbacks)
            mActivityLifecycleCallbacks = DefaultConfig.getInstance().buildActivityLifecycleCallbacks();
        mActivityLifecycleCallbacks.onActivityCreated(activity, savedInstanceState);
    }

    @Override
    public void onActivityStarted(Activity activity) {
        if (null == mActivityLifecycleCallbacks)
            mActivityLifecycleCallbacks = DefaultConfig.getInstance().buildActivityLifecycleCallbacks();
        mActivityLifecycleCallbacks.onActivityStarted(activity);
    }

    @Override
    public void onActivityResumed(Activity activity) {
        if (null == mActivityLifecycleCallbacks)
            mActivityLifecycleCallbacks = DefaultConfig.getInstance().buildActivityLifecycleCallbacks();
        mActivityLifecycleCallbacks.onActivityResumed(activity);
    }

    @Override
    public void onActivityPaused(Activity activity) {
        if (null == mActivityLifecycleCallbacks)
            mActivityLifecycleCallbacks = DefaultConfig.getInstance().buildActivityLifecycleCallbacks();
        mActivityLifecycleCallbacks.onActivityPaused(activity);
    }

    @Override
    public void onActivityStopped(Activity activity) {
        if (null == mActivityLifecycleCallbacks)
            mActivityLifecycleCallbacks = DefaultConfig.getInstance().buildActivityLifecycleCallbacks();
        mActivityLifecycleCallbacks.onActivityStopped(activity);
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        if (null == mActivityLifecycleCallbacks)
            mActivityLifecycleCallbacks = DefaultConfig.getInstance().buildActivityLifecycleCallbacks();
        mActivityLifecycleCallbacks.onActivitySaveInstanceState(activity, outState);
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        if (null == mActivityLifecycleCallbacks)
            mActivityLifecycleCallbacks = DefaultConfig.getInstance().buildActivityLifecycleCallbacks();
        mActivityLifecycleCallbacks.onActivityDestroyed(activity);
    }

    @Override
    public void setLeftImg(int imgResId) {
        if (null == mActionBar)
            mActionBar = DefaultConfig.getInstance().buildActionBar();
        mActionBar.setLeftImg(imgResId);
    }

    @Override
    public void setLeftText(String leftText) {
        if (null == mActionBar)
            mActionBar = DefaultConfig.getInstance().buildActionBar();
        mActionBar.setLeftText(leftText);
    }

    @Override
    public void setTitle(String title) {
        if (null == mActionBar)
            mActionBar = DefaultConfig.getInstance().buildActionBar();
        mActionBar.setTitle(title);
    }

    @Override
    public void setRightImg(int imgResId) {
        if (null == mActionBar)
            mActionBar = DefaultConfig.getInstance().buildActionBar();
        mActionBar.setRightImg(imgResId);
    }

    @Override
    public void setRightText(String rightText) {
        if (null == mActionBar)
            mActionBar = DefaultConfig.getInstance().buildActionBar();
        mActionBar.setRightText(rightText);
    }

    @Override
    public void setActionBarCallback(IActionBarCallback actionBarCallback) {
        if (null == mActionBar)
            mActionBar = DefaultConfig.getInstance().buildActionBar();
        mActionBar.setActionBarCallback(actionBarCallback);
    }

    @Override
    public void header(View header) {
        if (null == mHeaderNdFooter)
            mHeaderNdFooter = DefaultConfig.getInstance().buildHeaderNdFooter();
        mHeaderNdFooter.header(header);
    }

    @Override
    public void footer(View footer) {
        if (null == mHeaderNdFooter)
            mHeaderNdFooter = DefaultConfig.getInstance().buildHeaderNdFooter();
        mHeaderNdFooter.footer(footer);
    }

    @Override
    public void showHeader() {
        if (null == mHeaderNdFooter)
            mHeaderNdFooter = DefaultConfig.getInstance().buildHeaderNdFooter();
        mHeaderNdFooter.showHeader();
    }

    @Override
    public void showFooter() {
        if (null == mHeaderNdFooter)
            mHeaderNdFooter = DefaultConfig.getInstance().buildHeaderNdFooter();
        mHeaderNdFooter.showFooter();
    }

    @Override
    public void hideHeader() {
        if (null == mHeaderNdFooter)
            mHeaderNdFooter = DefaultConfig.getInstance().buildHeaderNdFooter();
        mHeaderNdFooter.hideHeader();
    }

    @Override
    public void hideFooter() {
        if (null == mHeaderNdFooter)
            mHeaderNdFooter = DefaultConfig.getInstance().buildHeaderNdFooter();
        mHeaderNdFooter.hideFooter();
    }

    @Override
    public void bindViews(View view) {
        if (null == mBindView)
            mBindView = DefaultConfig.getInstance().buildBindView();
        mBindView.bindViews(view);
    }

    @Override
    public void unbindView() {
        if (null == mBindView)
            mBindView = DefaultConfig.getInstance().buildBindView();
        mBindView.unbindView();
    }

    @Override
    public void showLoading(FragmentManager manager) {
        if (null == mLoadingDialogFragment)
            mLoadingDialogFragment = DefaultConfig.getInstance().buildLoadingDialogFragment();
        mLoadingDialogFragment.showLoading(manager);
    }

    @Override
    public void dismissLoading() {
        if (null == mLoadingDialogFragment)
            mLoadingDialogFragment = DefaultConfig.getInstance().buildLoadingDialogFragment();
        mLoadingDialogFragment.dismissLoading();
    }

    @Override
    public void setStatusBar(Activity activity) {
        if (null == mStatusBar)
            mStatusBar = DefaultConfig.getInstance().buildStatusBar();
        mStatusBar.setStatusBar(activity);
    }

    @Override
    public void showToast(String msg) {
        if (null == mToast)
            mToast = DefaultConfig.getInstance().buildToast();
        mToast.showToast(msg);
    }

    @Override
    public void showToast(int stringId) {
        if (null == mToast)
            mToast = DefaultConfig.getInstance().buildToast();
        mToast.showToast(stringId);
    }

    @Override
    public void showToast(String msg, int duration) {
        if (null == mToast)
            mToast = DefaultConfig.getInstance().buildToast();
        mToast.showToast(msg, duration);
    }
}
