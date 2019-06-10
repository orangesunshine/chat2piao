package com.orange.chat2piao.base.impl.component;

import android.view.View;
import android.widget.LinearLayout;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.ifc.component.IActionBar;
import com.orange.chat2piao.base.ifc.call.IAttachHolder;
import com.orange.chat2piao.base.ifc.call.IHolder;
import com.orange.chat2piao.base.ifc.callback.IActionBarCallback;

import butterknife.OnClick;

/**
 *
 */
public class CommonActionBar implements IActionBar<LinearLayout>, IAttachHolder {

    //vars
    private IHolder mHolder;
    private IActionBarCallback mActionBarCallback;

    @Override
    public void setActionBarCallback(IActionBarCallback actionBarCallback) {
        mActionBarCallback = actionBarCallback;
    }

    @Override
    public void setLeftImg(int imgResId) {
        if (null != mHolder) {
            mHolder.setVisible(R.id.iv_left_actbar, true);
            mHolder.setVisible(R.id.tv_left_actbar, false);
            mHolder.setImageResource(R.id.iv_left_actbar, imgResId);
        }
    }

    @Override
    public void setLeftText(String leftText) {
        if (null != mHolder) {
            mHolder.setVisible(R.id.iv_left_actbar, false);
            mHolder.setVisible(R.id.tv_left_actbar, true);
            mHolder.setText(R.id.tv_left_actbar, leftText);
        }
    }

    @Override
    public void setTitle(String title) {
        if (null != mHolder)
            mHolder.setText(R.id.tv_title_actbar, title);
    }

    @Override
    public void setRightImg(int imgResId) {
        if (null != mHolder) {
            mHolder.setVisible(R.id.iv_right_actbar, true);
            mHolder.setVisible(R.id.tv_right_actbar, false);
            mHolder.setImageResource(R.id.iv_right_actbar, imgResId);
        }
    }

    @Override
    public void setRightText(String rightText) {
        if (null != mHolder) {
            mHolder.setVisible(R.id.iv_right_actbar, false);
            mHolder.setVisible(R.id.tv_right_actbar, true);
            mHolder.setText(R.id.tv_right_actbar, rightText);
        }
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

    /**
     * 跟视图
     *
     * @param holder
     */
    @Override
    public void attachHolder(IHolder holder) {
        mHolder = holder;
    }
}
