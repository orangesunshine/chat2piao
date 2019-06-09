package com.orange.chat2piao.base.ui.activity.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentActivity;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.ifc.callback.IActvityAlive;
import com.orange.chat2piao.base.ifc.callback.IContentView;
import com.orange.chat2piao.base.ifc.callback.ICreatedNdDestroy;
import com.orange.chat2piao.base.ifc.callback.IInit;
import com.orange.chat2piao.base.ifc.callback.IInitVars;
import com.orange.chat2piao.base.ifc.component.IActionBar;
import com.orange.chat2piao.base.ifc.component.IBindView;
import com.orange.chat2piao.base.ifc.component.IStatusBar;
import com.orange.chat2piao.base.ifc.component.IToast;
import com.orange.chat2piao.base.ifc.component.generate.IBuildActionBar;
import com.orange.chat2piao.base.ifc.component.generate.IBuildBindView;
import com.orange.chat2piao.base.ifc.component.generate.IBuildStatusBar;
import com.orange.chat2piao.base.ifc.component.generate.IBuildToast;
import com.orange.chat2piao.base.ifc.view.IView;
import com.orange.chat2piao.base.impl.component.CommonActionBar;
import com.orange.chat2piao.base.impl.component.StatusBarTranslucent;
import com.orange.chat2piao.base.impl.component.ToastImpl;
import com.orange.chat2piao.base.impl.component.ViewHolderBindView;
import com.orange.chat2piao.base.impl.globle.GlobleImp;
import com.orange.chat2piao.utils.Preconditions;

public abstract class BaseActivity<V extends IView> extends FragmentActivity implements IContentView, ICreatedNdDestroy, IActvityAlive, IBuildStatusBar, IBuildActionBar, IBuildBindView, IBuildToast, IInitVars, IInit {


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
        FrameLayout flContent = LayoutInflater.from(activity).inflate(R.layout.activity_base, content, true).findViewById(R.id.fl_content);
        LayoutInflater.from(activity).inflate(getContentLayoutId(), flContent, true);

        //初始化操作
        initVars(bundle);

        //bindViews
        if (null == mBindView)
            mBindView = GlobleImp.getInstance().buildBindView();
        mBindView.bindViews(content);

        //statusbar
        if (null == mStatusBar)
            mStatusBar = GlobleImp.getInstance().buildStatusBar();
        mStatusBar.setStatusBar(activity);

        //actionbar
        if (null == mActionBar)
            mActionBar = GlobleImp.getInstance().buildActionBar();
        mActionBar.bindViews(content);

        //toast
        if (null == mToast)
            mToast = GlobleImp.getInstance().buildToast();

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
        Preconditions.checkNotNull(mBindView);
        mBindView.unbindView();
        Preconditions.checkNotNull(mActionBar);
        mActionBar.unbindView();
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
    protected IBindView mBindView;

    /**
     * 绑定控件
     *
     * @return
     */
    @Override
    public IBindView buildBindView() {
        return new ViewHolderBindView();
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
     * @param bundle
     */
    @Override
    public void initVars(Bundle bundle) {
        mActivity = this;
        mActivityAlive = true;
        mBindView = buildBindView();
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
