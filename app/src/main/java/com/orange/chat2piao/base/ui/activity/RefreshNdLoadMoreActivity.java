package com.orange.chat2piao.base.ui.activity;

import android.app.Activity;

import com.orange.chat2piao.base.ifc.presenter.IRefreshNdLoadMorePresenter;
import com.orange.chat2piao.base.ifc.view.ifc.IPullDownUp;
import com.orange.chat2piao.base.ifc.view.ifc.build.IBuildPullDownUp;
import com.orange.chat2piao.base.impl.defaultImp.DefaultConfig;
import com.orange.chat2piao.utils.Preconditions;

public abstract class RefreshNdLoadMoreActivity<T, P extends IRefreshNdLoadMorePresenter<T>> extends NetActivity<T, P> implements IBuildPullDownUp, IPullDownUp {
    protected IPullDownUp mBuildPullDownUp;

    @Override
    public void onActivityCreate(Activity activity) {
        super.onActivityCreate(activity);
        //pullndload
        mBuildPullDownUp = buidPullDownUp();
        if (null == mBuildPullDownUp)
            mBuildPullDownUp = DefaultConfig.getInstance().buidPullDownUp();
    }

    @Override
    public IPullDownUp buidPullDownUp() {
        return null;
    }

    @Override
    public void showPullDown() {
        Preconditions.checkNotNull(mBuildPullDownUp);
        mBuildPullDownUp.showPullDown();
    }

    @Override
    public void showPullUp() {
        Preconditions.checkNotNull(mBuildPullDownUp);
        mBuildPullDownUp.showPullUp();
    }
}
