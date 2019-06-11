package com.orange.chat2piao.base.ui.activity.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentActivity;

import com.orange.chat2piao.base.ifc.call.IAttachHolder;
import com.orange.chat2piao.base.ifc.call.IContentView;
import com.orange.chat2piao.base.ifc.call.IHolder;
import com.orange.chat2piao.base.ifc.call.activity.IActvityAlive;
import com.orange.chat2piao.base.ifc.call.activity.ICreatedNdDestroy;
import com.orange.chat2piao.base.ifc.call.activity.IInit;
import com.orange.chat2piao.base.ifc.call.activity.IInitVars;
import com.orange.chat2piao.base.ifc.component.IActionBar;
import com.orange.chat2piao.base.ifc.component.IStatusBar;
import com.orange.chat2piao.base.ifc.component.IToast;
import com.orange.chat2piao.base.ifc.generate.IBuildActionBar;
import com.orange.chat2piao.base.ifc.generate.IBuildHolder;
import com.orange.chat2piao.base.ifc.generate.IBuildStatusBar;
import com.orange.chat2piao.base.ifc.generate.IBuildToast;
import com.orange.chat2piao.base.ifc.view.IView;
import com.orange.chat2piao.base.impl.component.CommonActionBar;
import com.orange.chat2piao.base.impl.component.DefaultHolder;
import com.orange.chat2piao.base.impl.defaultImp.DefaultConfig;
import com.orange.chat2piao.thirdParty.statusbar.StatusBarTranslucent;
import com.orange.chat2piao.base.impl.component.ToastImpl;
import com.orange.chat2piao.base.impl.globle.GlobleImpl;

public abstract class BaseActivity<V extends IView> extends FragmentActivity implements IContentView, ICreatedNdDestroy, IActvityAlive, IInitVars, IInit, IBuildStatusBar, IBuildActionBar, IBuildHolder, IBuildToast {
    // <editor-fold defaultstate="collapsed" desc="生命周期回调方法">

    /**
     * 创建生命周期回调
     *
     * @param activity
     * @param bundle
     */
    @Override
    public void onActivityCreate(BaseActivity activity, Bundle bundle) {
        FrameLayout content = getWindow().getDecorView().findViewById(android.R.id.content);
        content.removeAllViews();
        LayoutInflater.from(activity).inflate(getContentLayoutId(), content, true);

        //初始化操作
        initVars(activity, bundle);

        //bindViews
        if (null == mHolder)
            mHolder = DefaultConfig.getInstance().buildHolder(content);

        //statusbar
        if (null == mStatusBar)
            mStatusBar = DefaultConfig.getInstance().buildStatusBar();
        mStatusBar.setStatusBar(activity);

        //actionbar
        if (null == mActionBar)
            mActionBar = DefaultConfig.getInstance().buildActionBar();
        if (mActionBar instanceof IAttachHolder)
            ((IAttachHolder) mActionBar).attachHolder(mHolder);

        //toast
        if (null == mToast)
            mToast = DefaultConfig.getInstance().buildToast();

        //初始化
        init();
    }


    /**
     * 销毁生命周期回调
     *
     * @param context
     */
    @Override
    public void onActivityDestroy(BaseActivity context) {
        mActivityAlive = false;
        if (null != mHolder)
            mHolder.clear();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="判断activity 是不是活的">
    private boolean mActivityAlive;

    /**
     * 判断activity 是不是活的
     *
     * @return
     */
    @Override
    public boolean isActivityAlive() {
        return mActivityAlive;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="状态栏">
    protected IStatusBar mStatusBar;

    /**
     * 状态栏
     *
     * @return
     */
    @Override
    public IStatusBar buildStatusBar() {
        return StatusBarTranslucent.getInstance();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="绑定控件">
    protected IHolder mHolder;

    /**
     * 绑定控件
     *
     * @return
     */
    @Override
    public IHolder buildHolder(View view) {
        return new DefaultHolder(view);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="创建标题栏">
    protected IActionBar mActionBar;

    /**
     * 创建标题栏
     *
     * @return
     */
    @Override
    public IActionBar buildActionBar() {
        return new CommonActionBar();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="创建toast">
    protected IToast mToast;

    /**
     * 创建toast
     *
     * @return
     */
    @Override
    public IToast buildToast() {
        return new ToastImpl();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="初始化变量">
    protected BaseActivity mActivity;

    /**
     * 初始化
     *
     * @param activity
     * @param bundle
     */
    @Override
    public void initVars(BaseActivity activity, Bundle bundle) {
        mActivity = this;
        mActivityAlive = true;
        mHolder = buildHolder(getWindow().getDecorView().findViewById(android.R.id.content));
        mStatusBar = buildStatusBar();
        mActionBar = buildActionBar();
        mToast = buildToast();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="初始化（控件相关）">

    /**
     * 初始化（控件相关）
     */
    @Override
    public void init() {

    }
    // </editor-fold>
}
