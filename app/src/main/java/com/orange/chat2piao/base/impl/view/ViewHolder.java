package com.orange.chat2piao.base.impl.view;

import android.app.Activity;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import com.orange.chat2piao.utils.Preconditions;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;

public class ViewHolder {
    //所有控件的集合
    private SparseArray<View> mViews;

    private View mDecorView;

    public ViewHolder(View view) {
        Preconditions.checkNotNull(view);
        mDecorView = view;
    }

    /**
     * 通过ViewId获取控件
     *
     * @param viewId View的Id
     * @param <T>    View的子类
     * @return 返回View
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mDecorView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 为文本设置text
     *
     * @param viewId view的Id
     * @param text   文本
     * @return 返回ViewHolder
     */
    public ViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        Preconditions.checkNotNull(tv);
        if (TextUtils.isEmpty(text))
            text = "";
        tv.setText(text);
        return this;
    }

    /**
     * 为文本设置text
     *
     * @param viewId
     * @param color
     * @return 返回ViewHolder
     */
    public ViewHolder setTextColor(int viewId, @ColorInt int color) {
        TextView tv = getView(viewId);
        Preconditions.checkNotNull(tv);
        tv.setTextColor(color);
        return this;
    }

    /**
     * 为文本设置text
     *
     * @param viewId
     * @param size
     * @return 返回ViewHolder
     */
    public ViewHolder setTextSize(int viewId, float size) {
        TextView tv = getView(viewId);
        Preconditions.checkNotNull(tv);
        tv.setTextSize(size);
        return this;
    }

    /**
     * setVisibility
     *
     * @param viewId
     * @param visible
     * @return
     */
    public ViewHolder setVisible(int viewId, boolean visible) {
        View view = getView(viewId);
        Preconditions.checkNotNull(view);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    /**
     * @param viewId
     * @param color
     * @return
     */
    public ViewHolder setBackgroudColor(int viewId, @ColorInt int color) {
        View view = getView(viewId);
        Preconditions.checkNotNull(view);
        view.setBackgroundColor(color);
        return this;
    }

    /**
     * @param viewId
     * @param imageResId
     * @return
     */
    public ViewHolder setImageResource(int viewId, @DrawableRes int imageResId) {
        View view = getView(viewId);
        Preconditions.checkNotNull(view);
        view.setBackgroundResource(imageResId);
        return this;
    }

    /**
     * 清空
     */
    public void clear() {
        if (null != mViews) {
            mViews.clear();
            mViews = null;
        }
    }
}
