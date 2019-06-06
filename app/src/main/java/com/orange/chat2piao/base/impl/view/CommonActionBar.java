package com.orange.chat2piao.base.impl.view;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.ifc.listener.IActionBarCallback;
import com.orange.chat2piao.base.ifc.view.ifc.IActionBar;
import com.orange.chat2piao.utils.ViewHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 *
 */
public class CommonActionBar implements IActionBar<LinearLayout> {
    //views
    @BindView(R.id.iv_left_actbar)
    ImageView ivLeftActbar;
    @BindView(R.id.tv_left_actbar)
    TextView tvLeftActbar;
    @BindView(R.id.tv_title_actbar)
    TextView tvTitleActbar;
    @BindView(R.id.iv_right_actbar)
    ImageView ivRightActbar;
    @BindView(R.id.tv_right_actbar)
    TextView tvRightActbar;

    //vars
    private Unbinder mUnbinder;
    private IActionBarCallback mActionBarCallback;

    @Override
    public void setActionBarCallback(IActionBarCallback actionBarCallback) {
        mActionBarCallback = actionBarCallback;
    }

    @Override
    public void setLeftImg(int imgResId) {
        ViewHelper.setVisible(ivLeftActbar, true);
        ViewHelper.setVisible(tvLeftActbar, false);
        ViewHelper.setImageResource(ivLeftActbar, imgResId);
    }

    @Override
    public void setLeftText(String leftText) {
        ViewHelper.setVisible(ivLeftActbar, false);
        ViewHelper.setVisible(tvLeftActbar, true);
        ViewHelper.setText(tvLeftActbar, leftText);
    }

    @Override
    public void setTitle(String title) {
        ViewHelper.setText(tvTitleActbar, title);
    }

    @Override
    public void setRightImg(int imgResId) {
        ViewHelper.setVisible(ivRightActbar, true);
        ViewHelper.setVisible(tvRightActbar, false);
        ViewHelper.setImageResource(ivRightActbar, imgResId);
    }

    @Override
    public void setRightText(String rightText) {
        ViewHelper.setVisible(ivRightActbar, false);
        ViewHelper.setVisible(tvRightActbar, true);
        ViewHelper.setText(tvRightActbar, rightText);
    }

    @OnClick({R.id.fl_left_actbar, R.id.fl_right_actbar, R.id.fl_title_actbar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fl_left_actbar:
                if (null != mActionBarCallback)
                    mActionBarCallback.onLeft();
                break;
            case R.id.fl_title_actbar:
                if (null != mActionBarCallback)
                    mActionBarCallback.onCenter();
                break;
            case R.id.fl_right_actbar:
                if (null != mActionBarCallback)
                    mActionBarCallback.onRight();
                break;
        }
    }

    @Override
    public void bindViews(View veiw) {
        mUnbinder = ButterKnife.bind(this, veiw);
    }

    @Override
    public void unbindView() {
        if (null != mUnbinder)
            mUnbinder.unbind();
    }
}
