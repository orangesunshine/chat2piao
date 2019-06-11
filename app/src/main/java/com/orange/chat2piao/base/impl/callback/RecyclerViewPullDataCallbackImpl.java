package com.orange.chat2piao.base.impl.callback;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.orange.chat2piao.base.ifc.callback.IListAdapterCallback;
import com.orange.chat2piao.base.ifc.callback.IRecyclerViewPullDataCallback;
import com.orange.chat2piao.base.ui.recyclerview.CommonAdapter;
import com.orange.chat2piao.base.ui.recyclerview.IConvertRecyclerView;

import java.util.List;

public class RecyclerViewPullDataCallbackImpl implements IRecyclerViewPullDataCallback {

    @Override
    public <DATA, ITEM> CommonAdapter<ITEM> adapterRecyclerViewPullData(Context context, RecyclerView rv, View empty, CommonAdapter<ITEM> adapter, int layout, boolean loadmore, DATA data, IListAdapterCallback<DATA, ITEM> listAdapterCallback, IConvertRecyclerView<ITEM> convertViewHolder) {
        List<ITEM> datas = null;
        if (null != listAdapterCallback)
            datas = listAdapterCallback.parselist(data);
        return CommonAdapter.newInstance(context, rv, empty, adapter, layout, loadmore, datas, convertViewHolder);
    }
}
