package com.orange.chat2piao.utils;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;

public class ViewHelper {
    /**
     * 为文本设置text
     *
     * @param text 文本
     * @return 返回ViewHolder
     */
    public static void setText(TextView tv, String text) {
        Preconditions.checkNotNull(tv);
        if (TextUtils.isEmpty(text))
            text = "";
        tv.setText(text);
    }

    /**
     * 为文本设置text
     *
     * @param tv
     * @param color
     * @return 返回ViewHolder
     */
    public static void setTextColor(TextView tv, @ColorInt int color) {
        Preconditions.checkNotNull(tv);
        tv.setTextColor(color);
    }

    /**
     * 为文本设置text
     *
     * @param tv
     * @param size
     * @return 返回ViewHolder
     */
    public static void setTextSize(TextView tv, float size) {
        Preconditions.checkNotNull(tv);
        tv.setTextSize(size);
    }

    /**
     * setVisibility
     *
     * @param view
     * @param visible
     * @return
     */
    public static void setVisible(View view, boolean visible) {
        Preconditions.checkNotNull(view);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    /**
     * @param view
     * @param color
     * @return
     */
    public static void setBackgroudColor(View view, @ColorInt int color) {
        Preconditions.checkNotNull(view);
        view.setBackgroundColor(color);
    }

    /**
     * @param view
     * @param imageResId
     * @return
     */
    public static void setImageResource(View view, @DrawableRes int imageResId) {
        Preconditions.checkNotNull(view);
        view.setBackgroundResource(imageResId);
    }
}
