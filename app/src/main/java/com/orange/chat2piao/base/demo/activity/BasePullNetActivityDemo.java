package com.orange.chat2piao.base.demo.activity;

import androidx.recyclerview.widget.RecyclerView;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.demo.presenter.PullDemoPresenter;
import com.orange.chat2piao.base.ifc.component.IRefreshNdLoadmore;
import com.orange.chat2piao.base.ui.activity.PullNetActivity;
import com.orange.chat2piao.base.ui.recyclerview.CommonAdapter;
import com.orange.chat2piao.thirdParty.smartfreshlayout.SmartRefreshNdLoadmore;

public class BasePullNetActivityDemo extends PullNetActivity<PullDemoPresenter> {
    private RecyclerView mRecyclerView;
    private CommonAdapter mCommonAdapter;

    /**
     * 获取contentLayout
     *
     * @return
     */
    @Override
    public int getContentLayoutId() {
        return R.layout.activity_demo_pull;
    }

    @Override
    public IRefreshNdLoadmore buildHeaderNdFooter() {
        return new SmartRefreshNdLoadmore();
    }

    /**
     * 初始化（控件相关）
     */
    @Override
    public void init() {
        super.init();
        mRecyclerView = mHolder.getView(R.id.recyclerview);
    }
}
