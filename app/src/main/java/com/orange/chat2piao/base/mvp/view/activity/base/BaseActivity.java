package com.orange.chat2piao.base.mvp.view.activity.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentActivity;

import com.orange.chat2piao.base.generate.IBuildActionBar;
import com.orange.chat2piao.base.actbar.CommonActionBar;
import com.orange.chat2piao.base.common.holder.DefaultHolder;
import com.orange.chat2piao.base.toast.ToastImpl;
import com.orange.chat2piao.base.common.DefaultConfig;
import com.orange.chat2piao.base.mvp.view.IView;
import com.orange.chat2piao.base.common.holder.IAttachHolder;
import com.orange.chat2piao.base.common.IContentView;
import com.orange.chat2piao.base.common.holder.IHolder;
import com.orange.chat2piao.base.actbar.IActionBar;
import com.orange.chat2piao.base.statusbar.IStatusBar;
import com.orange.chat2piao.base.toast.IToast;
import com.orange.chat2piao.thirdParty.statusbar.StatusBarTranslucent;

public abstract class BaseActivity<V extends IView> extends FragmentActivity implements IContentView, IBuildActionBar {
    // <editor-fold defaultstate="collapsed" desc="初始化变量">
    protected BaseActivity mActivity;
    protected IToast mToast;
    protected IHolder mHolder;
    protected IStatusBar mStatusBar;
    protected IActionBar mActionBar;

    private boolean mActivityAlive;

    /**
     * 初始化
     *
     * @param bundle
     */
    public void initVars(Bundle bundle) {
        mActivity = this;
        mActivityAlive = true;
        mHolder = new DefaultHolder(getWindow().getDecorView().findViewById(android.R.id.content));
        mStatusBar = StatusBarTranslucent.getInstance();
        mActionBar = buildActionBar();
        mToast = new ToastImpl();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="生命周期回调方法">

    /**
     * 创建生命周期回调
     *
     * @param activity
     * @param bundle
     */
    public void onActivityCreate(Activity activity, Bundle bundle) {
        FrameLayout content = getWindow().getDecorView().findViewById(android.R.id.content);
        content.removeAllViews();
        LayoutInflater.from(activity).inflate(getContentLayoutId(), content, true);

        //初始化操作
        initVars(bundle);

        //statusbar
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
    public void onActivityDestroy(BaseActivity context) {
        mActivityAlive = false;
        if (null != mHolder)
            mHolder.clear();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="判断activity 是不是活的">

    /**
     * 判断activity 是不是活的
     *
     * @return
     */
    public boolean isActivityAlive() {
        return mActivityAlive;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="创建标题栏">

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

    // <editor-fold defaultstate="collapsed" desc="初始化（控件相关）">

    /**
     * 初始化（控件相关）
     */
    public void init() {

    }
    // </editor-fold>
}
