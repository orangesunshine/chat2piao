package com.orange.chat2piao.ui.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

import com.orange.chat2piao.base.common.holder.IHolder;
import com.orange.chat2piao.base.common.holder.DefaultHolder;

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements IHolder, View.OnClickListener {
    private IHolder mHolder;

    /**
     * * 提供一个获取ViewHolder的方法
     */
    public static RecyclerViewHolder getRecyclerViewHolder(Context context, ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    /**
     * 构造函数
     *
     * @param itemView item
     */
    public RecyclerViewHolder(View itemView) {
        super(itemView);
        mHolder = new DefaultHolder(itemView);
    }

    /**
     * 通过ViewId获取控件
     *
     * @param viewId
     * @return
     */
    @Override
    public <T extends View> T getView(int viewId) {
        return null == mHolder ? null : mHolder.getView(viewId);
    }

    /**
     * 设置文本
     *
     * @param viewId
     * @param text
     * @return
     */
    @Override
    public IHolder setText(int viewId, CharSequence text) {
        return null == mHolder ? null : mHolder.setText(viewId, text);
    }

    /**
     * 设置文本
     *
     * @param tv
     * @param text
     * @return
     */
    @Override
    public IHolder setText(TextView tv, CharSequence text) {
        return null == mHolder ? null : mHolder.setText(tv, text);
    }

    /**
     * 设置文本
     *
     * @param viewId
     * @param stringRes
     */
    @Override
    public IHolder setText(int viewId, int stringRes) {
        return null == mHolder ? null : mHolder.setText(viewId, stringRes);
    }

    /**
     * 设置文本
     *
     * @param tv
     * @param stringRes
     */
    @Override
    public IHolder setText(TextView tv, @StringRes int stringRes) {
        return null == mHolder ? null : mHolder.setText(tv, stringRes);
    }

    /**
     * 设置文本大小
     *
     * @param viewId
     * @param size
     * @return
     */
    @Override
    public IHolder setTextSize(int viewId, float size) {
        return null == mHolder ? null : mHolder.setTextSize(viewId, size);
    }

    /**
     * 设置文本大小
     *
     * @param tv
     * @param size
     * @return
     */
    @Override
    public IHolder setTextSize(TextView tv, float size) {
        return null == mHolder ? null : mHolder.setTextSize(tv, size);
    }

    /**
     * 设置文本颜色
     *
     * @param viewId
     * @param color
     * @return
     */
    @Override
    public IHolder setTextColor(int viewId, int color) {
        return null == mHolder ? null : mHolder.setTextColor(viewId, color);
    }

    /**
     * 设置文本颜色
     *
     * @param tv
     * @param color
     * @return
     */
    @Override
    public IHolder setTextColor(TextView tv, int color) {
        return null == mHolder ? null : mHolder.setTextColor(tv, color);
    }

    /**
     * 设置图片资源
     *
     * @param viewId
     * @param resId
     * @return
     */
    @Override
    public IHolder setImageResource(int viewId, int resId) {
        return null == mHolder ? null : mHolder.setImageResource(viewId, resId);
    }

    /**
     * 设置图片资源
     *
     * @param iv
     * @param resId
     * @return
     */
    @Override
    public IHolder setImageResource(ImageView iv, int resId) {
        return null == mHolder ? null : mHolder.setImageResource(iv, resId);
    }

    /**
     * 设置背景图片资源
     *
     * @param viewId
     * @param resId
     * @return
     */
    @Override
    public IHolder setBackgroundResource(int viewId, int resId) {
        return null == mHolder ? null : mHolder.setBackgroundResource(viewId, resId);
    }

    /**
     * 设置背景图片资源
     *
     * @param view
     * @param resId
     * @return
     */
    @Override
    public IHolder setBackgroundResource(View view, int resId) {
        return null == mHolder ? null : mHolder.setBackgroundResource(view, resId);
    }

    /**
     * 加载gif图片资源
     *
     * @param viewId
     * @param resId
     * @return
     */
    @Override
    public IHolder loadImageResourceAsGif(int viewId, int resId) {
        return null == mHolder ? null : mHolder.loadImageResourceAsGif(viewId, resId);
    }

    /**
     * 加载gif图片资源
     *
     * @param iv
     * @param resId
     * @return
     */
    @Override
    public IHolder loadImageResourceAsGif(ImageView iv, int resId) {
        return null == mHolder ? null : mHolder.loadImageResourceAsGif(iv, resId);
    }

    /**
     * viewId设置可见性
     *
     * @param viewId
     * @param visible
     * @return
     */
    @Override
    public IHolder setVisible(int viewId, boolean visible) {
        return null == mHolder ? null : mHolder.setVisible(viewId, visible);
    }

    /**
     * view设置可见性
     *
     * @param view
     * @param visible
     * @return
     */
    @Override
    public IHolder setVisible(View view, boolean visible) {
        return null == mHolder ? null : mHolder.setVisible(view, visible);
    }

    /**
     * viewId设置选中
     *
     * @param viewId
     * @param selected
     * @return
     */
    @Override
    public IHolder setSelect(int viewId, boolean selected) {
        return null == mHolder ? null : mHolder.setSelect(viewId, selected);
    }

    /**
     * view设置选中
     *
     * @param view
     * @param selected
     * @return
     */
    @Override
    public IHolder setSelect(View view, boolean selected) {
        return null == mHolder ? null : mHolder.setSelect(view, selected);
    }

    /**
     * 设置项点击事件
     *
     * @param listener
     * @return
     */
    @Override
    public IHolder setOnItemClick(OnItemClickListener listener) {
        return null == mHolder ? null : mHolder.setOnItemClick(listener);
    }

    /**
     * 设置项子控件点击事件
     *
     * @param listener
     * @param viewIds
     * @return
     */
    @Override
    public IHolder setOnItemChildClick(OnItemChildClickListener listener, int... viewIds) {
        return null == mHolder ? null : mHolder.setOnItemChildClick(listener, viewIds);
    }

    /**
     * 清空view容器
     */
    @Override
    public void clear() {
        if (null != mHolder) mHolder.clear();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (null != mHolder) mHolder.onClick(v);
    }
}
