package com.orange.chat2piao.base.ifc.call;

import android.view.View;

public interface IFindView {
    /**
     * 根据viewId获取控件
     *
     * @param viewId
     * @param <T>
     * @return
     */
    <T extends View> T getView(int viewId);
}
