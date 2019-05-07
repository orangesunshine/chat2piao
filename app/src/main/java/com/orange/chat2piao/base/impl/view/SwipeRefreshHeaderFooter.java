package com.orange.chat2piao.base.impl.view;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.ifc.view.ifc.IHeaderNdFooter;
import com.orange.chat2piao.utils.Preconditions;
import com.orange.chat2piao.utils.ViewHelper;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SwipeRefreshHeaderFooter implements IHeaderNdFooter<SwipeRefreshLayout, TextView> {
    //views
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout swiperereshlayout;
    @BindView(R.id.swiperefreshlayout_footer)
    TextView tvFooter;

    //vars
    private Unbinder mUnbinder;

    @Override
    public void header(SwipeRefreshLayout header) {
        Preconditions.checkNotNull(header);
        swiperereshlayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light);
    }

    @Override
    public void footer(TextView footer) {
        Preconditions.checkNotNull(footer);
        footer.setTextAppearance(footer.getContext(), R.style.swiperefreshlayout_footer);
    }

    @Override
    public void showHeader() {
        Preconditions.checkNotNull(swiperereshlayout);
        swiperereshlayout.setRefreshing(true);
    }

    @Override
    public void showFooter() {
        ViewHelper.setVisible(tvFooter, true);
    }

    @Override
    public void hideHeader() {
        Preconditions.checkNotNull(swiperereshlayout);
        swiperereshlayout.setRefreshing(false);
    }

    @Override
    public void hideFooter() {
        ViewHelper.setVisible(tvFooter, false);
    }

    @Override
    public void bindViews(Activity activity) {
        mUnbinder = ButterKnife.bind(this, activity);
    }

    @Override
    public void unbindView() {
        if (null != mUnbinder)
            mUnbinder.unbind();
    }
}
