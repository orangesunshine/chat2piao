package com.orange.chat2piao.base.impl.component;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;

import com.orange.chat2piao.base.ifc.call.IHolder;
import com.orange.chat2piao.base.impl.globle.GlobleImp;
import com.orange.chat2piao.base.ui.recyclerview.RecyclerViewHolder;
import com.orange.chat2piao.utils.ViewUtils;

public class DefaultHolder implements IHolder {

    //所有控件的集合
    protected SparseArray<View> mViews;
    protected View itemView;
    //复用的View
    protected OnItemChildClickListener mOnItemChildClickListener;
    protected OnItemClickListener mOnItemClickListener;

    /**
     * * 提供一个获取ViewHolder的方法
     */
    public static DefaultHolder getDefaultHolder(Context context, ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        return new DefaultHolder(itemView);
    }

    /**
     * 构造函数
     *
     * @param itemView item
     */
    public DefaultHolder(View itemView) {
        this.itemView = itemView;
        mViews = new SparseArray<>();
        //构造方法中就指定布局
        itemView.setTag(this);
    }

    /**
     * 通过ViewId获取控件
     *
     * @param viewId
     * @return
     */
    @Override
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
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
        TextView tv = getView(viewId);
        return setText(tv, text);
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
        ViewUtils.setText(tv, text);
        return this;
    }

    /**
     * 设置文本
     *
     * @param viewId
     * @param stringRes
     */
    @Override
    public IHolder setText(int viewId, int stringRes) {
        TextView tv = getView(viewId);
        return setText(tv, stringRes);
    }

    /**
     * 设置文本
     *
     * @param tv
     * @param stringRes
     */
    @Override
    public IHolder setText(TextView tv, @StringRes int stringRes) {
        ViewUtils.setText(tv, stringRes);
        return this;
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
        TextView tv = getView(viewId);
        return setTextSize(tv, size);
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
        ViewUtils.setTextSize(tv, size);
        return this;
    }

    /**
     * 设置文本颜色
     *
     * @param viewId
     * @param color
     * @return
     */
    @Override
    public IHolder setTextColor(int viewId, @ColorInt int color) {
        TextView tv = getView(viewId);
        return setTextColor(tv, color);
    }

    /**
     * 设置文本颜色
     *
     * @param tv
     * @param color
     * @return
     */
    @Override
    public IHolder setTextColor(TextView tv, @ColorInt int color) {
        ViewUtils.setTextColor(tv, color);
        return this;
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
        ImageView iv = getView(viewId);
        return setImageResource(iv, resId);
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
        ViewUtils.setImageResource(iv, resId);
        return this;
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
        View view = getView(viewId);
        return setBackgroundResource(view, resId);
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
        ViewUtils.setBackgroundResource(view, resId);
        return this;
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
        ImageView iv = getView(viewId);
        return loadImageResourceAsGif(iv, resId);
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
        GlobleImp.getInstance().loadImageResourceAsGif(iv, resId);
        return this;
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
        View view = getView(viewId);
        return setVisible(view, visible);
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
        ViewUtils.setVisible(view, visible);
        return this;
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
        View view = getView(viewId);
        return setSelect(view, selected);
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
        ViewUtils.setSelect(view, selected);
        return this;
    }

    /**
     * 设置项点击事件
     *
     * @param listener
     * @return
     */
    @Override
    public IHolder setOnItemClick(OnItemClickListener listener) {
        mOnItemClickListener = listener;
        if (null != itemView)
            itemView.setOnClickListener(this);
        return this;
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
        if (null == viewIds || viewIds.length == 0) return this;
        mOnItemChildClickListener = listener;
        for (int viewId : viewIds) {
            View view = getView(viewId);
            if (null != view)
                view.setOnClickListener(this);
        }
        return this;
    }

    /**
     * 清空view容器
     */
    @Override
    public void clear() {
        if (null != mViews)
            mViews.clear();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v == itemView) {
            if (null != mOnItemClickListener) {
                RecyclerViewHolder tag = (RecyclerViewHolder) itemView.getTag();
                mOnItemClickListener.onItemClick(v, tag.getAdapterPosition());
            }
        } else {
            if (null != mOnItemChildClickListener) {
                mOnItemChildClickListener.onItemChildClick(v);
            }
        }
    }
}
