package com.orange.chat2piao.base.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;

import com.orange.chat2piao.utils.ViewHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用recyclerview适配器
 *
 * @param <T> 项数据类型
 */
public class CommonAdapter<T> extends RecyclerView.Adapter<CommonViewHolder> {
    public static final int SELECTED_NONE = -1;//所有item都未选中
    private Context mContext;
    private int mLayoutId;//item布局文件
    private int mSelectedIndex = SELECTED_NONE;//默认未选中
    private List<T> mDatas;//数据源
    private EmptyCallback mEmptyCallback;//数据为空回调
    private IConvertRecyclerView<T> mConvertViewHolder;//UI回调

    /**
     * 构造方法
     *
     * @param context
     * @param layoutId
     * @param datas
     * @param convertViewHolder
     */
    public CommonAdapter(Context context, int layoutId, List<T> datas, IConvertRecyclerView<T> convertViewHolder) {
        this.mContext = context;
        this.mLayoutId = layoutId;
        this.mDatas = new ArrayList<>();
        setDatas(datas);
        mConvertViewHolder = convertViewHolder;
    }

    /**
     * 列表为空回调构造
     *
     * @param context
     * @param layoutId
     * @param datas
     * @param convertViewHolder
     * @param emptyCallback
     */
    public CommonAdapter(Context context, int layoutId, List<T> datas, IConvertRecyclerView<T> convertViewHolder, EmptyCallback emptyCallback) {
        this(context, layoutId, datas, convertViewHolder);
        mEmptyCallback = emptyCallback;
    }

    public static <T> CommonAdapter<T> newInstance(Context context, RecyclerView rv, CommonAdapter<T> adapter, int layout, List<T> datas, IConvertRecyclerView<T> convertViewHolder) {
        return newInstance(context, rv, null, adapter, layout, datas, false, convertViewHolder);
    }

    public static <T> CommonAdapter<T> newInstance(Context context, RecyclerView rv, CommonAdapter<T> adapter, int layout, List<T> datas, boolean loadmore, IConvertRecyclerView<T> convertViewHolder) {
        return newInstance(context, rv, null, adapter, layout, datas, loadmore, convertViewHolder);
    }

    public static <T> CommonAdapter<T> newInstance(Context context, RecyclerView rv, View empty,CommonAdapter<T> adapter, int layout, List<T> datas, IConvertRecyclerView<T> convertViewHolder) {
        return newInstance(context, rv, empty, adapter, layout, datas, false, convertViewHolder);
    }

    /**
     * 静态new实例空回调
     *
     * @param context
     * @param rv
     * @param empty
     * @param adapter
     * @param layout
     * @param datas
     * @param loadmore 是否加载更多
     * @param convertViewHolder
     * @param <T>
     * @return
     */
    public static <T> CommonAdapter<T> newInstance(Context context, RecyclerView rv, View empty, CommonAdapter<T> adapter, int layout, List<T> datas, boolean loadmore, IConvertRecyclerView<T> convertViewHolder) {
        if (loadmore) {
            if (null == adapter || null == rv || adapter != rv.getTag())
                throw new IllegalArgumentException();
            adapter.addItems(datas);
        } else {
            if (null == adapter) {
                adapter = setRvAdapter(context, rv, empty, layout, datas, convertViewHolder);
            } else {
                if (adapter == rv.getTag()) {
                    adapter.setDatas(datas);
                } else {
                    adapter = setRvAdapter(context, rv, empty, layout, datas, convertViewHolder);
                }
            }
        }
        return adapter;
    }

    /**
     * new adapter实例并给recycler设置adapter，空回调
     *
     * @param context
     * @param rv
     * @param empty
     * @param layout
     * @param datas
     * @param convertViewHolder
     * @param <T>
     * @return
     */
    private static <T> CommonAdapter<T> setRvAdapter(Context context, RecyclerView rv, View empty, int layout, List<T> datas, IConvertRecyclerView<T> convertViewHolder) {
        CommonAdapter<T> adapter;
        EmptyCallbackAdapter emptyCallback = null;
        if (null == rv) throw new NullPointerException();
        if (null != empty) {
            emptyCallback = new EmptyCallbackAdapter(empty, rv);
            emptyCallback.empty(null == datas || datas.isEmpty());
        }
        adapter = new CommonAdapter<T>(context, layout, datas, convertViewHolder, emptyCallback);
        rv.setTag(adapter);
        rv.setAdapter(adapter);
        return adapter;
    }

