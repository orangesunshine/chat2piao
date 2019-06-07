package com.orange.chat2piao.base.ui.recyclerview;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.recyclerview.widget.RecyclerView;

import com.orange.chat2piao.utils.ViewHelper;

public class CommonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    //所有控件的集合
    private SparseArray<View> mViews;
    //复用的View
    private OnItemChildClickListener mOnItemChildClickListener;
    private OnItemClickListener mOnItemClickListener;

    /**
     * 构造函数
     *
     * @param itemView item
     */
    public CommonViewHolder(View itemView) {
        super(itemView);
        this.mViews = new SparseArray<>();
        //构造方法中就指定布局
        itemView.setTag(this);
    }

    /**
     * * 提供一个获取ViewHolder的方法
     */
    public static CommonViewHolder getRecyclerHolder(Context context, ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        CommonViewHolder viewHolder = new CommonViewHolder(itemView);
        return viewHolder;
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
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 通过ViewId获取控件
     *
     * @param viewId View的Id
     * @return 返回View
     */
    public TextView getTextView(int viewId) {
        return getView(viewId);
    }

    /**
     * 为文本设置text
     *
     * @param viewId view的Id
     * @param text   文本
     * @return 返回ViewHolder
     */
    public CommonViewHolder setText(int viewId, CharSequence text) {
        TextView tv = getView(viewId);
        ViewHelper.setText(tv, text);
        return this;
    }

    /**
     * 为文本设置text
     *
     * @param viewId view的Id
     * @param size
     * @return 返回ViewHolder
     */
    public CommonViewHolder setTextSize(int viewId, float size) {
        TextView tv = getView(viewId);
        ViewHelper.setTextSize(tv, size);
        return this;
    }

    /**
     * 为文本设置text
     *
     * @param viewId view的Id
     * @param color
     * @return 返回ViewHolder
     */
    public CommonViewHolder setTextColor(int viewId, @ColorRes int color) {
        TextView tv = getView(viewId);
        ViewHelper.setTextColor(tv, itemView.getResources().getColor(color));
        return this;
    }

    /**
     * 设置ImageView
     *
     * @param viewId view的Id
     * @param resId  资源Id
     * @return 返回ViewHolder
     */
    public CommonViewHolder setImageResource(int viewId, int resId) {
        ImageView iv = getView(viewId);
        ViewHelper.setImageResource(iv, resId);
        return this;
    }

    /**
     * 设置ImageView
     *
     * @param viewId view的Id
     * @param resId  资源Id
     * @return 返回ViewHolder
     */
    public CommonViewHolder setBackgroundResource(int viewId, int resId) {
        View iv = getView(viewId);
        ViewHelper.setBackgroundResource(iv, resId);
        return this;
    }

    /**
     * 设置ImageView
     *
     * @param viewId view的Id
     * @param resId  资源Id
     * @return 返回ViewHolder
     */
    public CommonViewHolder setGifImageResource(int viewId, Context context, int resId) {
        ImageView iv = getView(viewId);
        Glide.with(context).load(resId).asGif().into(iv);
        return this;
    }

    /**
     * 为文本设置text
     *
     * @param viewId  view的Id
     * @param visible
     * @return 返回ViewHolder
     */
    public CommonViewHolder setVisible(int viewId, boolean visible) {
        View view = getView(viewId);
        ViewHelper.setVisible(view, visible);
        return this;
    }

    /**
     * 为文本设置text
     *
     * @param view    view
     * @param visible
     * @return 返回ViewHolder
     */
    public CommonViewHolder setVisible(View view, boolean visible) {
        ViewHelper.setVisible(view, visible);
        return this;
    }

    /**
     * 为文本设置text
     *
     * @param viewId   view的Id
     * @param selected
     * @return 返回ViewHolder
     */
    public CommonViewHolder setSelect(int viewId, boolean selected) {
        View view = getView(viewId);
        ViewHelper.setSelect(view, selected);
        return this;
    }

    /**
     * 添加点击事件
     */
    public CommonViewHolder setOnItemClick(OnItemClickListener listener) {
        mOnItemClickListener = listener;
        if (null != itemView)
            itemView.setOnClickListener(this);
        return this;
    }

    /**
     * 添加点击事件
     */
    public CommonViewHolder setOnItemChildClick(OnItemChildClickListener listener, int... viewIds) {
        if (null == viewIds || viewIds.length == 0) return this;
        mOnItemChildClickListener = listener;
        for (int viewId : viewIds) {
            getView(viewId).setOnClickListener(this);
        }
        return this;
    }

    @Override
    public void onClick(View v) {
        if (v == itemView) {
            if (null != mOnItemClickListener) {
                CommonViewHolder tag = (CommonViewHolder) itemView.getTag();
                mOnItemClickListener.onItemClick(v, tag.getAdapterPosition());
            }
        } else {
            if (null != mOnItemChildClickListener) {
                mOnItemChildClickListener.onItemChildClick(v);
            }
        }
    }

    public interface OnItemChildClickListener {
        void onItemChildClick(View v);
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }
}
