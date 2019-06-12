package com.orange.chat2piao.base.demo.activity;

import com.orange.chat2piao.R;
import com.orange.chat2piao.base.actbar.IActionBarCallback;
import com.orange.chat2piao.base.mvp.view.activity.base.BaseActivity;

import java.util.Random;

public class BaseActivityDemo extends BaseActivity {
    private Random mRandom = new Random();

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_template_actbar;
    }

    @Override
    public void init() {
        super.init();
        testBindview();
    }

    private void testBindview() {
        mHolder.setOnItemChildClick(v -> {
            switch (v.getId()) {
                case R.id.btn_actbar:
                    testActbar();
                    break;
                case R.id.btn_bindview:
                    break;
                case R.id.btn_statusbar:
                    testStatusbar();
                    break;
                case R.id.btn_toast:
                    testToast();
                    break;
            }
        }, R.id.btn_actbar, R.id.btn_bindview, R.id.btn_statusbar, R.id.btn_toast);
    }

    private void testStatusbar() {
        mStatusBar.setStatusBar(mActivity);
    }

    private void testActbar() {
        mActionBar.setActionBarCallback(new IActionBarCallback() {
            @Override
            public void onLeft() {
                mToast.showToast("onLeft");
            }

            @Override
            public void onCenter() {
                mToast.showToast("onCenter");
            }

            @Override
            public void onRight() {
                mToast.showToast("onRight");
            }
        });
        int random = mRandom.nextInt(5);
        switch (random) {
            case 0:
                mActionBar.setLeftText("取消");
                break;
            case 1:
                mActionBar.setLeftImg(R.drawable.ic_photo_gray);
                break;
            case 2:
                mActionBar.setRightText("确定");
                break;
            case 3:
                mActionBar.setRightImg(R.drawable.ic_image_white);
                break;
            case 4:
                mActionBar.setTitle("标题");
                break;
        }
    }

    private void testToast() {
        int random = mRandom.nextInt(2);
        if (0 == random) {
            mToast.showToast(R.string.loading_dialog);
        } else {
            mToast.showToast("测试");
        }
    }
}