    /**
     * 生成viewholder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommonViewHolder viewHolder = CommonViewHolder.getRecyclerHolder(mContext, parent, mLayoutId);
        return viewHolder;
    }

    /**
     * 处理hoderUI
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        if (null != mConvertViewHolder) {
            mConvertViewHolder.convert(holder, mDatas.get(position), mSelectedIndex == position);
        }
    }

    @Override
    public int getItemCount() {
        return null == mDatas ? 0 : mDatas.size();
    }

    /**
     * 设置数据源，1.清空，2.添加，3.更新UI，通知空回调
     *
     * @param datas
     */
    public void setDatas(List<T> datas) {
        getDatas().clear();
        if (null != datas && !datas.isEmpty())
            getDatas().addAll(datas);
        notifyDataSetChanged();
        notifyEmpty();
    }

    /**
     * 新增多项数据
     *
     * @param datas
     */
    public void addItems(List<T> datas) {
        if (null != datas && !datas.isEmpty()) {
            getDatas().addAll(datas);
            notifyDataSetChanged();
        }
    }

    /**
     * 新增一项数据，并更新该项
     *
     * @param data
     */
    public void addItem(T data) {
        if (null != data) {
            getDatas().add(data);
            notifyItemChanged(getDatas().size());
        }
    }

    /**
     * 清空数据
     */
    public void clear() {
        getDatas().clear();
        notifyDataSetChanged();
        notifyEmpty();
    }

    /**
     * 删除数据对应项
     *
     * @param data
     */
    public void deleteItem(T data) {
        if (null != data) {
            List<T> datas = getDatas();
            int index = datas.indexOf(data);
            if (-1 != index) {
                datas.remove(data);
                notifyDataSetChanged();
                notifyEmpty();
            }
        }
    }

    /**
     * 删除position项
     *
     * @param position
     */
    public void deleteItem(int position) {
        List<T> datas = getDatas();
        if (position < datas.size()) {
            datas.remove(position);
            notifyDataSetChanged();
            notifyEmpty();
        }
    }

    /**
     * 空回调
     */
    private void notifyEmpty() {
        if (null != mEmptyCallback)
            mEmptyCallback.empty(getDatas().isEmpty());
    }

    /**
     * 设置选中项
     *
     * @param selectedIndex
     */
    public void setSelectedIndex(int selectedIndex) {
        if (selectedIndex >= getDatas().size()) throw new IllegalArgumentException();
        if (mSelectedIndex == selectedIndex) return;
        int oldIndex = mSelectedIndex;
        mSelectedIndex = selectedIndex;
        notifyItemChanged(oldIndex);
        notifyItemChanged(selectedIndex);
    }

    /**
     * 获取选中项
     *
     * @return
     */
    public int getSelectedIndex() {
        return mSelectedIndex;
    }

    /**
     * 获取数据源
     *
     * @return
     */
    private List<T> getDatas() {
        if (null == mDatas)
            mDatas = new ArrayList<>();
        return mDatas;
    }

    /**
     * 获取position位置数据项
     *
     * @param position
     * @return
     */
    public T getItemData(int position) {
        if (position < getDatas().size())
            return getDatas().get(position);
        return null;
    }

    /**
     * 根据charSequence过滤数据
     *
     * @param charSequence
     */
    public void filter(CharSequence charSequence, Filter filter) {
        if (null == filter) throw new NullPointerException();
        List<T> datas = getDatas();
        if (datas.isEmpty()) return;
        List<T> mFilterDatas = new ArrayList<>();
        for (T t : datas) {
            if (filter.filter(t, charSequence))
                mFilterDatas.add(t);
        }
        mDatas = mFilterDatas;
    }

    /**
     * 设置空回调
     *
     * @param emptyCallback
     */
    public void setEmptyCallback(EmptyCallback emptyCallback) {
        mEmptyCallback = emptyCallback;
        notifyEmpty();
    }

    /**
     * 过滤数据接口
     *
     * @param <T> 数据源
     * @param <F> 过滤条件数据
     */
    public interface Filter<T, F> {
        boolean filter(T data, F f);
    }

    /**
     * 空回调接口
     */
    public interface EmptyCallback {
        void empty(boolean empty);
    }

    /**
     * 空回调默认实现
     */
    public static class EmptyCallbackAdapter implements EmptyCallback {
        private View emtpy;
        private RecyclerView rv;

        public EmptyCallbackAdapter(View emtpy, RecyclerView rv) {
            this.emtpy = emtpy;
            this.rv = rv;
        }

        @Override
        public void empty(boolean empty) {
            ViewHelper.setVisible(rv, !empty);
            ViewHelper.setVisible(emtpy, empty);
        }
    }
}
