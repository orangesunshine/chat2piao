package com.orange.chat2piao.base.ifc.call;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;

public interface IHolder extends View.OnClickListener, IFindView {

    /**
     * 设置文本
     *
     * @param viewId
     * @param text
     * @return
     */
    IHolder setText(int viewId, CharSequence text);

    /**
     * 设置文本
     *
     * @param tv
     * @param text
     * @return
     */
    IHolder setText(TextView tv, CharSequence text);

    /**
     * 设置文本
     *
     * @param viewId
     * @param stringRes
     */
    IHolder setText(int viewId, @StringRes int stringRes);

    /**
     * 设置文本
     *
     * @param tv
     * @param stringRes
     */
    IHolder setText(TextView tv, @StringRes int stringRes);

    /**
     * 设置文本大小
     *
     * @param viewId
     * @param size
     * @return
     */
    IHolder setTextSize(int viewId, float size);

    /**
     * 设置文本大小
     *
     * @param tv
     * @param size
     * @return
     */
    IHolder setTextSize(TextView tv, float size);

    /**
     * 设置文本颜色
     *
     * @param viewId
     * @param color
     * @return
     */
    IHolder setTextColor(int viewId, @ColorRes int color);

    /**
     * 设置文本颜色
     *
     * @param tv
     * @param color
     * @return
     */
    IHolder setTextColor(TextView tv, @ColorRes int color);

    /**
     * 设置图片资源
     *
     * @param viewId
     * @param resId
     * @return
     */
    IHolder setImageResource(int viewId, int resId);

    /**
     * 设置图片资源
     *
     * @param iv
     * @param resId
     * @return
     */
    IHolder setImageResource(ImageView iv, int resId);

    /**
     * 设置背景图片资源
     *
     * @param viewId
     * @param resId
     * @return
     */
    IHolder setBackgroundResource(int viewId, int resId);

    /**
     * 设置背景图片资源
     *
     * @param view
     * @param resId
     * @return
     */
    IHolder setBackgroundResource(View view, int resId);

    /**
     * 加载gif图片资源
     *
     * @param viewId
     * @param resId
     * @return
     */
    IHolder loadImageResourceAsGif(int viewId, int resId);

    /**
     * 加载gif图片资源
     *
     * @param iv
     * @param resId
     * @return
     */
    IHolder loadImageResourceAsGif(ImageView iv, int resId);

    /**
     * viewId设置可见性
     *
     * @param viewId
     * @param visible
     * @return
     */
    IHolder setVisible(int viewId, boolean visible);

    /**
     * view设置可见性
     *
     * @param view
     * @param visible
     * @return
     */
    IHolder setVisible(View view, boolean visible);

    /**
     * viewId设置选中
     *
     * @param viewId
     * @param selected
     * @return
     */
    IHolder setSelect(int viewId, boolean selected);

    /**
     * view设置选中
     *
     * @param view
     * @param selected
     * @return
     */
    IHolder setSelect(View view, boolean selected);

    /**
     * 设置项点击事件
     *
     * @param listener
     * @return
     */
    IHolder setOnItemClick(OnItemClickListener listener);

    /**
     * 设置项子控件点击事件
     *
     * @param listener
     * @param viewIds
     * @return
     */
    IHolder setOnItemChildClick(OnItemChildClickListener listener, int... viewIds);

    /**
     * 清空view容器
     */
    void clear();

    /**
     * 项子控件点击事件监听
     */
    interface OnItemChildClickListener {
        void onItemChildClick(View v);
    }

    /**
     * 项点击事件监听
     */
    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }
}
