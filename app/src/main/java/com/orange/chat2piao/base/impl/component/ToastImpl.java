package com.orange.chat2piao.base.impl.component;

import com.blankj.utilcode.util.ToastUtils;
import com.orange.chat2piao.base.ifc.component.IToast;

public class ToastImpl implements IToast {
    @Override
    public void showToast(CharSequence text) {
        ToastUtils.showShort(text);
    }

    @Override
    public void showToast(int stringId) {
        ToastUtils.showShort(stringId);
    }
}
