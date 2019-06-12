package com.orange.chat2piao.ui.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.orange.chat2piao.constant.IFinalConst;
import com.orange.chat2piao.utils.Preconditions;
import com.orange.chat2piao.utils.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import static com.orange.chat2piao.constant.IFinalConst.TYPE_LOADMORE;
import static com.orange.chat2piao.constant.IFinalConst.TYPE_REFRESH;

/**
 * 通用recyclerview适配器
 *
 * @param <ITEM> 项数据类型
 */
public class CommonAdapter<ITEM> extends RecyclerView.Adapter<RecyclerViewHolder> {
    public static final int SELECTED_NONE = -1;//所有item都未选中
    private Context mContext;
    private int mLayoutId;//item布局文件
    private int mSelectedIndex = SELECTED_NONE;//默认未选中
    private List<ITEM> mDatas;//数据源
    private static EmptyCallback mEmptyCallback;//数据为空回调
    private IConvertRecyclerView<ITEM> mConvertViewHolder;//UI回调
    private int mPageIndex = 1;//当前页数下标，下拉刷新时用

    /**
     * 刷新|加载pageIndex
     */
    public int getPageIndex(@IFinalConst.PullType int type) {
        if (IFinalConst.TYPE_LOADMORE == type) {
            mPageIndex++;
        } else if (TYPE_REFRESH == type) {
            mPageIndex = 1;
        }
        return mPageIndex;
    }

    /**
     * 构造方法用于pull，数据由静态方法参数
     *
     * @param context
     * @param layoutId
     * @param convertViewHolder
     */
    public CommonAdapter(Context context, int layoutId, IConvertRecyclerView<ITEM> convertViewHolder) {
        this.mContext = context;
        this.mLayoutId = layoutId;
        this.mDatas = new ArrayList<>();
        mConvertViewHolder = convertViewHolder;
    }

    /**
     * 构造方法
     *
     * @param context
     * @param layoutId
     * @param datas
     * @param convertViewHolder
     */
    public CommonAdapter(Context context, int layoutId, List<ITEM> datas, IConvertRecyclerView<ITEM> convertViewHolder) {
        this.mContext = context;
        this.mLayoutId = layoutId;
        this.mDatas = new ArrayList<>();
        setDatas(datas);
        mConvertViewHolder = convertViewHolder;
    }

    /**
     * 构造方法：增加空回调
     *
     * @param context
     * @param layoutId
     * @param datas
     * @param convertViewHolder
     * @param emptyCallback
     */
    public CommonAdapter(Context context, int layoutId, List<ITEM> datas, IConvertRecyclerView<ITEM> convertViewHolder, EmptyCallback emptyCallback) {
        this(context, layoutId, datas, convertViewHolder);
        mEmptyCallback = emptyCallback;
    }

    public static <ITEM> void adaptDatas(RecyclerView rv, CommonAdapter<ITEM> adapter, List<ITEM> datas) {
        adaptDatas(rv, null, adapter, false, datas);
    }

    public static <ITEM> void adaptDatas(RecyclerView rv, CommonAdapter<ITEM> adapter, List<ITEM> datas, boolean loadmore) {
        adaptDatas(rv, null, adapter, loadmore, datas);
    }

    public static <ITEM> void adaptDatas(RecyclerView rv, View empty, CommonAdapter<ITEM> adapter, List<ITEM> datas) {
        adaptDatas(rv, empty, adapter, false, datas);
    }

    /**
     * 静态new实例空回调
     *
     * @param rv
     * @param empty
     * @param adapter
     * @param datas
     * @param loadmore 是否加载更多
     * @param <ITEM>
     * @return
     */
    public static <ITEM> void adaptDatas(RecyclerView rv, View empty, CommonAdapter<ITEM> adapter, boolean loadmore, List<ITEM> datas) {
        Preconditions.checkNotNull(adapter);
        if (null == rv || adapter != rv.getTag())
            throw new IllegalArgumentException();
        if (loadmore) {
            adapter.addItems(datas);
        } else {
            if (adapter != rv.getTag()) {
                setRvAdapter(rv, empty, adapter, datas);
            } else {
                adapter.setDatas(datas);
            }
        }
    }

    /**
     * new adapter实例并给recycler设置adapter，空回调
     *
     * @param rv
     * @param empty
     * @param datas
     * @param <ITEM>
     * @return
     */
    private static <ITEM> void setRvAdapter(RecyclerView rv, View empty, CommonAdapter<ITEM> adapter, List<ITEM> datas) {
        Preconditions.checkNotNull(rv, adapter);
        if (null != empty) {
            if (null == mEmptyCallback)
                mEmptyCallback = new EmptyCallbackAdapter(empty, rv);
            mEmptyCallback.empty(null == datas || datas.isEmpty());
        }
        adapter.setDatas(datas);
        rv.setTag(adapter);
        rv.setAdapter(adapter);
    }

    /**
     * 生成viewholder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return RecyclerViewHolder.getRecyclerViewHolder(mContext, parent, mLayoutId);
    }

    /**
     * 处理hoderUI
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
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
    public void setDatas(List<ITEM> datas) {
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
    public void addItems(List<ITEM> datas) {
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
    public void addItem(ITEM data) {
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
    public void deleteItem(ITEM data) {
        if (null != data) {
            List<ITEM> datas = getDatas();
            int index = datas.indexOf(data);
            if (-1 != index) {
                datas.remove(index);
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
        List<ITEM> datas = getDatas();
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
    private List<ITEM> getDatas() {
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
    public ITEM getItemData(int position) {
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
        List<ITEM> datas = getDatas();
        if (datas.isEmpty()) return;
        List<ITEM> mFilterDatas = new ArrayList<>();
        for (ITEM t : datas) {
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
            ViewUtils.setVisible(rv, !empty);
            ViewUtils.setVisible(emtpy, empty);
        }
    }
}
