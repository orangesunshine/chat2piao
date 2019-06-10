package com.orange.chat2piao.base.ifc.component;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public interface IFindView {
    /**
     * 根据viewId获取控件
     *
     * @param viewId
     * @param <T>
     * @return
     */
    <T extends View> T getView(int viewId);

    /**
     * 通过ViewId获取TextView控件
     *
     * @param viewId
     * @return
     */
    TextView getTextView(int viewId);

    /**
     * 通过ViewId获取ImageView控件
     *
     * @param viewId
     * @return
     */
    ImageView getImageView(int viewId);
}
